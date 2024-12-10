/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.controller;

import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormEmployeeMainMenu;
import com.expressswallows.view.FormLogin;
import com.expressswallows.view.FormSignup;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 *
 * @author shahi
 */
public class LoginController {
    
    private FormLogin formLogin;
    
    public LoginController(FormLogin formLogin) {
        this.formLogin = formLogin;
    }

    /***
     * When you click on the password box it will show the user the password
     */
    public void passwordChange() {
        if(formLogin.passwordBox.isSelected()){
            formLogin.passwordTB.setEchoChar((char)0);
        }else{
            formLogin.passwordTB.setEchoChar('*');
        }
    }

    /**
     * Updates the language between English and French
     */
    public void updateLang() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formLogin.langBtn.setText(rb.getString("lang"));
        formLogin.loginBtn.setText(rb.getString("login"));
        formLogin.logoutBtn.setText(rb.getString("logout"));
        formLogin.emailLbl.setText(rb.getString("email"));
        formLogin.passwordLbl.setText(rb.getString("password"));
        formLogin.errorLbl.setText(rb.getString("error"));
        formLogin.passwordBox.setText(rb.getString("showpass"));
        formLogin.signupBtn.setText(rb.getString("signup"));
        formLogin.loginLbl.setText(rb.getString("login"));
    }

    /**
     * Logs out of the application if the user wants to
     */
    public void logout() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("exitMes");
        String title = rb.getString("select");

        int a = JOptionPane.showConfirmDialog(null, message, title,JOptionPane.YES_NO_OPTION);
        if(a == 0){
            System.exit(0);
        }
    }

    /**
     * If the user or client exists in the database and has the matching credentials, it will allow them to go to the next frame
     */
    public void login() {
        String email = formLogin.emailTB.getText();
        String password = formLogin.passwordTB.getText();

        Client client = ClientController.login(email, password);
        Employee employee = EmployeeController.login(email, password);
        if (client != null) {
            Order order = new Order(client);
            formLogin.dispose();
            new FormClientMainMenu(client, order).setVisible(true);
        } else if (employee != null) {
            formLogin.dispose();
            new FormEmployeeMainMenu(employee).setVisible(true);
        } else {
            formLogin.errorLbl.setVisible(true);
        }
    }

    /**
     * opens the signup frame
     */
    public void signup() {
        formLogin.setVisible(false);
        new FormSignup().setVisible(true);
    }


    
}
