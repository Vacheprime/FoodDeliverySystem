/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.factories;

import com.expressswallows.model.menu.fooditems.Fries;
import com.expressswallows.model.menu.fooditems.burgers.Burger;
import com.expressswallows.model.menu.fooditems.drinks.Drink;
import com.expressswallows.model.menu.fooditems.hotdogs.GlizzyGobbler;
import com.expressswallows.model.menu.fooditems.hotdogs.Hotdog;
import com.expressswallows.model.menu.fooditems.hotdogs.MillimeterDefeater;
import com.expressswallows.model.menu.fooditems.pizzas.Pizza;

/**
 *
 * @author shahi
 */
public class HotdogFactory extends AbstractFactory {


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
        if (request.equalsIgnoreCase("Glizzy Gobbler")) {
            return new GlizzyGobbler(Hotdog.HotdogBun.SOGGY);
        } else if (request.equalsIgnoreCase("Millimeter Defeater")) {
            return new MillimeterDefeater(Hotdog.HotdogBun.WHITE);
        }
        return null;
    }

    @Override
    public Fries createFries(int request) {
        return null;
    }
}
