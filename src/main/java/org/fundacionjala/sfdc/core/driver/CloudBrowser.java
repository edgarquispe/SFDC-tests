package org.fundacionjala.sfdc.core.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.sfdc.core.MyRuntimeException;

/**
 * This class abstracts and implements common methods of the navigators in the cloud.
 */
public abstract class CloudBrowser implements IBrowser {

    private static final Logger LOGGER = LogManager.getLogger();
    private String url;

    /**
     * This method sets the capabilities of the Cloud Browser.
     *
     * @return a Desired Capabilities instance.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * This is the constructor.
     *
     * @param url This variable contains the url authentication.
     */
    CloudBrowser(String url) {
        this.url = url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("Not instance driver");
            LOGGER.info(e);
            throw new MyRuntimeException(e);
        }
        return driver;
    }
}
