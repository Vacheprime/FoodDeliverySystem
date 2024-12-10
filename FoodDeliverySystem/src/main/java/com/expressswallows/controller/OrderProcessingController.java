package com.expressswallows.controller;

import com.expressswallows.exceptions.DatabaseException;
import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.model.restaurant.Restaurant.OrderProcessTask;
import com.expressswallows.utils.DatabaseConnectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class OrderProcessingController {
    private static OrderProcessingController instance;
    private List<Restaurant> restaurants;
    private List<Executor> orderProcessors;

    private OrderProcessingController() {
        loadRestaurants();
        startOrderProcessors();
    }

    public static OrderProcessingController getInstance() {
        if (instance == null) {
            synchronized (OrderProcessingController.class) {
                if (instance == null) {
                    instance = new OrderProcessingController();
                }
            }
        }
        return instance;
    }

    /**
     * Load the restaurant locations from the database.
     */
    private void loadRestaurants() {
        try (DatabaseConnectionUtils database = DatabaseConnectionUtils.getInstance()) {
            this.restaurants = database.fetchRestaurantLocations();
            if (restaurants.isEmpty()) {
                throw new RuntimeException("Error: the database does not contain any restaurants.");
            }
        } catch (DatabaseException e) {
            throw new RuntimeException("Error: could not access database: " + e.getMessage());
        }
    }

    /**
     * Initialize the thread pools responsible for processing orders
     * and start them.
     */
    private void startOrderProcessors() {
        // Only start if order processors haven't been started yet
        if (orderProcessors != null) {
            return;
        }
        // Create a single threaded executor for each restaurant
        orderProcessors = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            // Create an executor where every thread is a daemon thread
            Executor orderProcessor = Executors.newSingleThreadExecutor(r -> {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            });
            // Start processing orders
            RestaurantOrderProcessor processor = new RestaurantOrderProcessor(restaurant);
            orderProcessor.execute(processor);
            // Add the executor to the list of executors
            orderProcessors.add(orderProcessor);
        }
    }

    /**
     * Runnable that indefinitely fetches orders inserted into the
     * restaurant and processes them.
     */
    private static class RestaurantOrderProcessor implements Runnable {
        private Restaurant restaurant;

        /**
         * Constructor for a new restaurant order processor.
         * @param restaurant the restaurant to manage.
         */
        public RestaurantOrderProcessor(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        /**
         * Continuously process restaurant orders.
         */
        @Override
        public void run() {
            // Process orders indefinitely
            while (true) {
                // Get the order task from the queue
                OrderProcessTask task = null;
                try {
                    task = restaurant.processNextOrder();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    continue;
                }
                if (task == null) {
                    continue;
                }
                System.out.println("Processing order: " + task.getOrder() + " TIME: " + task.getEstimatedRemainingTime());
                // Execute the task
                task.process();
                // Finish the order
                restaurant.finishCurrentOrder();
                System.out.println("Order processed!");
            }
        }
    }
}
