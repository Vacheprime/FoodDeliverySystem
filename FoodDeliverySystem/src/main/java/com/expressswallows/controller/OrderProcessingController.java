package com.expressswallows.controller;

import com.expressswallows.model.restaurant.Restaurant;

import java.util.List;

public class OrderProcessingController {
    private static OrderProcessingController instance;
    private List<Restaurant> restaurants;

    private OrderProcessingController() {
        
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

}
