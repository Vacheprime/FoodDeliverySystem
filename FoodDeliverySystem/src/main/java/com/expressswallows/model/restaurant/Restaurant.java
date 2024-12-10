package com.expressswallows.model.restaurant;

import com.expressswallows.controller.RestaurantController;
import com.expressswallows.exceptions.DatabaseException;
import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.utils.DatabaseConnectionUtils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Restaurant class is used to represent a restaurant location.
 * @author shahi
 */
public class Restaurant {
    public static double DELIVERY_TIME_PER_KM = 0.1;
    private int restaurantId;
    private Address location;
    private String name;
    private double balance;
    private final BlockingQueue<OrderProcessTask> orderTaskQueue;
    private OrderProcessTask currentOrderTask;

    /**
     * All argument constructor for a new Restaurant.
     * @param location the address of this restaurant.
     * @param name the name of this restaurant.
     * @param balance the balance of this restaurant.
     */
    public Restaurant(Address location, String name, double balance) {
        this.location = location;
        this.name = name;
        this.balance = balance;
        this.orderTaskQueue = new LinkedBlockingQueue<>();
    }

    public BlockingQueue<OrderProcessTask> getOrderTaskQueue() {
        return orderTaskQueue;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public OrderProcessTask getCurrentOrderTask() {
        return currentOrderTask;
    }

    public void setCurrentOrderTask(OrderProcessTask currentOrderTask) {
        this.currentOrderTask = currentOrderTask;
    }

    /**
     * Getter for the location.
     * @return the location of the restaurant.
     */
    public Address getLocation() {
        return location;
    }

    /**
     * Setter for the location.
     * @param location the new location of the restaurant.
     */
    public void setLocation(Address location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        this.location = location;
    }

    /**
     * Getter for the name.
     * @return the name of the restaurant.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     * @param name the new name of the restaurant.
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    /**
     * Getter for the balance.
     * @return the balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter for the balance.
     * @param balance the new balance
     */
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    /**
     * Add an order to the restaurant's queue.
     * This method is synchronized and can be used by
     * multiple threads.
     */
    public void addOrder(Order order) throws InterruptedException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        // Don't set the order date time if it was set by the database
        if (order.getOrderDateTime() == null) {
            order.setOrderDateTime(LocalDateTime.now()); // Set the date and time the order was placed
        }
        orderTaskQueue.put(new OrderProcessTask(order, this));
    }

    /**
     * Get the next restaurant's order to be processed.
     * @return the order completed.
     */
    public OrderProcessTask processNextOrder() throws InterruptedException {
        this.currentOrderTask = orderTaskQueue.take();
        this.currentOrderTask.setStartTime(LocalTime.now()); // Set the start time
        return currentOrderTask;
    }

    /**
     * Find the OrderProcessTask that is responsible for
     * processing the order specified, if any exist.
     * @param order the order to search for.
     * @return the OrderProcessTask responsible for processing the order specified.
     * Null if no OrderProcessTask can be found.
     */
    public OrderProcessTask findTaskWithOrder(Order order) {
        if (isQueueEmpty()) {
            return null;
        }
        if (currentOrderTask.getOrder().equals(order)) {
            return currentOrderTask;
        }
        for (OrderProcessTask task : orderTaskQueue) {
            if (task.getOrder().equals(order)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Check if the restaurant does not have and is not processing
     * any orders.
     * @return
     */
    public boolean isQueueEmpty() {
        return currentOrderTask == null && orderTaskQueue.isEmpty();
    }

    /**
     * Reset the current order task when a task is finished.
     * This method should be called every time a task is finished
     * as to clear the current task when the queue is emptied.
     */
    public synchronized void finishCurrentOrder() {
        this.currentOrderTask = null;
    }

    /**
     * Add a payment to the restaurant.
     * @param payment the payment to add.
     */
    public void addPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        this.balance += payment.getPaymentAmount();
    }

    @Override
    public String toString() {
        return name + ", " + location;
    }

    /**
     * OrderProcessTask is used to represent an order task.
     */
    public static class OrderProcessTask {
        private final Order order;
        private final Restaurant restaurant;
        private LocalTime startTime;

        public OrderProcessTask(Order order, Restaurant restaurant) {
            this.order = order;
            this.restaurant = restaurant;
            this.startTime = null;
        }

        /**
         * Get the order of the OrderProcess
         *
         * @return the order of the OrderProcess
         */
        public Order getOrder() {
            return order;
        }

        /**
         * Get the restaurant of the OrderProcess.
         *
         * @return the restaurant of the OrderProcess.
         */
        public Restaurant getRestaurant() {
            return restaurant;
        }

        /**
         * Get the start time of the OrderProcess.
         *
         * @return the start time of the OrderProcess or null if not started.
         */
        public LocalTime getStartTime() {
            return startTime;
        }

        /**
         * Set the start time of the OrderProcess.
         *
         * @param startTime the new start time of the OrderProcess.
         */
        public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
        }

        /**
         * Get the estimated amount of minutes remaining until
         * completion of the order.
         *
         * @return the estimated remaining time in minutes until order completion.
         */
        public int getEstimatedRemainingTime() {
            if (startTime == null) {
                int totalTime = 0;
                // Get the totalTime of the current order task
                // Since it may be null due do concurrent access, make sure it isn't before accessing
                if (restaurant.getCurrentOrderTask() != null) {
                    totalTime += restaurant.getCurrentOrderTask().getEstimatedRemainingTime();
                }
                // Loop over all orders in the queue
                for (OrderProcessTask task : restaurant.getOrderTaskQueue()) {
                    // If the current order has been reached, stop
                    if (task.getOrder().equals(order)) {
                        break;
                    }
                    // Append the process time of the order to the total time
                    totalTime += RestaurantController.getTotalProcessTime(task.getOrder(), restaurant);
                }
                // Append the process time of this order to the total time and return
                return totalTime + RestaurantController.getTotalProcessTime(order, restaurant);
            } else {
                //
                LocalTime currentTime = LocalTime.now();
                int minutesPassed = (int) Duration.between(startTime, currentTime).toMinutes();
                int processTime = RestaurantController.getTotalProcessTime(order, restaurant);
                return processTime - minutesPassed;
            }
        }

        private void updateStatus(Order.Status status) {
            // Synchronize db access
            DatabaseConnectionUtils.dbLock.lock();
            try {
                // Update the status in the database
                try (DatabaseConnectionUtils db = DatabaseConnectionUtils.getInstance()) {
                    db.updateOrderStatus(order.getOrderId(), status);
                } catch (DatabaseException e) {
                    e.printStackTrace();
                }
            } finally {
                DatabaseConnectionUtils.dbLock.unlock();
            }
        }

        /**
         * Process the order.
         */
        public void process() {
            try {
                // Set status to cooking
                order.setStatus(Order.Status.IN_PROGRESS);
                // Update the status in the database
                updateStatus(Order.Status.IN_PROGRESS);
                // Wait for cooking to finish
                long cookTime = (long) order.calculateTotalCookTime() * 60 * 1000;
                Thread.sleep(cookTime);
                // Set status to delivering
                order.setStatus(Order.Status.DELIVERING);
                // Update the status in the database
                updateStatus(Order.Status.DELIVERING);
                // Wait for delivery
                long deliveryTime = (long) RestaurantController.getDeliveryTime(order, restaurant) * 60 * 1000;
                Thread.sleep(deliveryTime);
                // Set status to arrived
                order.setStatus(Order.Status.ARRIVED);
                // Update the status in the database
                updateStatus(Order.Status.ARRIVED);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
