package com.expressswallows.controller;

import com.expressswallows.exceptions.DatabaseException;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.view.FormOrderDetails;
import com.expressswallows.view.FormPayment;
import com.expressswallows.view.FormRestaurantDetails;

import java.util.List;

/**
 * The RestaurantController class is responsible for managing order processes and restaurants.
 */
public class RestaurantController {
    private FormPayment paymentForm;
    private FormOrderDetails orderDetailsForm;
    private FormRestaurantDetails restaurantDetailsForm;

    private List<Restaurant> restaurants;

    public RestaurantController(FormPayment paymentForm, FormOrderDetails orderDetailsForm, FormRestaurantDetails restaurantDetailsForm) {
        this.paymentForm = paymentForm;
        this.orderDetailsForm = orderDetailsForm;
        this.restaurantDetailsForm = restaurantDetailsForm;
        loadRestaurants();
    }

    /**
     * Load the restaurant locations from the database.
     */
    public void loadRestaurants() {
        try (DatabaseConnectionUtils database = DatabaseConnectionUtils.getInstance()) {
            this.restaurants = database.fetchRestaurantLocations();
        } catch (DatabaseException e) {
            throw new RuntimeException("Could not access database: " + e.getMessage());
        }
    }

    /**
     * Calculate the total order time of an order if it is assigned to a given restaurant.
     * The total order time is equal to the sum of the cook time, the delivery, and the queue wait time.
     *
     * @param order the order to process.
     * @param restaurant the restaurant responsible for processing the order.
     * @return the total order time.
     */
    public static int getTotalTime(Order order, Restaurant restaurant){
        return getTotalProcessTime(order, restaurant) + getQueueTime(restaurant);
    }

    /**
     * Calculate the total processing time of an order if it is assigned to a given restaurant.
     * The total processing time is equal to the sum of the cook time and the delivery time.
     *
     * @return the total processing time.
     */
    public static int getTotalProcessTime(Order order, Restaurant restaurant) {
        return order.calculateTotalCookTime() + RestaurantController.getDeliveryTime(order, restaurant);
    }

    /**
     * Calculate the current queue time of a restaurant.
     *
     * @return the total time it takes for a restaurant to process all orders.
     */
    public static int getQueueTime(Restaurant restaurant) {
        int totalCookTime = 0;
        for (Restaurant.OrderProcessTask task : restaurant.getOrderTaskQueue()) {
            Order order = task.getOrder();
            totalCookTime += order.calculateTotalCookTime();
        }
        return totalCookTime;
    }

    /**
     * Calculate the delivery time of the order if it is assigned to a restaurant.
     *
     * @return the delivery time of the order.
     */
    public static int getDeliveryTime(Order order, Restaurant restaurant) {
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
     * Determine the restaurant, amongst a list of restaurants, that will process the given order the
     * fastest.
     *
     * @param order the order to process.
     * @param availableRestaurants the list of available restaurant locations.
     * @return the restaurant that will process the given order the fastest.
     */
    public static Restaurant findRestaurant(Order order, List<Restaurant> availableRestaurants) {
        Restaurant bestRestaurant = null;
        int shortestTime = Integer.MAX_VALUE;

        for (Restaurant restaurant : availableRestaurants) {
            int queueTime = getQueueTime(restaurant);

            int deliveryTime = getDeliveryTime(order, restaurant);

            int totalTime = queueTime + deliveryTime;

            if (totalTime < shortestTime) {
                shortestTime = totalTime;
                bestRestaurant = restaurant;
            }
        }
        return bestRestaurant;
    }
}
