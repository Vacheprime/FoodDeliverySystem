package com.expressswallows;

import com.expressswallows.exceptions.DatabaseException;
import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormLogin;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for the Delivery System Application.
 *
 */
public class Main {

    public static void main(String[] args ) throws DatabaseException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }
}
