package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.sfdc.Env;
import org.fundacionjala.sfdc.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.login.Login;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Created by abelb on 8/14/2017.
 */
public class Hooks {

    private static final Env ENV = Env.getInstance();
    private Helper helper;

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
//        ProductHome productHome = Navigator.goToProductsHome();
//        productHome.deleteElement(helper.getItemName());
        ProductHome.deleteElement(helper.getItemName());
//        ProductHome productHome = DriverManager.getInstance().getDriver().navigate().refresh();
        //For delete inside Details
//        helper.setProductHome((ProductHome) helper.getProductDetail().deleteItem());
//        helper.getProductHome().deleteElement("Automated");
//        helper.getProductDetail().deleteItem();
    }
}
