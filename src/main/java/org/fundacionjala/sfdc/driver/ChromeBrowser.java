package org.fundacionjala.sfdc.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by abelb on 8/12/2017.
 */
public class ChromeBrowser implements IBrowser {

    /**
     * Default Constructor.
     */
    public ChromeBrowser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        return new ChromeDriver();
    }
}
