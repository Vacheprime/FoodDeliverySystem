/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.restaurant;

import com.expressswallows.controller.OrderController;
import com.expressswallows.model.restaurant.users.Address;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author shahi
 */
public class Restaurant {
    private Address location;
    private static double balance;
    private final Queue<Order> orderQueue;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4); //handles 4 orders at a time

    public Restaurant(Address location) {
        this.location = location;
        this.balance = 0;
        this.orderQueue = new LinkedList<>();
    }

    public synchronized void addOrder(Order order) {
        orderQueue.add(order);
    }
    
    /**
     *
     * @param payment
     */
    public static synchronized void addPayment(Payment payment) {
        balance += payment.getPaymentAmount();
    }
}
