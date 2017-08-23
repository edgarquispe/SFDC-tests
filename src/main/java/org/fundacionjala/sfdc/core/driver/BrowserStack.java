package org.fundacionjala.sfdc.core.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.sfdc.core.Env;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * BrowserStack class that implements IBrowsers.
 */
public class BrowserStack implements IBrowser {

    private static final Env ENV = Env.getInstance();
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String USER_NAME = ENV.getRemoteUserName();
    private static final String ACCESS_KEY = ENV.getRemoteKey();
    private static final String URL =
            String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", USER_NAME, ACCESS_KEY);
    private static final String BROWSER = "browser";
    private static final String VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";
    private static final String RESOLUTION = "resolution";

    /**
     * This method save all capabilities.
     *
     * @return setting capabilities BrowserStack.
     */
    private DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER, ENV.getRemoteBrowser());
        caps.setCapability(VERSION, ENV.getRemoteBrowserVersion());
        caps.setCapability(OS, ENV.getRemotePlatform());
        caps.setCapability(OS_VERSION, ENV.getRemotePlatformVersion());
        caps.setCapability(RESOLUTION, ENV.getRemoteResolution());
        return caps;
    }

    /**
     * This method override get browser.
     *
     * @return Driver.
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), setCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.error("Not instance driver");
            throw new RuntimeException();
        }
        return driver;
    }
}
