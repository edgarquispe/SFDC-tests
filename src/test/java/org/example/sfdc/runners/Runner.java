package org.example.sfdc.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.example.core.ui.DriverManager;

/**
 * Runner class for all tests.
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"},
        features = {"src/test/resources/features"},
        glue = {"org.example"},
        tags = "@bvt"
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest()
    public void setUp() {
    }

    /**
     * Close the browser.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().quitDriver();
    }
}
