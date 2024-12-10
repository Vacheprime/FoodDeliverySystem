package com.expressswallows.controller;

import com.expressswallows.utils.Utils;
import com.expressswallows.view.*;

import javax.swing.*;
import java.util.ResourceBundle;

public class ClientMainMenuController {

    private FormClientMainMenu formClientMainMenu;

    public ClientMainMenuController(FormClientMainMenu formClientMainMenu) {
        this.formClientMainMenu = formClientMainMenu;
    }

    /**
     * Updates the language between English and French
     */
    public void updateLang() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formClientMainMenu.langBtn.setText(rb.getString("lang"));
        formClientMainMenu.logoutBtn.setText(rb.getString("logout"));
        formClientMainMenu.burgerBtn.setText(rb.getString("burgermenu"));
        formClientMainMenu.pizzaBtn.setText(rb.getString("pizzamenu"));
        formClientMainMenu.hotdogBtn.setText(rb.getString("hotdogmenu"));
        formClientMainMenu.friesBtn.setText(rb.getString("friesmenu"));
        formClientMainMenu.drinksBtn.setText(rb.getString("drinksmenu"));
        formClientMainMenu.viewCartBtn.setText(rb.getString("viewcart"));
        formClientMainMenu.viewPreOrderBtn.setText(rb.getString("viewprev"));
    }

    /**
     * Logs out of the application and goes back to the LoginForm
     */
    public void logout() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("logmes");
        String title = rb.getString("select");

        int a = JOptionPane.showConfirmDialog(null, message,title,JOptionPane.YES_NO_OPTION);
        if(a == 0){
            formClientMainMenu.dispose();
            new FormLogin().setVisible(true);
        }
    }

    /**
     * Opens the ViewOrders form
     */
    public void previousOrderButton() {
        formClientMainMenu.dispose();
        new FormViewOrders(formClientMainMenu.client, formClientMainMenu.order).setVisible(true);
    }

    /**
     * Opens the BurgerMenu form
     */
    public void burgerMenu() {
        formClientMainMenu.dispose();
        new FormBurgerMenu(formClientMainMenu.client, formClientMainMenu.order).setVisible(true);
    }

    /**
     * Opens the PizzaMenu form
     */
    public void pizzaMenu() {
        formClientMainMenu.dispose();
        new FormPizzaMenu(formClientMainMenu.client, formClientMainMenu.order).setVisible(true);
    }

    /**
     * Opens the DrinkMenu form
     */
    public void drinkMenu() {
        formClientMainMenu.dispose();
        new FormDrinksMenu(formClientMainMenu.client, formClientMainMenu.order).setVisible(true);
    }

    /**
     * Opens the FriesMenu form
     */
    public void friesMenu() {
        formClientMainMenu.dispose();
        new FormFriesMenu(formClientMainMenu.client, formClientMainMenu.order).setVisible(true);
    }

    /**
     * Opens the HotdogMenu form
     */
    public void hotdogMenu() {
        formClientMainMenu.dispose();
        new FormHotDogMenu(formClientMainMenu.client, formClientMainMenu.order).setVisible(true);
    }

    /**
     * Opens the ViewCart form
     */
    public void viewCart() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("emptyCartMes");
        String title = rb.getString("empty");

        if (formClientMainMenu.order.getFoods() != null && !formClientMainMenu.order.getFoods().isEmpty() && formClientMainMenu.order != null) {
            formClientMainMenu.dispose();
            new FormViewCart(formClientMainMenu.client, formClientMainMenu.order).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
