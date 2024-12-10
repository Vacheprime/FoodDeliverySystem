package com.expressswallows.controller;

import com.expressswallows.model.restaurant.users.Client;
import com.expressswallows.model.restaurant.users.Employee;
import com.expressswallows.utils.DatabaseConnectionUtils;

public class EmployeeController {

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
