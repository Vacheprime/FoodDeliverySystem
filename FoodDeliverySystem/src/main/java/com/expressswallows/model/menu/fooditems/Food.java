/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.fooditems;

/**
 *
 * @author shahi
 */
public abstract class Food {
    protected int cookTime;
    protected int productId;
    protected double price;

    public Food(int cookTime, int productId, double price) {
        this.cookTime = cookTime;
        this.productId = productId;
        this.price = price;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    public abstract Food prepare(Food food);
    
}
