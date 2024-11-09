package com.expressswallows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main entry point for the Delivery System Application.
 *
 */
public class Main 
{
    public static void main( String[] args ) throws ParseException
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse("2005-11-07");
        
        Employee e1 = new Employee("Andrew","Shahini","andrewshahini@gmail.com","123456",d1,"123-123-1234");
    }
}
