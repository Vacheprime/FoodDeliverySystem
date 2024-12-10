package com.expressswallows.model.restaurant;

import com.expressswallows.controller.RestaurantController;
import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.users.Address;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Restaurant class is used to represent a restaurant location.
 * @author shahi
 */
public class Restaurant {
    public static double DELIVERY_TIME_PER_KM = 0.2; // Three minutes per km
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
    public synchronized void addOrder(Order order) throws InterruptedException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        order.setOrderDateTime(LocalDateTime.now()); // Set the date and time the order was placed
        orderTaskQueue.put(new OrderProcessTask(order, this));
    }

    /**
     * Get the next restaurant's order to be processed.
     * @return the order completed.
     */
    public synchronized OrderProcessTask processNextOrder() throws InterruptedException {
        if (currentOrderTask.getOrder().getStatus() == Order.Status.ARRIVED) {
            this.currentOrderTask = orderTaskQueue.take();
            return currentOrderTask;
        }
        return null;
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
         * Get the estimated amount of minutes remaining until
         * completion of the order.
         *
         * @return the estimated remaining time in minutes until order completion.
         */
        public int getEstimatedRemainingTime() {
            if (startTime == null) {
                return Integer.MAX_VALUE;
            }
    
            LocalTime currentTime = LocalTime.now();
            int minutesPassed = (int) Duration.between(startTime, currentTime).toMinutes();
            int processTime = RestaurantController.getTotalProcessTime(order, restaurant);
            return processTime - minutesPassed;
        }

        /**
         * Process the order.
         */
        public void process() {
            // Set the current time
            this.startTime = LocalTime.now();
            try {
                this.startTime = LocalTime.now();

                long queueTime = RestaurantController.getQueueTime(restaurant) * 60 * 1000;
                Thread.sleep(queueTime);
                order.setStatus(Order.Status.IN_PROGRESS);

                long cookTime = order.calculateTotalCookTime() * 60 * 1000;
                Thread.sleep(cookTime);
                order.setStatus(Order.Status.DELIVERING);

                long deliveryTime = RestaurantController.getDeliveryTime(order, restaurant) * 60 * 1000;
                Thread.sleep(deliveryTime);
                order.setStatus(Order.Status.ARRIVED);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
