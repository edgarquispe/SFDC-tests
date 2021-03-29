package org.example.core.ui;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.example.core.Env;

/**
 * Driver Manager class that implements singleton Instance.
 */
public final class DriverManager {

    private static final String BASE_URL = Env.getInstance().getBaseUrl();

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * Constructor.
     */
    private DriverManager() {
        driver = BrowserFactory.getDriverManager(DriverType.valueOf(
                Env.getInstance().getBrowser().toUpperCase()));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Env.getInstance().getImplicitTimeWait(), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Env.getInstance().getExplicitTimeWait());
    }

    /**
     * Get Instance of the Driver manager.
     *
     * @return the instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Set time implicit wait.
     *
     * @param implicitTimeWait time for wait.
     */
    public void setImplicitTimeWait(int implicitTimeWait) {
        driver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }

    /**
     * Set time explicit wait.
     *
     * @param explicitTimeWait time for wait.
     */
    public void setExplicitTimeWait(int explicitTimeWait) {
        wait.withTimeout(Duration.ofSeconds(explicitTimeWait));
    }

    /**
     * Get Driver instance.
     *
     * @return driver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Quit the Driver instance.
     */
    public void quitDriver() {
        driver.quit();
    }

    /**
     * Get Base Url the driver.
     *
     * @return String url.
     */
    public String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * Gets wait instance.
     *
     * @return the wait.
     */
    public WebDriverWait getWait() {
        return wait;
    }
}

