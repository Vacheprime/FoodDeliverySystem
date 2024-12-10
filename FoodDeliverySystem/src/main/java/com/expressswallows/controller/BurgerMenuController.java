package com.expressswallows.controller;

import com.expressswallows.model.menu.factories.BurgerFactory;
import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.fooditems.burgers.Burger;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormBurgerMenu;
import com.expressswallows.view.FormClientMainMenu;

import javax.swing.*;
import java.util.ResourceBundle;

public class BurgerMenuController {
    private FormBurgerMenu formBurgerMenu;

    public BurgerMenuController(FormBurgerMenu formBurgerMenu) {
        this.formBurgerMenu = formBurgerMenu;
    }

    /**
     * Updates the language between English and French
     */
    public void updateLang() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formBurgerMenu.backBtn.setText(rb.getString("back"));
        formBurgerMenu.burgerMenuLbl.setText(rb.getString("burgermenu"));
        formBurgerMenu.langBtn.setText(rb.getString("lang"));
        formBurgerMenu.bigFattyBtn.setText(rb.getString("addtocart"));
        formBurgerMenu.greenBushBtn.setText(rb.getString("addtocart"));
        formBurgerMenu.skinnyPityBtn.setText(rb.getString("addtocart"));

        if (Utils.currentLocale.getLanguage().equals("en")) {
            formBurgerMenu.priceBFLbl.setText(rb.getString("price") + "$" + formBurgerMenu.PRICEBF);
            formBurgerMenu.priceGBLbl.setText(rb.getString("price") + "$" + formBurgerMenu.PRICEGB);
            formBurgerMenu.priceSPLbl.setText(rb.getString("price") + "$" + formBurgerMenu.PRICESP);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            formBurgerMenu.priceBFLbl.setText(rb.getString("price") + formBurgerMenu.PRICEBF + "$");
            formBurgerMenu.priceGBLbl.setText(rb.getString("price") + formBurgerMenu.PRICEGB + "$");
            formBurgerMenu.priceSPLbl.setText(rb.getString("price") + formBurgerMenu.PRICESP + "$");
        }
    }

    /**
     * Opens the client main menu
     */
    public void backButton() {
        formBurgerMenu.dispose();
        new FormClientMainMenu(formBurgerMenu.client, formBurgerMenu.order).setVisible(true);
    }

    /***
     * Creates the BigFatty from the factory
     */
    public void addBigFatty() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String choice = "BigFatty";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        BurgerFactory factory = (BurgerFactory) creator.getFoodFactory("Burger");
        Burger burger = factory.createBurger(choice);
        formBurgerMenu.order.addFoodToOrder(burger);
        String message = rb.getString("bigfattymessage");
        String title = rb.getString("burgerTitle");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /***
     * Creates the GreenBush from the factory
     */
    public void addGreenBush() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String choice = "GreenBush";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        BurgerFactory factory = (BurgerFactory) creator.getFoodFactory("Burger");
        Burger burger = factory.createBurger(choice);
        formBurgerMenu.order.addFoodToOrder(burger);
        String message = rb.getString("greenbushmes");
        String title = rb.getString("burgerTitle");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /***
     * Creates the SkinnyPity from the factory
     */
    public void addSkinnyPity() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String choice = "SkinnyPity";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        BurgerFactory factory = (BurgerFactory) creator.getFoodFactory("Burger");
        Burger burger = factory.createBurger(choice);
        formBurgerMenu.order.addFoodToOrder(burger);
        String message = rb.getString("skinnypitymes");
        String title = rb.getString("burgerTitle");
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
