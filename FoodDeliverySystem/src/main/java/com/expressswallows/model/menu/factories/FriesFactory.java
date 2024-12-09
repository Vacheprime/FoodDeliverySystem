/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.factories;

import com.expressswallows.model.menu.fooditems.Fries;
import com.expressswallows.model.menu.fooditems.burgers.Burger;
import com.expressswallows.model.menu.fooditems.drinks.Drink;
import com.expressswallows.model.menu.fooditems.hotdogs.Hotdog;
import com.expressswallows.model.menu.fooditems.pizzas.Pizza;

/**
 *
 * @author shahi
 */
public class FriesFactory extends AbstractFactory {


    @Override
    public Burger createBurger(String request) {
        return null;
    }

    @Override
    public Pizza createPizza(String request) {
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
        Fries fries;
        switch (request) {
            case 0:
                fries = new Fries(Fries.FriesSize.SMALL);
                break;
            case 1:
                fries = new Fries(Fries.FriesSize.MEDIUM);
                break;
            case 2:
                fries = new Fries(Fries.FriesSize.LARGE);
                break;
            default:
                throw new IllegalArgumentException("Invalid size request.");
        }
        fries.prepare();
        return fries;
    }
}
