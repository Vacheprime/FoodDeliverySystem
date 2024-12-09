package com.expressswallows.model.menu.fooditems.pizzas;

import java.util.List;

/**
 * AllDressedPizza class is used to represent an All-Dressed pizza.
 */
public class AllDressedPizza extends Pizza {
    private static final int cookTime = 25;
    private static final double price = 22.99;
    private static final List<String> toppings = List.of("Mozzarella", "Pepperoni",
            "Mushrooms", "Bell peppers", "Chicken");

    /**
     * Constructor for an All-Dressed pizza.
     */
    public AllDressedPizza() {
        super(cookTime, price);
        this.prepare();
    }

    @Override
    public String getDatabaseType() {
        return "PIZZA:ALLDRESSEDPIZZA";
    }

    /**
     * Prepare an All-Dressed pizza.
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
