/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.fooditems;

import java.util.Objects;

/**
 * Burger class is used to represent all food items that are burgers.
 * @author shahi
 */
public abstract class Burger extends Food {
    private BurgerSauce sauce;

    /**
     * BurgerSauce enum is used to represent all possible burger
     * sauces.
     */
    public enum BurgerSauce {
        CLASSIC(0),
        SPICY(0.99);

        // Store the price of sauce type
        private final double price;

        /**
         * Constructor for a sauce type.
         * @param price the price of the sauce.
         */
        BurgerSauce(double price) {
            this.price = price;
        }

        /**
         * Getter for the sauce price.
         * @return the sauce price.
         */
        public double getPrice() {
            return price;
        }
    }

    /**
     * All argument constructor for a new burger.
     * @param cookTime the cook time of the burger.
     * @param price the price of the burger.
     * @param sauce the sauce type of the burger
     */
    public Burger(int cookTime, double price, BurgerSauce sauce) {
        super(cookTime, price);
        if (sauce == null) {
            throw new IllegalArgumentException("The sauce argument cannot be null.");
        }
        this.sauce = sauce;
    }

    /**
     * Getter for the burger sauce.
     * @return the sauce type.
     */
    public BurgerSauce getSauce() {
        return sauce;
    }

    /**
     * Setter for the burger sauce type.
     * @param sauce
     */
    public void setSauce(BurgerSauce sauce) {
        if (sauce == null) {
            throw new IllegalArgumentException("The sauce argument cannot be null.");
        }
        this.sauce = sauce;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Burger burger)) return false;
        if (!super.equals(o)) return false;
        return sauce == burger.sauce;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sauce);
    }

    @Override
    public String toString() {
        return "Burger{" +
                "sauce=" + sauce +
                '}';
    }
}
