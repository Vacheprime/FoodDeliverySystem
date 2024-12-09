/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author shahi
 */
public class FormViewOrders extends javax.swing.JFrame {

    Client client;
    Order order;
    //static List<Order> orders = new ArrayList<>();
    private double price;
    /**
     * Creates new form FormViewOrders
     */
    public FormViewOrders(Client client, Order order) {
        initComponents();
        this.client = client;
        this.order = order;

        loadOrders(client);
        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yourOrdersLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        langBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfOrders = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        yourOrdersLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        yourOrdersLbl.setText("Your Orders History");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        langBtn.setText("French");
        langBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listOfOrders);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(backBtn)
                        .addGap(18, 18, 18)
                        .addComponent(yourOrdersLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(langBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(yourOrdersLbl)
                    .addComponent(langBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        backBtn.setText(rb.getString("back"));
        yourOrdersLbl.setText(rb.getString("orderhistory"));
        langBtn.setText(rb.getString("lang"));
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        new FormClientMainMenu(client, order).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        Utils.switchLanguage();
        update();
    }//GEN-LAST:event_langBtnActionPerformed

    private void loadOrders(Client client) {

        try(var database = DatabaseConnectionUtils.getInstance()) {
           List<Order> orders = database.fetchOrdersByClientId(client.getClientId());
            DefaultListModel<String> listModel = new DefaultListModel<>();

            for (Order order : orders) {
                listModel.addElement("Order ID: " + order.getOrderId() + " Total: $" + order.calculateTotalPrice());
            }
            listOfOrders.setModel(listModel);

            listOfOrders.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = listOfOrders.getSelectedIndex();
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

    private void openOrderDetails(Order order) {
        this.dispose();
        FormOrderDetails orderDetailsForm = new FormOrderDetails(client, order);
        orderDetailsForm.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton langBtn;
    private javax.swing.JList<String> listOfOrders;
    private javax.swing.JLabel yourOrdersLbl;
    // End of variables declaration//GEN-END:variables
}
