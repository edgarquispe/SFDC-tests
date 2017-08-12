package org.fundacionjala.sfdc.driver;

import org.openqa.selenium.WebDriver;

/**
 * Created by abelb on 8/12/2017.
 */
public interface IBrowser {

    /**
     * Gets the WebDriver to use.
     *
     * @return WebDriver.
     */
    WebDriver getBrowser();
}
