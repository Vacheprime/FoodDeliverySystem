package com.expressswallows.model.menu.fooditems;

/**
 * Food abstract class is used to represent food items sold by the restaurant.
 * @author shahi
 */
public abstract class Food {
    private int productId;
    private int cookTime;
    private double price;

    /**
     * All argument constructor for a food item.
     * 
     * @param cookTime the time it takes to cook the food item in minutes.
     * @param price the price of the food item.
     */
    public Food(int cookTime, double price) {
        this.cookTime = cookTime;
        this.price = price;
    }

    /**
     * Getter for the cook time.
     * @return the cook time.
     */
    public int getCookTime() {
        return cookTime;
    }

    /**
     * Getter for the product ID.
     * @return the product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Setter for the product ID.
     * Used since the ID is assigned when the food item is inserted into the
     * database and not when the food object is created.
     * @param productId the product ID.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Getter for the food item's price.
     * @return the price of the food item.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Abstract method prepare is used by subclasses to let them initialize
     * their fields with their own predefined values.
     * 
     * @return the food item (the object itself) initialized with the right
     * values.
     */
    public abstract Food prepare();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.productId;
        hash = 37 * hash + this.cookTime;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        final Food other = (Food) obj;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.cookTime != other.cookTime) {
            return false;
        }
        return Double.doubleToLongBits(this.price) == Double.doubleToLongBits(other.price);
    }

    @Override
    public String toString() {
        return "Food{" + "productId=" + productId + ", cookTime=" + cookTime + ", price=" + price + '}';
    }
}
