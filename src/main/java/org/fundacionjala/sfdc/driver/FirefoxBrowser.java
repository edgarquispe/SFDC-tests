package org.fundacionjala.sfdc.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * FirefoxBrowser class that implements IBrowsers.
 */
public class FirefoxBrowser implements IBrowser {

    /**
     * Default Constructor.
     */
    public FirefoxBrowser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        return new FirefoxDriver();
    }
}
