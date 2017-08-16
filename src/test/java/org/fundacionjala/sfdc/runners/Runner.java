package org.fundacionjala.sfdc.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.fundacionjala.sfdc.core.Env;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pages.login.Login;

/**
 * Runner class for all tests.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.sfdc"})
public class Runner extends AbstractTestNGCucumberTests {

    private static final Env ENV = Env.getInstance();

    /**
     * Opens the browser and Logins to Sales Force.
     */
    @BeforeTest()
    public void loginToSalesForce() {
        Login.loginInitial(ENV.getUsername(), ENV.getPassword());
    }

    /**
     * Close the browser.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().quitDriver();
    }
}
