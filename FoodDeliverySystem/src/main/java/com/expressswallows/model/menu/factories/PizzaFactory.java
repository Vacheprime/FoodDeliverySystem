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

    @Override
    public Pizza createPizza(String request) {
        if (request.equalsIgnoreCase("Cheese")) {
            return new CheesePizza();
        } else if (request.equalsIgnoreCase("Pepperoni")) {
            return new PepperoniPizza();
        } else if (request.equalsIgnoreCase("All dressed")) {
            return new AllDressedPizza();
        }
        return null;
    }

    @Override
    public Drink createDrink(String request, String size) {
        return null;
    }

    @Override
    public Hotdog createHotdog(String request) {
        return null;
    }

    @Override
    public Fries createFries(String request) {
        return null;
    }
}
