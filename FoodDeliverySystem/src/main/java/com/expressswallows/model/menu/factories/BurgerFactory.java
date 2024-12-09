/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.factories;

import com.expressswallows.model.menu.fooditems.Fries;
import com.expressswallows.model.menu.fooditems.burgers.BigFatty;
import com.expressswallows.model.menu.fooditems.burgers.Burger;
import com.expressswallows.model.menu.fooditems.burgers.GreenBush;
import com.expressswallows.model.menu.fooditems.burgers.SkinnyPity;
import com.expressswallows.model.menu.fooditems.drinks.Drink;
import com.expressswallows.model.menu.fooditems.hotdogs.Hotdog;
import com.expressswallows.model.menu.fooditems.pizzas.Pizza;

/**
 *
 * @author shahi
 */
public class BurgerFactory extends AbstractFactory{

    @Override
    public Burger createBurger(String request) {
        if (request.equalsIgnoreCase("BigFatty")) {
            return new BigFatty(Burger.BurgerSauce.SPICY);
        } else if (request.equalsIgnoreCase("SkinnyPity")) {
            return new SkinnyPity(Burger.BurgerSauce.CLASSIC);
        } else if (request.equalsIgnoreCase("GreenBush")) {
            return new GreenBush(Burger.BurgerSauce.CLASSIC);
        }
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
        return null;
    }
}
