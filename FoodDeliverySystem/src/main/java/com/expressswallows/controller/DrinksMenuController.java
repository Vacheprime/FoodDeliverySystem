package com.expressswallows.controller;

import com.expressswallows.model.menu.factories.DrinkFactory;
import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.fooditems.drinks.Drink;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormDrinksMenu;

import javax.swing.*;
import java.util.ResourceBundle;

public class DrinksMenuController {

    private FormDrinksMenu formDrinksMenu;

    public DrinksMenuController(FormDrinksMenu formDrinksMenu) {
        this.formDrinksMenu = formDrinksMenu;
    }

    /**
     * Updates the language between English and French
     */
    public void updateLang() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formDrinksMenu.backBtn.setText(rb.getString("back"));
        formDrinksMenu.langBtn.setText(rb.getString("lang"));
        formDrinksMenu.drinksMenuLbl.setText(rb.getString("drinksmenu"));
        formDrinksMenu.sizeLbl.setText(rb.getString("size"));

        String priceText = String.format("%.2f", formDrinksMenu.currentPrice);
        if (Utils.currentLocale.getLanguage().equals("en")) {
            formDrinksMenu.priceLbl.setText(rb.getString("price") + " $" + priceText);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            formDrinksMenu.priceLbl.setText(rb.getString("price") + " " + priceText + "$");
        }

        formDrinksMenu.orderBtn.setText(rb.getString("addtocart"));

        formDrinksMenu.typeBox.removeItemAt(0);
        formDrinksMenu.typeBox.insertItemAt(rb.getString("water"),0);

        formDrinksMenu.sizeBox.removeAllItems();

        formDrinksMenu.sizeBox.addItem(rb.getString("small"));
        formDrinksMenu.sizeBox.addItem(rb.getString("medium"));
        formDrinksMenu.sizeBox.addItem(rb.getString("large"));
    }

    /**
     * Updates the language but also remembers what selection the user was on before
     */
    public void updateLangAndIndex() {
        int selectedSize = formDrinksMenu.sizeBox.getSelectedIndex();
        int selectedType = formDrinksMenu.typeBox.getSelectedIndex();
        Utils.switchLanguage();
        formDrinksMenu.controller.updateLang();
        formDrinksMenu.sizeBox.setSelectedIndex(selectedSize);
        formDrinksMenu.typeBox.setSelectedIndex(selectedType);
    }

    /**
     * Opens the ClientMainMenu form
     */
    public void backButton() {
        formDrinksMenu.dispose();
        new FormClientMainMenu(formDrinksMenu.client, formDrinksMenu.order).setVisible(true);
    }

    /**
     * Changes the price based on the selection of the drink size
     */
    public void sizeControls() {
        int selectedSize = formDrinksMenu.sizeBox.getSelectedIndex();

        switch (selectedSize) {
            case 0 -> formDrinksMenu.currentPrice = formDrinksMenu.SMALL;
            case 1 -> formDrinksMenu.currentPrice = formDrinksMenu.MEDIUM;
            case 2 -> formDrinksMenu.currentPrice = formDrinksMenu.LARGE;
        }

        String priceText = String.format("%.2f", formDrinksMenu.currentPrice);
        if (Utils.currentLocale.getLanguage().equals("en")) {
            formDrinksMenu.priceLbl.setText("Price: $" + priceText);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            formDrinksMenu.priceLbl.setText("Prix: " + priceText + "$");
        }
    }

    /**
     * Adds the drink to your cart from the factory
     */
    public void addToCart() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("drinkMes");
        String title = rb.getString("drinkTitle");

        int drinkChoice = formDrinksMenu.typeBox.getSelectedIndex();
        int size = formDrinksMenu.sizeBox.getSelectedIndex();
        FoodFactoryCreator creator = new FoodFactoryCreator();
        DrinkFactory factory = (DrinkFactory) creator.getFoodFactory("Drink");
        Drink drink = factory.createDrink(drinkChoice, size);
        formDrinksMenu.order.addFoodToOrder(drink);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
