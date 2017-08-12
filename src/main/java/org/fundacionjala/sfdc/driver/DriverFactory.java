package org.fundacionjala.sfdc.driver;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abelb on 8/12/2017.
 */
public final class DriverFactory {

    /**
     * Private Constructor.
     */
    private DriverFactory() {

    }

    /**
     * Return current Driver.
     *
     * @param driverType Enum from DriverType.
     * @return Current WebDriver.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        Map<DriverType, IBrowser> map = new HashMap<>();
        map.put(DriverType.CHROME, new ChromeBrowser());
        map.put(DriverType.FIREFOX, new FirefoxBrowser());
        return map.get(driverType).getBrowser();
    }
}
