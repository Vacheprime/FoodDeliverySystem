package com.expressswallows.model.restaurant;

import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.users.Address;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
        if (currentOrderTask.getOrder().getStatus() == Order.Status.DELIVERED) {
            this.currentOrderTask = orderTaskQueue.take();
            return currentOrderTask;
        }
        return null;
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
    public static class OrderProcessTask implements Runnable {
        private Order order;
        private Restaurant restaurant;
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
        public int getEstimatedRemainingTime(Order order) {
            if (startTime == null) {
                return Integer.MAX_VALUE; // The remaining time is undefined
            }
            // Find the time difference in minutes between the start
            // and current time
            LocalTime currentTime = LocalTime.now();
            int minutesPassed = (int) Duration.between(startTime, currentTime).toMinutes();
            // Get the total process time
            int processTime = getTotalProcessTime(order);
            return processTime - minutesPassed;
        }

        /**
         * @return
         */
        public int calculateQueueTime(Restaurant restaurant) {
            int totalCookTime = 0;
            for (OrderProcessTask task : restaurant.orderTaskQueue) {
                Order order = task.getOrder();
                totalCookTime += order.calculateTotalCookTime();
            }
            return totalCookTime;
        }

        /**
         * Get the total processing time.
         *
         * @return the total processing time.
         */
        public int getTotalProcessTime(Order order) {
            return order.calculateTotalCookTime() + getDeliveryTime(order, getRestaurant());
        }

        /**
         * Get the delivery time of the order.
         *
         * @return the delivery time of the order.
         */
        public int getDeliveryTime(Order order, Restaurant restaurant) {
            // Get coordinates
            double x1 = order.getOrderedBy().getAddress().mapAddressToX();
            double y1 = order.getOrderedBy().getAddress().mapAddressToY();
            double x2 = restaurant.getLocation().mapAddressToX();
            double y2 = restaurant.getLocation().mapAddressToY();
            // Calculate distance and round it
            int distance = (int) Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
            return (int) (distance * Restaurant.DELIVERY_TIME_PER_KM);
        }


        /***
         *
         * @param order
         * @param availableRestaurants
         * @return
         */
        public Restaurant findRestaurant(Order order, List<Restaurant> availableRestaurants) {
            Restaurant bestRestaurant = null;
            int shortestTime = Integer.MAX_VALUE;

            for (Restaurant restaurant : availableRestaurants) {
                int queueTime = calculateQueueTime(restaurant);

                int deliveryTime = getDeliveryTime(order, restaurant);

                int totalTime = queueTime + deliveryTime;

                if (totalTime < shortestTime) {
                    shortestTime = totalTime;
                    bestRestaurant = restaurant;
                }
            }
            return bestRestaurant;
        }

        /**
         * Process the order.
         */
        @Override
        public void run() {
            // Set the current time
            this.startTime = LocalTime.now();
            try {
                // Prepare the items
                for (Food f : order.getFoods()) {
                    f.prepare();
                }
                // Wait for cook time
                Thread.sleep((long) order.calculateTotalCookTime() * 60 * 1000);
                // Update to delivering
                order.setStatus(Order.Status.DELIVERING);
                Thread.sleep((long) getDeliveryTime(order, restaurant) * 60 * 1000);
                // Update to delivered
                order.setStatus(Order.Status.DELIVERED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
