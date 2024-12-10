package com.expressswallows.controller;

import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.Payment;
import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.model.restaurant.Restaurant.OrderProcessTask;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormOrderDetails;
import com.expressswallows.view.FormPayment;
import com.expressswallows.view.FormViewCart;

import javax.swing.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The RestaurantController class is responsible for managing order processes and restaurants.
 */
public class RestaurantController {
    private FormPayment paymentForm;
    private FormOrderDetails orderDetailsForm;

    public RestaurantController(FormPayment paymentForm) {
        this.paymentForm = paymentForm;
    }

    public RestaurantController(FormOrderDetails orderDetailsForm) {
        this.orderDetailsForm = orderDetailsForm;
    }

    /**
     * Switch the language of the FormPayment.
     */
    public void updateFormPaymentLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        paymentForm.backBtn.setText(rb.getString("back"));
        paymentForm.langBtn.setText(rb.getString("lang"));
        paymentForm.cardnumberLbl.setText(rb.getString("cardnum"));
        paymentForm.expirydateLbl.setText(rb.getString("expiry"));

        if (Utils.currentLocale.getLanguage().equals("en")) {
            paymentForm.totalLbl.setText(rb.getString("amount") + "$" + paymentForm.price);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            paymentForm.totalLbl.setText(rb.getString("amount")+ paymentForm.price + "$");
        }

