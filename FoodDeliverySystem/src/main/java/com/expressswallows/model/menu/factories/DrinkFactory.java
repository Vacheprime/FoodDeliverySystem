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

    @Override
    public Drink createDrink(String request, String size) {
        if (request.equals("Coke")) {
            if (size.equals("Small")) {
                return new Coke(Drink.Size.SMALL);
            } else if (size.equals("Medium")) {
                return new Coke(Drink.Size.MEDIUM);
            } else if (size.equals("Large")) {
                return new Coke(Drink.Size.LARGE);
            }
        } else if (request.equals("Water")) {
            if (size.equals("Small")) {
                return new Water(Drink.Size.SMALL);
            } else if (size.equals("Medium")) {
                return new Water(Drink.Size.MEDIUM);
            } else if (size.equals("Large")) {
                return new Water(Drink.Size.LARGE);
            }
        } else if (request.equals("SevenUp")) {
            if (size.equals("Small")) {
                return new SevenUp(Drink.Size.SMALL);
            } else if (size.equals("Medium")) {
                return new SevenUp(Drink.Size.MEDIUM);
            } else if (size.equals("Large")) {
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
    public Fries createFries(String request) {
        return null;
    }
}
