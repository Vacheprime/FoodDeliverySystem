/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.factories;

import com.expressswallows.model.menu.fooditems.Fries;
import com.expressswallows.model.menu.fooditems.burgers.Burger;
import com.expressswallows.model.menu.fooditems.drinks.Coke;
import com.expressswallows.model.menu.fooditems.drinks.Drink;
import com.expressswallows.model.menu.fooditems.drinks.SevenUp;
import com.expressswallows.model.menu.fooditems.drinks.Water;
import com.expressswallows.model.menu.fooditems.hotdogs.Hotdog;
import com.expressswallows.model.menu.fooditems.pizzas.Pizza;

/**
 *
 * @author shahi
 */
public class DrinkFactory extends AbstractFactory {

    @Override
    public Burger createBurger(String request) {
        return null;
    }

    @Override
    public Pizza createPizza(String request) {
        return null;
    }

    /**
     * Creates a drink from the factory based on the user's choice
     * @param request Type of drink
     * @param size Size 0 for small, 1 for medium, and 2 for large
     * @return
     */
    @Override
    public Drink createDrink(int request, int size) {
        if (request == 1) {
            if (size == 0) {
                return new Coke(Drink.Size.SMALL);
            } else if (size == 1) {
                return new Coke(Drink.Size.MEDIUM);
            } else if (size == 2) {
                return new Coke(Drink.Size.LARGE);
            }
        } else if (request == 0) {
            if (size == 0) {
                return new Water(Drink.Size.SMALL);
            } else if (size == 1) {
                return new Water(Drink.Size.MEDIUM);
            } else if (size == 2) {
                return new Water(Drink.Size.LARGE);
            }
        } else if (request == 2) {
            if (size == 0) {
                return new SevenUp(Drink.Size.SMALL);
            } else if (size == 1) {
                return new SevenUp(Drink.Size.MEDIUM);
            } else if (size == 2) {
                return new SevenUp(Drink.Size.LARGE);
            }
        }
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
