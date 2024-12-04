/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.model.restaurant.users.Employee;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author shahi
 */
public class FormEmployeeMainMenu extends javax.swing.JFrame {

    List<Restaurant> restaurants;
    Employee employee;
    ImageIcon restaurant = new ImageIcon("FoodDeliverySystem/restaurants.jpg");
    
    /**
     * Creates new form frmEmployeeMainMenu
     */
    public FormEmployeeMainMenu(Employee employee) {
        initComponents();
        
        this.employee = employee;
        rest1lbl.setText("");
        rest1lbl.setIcon(restaurant);
        rest2lbl.setText("");
        rest2lbl.setIcon(restaurant);
        rest3lbl.setText("");
        rest3lbl.setIcon(restaurant);
        rest4lbl.setText("");
        rest4lbl.setIcon(restaurant);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rest1lbl = new javax.swing.JLabel();
        allRestaurantsLbl = new javax.swing.JLabel();
        rest2lbl = new javax.swing.JLabel();
        view1Btn = new javax.swing.JButton();
        view2Btn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        langBtn = new javax.swing.JButton();
        rest3lbl = new javax.swing.JLabel();
        rest4lbl = new javax.swing.JLabel();
        view3Btn = new javax.swing.JButton();
        view4Btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rest1lbl.setText("jLabel1");

        allRestaurantsLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        allRestaurantsLbl.setText("All Restaurants");

        rest2lbl.setText("jLabel2");

        view1Btn.setText("View");
        view1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view1BtnActionPerformed(evt);
            }
        });

        view2Btn.setText("View");
        view2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view2BtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("Log out");

        langBtn.setText("French");

        rest3lbl.setText("jLabel1");

        rest4lbl.setText("jLabel2");

        view3Btn.setText("View");
        view3Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view3BtnActionPerformed(evt);
            }
        });

        view4Btn.setText("View");
        view4Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view4BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rest1lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(view1Btn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rest2lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(view2Btn)
                                .addGap(120, 120, 120))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(allRestaurantsLbl)
                                .addGap(72, 72, 72)
                                .addComponent(langBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(view3Btn))
                                    .addComponent(rest3lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(rest4lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(view4Btn)
                                        .addGap(137, 137, 137)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allRestaurantsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn)
                    .addComponent(langBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rest1lbl)
                    .addComponent(rest2lbl))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view1Btn)
                    .addComponent(view2Btn))
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rest3lbl)
                    .addComponent(rest4lbl))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view3Btn)
                    .addComponent(view4Btn))
                .addContainerGap(278, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void view1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view1BtnActionPerformed
        this.dispose();
        new FormRestaurentDetails(restaurants.get(0), employee).setVisible(true);
    }//GEN-LAST:event_view1BtnActionPerformed

    private void view2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view2BtnActionPerformed
        this.dispose();
        new FormRestaurentDetails(restaurants.get(1), employee).setVisible(true);
    }//GEN-LAST:event_view2BtnActionPerformed

    private void view3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view3BtnActionPerformed
        this.dispose();
        new FormRestaurentDetails(restaurants.get(2), employee).setVisible(true);
    }//GEN-LAST:event_view3BtnActionPerformed

    private void view4BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view4BtnActionPerformed
        this.dispose();
        new FormRestaurentDetails(restaurants.get(3), employee).setVisible(true);
    }//GEN-LAST:event_view4BtnActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allRestaurantsLbl;
    private javax.swing.JButton langBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel rest1lbl;
    private javax.swing.JLabel rest2lbl;
    private javax.swing.JLabel rest3lbl;
    private javax.swing.JLabel rest4lbl;
    private javax.swing.JButton view1Btn;
    private javax.swing.JButton view2Btn;
    private javax.swing.JButton view3Btn;
    private javax.swing.JButton view4Btn;
    // End of variables declaration//GEN-END:variables
}
