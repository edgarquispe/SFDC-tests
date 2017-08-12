package org.fundacionjala.sfdc.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by abelb on 8/12/2017.
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
