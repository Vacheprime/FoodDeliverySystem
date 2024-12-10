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

    /**
     * Gets the food factory based on the client's choice
     * @param category which food item
     * @return the food item's factory
     */
    public AbstractFactory getFoodFactory(String category) {
        if (category.equalsIgnoreCase("Burger")) {
            return new BurgerFactory();
        } else if (category.equalsIgnoreCase("Drink")) {
            return new DrinkFactory();
        } else if (category.equalsIgnoreCase("Fries")) {
            return new FriesFactory();
        } else if (category.equalsIgnoreCase("Hotdog")) {
            return new HotdogFactory();
        } else if (category.equalsIgnoreCase("Pizza")) {
            return new PizzaFactory();
        }
        return null;
    }
    
}
