package com.expressswallows.controller;

import com.expressswallows.model.menu.factories.FoodFactoryCreator;
import com.expressswallows.model.menu.factories.HotdogFactory;
import com.expressswallows.model.menu.fooditems.hotdogs.Hotdog;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormHotDogMenu;

import javax.swing.*;
import java.util.ResourceBundle;

public class HotdogMenuController {

    private FormHotDogMenu formHotDogMenu;

    public HotdogMenuController(FormHotDogMenu formHotDogMenu) {
        this.formHotDogMenu = formHotDogMenu;
    }

    /**
     * Opens the ClientMainMenuForm
     */
    public void backButton() {
        formHotDogMenu.dispose();
        new FormClientMainMenu(formHotDogMenu.client, formHotDogMenu.order).setVisible(true);
    }

    /**
     * Updates the language between English and French
     */
    public void updateLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formHotDogMenu.backBtn.setText(rb.getString("back"));
        formHotDogMenu.langBtn.setText(rb.getString("lang"));
        formHotDogMenu.hotdogMenuLbl.setText(rb.getString("hotdogmenu"));
        formHotDogMenu.glizzyBtn.setText(rb.getString("addtocart"));
        formHotDogMenu.millimeterBtn.setText(rb.getString("addtocart"));

        if (Utils.currentLocale.getLanguage().equals("en")) {
            formHotDogMenu.priceGGLbl.setText(rb.getString("price") + "$" + formHotDogMenu.PRICEGG);
            formHotDogMenu.priceMDLbl.setText(rb.getString("price") + "$" + formHotDogMenu.PRICEMD);
        } else if (Utils.currentLocale.getLanguage().equals("fr")) {
            formHotDogMenu.priceGGLbl.setText(rb.getString("price") + formHotDogMenu.PRICEGG + "$");
            formHotDogMenu.priceMDLbl.setText(rb.getString("price") + formHotDogMenu.PRICEMD + "$");
        }
    }

    /**
     * Creates the Millimeter Defeater from the factory and add it to the client's cart
     */
    public void addMD() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("mmMes");
        String title = rb.getString("hotTitle");

        String choice = "MillimeterDefeater";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        HotdogFactory factory = (HotdogFactory) creator.getFoodFactory("Hotdog");
        Hotdog hotdog = factory.createHotdog(choice);
        formHotDogMenu.order.addFoodToOrder(hotdog);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Creates the Glizzy Gobbler from the factory and add it to the client's cart
     */
    public void addGG() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("glizzyMes");
        String title = rb.getString("hotTitle");

        String choice = "GlizzyGobbler";
        FoodFactoryCreator creator = new FoodFactoryCreator();
        HotdogFactory factory = (HotdogFactory) creator.getFoodFactory("Hotdog");
        Hotdog hotdog = factory.createHotdog(choice);
        formHotDogMenu.order.addFoodToOrder(hotdog);
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
