/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.controller;

import com.expressswallows.model.restaurant.Order;
import java.util.concurrent.*;

/**
 *
 * @author shahi
 */
public class OrderController {
    
    private String status;
    //private Order order;
    private int cookTime;
    private final ExecutorService threadPool = Executors.newScheduledThreadPool(4);
    
    public OrderController(Order order) {
        this.cookTime = order.calculateTotalCookTime();
        this.status = "In Queue";
    }

    public String getStatus() {
        return status;
    }
    
    public void startPreparation(Runnable change) {
        status = "Being Prepared";
        //need to countdown the amount of minutes and "Delivering", "Being Prepared", "In Queue", and "Arrived".
    // calculate the distance between the restaurant and the client's house for the delivery time
    }
    
}
