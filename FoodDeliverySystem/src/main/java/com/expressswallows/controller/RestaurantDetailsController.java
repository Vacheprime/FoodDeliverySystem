package com.expressswallows.controller;

import com.expressswallows.utils.Utils;
import com.expressswallows.view.FormEmployeeMainMenu;
import com.expressswallows.view.FormRestaurantDetails;

import java.util.ResourceBundle;

public class RestaurantDetailsController {

    private FormRestaurantDetails formRestaurantDetails;

    public RestaurantDetailsController(FormRestaurantDetails formRestaurantDetails) {
        this.formRestaurantDetails = formRestaurantDetails;
    }

    /**
     * Updates the language between English and French
     */
    public void updateLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Utils.currentLocale);
        formRestaurantDetails.titleLbl.setText(rb.getString("restdet"));
        formRestaurantDetails.nameLbl.setText(rb.getString("name") + formRestaurantDetails.restaurant.getName());
        formRestaurantDetails.locationLbl.setText(rb.getString("location") + formRestaurantDetails.restaurant.getLocation().toString());
        formRestaurantDetails.langBtn.setText(rb.getString("lang"));
        formRestaurantDetails.balanceLbl.setText(rb.getString("balance") + formRestaurantDetails.restaurant.getBalance());
        formRestaurantDetails.numOrdersLbl.setText(rb.getString("numorders"));
    }

    /**
     * Opens the EmployeeMainMenu form
     */
    public void backButtonClicked() {
        formRestaurantDetails.dispose();
        new FormEmployeeMainMenu(formRestaurantDetails.employee).setVisible(true);
    }
}
