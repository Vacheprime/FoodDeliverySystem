package com.expressswallows.controller;

import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormLogin;
import com.expressswallows.view.FormSignup;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SignupController {

    private FormSignup formSignup;

    public SignupController(FormSignup formSignup) {
        this.formSignup = formSignup;
    }

    /**
     * Shows the password when the password box is clicked
     */
    public void showPassword() {
        if(formSignup.passwordBox.isSelected()){
            formSignup.passwordTB.setEchoChar((char)0);
        }else{
            formSignup.passwordTB.setEchoChar('*');
        }
    }

    /***
     * Updates the language between English and French
     */
    public void updateLang() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formSignup.firstNameLbl.setText(rb.getString("firstname"));
        formSignup.lastNameLbl.setText(rb.getString("lastname"));
        formSignup.phoneNumberLbl.setText(rb.getString("phone"));
        formSignup.dobLbl.setText(rb.getString("dob"));
        formSignup.emailLbl.setText(rb.getString("email"));
        formSignup.passwordLbl.setText(rb.getString("password"));
        formSignup.passwordBox.setText(rb.getString("showpass"));
        formSignup.streetNumLbl.setText(rb.getString("streetnum"));
        formSignup.streetNameLbl.setText(rb.getString("streetname"));
        formSignup.postalCodeLbl.setText(rb.getString("postal"));
        formSignup.signupLbl.setText(rb.getString("signup"));
        formSignup.backBtn.setText(rb.getString("back"));
        formSignup.signUpBtn.setText(rb.getString("signup"));
    }

    /***
     * Creates the client's account after it checks to see if all the inputs are valid
     */
    public void createAccount() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("usernull");
        String title = rb.getString("creationerror");
        String message2 = rb.getString("successAc");
        String title2 = rb.getString("successTitle");

        String first = formSignup.firstNameTB.getText();
        String last = formSignup.lastNameTB.getText();
        String phone = formSignup.phoneNumberTB.getText();

        String dob = formSignup.dobTB.getText(); //LocalDate (yyyy/mm/dd)

        String streetNum = formSignup.streetNumTB.getText();
        String streetName = formSignup.streetNameTB.getText();
        String postal = formSignup.postalCodeTB.getText();
        String email = formSignup.emailTB.getText();
        String password = formSignup.passwordTB.getText();

        if (!checkClient()) {
            return;
        }
        Client client = ClientController.createClient(first, last, phone, dob, streetNum, streetName, postal, email, password);
        if (client == null) {
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
            return;
        }
        try(var database = DatabaseConnectionUtils.getInstance()) {
            database.insertClient(client);
        } catch (Exception de) {
            de.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, message2, title2, JOptionPane.INFORMATION_MESSAGE);
        formSignup.dispose();
        new FormLogin().setVisible(true);
    }

    /**
     * Opens the FormLogin
     */
    public void backButton() {
        formSignup.dispose();
        new FormLogin().setVisible(true);
    }


    /***
     * Checks the client's input and validates them to see if they are properly formatted.
     * @return true if all the information is valid or false if one of the information is invalid
     */
    private boolean checkClient() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String firstLast = rb.getString("firstLast");
        String val = rb.getString("val");
        String doberror = rb.getString("doberror");
        String dober = rb.getString("dober");
        String phoneerr = rb.getString("phoneerr");
        String emailerr = rb.getString("emailerr");
        String postalerr = rb.getString("postalerr");
        String streeterr = rb.getString("streeterr");
        String passerr = rb.getString("passerr");

        String first = formSignup.firstNameTB.getText();
        String last = formSignup.lastNameTB.getText();
        if (!ClientController.validateClientFirstAndLast(first,last)){
            JOptionPane.showMessageDialog(null, firstLast, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String dob = formSignup.dobTB.getText();
        if (!ClientController.validateClientDob(dob)) {
            JOptionPane.showMessageDialog(null, doberror, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.parse(dob, format);
        if (!Utils.validateClientAge(birthday)) {
            JOptionPane.showMessageDialog(null, dober, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String phone = formSignup.phoneNumberTB.getText();
        if (!ClientController.validateClientPhone(phone)) {
            JOptionPane.showMessageDialog(null, phoneerr, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String email = formSignup.emailTB.getText();

        if (!ClientController.validateClientEmail(email)) {
            JOptionPane.showMessageDialog(null, emailerr, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String postal = formSignup.postalCodeTB.getText();
        if (!ClientController.validateClientPostalCode(postal)) {
            JOptionPane.showMessageDialog(null, postalerr, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String streetNum = formSignup.streetNumTB.getText();
        String streetName = formSignup.streetNameTB.getText();
        if (!ClientController.validateClientAddress(streetName,streetNum)) {
            JOptionPane.showMessageDialog(null, streeterr, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String password = formSignup.passwordTB.getText();
        if (!ClientController.validateClientPassword(password)) {
            JOptionPane.showMessageDialog(null, passerr, val, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
