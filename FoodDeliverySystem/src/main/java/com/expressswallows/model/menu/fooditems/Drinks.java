/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.fooditems;

public class Drinks extends Food {

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    public enum Type {
        WATER,
        SEVEN_UP,
        COKE
    }     
    private Type type; 
    private Size size;

    public Drinks(String cookTime, int productId, double price, Type type, Size size) {
        super(cookTime, productId, price); 
        this.type = type;
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }
    
    @Override
    public Food prepare(Food food) {
       return null; 
    }
    
}
