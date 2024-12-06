/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.restaurant;

import com.expressswallows.model.restaurant.users.Address;

import java.util.Queue;

/**
 * Restaurant class is used to represent a restaurant location.
 * @author shahi
 */
public class Restaurant {
    private Address location;
    private String name;
    private double balance;
    private Queue<Order> orderQueue;

    /**
     * All argument constructor for a new Restaurant.
     * @param location the address of this restaurant.
     * @param name the name of this restaurant.
     * @param balance the balance of this restaurant.
     * @param orderQueue the order queue of this restaurant.
     */
    public Restaurant(Address location, String name, double balance, Queue<Order> orderQueue) {
        this.location = location;
        this.name = name;
        this.balance = balance;
        this.orderQueue = orderQueue;
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
     * @param category the category of the food item.
     * @param food the concrete food item.
     */
    public synchronized void addOrder(String category, String food) {
        // TODO
    }

    /**
     * Complete a restaurant's order.
     * @return the order completed.
     */
    public synchronized Order completeOrder() {
        return orderQueue.poll();
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
        return "Restaurant{" +
                "location=" + location +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", orderQueue=" + orderQueue +
                '}';
    }
}
