package com.expressswallows;

import com.expressswallows.controller.OrderProcessingController;
import com.expressswallows.exceptions.DatabaseException;
import com.expressswallows.view.FormLogin;

/**
 * Main entry point for the Delivery System Application.
 *
 */
public class Main {

    public static void main(String[] args ) throws DatabaseException {
        // Call the getInstance method to start the order processor
        OrderProcessingController orderProcessor = OrderProcessingController.getInstance();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }
}
