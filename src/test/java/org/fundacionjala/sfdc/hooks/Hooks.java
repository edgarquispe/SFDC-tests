package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.sfdc.Env;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.login.Login;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Hooks Class for actions to run before and after Scenarios.
 */
public class Hooks {

    private static final Env ENV = Env.getInstance();
    private Helper helper;

    /**
     * Default Constructor.
     * @param helper Helper.
     */
    public Hooks(Helper helper) {
        this.helper = helper;
    }

    /**
     * Opens the browser and Logins to Sales Force.
     */
    @Before("@login")
    public void loginToSalesForce() {
        Login.loginInitial(ENV.getUsername(), ENV.getPassword());
    }

    /**
     * Delete Item.
     */
    @After(value = "@deleteProduct")
    public void deleteCreatedItem() {
        new ProductHome().deleteElement(helper.getDataMap().get(ProductFormField.PRODUCT_NAME).toString());
    }
}
