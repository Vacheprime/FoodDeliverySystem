/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.Utils;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 *
 * @author shahi
 */
public class FormSignup extends javax.swing.JFrame {

    /**
     * Creates new form frmSignup
     */
    public FormSignup() {
        initComponents();
        update();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signupLbl = new javax.swing.JLabel();
        firstNameLbl = new javax.swing.JLabel();
        firstNameTB = new javax.swing.JTextField();
        langBtn = new javax.swing.JButton();
        lastNameLbl = new javax.swing.JLabel();
        lastNameTB = new javax.swing.JTextField();
        phoneNumberLbl = new javax.swing.JLabel();
        phoneNumberTB = new javax.swing.JTextField();
        emailLbl = new javax.swing.JLabel();
        emailTB = new javax.swing.JTextField();
        passwordTB = new javax.swing.JPasswordField();
        passwordLbl = new javax.swing.JLabel();
        streetNameLbl = new javax.swing.JLabel();
        streetNameTB = new javax.swing.JTextField();
        postalCodeLbl = new javax.swing.JLabel();
        postalCodeTB = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        signUpBtn = new javax.swing.JButton();
        passwordBox = new javax.swing.JCheckBox();
        streetNumTB = new javax.swing.JTextField();
        streetNumLbl = new javax.swing.JLabel();
        dobTB = new javax.swing.JTextField();
        dobLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        signupLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        signupLbl.setText("SIGN UP");

        firstNameLbl.setText("First name:");

        langBtn.setText("French");
        langBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langBtnActionPerformed(evt);
            }
        });

        lastNameLbl.setText("Last name:");

        phoneNumberLbl.setText("Phone number:");

        emailLbl.setText("Email:");

        passwordLbl.setText("Password:");

        streetNameLbl.setText("Street name:");

        postalCodeLbl.setText("Postal code:");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        signUpBtn.setText("Sign Up");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        passwordBox.setText("Show password");
        passwordBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordBoxActionPerformed(evt);
            }
        });

        streetNumLbl.setText("Street Number:");

        dobLbl.setText("Date of birth:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(langBtn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(postalCodeLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(postalCodeTB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(emailLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(emailTB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordTB, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addComponent(backBtn)
                                        .addGap(59, 59, 59)
                                        .addComponent(signUpBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(streetNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(streetNumTB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(streetNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addComponent(streetNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(lastNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lastNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(signupLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dobLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dobTB)
                            .addComponent(phoneNumberTB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(firstNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signupLbl)
                    .addComponent(langBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLbl)
                    .addComponent(firstNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLbl)
                    .addComponent(lastNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(phoneNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dobLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetNameLbl)
                    .addComponent(streetNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetNumTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetNumLbl))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postalCodeLbl)
                    .addComponent(postalCodeTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLbl)
                    .addComponent(emailTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLbl)
                    .addComponent(passwordTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(passwordBox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(signUpBtn))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        firstNameLbl.setText(rb.getString("firstname"));
        lastNameLbl.setText(rb.getString("lastname"));
        phoneNumberLbl.setText(rb.getString("phone"));
        dobLbl.setText(rb.getString("dob"));
        emailLbl.setText(rb.getString("email"));
        passwordLbl.setText(rb.getString("password"));
        passwordBox.setText(rb.getString("showpass"));
        streetNumLbl.setText(rb.getString("streetnum"));
        streetNameLbl.setText(rb.getString("streetname"));
        postalCodeLbl.setText(rb.getString("postal"));
        signupLbl.setText(rb.getString("signup"));
        backBtn.setText(rb.getString("back"));
        signUpBtn.setText(rb.getString("signup"));

    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        if (!checkClient())
        {
            return;
        }
        Client client = createClient();
        if (client == null) {
            JOptionPane.showMessageDialog(null, "User was null", "Creation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        FormLogin.clients.add(client);
        JOptionPane.showMessageDialog(null, "You have successfully created an account.", "Account Creation Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        new FormLogin().setVisible(true);

    }//GEN-LAST:event_signUpBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        Utils.switchLanguage();
        update();
    }//GEN-LAST:event_langBtnActionPerformed

    private void passwordBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordBoxActionPerformed
        if(passwordBox.isSelected()){
            passwordTB.setEchoChar((char)0);
        }else{
            passwordTB.setEchoChar('*');
        }
    }//GEN-LAST:event_passwordBoxActionPerformed


    /***
     * Creates a Client based on the textboxes from the JFrame and inserts them to the database
     * @return The created client or null if there was a sql exception
     */
    private Client createClient() {
        String first = firstNameTB.getText();
        String last = lastNameTB.getText();
        String phone = phoneNumberTB.getText();

        String dob = dobTB.getText(); //LocalDate (yyyy/mm/dd)
        LocalDate birthday = Utils.parseDobToLocalDate(dob);

        String streetNum = streetNumTB.getText();
        String streetName = streetNameTB.getText();
        String postal = postalCodeTB.getText();
        String email = emailTB.getText();
        String password = passwordTB.getText();

        try {
            Client client = new Client(first, last, email, password, birthday, phone,
                    new Address(streetName, streetNum, postal, Address.City.Montreal));
            //add them to database
            return client;
        } catch (Exception e/*SQLException ex*/) {

        }
        return null;
    }


    /***
     * Checks the client's input and validates them to see if they are properly formatted.
     * @return true if all the information is valid or false if one of the information is invalid
     */
    private boolean checkClient() {
        String first = firstNameTB.getText();
        String last = lastNameTB.getText();
        if (!first.isEmpty() || !last.isEmpty()) {
            JOptionPane.showMessageDialog(null, "First name and last name must not be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String dob = dobTB.getText();
        if (!Utils.validateDate(dob)) {
            JOptionPane.showMessageDialog(null, "Invalid dob.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.parse(dob, format);
        if (!Utils.validateClientAge(birthday)) {
            JOptionPane.showMessageDialog(null, "Date of birth is invalid or indicates an age that does not meet the requirement.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String phone = phoneNumberTB.getText();
        if (!Utils.validatePhoneNumber(phone)) {
            JOptionPane.showMessageDialog(null, "Phone number is invalid. Ensure it follows the required format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String email = emailTB.getText();
        if (!Utils.validateEmailAddress(email)) {
            JOptionPane.showMessageDialog(null, "Email address is invalid. Ensure it follows the required format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String postal = postalCodeTB.getText();
        if (!Utils.validatePostalCode(postal)) {
            JOptionPane.showMessageDialog(null, "Postal code is invalid. Ensure it follows the required format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String streetNum = streetNumTB.getText();
        String streetName = streetNameTB.getText();
        if (!streetNum.isEmpty() || !streetName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Street number and name must not be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String password = passwordTB.getText();
        if (!password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password must not be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JTextField dobTB;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTB;
    private javax.swing.JLabel firstNameLbl;
    private javax.swing.JTextField firstNameTB;
    private javax.swing.JButton langBtn;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JTextField lastNameTB;
    private javax.swing.JCheckBox passwordBox;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPasswordField passwordTB;
    private javax.swing.JLabel phoneNumberLbl;
    private javax.swing.JTextField phoneNumberTB;
    private javax.swing.JLabel postalCodeLbl;
    private javax.swing.JTextField postalCodeTB;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JLabel signupLbl;
    private javax.swing.JLabel streetNameLbl;
    private javax.swing.JTextField streetNameTB;
    private javax.swing.JLabel streetNumLbl;
    private javax.swing.JTextField streetNumTB;
    // End of variables declaration//GEN-END:variables
}
