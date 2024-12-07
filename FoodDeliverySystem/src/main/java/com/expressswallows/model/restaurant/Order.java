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
    private ArrayList<Food> foods;
    private Client orderedBy;
    private Restaurant assignedTo;
    private final LocalDateTime orderDateTime;
    private Status status;
    private int orderId;

    /**
     * Status enum is used to represent the different states that an order can be in.
     */
    public enum Status {
        IN_PROGRESS,
        DELIVERING,
        DELIVERED
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
        this.status = Status.IN_PROGRESS;
        this.orderId = -1;
        this.foods = new ArrayList<>();
        this.orderedBy = orderedBy;
        this.assignedTo = assignedTo;
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
        this.status = Status.IN_PROGRESS;
        this.orderId = -1;
        this.foods = new ArrayList<>();
        this.orderedBy = orderedBy;
        this.assignedTo = null;
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
     * Getter for the restaurant that is responsible for completing the order.
     *
     * @return the restaurant responsible for completing the order.
     */
    public Restaurant getAssignedTo() {
        return assignedTo;
    }

    /**
     * Setter for the assigned restaurant,
     *
     * @param assignedTo the new restaurant in charge of the order.
     */
    public void setAssignedTo(Restaurant assignedTo) {
        this.assignedTo = assignedTo;
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
        hash = 23 * hash + Objects.hashCode(this.assignedTo);
        hash = 23 * hash + Objects.hashCode(this.orderDateTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.foods, other.foods)) {
            return false;
        }
        if (!Objects.equals(this.orderedBy, other.orderedBy)) {
            return false;
        }
        if (!Objects.equals(this.assignedTo, other.assignedTo)) {
            return false;
        }
        return Objects.equals(this.orderDateTime, other.orderDateTime);
    }

    @Override
    public String toString() {
        return "Order{" + "foods=" + foods + ", orderedBy=" + orderedBy + ", assignedTo=" + assignedTo + ", orderDateTime=" + orderDateTime + '}';
    }
}
