/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.factories;

/**
 *
 * @author shahi
 */
public class FoodFactoryCreator {

    public AbstractFactory getFoodFactory(String category) {
        if (category.equals("Burger")) {
            return new BurgerFactory();
        } else if (category.equals("Drink")) {
            return new DrinkFactory();
        } else if (category.equals("Fries")) {
            return new FriesFactory();
        } else if (category.equals("Hotdog")) {
            return new HotdogFactory();
        } else if (category.equals("Pizza")) {
            return new PizzaFactory();
        }
        return null;
    }
    
}
