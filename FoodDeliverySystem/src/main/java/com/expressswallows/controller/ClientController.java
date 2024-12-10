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

    /**
     * Validates the client's first and last name
     * @param first first name
     * @param last last name
     * @return returns false if one of the two are invalid and returns true if they are valid
     */
    public static boolean validateClientFirstAndLast(String first, String last) {
        if (!Utils.validateName(first) || !Utils.validateName(last)) {
            return false;
        }
        return true;
    }

    /**
     * Validates the date of birth of the clients
     * @param dob Date of birth (YYYY-MM-DD)
     * @return true if the dob is valid and false if it is invalid
     */
    public static boolean validateClientDob(String dob) {
        if (!Utils.validateDate(dob)) {
            return false;
        }
        return true;
    }

    /***
     * Validates the client's phone number
     * @param phone phone number (xxx) xxx-xxxx
     * @return true if the phone number is valid and false if it invalid
     */
    public static boolean validateClientPhone(String phone) {
        if (!Utils.validatePhoneNumber(phone)) {
            return false;
        }
        return true;
    }

    /***
     * Validates the client's email address
     * @param email email
     * @return returns false if it is not a format valid and returns true if it has a valid format
     */
    public static boolean validateClientEmail(String email) {
        if (!Utils.validateEmailAddress(email)) {
            return false;
        }
        return true;
    }

    /***
     * Validates the client's password
     * @param password password
     * @return returns true if it is greater than 6 and less than 15 and returns false if it does not
     */
    public static boolean validateClientPassword(String password) {
        if (password.length() < 6 || password.length() > 15) {
            return false;
        }
        return true;
    }

    /***
     * Validates the client's postal code
     * @param postalCode postal code
     * @return returns false if it does not match the format and returns true if it does
     */
    public static boolean validateClientPostalCode(String postalCode) {
        if (!Utils.validatePostalCode(postalCode)) {
            return false;
        }
        return true;
    }

    /**
     * Validates the client's street name and street number
     * @param streetName street name
     * @param streetNum street number
     * @return true if it is valid and returns false if it is left empty
     */
    public static boolean validateClientAddress(String streetName, String streetNum) {
        if (streetNum.isEmpty() || streetName.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Allows a client to log in to the client main menu
     * @param email email
     * @param password password
     * @return Client that matches the email and password
     */
    public static Client login(String email, String password) {
        Client client = null;
        try (var database = DatabaseConnectionUtils.getInstance()) {
            client = database.fetchClientWithCredentials(email, password);
            if (client != null) {
                return client;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
