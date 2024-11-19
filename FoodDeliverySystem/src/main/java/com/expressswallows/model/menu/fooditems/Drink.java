package com.expressswallows.model.menu.fooditems;

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

    public Drink(int cookTime, int productId, double price, Size size) {
        super(cookTime, price);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
}
