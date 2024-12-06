package com.expressswallows.model.menu.fooditems.pizzas;

import java.util.List;

/**
 * PepperoniPizza class is used to represent Pizza.
 */
public class PepperoniPizza extends Pizza {
    private static final int cookTime = 20;
    private static final double price = 17.99;
    private static final List<String> toppings = List.of("Pepperoni", "Mozzarella");

    /**
     * Constructor for a new Pepperoni pizza.
     */
    public PepperoniPizza() {
        super(cookTime, price);
    }

    /**
     * Prepare the Pepperoni pizza.
     */
    @Override
    public void prepare() {
        for (String topping: toppings) {
            addTopping(topping);
        }
    }
}