        paymentForm.confirmBtn.setText(rb.getString("confirm"));
        paymentForm.paymentLbl.setText(rb.getString("payment"));
    }

    /**
     * On the payment form, check if the payment information is correct.
     * @return a boolean indicating whether the payment information is correct.
     */
    private boolean checkPayment() {
        String cardnum = paymentForm.cardnumberTB.getText();
        String cvv = paymentForm.cvvTB.getText();
        String expirydate = paymentForm.expirydateTB.getText();

        if (!Utils.validateCreditCard(cardnum, cvv, expirydate)) {
            return false;
        }
        return true;
    }

    /**
     * Pay for an order in the payment form.
     */
    public void payOrder() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("payFail");
        String title = rb.getString("er");

        if (!checkPayment()) {
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
            return;
        }

        Payment payment = new Payment(paymentForm.price, paymentForm.client);
        paymentForm.dispose();
        new FormOrderDetails(paymentForm.client, paymentForm.order, payment).setVisible(true);
    }

    /**
     * Return to cart from the payment form.
     */
    public void returnToCart() {
        paymentForm.dispose();
        new FormViewCart(paymentForm.client, paymentForm.order).setVisible(true);
    }

    /**
     * Generate a string representation of the foods contained in an
     * order.
     *
     * @param order the order whose foods are to be represented.
     * @return string representation of the foods contained in an order.
     */
    private String foodList(Order order) {
        StringBuilder foodDetails = new StringBuilder();
        for (Food food : order.getFoods()) {
            foodDetails.append(food.toString()).append("\n");
        }
        return foodDetails.toString();
    }

    /**
     * Initialize the order details form after making a payment for an order.
     */
    public void initializeOrderFormWithPayment() {
        // Get the list of restaurants
        List<Restaurant> restaurants = OrderProcessingController.getInstance().getRestaurants();

        // Set the text of the current order
        orderDetailsForm.orderListTA.setText(foodList(orderDetailsForm.order));

        // Find the restaurant that can process the order the fastest
        orderDetailsForm.restaurant = findRestaurant(orderDetailsForm.order, restaurants);

        // Synchronize inputting an order
        DatabaseConnectionUtils.dbLock.lock();
        try {
            // Assign the order to the restaurant select and set the order's restaurant ID to that selected restaurant
            // Must be assigned before inserted into the database so that the order time is set
            try {
                orderDetailsForm.restaurant.addOrder(orderDetailsForm.order);
                orderDetailsForm.order.setRestaurantId(orderDetailsForm.restaurant.getRestaurantId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Insert the order and the payment in the database
            try(var database = DatabaseConnectionUtils.getInstance()) {
                database.insertOrder(orderDetailsForm.order);
                database.insertPayment(orderDetailsForm.payment, orderDetailsForm.restaurant.getRestaurantId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            DatabaseConnectionUtils.dbLock.unlock();
        }

        // Display the UI
        updateOrderDetailsFormLanguage();
        // Continuously update the UI
        OrderDetailsRefreshThread refreshThread = new OrderDetailsRefreshThread(orderDetailsForm);
        refreshThread.start();
    }

    /**
     * Initialize the order details form of an order.
     */
    public void initializeOrderFormWithOrder() {
        // Get the list of restaurants
        OrderProcessingController processingController = OrderProcessingController.getInstance();
        // Find the restaurant that is responsible for the order
        orderDetailsForm.restaurant = processingController.getRestaurantById(orderDetailsForm.order.getRestaurantId());
        // Set the text of the current order
        orderDetailsForm.orderListTA.setText(foodList(orderDetailsForm.order));
        // Display the UI
        updateOrderDetailsFormLanguage();
        // Continuously update the UI
        OrderDetailsRefreshThread refreshThread = new OrderDetailsRefreshThread(orderDetailsForm);
        refreshThread.start();
    }

    /**
     * Update the language of the order details form.
     */
    public void updateOrderDetailsFormLanguage() {
        // Determine remaining time
        int remainingTime = 0;

        // Determine whether the order has been completed or not
        Order currentOrder = orderDetailsForm.order;

        if (currentOrder.getStatus() != Order.Status.ARRIVED) {
            // Get the remaining time of the order
            OrderProcessingController processingController = OrderProcessingController.getInstance();
            Restaurant assignedRestaurant = processingController.getRestaurantById(orderDetailsForm.order.getRestaurantId());
            OrderProcessTask processTask = assignedRestaurant.findTaskWithOrder(orderDetailsForm.order);
            if (processTask != null) {
                // Set the current order to the order being processed in order to get live reloads
                orderDetailsForm.order = processTask.getOrder();
                remainingTime = processTask.getEstimatedRemainingTime();
            }
        }

        // Set the text of the form
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        orderDetailsForm.langBtn.setText(rb.getString("lang"));
        orderDetailsForm.backBtn.setText(rb.getString("back"));
        orderDetailsForm.orderLbl.setText(rb.getString("order") + " " + orderDetailsForm.order.getOrderId());
        orderDetailsForm.etaLbl.setText(rb.getString("eta") + " " + remainingTime + " mins.");
        orderDetailsForm.locationAssignedLbl.setText(rb.getString("locationassigned") + " " + orderDetailsForm.restaurant.toString());
        orderDetailsForm.statusLbl.setText(rb.getString("status") + " " + orderDetailsForm.order.getStatus());
    }

    public void updateOrderDetails() {
        // Determine remaining time
        int remainingTime = 0;

        // Determine whether the order has been completed or not
        Order currentOrder = orderDetailsForm.order;
        if (currentOrder.getStatus() != Order.Status.ARRIVED) {
            // Get the remaining time of the order
            OrderProcessingController processingController = OrderProcessingController.getInstance();
            Restaurant assignedRestaurant = processingController.getRestaurantById(orderDetailsForm.order.getRestaurantId());
            OrderProcessTask processTask = assignedRestaurant.findTaskWithOrder(orderDetailsForm.order);
            if (processTask != null) {
                remainingTime = processTask.getEstimatedRemainingTime();
            }

        }
        // Set the text of the form
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        orderDetailsForm.etaLbl.setText(rb.getString("eta") + " " + remainingTime + " mins.");
        orderDetailsForm.statusLbl.setText(rb.getString("status") + " " + orderDetailsForm.order.getStatus());
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

    private class OrderDetailsRefreshThread extends Thread {
        private FormOrderDetails orderDetailsForm;

        public OrderDetailsRefreshThread(FormOrderDetails orderDetailsForm) {
            this.orderDetailsForm = orderDetailsForm;
            this.setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    updateOrderDetails();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
