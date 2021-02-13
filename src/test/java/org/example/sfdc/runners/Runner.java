package org.example.sfdc.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.example.sfdc.core.Env;
import org.example.sfdc.core.ui.DriverManager;
import org.example.sfdc.pages.login.Login;

/**
 * Runner class for all tests.
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"},
        features = {"src/test/resources/features"},
        glue = {"org.example.sfdc"},
        tags = "@bvt"
)
public class Runner extends AbstractTestNGCucumberTests {

    private static final Env ENV = Env.getInstance();

    /**
     * Opens the browser and log in to Sales Force.
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
