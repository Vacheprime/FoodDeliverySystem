/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.factories;

import com.expressswallows.model.menu.fooditems.Fries;
import com.expressswallows.model.menu.fooditems.burgers.Burger;
import com.expressswallows.model.menu.fooditems.drinks.Drink;
import com.expressswallows.model.menu.fooditems.hotdogs.Hotdog;
import com.expressswallows.model.menu.fooditems.pizzas.AllDressedPizza;
import com.expressswallows.model.menu.fooditems.pizzas.CheesePizza;
import com.expressswallows.model.menu.fooditems.pizzas.PepperoniPizza;
import com.expressswallows.model.menu.fooditems.pizzas.Pizza;

/**
 *
 * @author shahi
 */
public class PizzaFactory extends AbstractFactory {


    @Override
    public Burger createBurger(String request) {
        return null;
    }

    /***
     * Creates the pizza of choice from the pizza factory
     * @param request the pizza the client requested
     * @return the pizza
     */
    @Override
    public Pizza createPizza(String request) {
        if (request.equalsIgnoreCase("CheesePizza")) {
            return new CheesePizza();
        } else if (request.equalsIgnoreCase("PepperoniPizza")) {
            return new PepperoniPizza();
        } else if (request.equalsIgnoreCase("Alldressedpizza")) {
            return new AllDressedPizza();
        }
        return null;
    }

    @Override
    public Drink createDrink(int request, int size) {
        return null;
    }

    @Override
    public Hotdog createHotdog(String request) {
        return null;
    }

    @Override
    public Fries createFries(int request) {
        return null;
    }
}
