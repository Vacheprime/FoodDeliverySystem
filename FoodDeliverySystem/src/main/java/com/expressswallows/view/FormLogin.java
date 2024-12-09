/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.expressswallows.view;

import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.model.restaurant.users.Person;
import com.expressswallows.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shahi
 */
public class FormLogin extends javax.swing.JFrame {
    LocalDate d1 = LocalDate.of(2005, 03, 15);
    Employee e1 = new Employee("Andrew","Shahini","andrewshahini@gmail.com","123456",d1,"(123) 123-1234");
    Employee e2 = new Employee("Danat","Muradov","danatmuradov@gmail.com","123456",d1,"(123) 123-1234");

    public static List<Client> clients = new ArrayList<>();
    
    
    /**
     * Creates new form frmLogin
     */
    public FormLogin() {
        initComponents();
        clients.add(new Client("Andy", "Shah", "andrew@gmail.com", "123456", d1, "(123) 122-1323", new Address("Street", "122", "H2R 2B1", Address.City.MONTREAL)));

        errorLbl.setVisible(false);
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

        loginLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        emailTB = new javax.swing.JTextField();
        errorLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        langBtn = new javax.swing.JButton();
        passwordBox = new javax.swing.JCheckBox();
        logoutBtn = new javax.swing.JButton();
        signupBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        passwordTB = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        loginLbl.setText("LOGIN");

        emailLbl.setText("email:");

        errorLbl.setForeground(new java.awt.Color(255, 51, 51));
        errorLbl.setText("Incorrect email or password!");

        passwordLbl.setText("password:");

        langBtn.setText("French");
        langBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langBtnActionPerformed(evt);
            }
        });

        passwordBox.setText("Show password");
        passwordBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordBoxActionPerformed(evt);
            }
        });

        logoutBtn.setText("Log Out");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        signupBtn.setText("Sign Up");
        signupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBtnActionPerformed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(emailLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailTB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(passwordTB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(errorLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(signupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(langBtn)
                        .addGap(128, 128, 128)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(langBtn)
                    .addComponent(logoutBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLbl)
                .addGap(12, 12, 12)
                .addComponent(passwordBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn)
                    .addComponent(signupBtn))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        langBtn.setText(rb.getString("lang"));
        loginBtn.setText(rb.getString("login"));
        logoutBtn.setText(rb.getString("logout"));
        emailLbl.setText(rb.getString("email"));
        passwordLbl.setText(rb.getString("password"));
        errorLbl.setText(rb.getString("error"));
        passwordBox.setText(rb.getString("showpass"));
        signupBtn.setText(rb.getString("signup"));
        loginLbl.setText(rb.getString("login"));
    }

    private void passwordBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordBoxActionPerformed
        if(passwordBox.isSelected()){
            passwordTB.setEchoChar((char)0);
        }else{
            passwordTB.setEchoChar('*');
        }
    }//GEN-LAST:event_passwordBoxActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you want to exit the application","Select",JOptionPane.YES_NO_OPTION);
        if(a == 0){
            System.exit(0); //exits
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

        /*
        var database = DatabaseUtilsConnection.getInstance();
        Client client = database.getClientByCredentials(emailTB.getText(), passwordTB.getText());
        Employee employee = database.getEmployeeByCredentials(emailTB.getText(), passwordTB.getText());
        database.CloseConnection();

        if (client != null) {
            Order order = new Order(client);
            this.dispose();
            new FormClientMainMenu(client, order).setVisible(true);
            return;
        } else if (employee != null) {
            this.dispose();
            new FormEmployeeMainMenu(employee).setVisible(true);
        } else {
            errorLbl.setVisible(true);
        }

         */


        if (emailTB.getText().equals(e1.getEmail()) && passwordTB.getText().equals(e1.getPassword()) ||
              emailTB.getText().equals(e2.getEmail()) && passwordTB.getText().equals(e2.getPassword())) {
        this.dispose();
        new FormEmployeeMainMenu(e1).setVisible(true);  
    }
    for (Client client : clients) {
        if (emailTB.getText().equals(client.getEmail()) && passwordTB.getText().equals(client.getPassword())) {
            
            Order order = new Order(client);
            this.dispose();
            new FormClientMainMenu(client, order).setVisible(true);
            return;
        }
    }

    errorLbl.setVisible(true);
    }//GEN-LAST:event_loginBtnActionPerformed

    private void langBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langBtnActionPerformed
        Utils.switchLanguage();
        update();
    }//GEN-LAST:event_langBtnActionPerformed

    private void signupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBtnActionPerformed
        setVisible(false);
        new FormSignup().setVisible(true);
    }//GEN-LAST:event_signupBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTB;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JButton langBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JCheckBox passwordBox;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPasswordField passwordTB;
    private javax.swing.JButton signupBtn;
    // End of variables declaration//GEN-END:variables
}
