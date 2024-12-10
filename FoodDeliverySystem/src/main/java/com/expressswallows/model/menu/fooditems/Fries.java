/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.fooditems;

import java.util.Objects;

/**
 * Fries class represents the fries item.
 * @author shahi
 */
public class Fries extends Food {
    private FriesSize size;
    
    /**
     * FriesSize enum is used to represent the available portion sizes for fries.
     */
    public enum FriesSize {
        SMALL(2.99, 2),
        MEDIUM(3.49, 3),
        LARGE (4.99, 4);

        // Store the price and cook time for each fry size
        private final double price;
        private final int cookTime;

        /**
         * Constructor for frie size enum
         * @param price the price of the size.
         * @param cookTime the cook time of the size.
         */
        FriesSize(double price, int cookTime) {
            this.price = price;
            this.cookTime = cookTime;
        }

        /**
         * Getter for the size price.
         * @return
         */
        public double getPrice() {
            return price;
        }

        /**
         * Getter for the enum cook time.
         * @return
         */
        public int getCookTime() {
            return cookTime;
        }
    }

    /**
     * All argument constructor for a fries food item.
     * 
     * @param size the size of the fries.
     */
    public Fries(FriesSize size) {
        if (size == null) {
            throw new IllegalArgumentException("The fries size cannot be null.");
        }
        this.size = size;
    }

    /**
     * Getter for the size of the fries.
     * @return the size of the fries.
     */
    public FriesSize getSize() {
        return size;
    }


    @Override
    public String getDatabaseType() {
        return "FRIES:FRIES:"+size;
    }

    /**
     * Prepare the Fries based on the size chosen.
     */
    @Override
    public void prepare() {
        this.setPrice(this.size.getPrice());
        this.setCookTime(this.size.getCookTime());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.size);
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
        final Fries other = (Fries) obj;
        return this.size == other.size;
    }

    @Override
    public String toString() {
        return size + " fries";
    }
}
