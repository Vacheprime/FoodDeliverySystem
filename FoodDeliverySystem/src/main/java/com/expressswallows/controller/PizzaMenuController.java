package com.expressswallows.controller;

import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.factories.PizzaFactory;
import com.expressswallows.model.menu.fooditems.pizzas.Pizza;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormPizzaMenu;

import javax.swing.*;
import java.util.ResourceBundle;

public class PizzaMenuController {

    private FormPizzaMenu formPizzaMenu;

    public PizzaMenuController(FormPizzaMenu formPizzaMenu) {
        this.formPizzaMenu = formPizzaMenu;
    }

    /**
     * Updates the language between English and French
     */
    public void updateLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formPizzaMenu.backBtn.setText(rb.getString("back"));
        formPizzaMenu.langBtn.setText(rb.getString("lang"));
        formPizzaMenu.pizzaMenuLbl.setText(rb.getString("pizzamenu"));
        formPizzaMenu.cheeseLbl.setText(rb.getString("cheese"));
        formPizzaMenu.alldressLbl.setText(rb.getString("alldress"));
        formPizzaMenu.alldressBtn.setText(rb.getString("addtocart"));
        formPizzaMenu.pepperoniBtn.setText(rb.getString("addtocart"));
        formPizzaMenu.cheeseBtn.setText(rb.getString("addtocart"));
        formPizzaMenu.priceADLbl.setText(rb.getString("price"));
        formPizzaMenu.priceCheeseLbl.setText(rb.getString("price"));
        formPizzaMenu.pricePepLbl.setText(rb.getString("price"));

        if (Utils.currentLocale.getLanguage().equals("en")) {
            formPizzaMenu.priceCheeseLbl.setText(rb.getString("price") + "$" + formPizzaMenu.PRICECHEEESE);
            formPizzaMenu.pricePepLbl.setText(rb.getString("price") + "$" + formPizzaMenu.PRICEPEP);
            formPizzaMenu.priceADLbl.setText(rb.getString("price") + "$" + formPizzaMenu.PRICEAD);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            formPizzaMenu.priceCheeseLbl.setText(rb.getString("price") + formPizzaMenu.PRICECHEEESE + "$");
            formPizzaMenu.pricePepLbl.setText(rb.getString("price") + formPizzaMenu.PRICEPEP + "$");
            formPizzaMenu.priceADLbl.setText(rb.getString("price") + formPizzaMenu.PRICEAD + "$");
        }

    }

    /**
     * Opens the ClientMainMenu form
     */
    public void backButtonClicked() {
        formPizzaMenu.dispose();
        new FormClientMainMenu(formPizzaMenu.client, formPizzaMenu.order).setVisible(true);
    }

    /**
     * Adds the cheese pizza to your cart by creating it from the factory
     */
    public void cheesePizza() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("cheeseMes");
        String title = rb.getString("pizzaTitle");

        String choice = "CheesePizza";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        PizzaFactory factory = (PizzaFactory) creator.getFoodFactory("Pizza");
        Pizza pizza = factory.createPizza(choice);
        formPizzaMenu.order.addFoodToOrder(pizza);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Adds the pepperoni pizza to your cart by creating it from the factory
     */
    public void pepperoniPizza() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("pepMes");
        String title = rb.getString("pizzaTitle");

        String choice = "PepperoniPizza";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        PizzaFactory factory = (PizzaFactory) creator.getFoodFactory("Pizza");
        Pizza pizza = factory.createPizza(choice);
        formPizzaMenu.order.addFoodToOrder(pizza);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Adds the allDressed pizza to your cart by creating it from the factory
     */
    public void allDressedPizza() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("alldMes");
        String title = rb.getString("pizzaTitle");

        String choice = "AlldressedPizza";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        PizzaFactory factory = (PizzaFactory) creator.getFoodFactory("Pizza");
        Pizza pizza = factory.createPizza(choice);
        formPizzaMenu.order.addFoodToOrder(pizza);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
