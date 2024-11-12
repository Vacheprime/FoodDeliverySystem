package com.expressswallows;

import com.expressswallows.model.restaurant.users.Address;
import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.frmLogin;
import java.time.LocalDate;

/**
 * Main entry point for the Delivery System Application.
 *
 */
public class Main 
{
    public static void main(String[] args )
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });  
    }
}
