package com.expressswallows.model.menu.fooditems.pizzas;

import com.expressswallows.model.menu.fooditems.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Pizza class represents all menu items that are pizzas.
 */
public abstract class Pizza extends Food {
    private List<String> toppings;

    /**
     * All argument constructor for a new pizza.
     * @param cookTime the cook time of the pizza.
     * @param price the price of the pizza.
     */
    public Pizza(int cookTime, double price) {
        super(cookTime, price);
        this.toppings = new ArrayList<>();
    }

    /**
     * Getter for the list of toppings.
     * @return the list of toppings.
     */
    public List<String> getToppings() {
        return toppings;
    }

    /**
     * Setter for the list of toppings.
     * @param toppings the new list of toppings.
     */
    public void setToppings(List<String> toppings) {
        if (toppings == null) {
            throw new IllegalArgumentException("The toppings argument cannot be null.");
        }
        this.toppings = toppings;
    }

    /**
     * Add a topping to the list of toppings.
     * @param topping the topping to add.
     */
    public void addTopping(String topping) {
        if (topping == null) {
            throw new IllegalArgumentException("The topping argument cannot be null.");
        }
        toppings.add(topping);
    }

    /**
     * Remove a topping from the list of toppings.
     * @param topping the topping to remove.
     */
    public void removeTopping(String topping) {
        toppings.remove(topping);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pizza pizza)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(toppings, pizza.toppings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), toppings);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                '}';
    }
}
