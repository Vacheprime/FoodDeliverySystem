package com.expressswallows.controller;

import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.factories.FriesFactory;
import com.expressswallows.model.menu.fooditems.Fries;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormFriesMenu;

import javax.swing.*;
import java.util.ResourceBundle;

public class FriesMenuController {

    private FormFriesMenu formFriesMenu;

    public FriesMenuController(FormFriesMenu formFriesMenu) {
        this.formFriesMenu = formFriesMenu;
    }

    /**
     * Updates the language between English and French
     */
    public void updateLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formFriesMenu.backBtn.setText(rb.getString("back"));
        formFriesMenu.langBtn.setText(rb.getString("lang"));
        formFriesMenu.friesMenuLbl.setText(rb.getString("friesmenu"));

        String priceText = String.format("%.2f", formFriesMenu.currentPrice);
        if (Utils.currentLocale.getLanguage().equals("en")) {
            formFriesMenu.priceLbl.setText(rb.getString("price") + " $" + priceText);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            formFriesMenu.priceLbl.setText(rb.getString("price") + " " + priceText + "$");
        }

        formFriesMenu.addToCartBtn.setText(rb.getString("addtocart"));

        formFriesMenu.sizeBox.removeAllItems();

        formFriesMenu.sizeBox.addItem(rb.getString("small"));
        formFriesMenu.sizeBox.addItem(rb.getString("medium"));
        formFriesMenu.sizeBox.addItem(rb.getString("large"));
    }

    /**
     * Updates the language and remembers what choice you made in the combobox
     */
    public void updateLangAndIndex() {
        int selectedSize = formFriesMenu.sizeBox.getSelectedIndex();
        Utils.switchLanguage();
        formFriesMenu.controller.updateLanguage();
        formFriesMenu.sizeBox.setSelectedIndex(selectedSize);
    }

    /**
     * Opens the ClientMainMenu form
     */
    public void backButton() {
        formFriesMenu.dispose();
        new FormClientMainMenu(formFriesMenu.client, formFriesMenu.order).setVisible(true);
    }

    /**
     * Adds the fry to your cart by creating it from the factory
     */
    public void addToCart() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("friesMes");
        String title = rb.getString("friesTitle");


        int size = formFriesMenu.sizeBox.getSelectedIndex();
        FoodFactoryCreator creator = new FoodFactoryCreator();
        FriesFactory factory = (FriesFactory) creator.getFoodFactory("Fries");
        Fries fries = factory.createFries(size);
        formFriesMenu.order.addFoodToOrder(fries);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Changes the price label based on the size of the fries.
     */
    public void sizeControls() {
        int selectedSize = formFriesMenu.sizeBox.getSelectedIndex();

        switch (selectedSize) {
            case 0 -> formFriesMenu.currentPrice = formFriesMenu.SMALL_PRICE;
            case 1 -> formFriesMenu.currentPrice = formFriesMenu.MEDIUM_PRICE;
            case 2 -> formFriesMenu.currentPrice = formFriesMenu.LARGE_PRICE;
        }

        String priceText = String.format("%.2f", formFriesMenu.currentPrice);
        if (Utils.currentLocale.getLanguage().equals("en")) {
            formFriesMenu.priceLbl.setText("Price: $" + priceText);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            formFriesMenu.priceLbl.setText("Prix: " + priceText + "$");
        }
    }
}
