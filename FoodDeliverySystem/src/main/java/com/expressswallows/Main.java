package com.expressswallows;

import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormLogin;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for the Delivery System Application.
 *
 */
public class Main 
{

public static List<Restaurant> restaurants = new ArrayList<>();
    public static void main(String[] args )
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
        restaurants.add(new Restaurant(new Address("dasds","12","H2R 2B1", Address.City.Montreal),"BBQ",0));
        restaurants.add(new Restaurant(new Address("street","13","D2R 2C1", Address.City.Montreal),"Poop",0));
    }
}
