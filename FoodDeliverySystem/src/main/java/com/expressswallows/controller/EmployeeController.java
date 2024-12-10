package com.expressswallows.controller;

import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.utils.DatabaseConnectionUtils;

public class EmployeeController {

    /***
     * Checks the employee's credentials and allows them to login and go into the employee main menu
     * @param email email
     * @param password password
     * @return returns the employee if there's a match if not it returns null
     */
    public static Employee login (String email, String password) {
        Employee employee = null;
        try(var database = DatabaseConnectionUtils.getInstance()) {
            employee = database.fetchEmployeeWithCredentials(email, password);
            if(email != null) {
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
