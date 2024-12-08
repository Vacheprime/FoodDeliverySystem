package com.expressswallows.model.menu.fooditems.pizzas;

import java.util.List;

/**
 * CheesePizza class is used to represent a Cheese pizza.
 */
public class CheesePizza extends Pizza {
    private static final int cookTime = 15;
    private static final double price = 10.99;
    private static final List<String> toppings = List.of("Mozzarella");

    /**
     * Constructor for a new Cheese pizza.
     */
    public CheesePizza() {
        super(cookTime, price);
        this.prepare();
    }

    /**
     * Prepare the Cheese pizza.
     */
    @Override
    public void prepare() {
        for (String topping: toppings) {
            addTopping(topping);
        }
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
