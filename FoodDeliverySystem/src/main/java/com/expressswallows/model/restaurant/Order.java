package com.expressswallows.model.restaurant;

import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.users.Client;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Order class is used to keep track of client's orders.
 * @author Danat
 */
public class Order {
    private int orderId;
    private int restaurantId;
    private ArrayList<Food> foods;
    private Client orderedBy;
    private LocalDateTime orderDateTime;
    private Status status;

    /**
     * Status enum is used to represent the different states that an order can be in.
     */
    public enum Status {
        IN_QUEUE,
        IN_PROGRESS,
        DELIVERING,
        ARRIVED
    }

    /**
     * All argument constructor for a client's Order.
     * 
     * @param orderedBy the client that ordered the food items.
     * @param assignedTo the restaurant charged with completing the order.
     */
    public Order(Client orderedBy, Restaurant assignedTo) {
        // Validate the arguments
        if (orderedBy == null || assignedTo == null) {
            throw new IllegalArgumentException("The arguments cannot be null.");
        }
        this.status = Status.IN_QUEUE;
        this.orderId = -1;
        this.foods = new ArrayList<>();
        this.orderedBy = orderedBy;
        this.restaurantId = assignedTo.getRestaurantId();
        this.orderDateTime = null;
    }

    public Order(int restaurantId, Client orderedBy) {
        // Validate the arguments
        if (orderedBy == null) {
            throw new IllegalArgumentException("The arguments cannot be null.");
        }
        this.status = Status.IN_QUEUE;
        this.orderId = -1;
        this.foods = new ArrayList<>();
        this.orderedBy = orderedBy;
        this.restaurantId = restaurantId;
        this.orderDateTime = null;
    }

    /**
     * Minimal constructor for a client's order.
     * This constructor assumes that the assigned restaurant will be
     * assigned later on.
     *
     * @param orderedBy
     */
    public Order(Client orderedBy) {
        this.status = Status.IN_QUEUE;
        this.orderId = -1;
        this.foods = new ArrayList<>();
        this.orderedBy = orderedBy;
        this.restaurantId = -1;
        this.orderDateTime = null;
    }

    /**
     * Calculate the total price of the order.
     *
     * @return the total price of the order.
     */
    public double calculateTotalPrice() {
        double total = foods.stream().mapToDouble(Food::getPrice).sum();
        return Double.parseDouble(String.format("%.2f", total));
    }

    /**
     * Calculate the total cook time of the order.
     *
     * @return the total cook time of the order.
     */
    public int calculateTotalCookTime() {
        return foods.stream().mapToInt(f -> f.getCookTime()).sum();
    }

    /**
     * Getter for the list of food items that make up the order.
     *
     * @return the list of food items that make up the order.
     */
    public List<Food> getFoods() {
        return foods;
    }

    /**
     * Add a food item to the order.
     *
     * @param food the food item to add.
     */
    public void addFoodToOrder(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("The food to add cannot be null.");
        }
        foods.add(food);
    }

    /**
     * Getter for the client that made the order.
     *
     * @return the client that made the order.
     */
    public Client getOrderedBy() {
        return orderedBy;
    }

    /**
     * Getter for the restaurant ID that is responsible for completing the order.
     *
     * @return the restaurant ID responsible for completing the order.
     */
    public int getRestaurantId() {
        return restaurantId;
    }

    /**
     * Setter for the assigned restaurant ID.
     *
     * @param restaurantId the new restaurant ID of the restaurant in charge of the order.
     */
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * Getter for the date and time the order was placed.
     *
     * @return the date and time the order was placed.
     */
    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    /**
     * Setter for the date and time the order was placed.
     * @param orderDateTime the date and time the order was placed.
     */
    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    /**
     * Getter for the status of the order.
     * @return
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setter for the status of the order.
     * @param status the new status of the order.
     */
    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("The status cannot be null.");
        }
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.foods);
        hash = 23 * hash + Objects.hashCode(this.orderedBy);
        hash = 23 * hash + Objects.hashCode(this.restaurantId);
        hash = 23 * hash + Objects.hashCode(this.orderDateTime);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return orderId == order.orderId && restaurantId == order.restaurantId && Objects.equals(foods, order.foods) && Objects.equals(orderedBy, order.orderedBy);
    }

    @Override
    public String toString() {
        return "Order{" + "foods=" + foods + ", orderedBy=" + orderedBy + ", assignedTo=" + restaurantId + ", orderDateTime=" + orderDateTime + '}';
    }
}
