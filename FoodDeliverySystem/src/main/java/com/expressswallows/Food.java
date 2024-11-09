/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows;

/**
 *
 * @author shahi
 */
public abstract class Food {
    protected String cookTime;
    protected int productId;
    protected double price;

    public Food(String cookTime, int productId, double price) {
        this.cookTime = cookTime;
        this.productId = productId;
        this.price = price;
    }
    
    public abstract Food prepare(Food food);
    
}
