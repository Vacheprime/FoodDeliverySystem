package com.expressswallows.model.menu.fooditems;

import java.util.Objects;

/**
 * Drink class is used to represent 
 * @author Andrew and Danat
 */
public abstract class Drink extends Food {
    private Size size;
    private int sugarContent;
    
    /**
     * Size enum represents the different sizes of Drinks available.
     */
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    /**
     * All argument constructor for a drink object.
     * 
     * @param cookTime the cook time of the drink.
     * @param price the price of the drink.
     * 
     */
    public Drink(int cookTime, double price) {
        super(cookTime, price);
    }

    /**
     * Getter for the size of the drink.
     * @return the size of the drink.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Setter for the size of the drink.
     * @param size the new size of the drink.
     */
    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("The size cannot be null.");
        }
        this.size = size;
    }

    /**
     * Getter for the sugar content of the drink.
     * @return the sugar content of the drink.
     */
    public int getSugarContent() {
        return sugarContent;
    }

    /**
     * Setter for the sugar content of the drink.
     * @param sugarContent the new sugar content of the drink.
     */
    public void setSugarContent(int sugarContent) {
        this.sugarContent = sugarContent;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.size);
        hash = 71 * hash + this.sugarContent;
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
        final Drink other = (Drink) obj;
        if (this.sugarContent != other.sugarContent) {
            return false;
        }
        return this.size == other.size;
    }

    @Override
    public String toString() {
        return "Drink{" + "size=" + size + ", sugarContent=" + sugarContent + '}';
    }
}