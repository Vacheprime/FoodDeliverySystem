package com.expressswallows.controller;

import com.expressswallows.model.restaurant.Order;
import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormClientMainMenu;
import com.expressswallows.view.FormEmployeeMainMenu;

import javax.swing.*;
import java.time.LocalDate;

public class ClientController {

    /***
     * Creates a Client based on the textboxes from the JFrame and inserts them to the database
     * @return The created client or null if there was a sql exception
     */
    public static Client createClient(String first, String last, String phone, String dob, String streetNum, String streetName, String postal, String email, String password) {

        LocalDate birthday = Utils.parseDobToLocalDate(dob);

        try {
            Client client = new Client(first, last, email, password, birthday, phone,
                    new Address(streetName, streetNum, postal, Address.City.MONTREAL));
            return client;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean validateClientFirstAndLast(String first, String last) {
        if (!Utils.validateName(first) || !Utils.validateName(last)) {
            return false;
        }
        return true;
    }

    public static boolean validateClientDob(String dob) {
        if (!Utils.validateDate(dob)) {
            return false;
        }
        return true;
    }

    public static boolean validateClientPhone(String phone) {
        if (!Utils.validatePhoneNumber(phone)) {
            return false;
        }
        return true;
    }

    public static boolean validateClientEmail(String email) {
        if (!Utils.validateEmailAddress(email)) {
            return false;
        }
        return true;
    }

    public static boolean validateClientPassword(String password) {
        if (password.length() < 6) {
            return false;
        }
        return true;
    }

    public static boolean validateClientPostalCode(String postalCode) {
        if (!Utils.validatePostalCode(postalCode)) {
            return false;
        }
        return true;
    }

    public static boolean validateClientAddress(String streetName, String streetNum) {
        if (streetNum.isEmpty() || streetName.isEmpty()) {
            return false;
        }
        return true;
    }

    public static Client login(String email, String password) {
        Client client = null;
        try(var database = DatabaseConnectionUtils.getInstance()) {
            client = database.fetchClientWithCredentials(email, password);
            if(client != null) {
                return client;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
