package com.expressswallows.controller;

import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormOrderDetails;
import com.expressswallows.view.FormViewOrders;

import javax.swing.*;
import java.util.List;
import java.util.ResourceBundle;

public class ViewOrdersController {

    private FormViewOrders formViewOrders;

    public ViewOrdersController(FormViewOrders formViewOrders) {
        this.formViewOrders = formViewOrders;
    }

    /**
     *
     */
    public void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formViewOrders.backBtn.setText(rb.getString("back"));
        formViewOrders.yourOrdersLbl.setText(rb.getString("orderhistory"));
        formViewOrders.langBtn.setText(rb.getString("lang"));
    }

    /**
     *
     */
    public void backButtonClicked() {
        formViewOrders.dispose();
        new FormClientMainMenu(formViewOrders.client, formViewOrders.order).setVisible(true);
    }

    /**
     *
     */
    public void openOrderDetails(Order order) {
        formViewOrders.dispose();
        FormOrderDetails orderDetailsForm = new FormOrderDetails(formViewOrders.client, order);
        orderDetailsForm.setVisible(true);
    }

    /***
     * Loads all the orders from a client
     * @param client Client
     */
    public void loadOrders(Client client) {

        try(var database = DatabaseConnectionUtils.getInstance()) {
            List<Order> orders = database.fetchOrdersByClientId(client.getClientId());
            DefaultListModel<String> listModel = new DefaultListModel<>();

            for (Order order : orders) {
                listModel.addElement("Order ID: " + order.getOrderId() + " Total: $" + order.calculateTotalPrice());
            }
            formViewOrders.listOfOrders.setModel(listModel);

            formViewOrders.listOfOrders.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = formViewOrders.listOfOrders.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Order selectedOrder = orders.get(selectedIndex);
                        openOrderDetails(selectedOrder);
                    }
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
