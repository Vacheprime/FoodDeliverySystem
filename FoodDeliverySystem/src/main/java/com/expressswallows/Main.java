package com.expressswallows;

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
        LocalDate d1 = LocalDate.of(2005, 03, 15);
        System.out.println(d1);
        Employee e1 = new Employee("Andrew","Shahini","andrewshahini@gmail.com","123456",d1,"(123) 123-1234");
    }
}
