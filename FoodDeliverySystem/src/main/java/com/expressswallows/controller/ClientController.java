package com.expressswallows.controller;

import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.utils.Utils;

import java.time.LocalDate;

public class ClientController {
    Client client;



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

}
