package com.expressswallows.controller;

import com.expressswallows.model.restaurant.Restaurant;
import com.expressswallows.utils.DatabaseConnectionUtils;
import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormEmployeeMainMenu;
import com.expressswallows.view.FormLogin;
import com.expressswallows.view.FormRestaurantDetails;

import javax.swing.*;
import java.util.ResourceBundle;

public class EmployeeMainMenuController {

    private FormEmployeeMainMenu formEmployeeMainMenu;

    public EmployeeMainMenuController(FormEmployeeMainMenu formEmployeeMainMenu) {
        this.formEmployeeMainMenu = formEmployeeMainMenu;
    }

    /**
     * Updates the language between English and French
     */
    public void updateLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formEmployeeMainMenu.logoutBtn.setText(rb.getString("logout"));
        formEmployeeMainMenu.langBtn.setText(rb.getString("lang"));
        formEmployeeMainMenu.allRestLbl.setText(rb.getString("allrest"));
    }

    /**
     * Logs out of the employee to go back to the login form
     */
    public void logout() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        String message = rb.getString("logmes");
        String title = rb.getString("select");

        int a = JOptionPane.showConfirmDialog(null, message, title,JOptionPane.YES_NO_OPTION);
        if(a == 0){
            formEmployeeMainMenu.dispose();
            new FormLogin().setVisible(true);
        }
    }

    /**
     * Opens the first restaurant from the database
     */
    public void openRest1() {
        try(var database = DatabaseConnectionUtils.getInstance()) {
            Restaurant restaurant1 = database.fetchRestaurantLocations().getFirst();
            formEmployeeMainMenu.dispose();
            new FormRestaurantDetails(restaurant1,formEmployeeMainMenu.employee).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the second restaurant from the database
     */
    public void openRest2() {
        try(var database = DatabaseConnectionUtils.getInstance()) {
            Restaurant restaurant1 = database.fetchRestaurantLocations().get(1);
            formEmployeeMainMenu.dispose();
            new FormRestaurantDetails(restaurant1, formEmployeeMainMenu.employee).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the third restaurant from the database
     */
    public void openRest3() {
        try(var database = DatabaseConnectionUtils.getInstance()) {
            Restaurant restaurant1 = database.fetchRestaurantLocations().get(2);
            formEmployeeMainMenu.dispose();
            new FormRestaurantDetails(restaurant1, formEmployeeMainMenu.employee).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the fourth restaurant from the database
     */
    public void openRest4() {
        try(var database = DatabaseConnectionUtils.getInstance()) {
            Restaurant restaurant1 = database.fetchRestaurantLocations().get(3);
            formEmployeeMainMenu.dispose();
            new FormRestaurantDetails(restaurant1, formEmployeeMainMenu.employee).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
