/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.fooditems;

import com.expressswallows.model.menu.fooditems.Food;

/**
 *
 * @author shahi
 */
public abstract class Fries extends Food {

    enum size {
        Small,
        Medium,
        Large
    }

    public Fries(int cookTime, int productId, double price) {
        super(cookTime, price);
    }
}
