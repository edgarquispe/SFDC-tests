package org.example.sfdc.core.ui;

import java.util.EnumMap;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

/**
 * Driver Factory class that gets the browser.
 */
public final class BrowserFactory {

    private static final EnumMap<DriverType, Supplier<Browser>> BROWSERS = new EnumMap<>(DriverType.class);
    static {
        BROWSERS.put(DriverType.CHROME, ChromeBrowser::new);
        BROWSERS.put(DriverType.FIREFOX, FirefoxBrowser::new);
        BROWSERS.put(DriverType.SAUCELABS, SauceLabs::new);
        BROWSERS.put(DriverType.BROWSERSTACK, BrowserStack::new);
        BROWSERS.put(DriverType.DOCKER_CHROME, DockerChromeBrowser::new);
        BROWSERS.put(DriverType.DOCKER_FIREFOX, DockerFirefoxBrowser::new);
    }

    /**
     * Private Constructor.
     */
    private BrowserFactory() {
    }

    /**
     * Return current Driver.
     *
     * @param driverType Enum from DriverType.
     * @return Current WebDriver.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        return BROWSERS.get(driverType).get().getBrowser();
    }
}
