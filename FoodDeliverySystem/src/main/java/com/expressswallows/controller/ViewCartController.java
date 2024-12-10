package com.expressswallows.controller;

import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormPayment;
import com.expressswallows.view.FormViewCart;

import javax.swing.*;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCartController {

    private FormViewCart formViewCart;

    public ViewCartController(FormViewCart formViewCart) {
        this.formViewCart = formViewCart;
    }

    /**
     * Opens the ClientMainMenu frame
     */
    public void backButtonClicked() {
        formViewCart.dispose();
        new FormClientMainMenu(formViewCart.client, formViewCart.order).setVisible(true);
    }

    /**
     * Updates the language between English and French
     */
    public void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formViewCart.viewcartLbl.setText(rb.getString("yourcart"));
        formViewCart.payBtn.setText(rb.getString("pay"));
        formViewCart.backBtn.setText(rb.getString("back"));
        formViewCart.removeBtn.setText(rb.getString("remove"));
    }

    /**
     * Loads all the foods in the JList
     * @param foods list of foods
     */
    public void loadOrder(List<Food> foods) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Food food : foods) {
            listModel.addElement(food.getClass().getSimpleName());
        }
        formViewCart.listOrders.setModel(listModel);
    }

    /**
     * Removes a food from the list
     */
    public void remove() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String err = rb.getString("removeErr");
        String success = rb.getString("removeSuc");

        int selectedIndex = formViewCart.listOrders.getSelectedIndex(); // selected with the mouse
        if (selectedIndex != -1) {
            String selectedFood = formViewCart.listOrders.getSelectedValue();

            for (Food food : formViewCart.order.getFoods()) {
                if (food.getClass().getSimpleName().equals(selectedFood)) {
                    formViewCart.order.getFoods().remove(food);
                    JOptionPane.showMessageDialog(null, success);

                    DefaultListModel<String> model = (DefaultListModel<String>) formViewCart.listOrders.getModel();
                    model.removeElement(selectedFood);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    /**
     * Opens the Payment form
     */
    public void pay() {
        formViewCart.dispose();
        new FormPayment(formViewCart.client, formViewCart.order).setVisible(true);
    }

}
