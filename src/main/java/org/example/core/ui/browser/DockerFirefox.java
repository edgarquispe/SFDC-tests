package org.example.core.ui.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.example.core.Env;
import org.example.core.MyRuntimeException;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerFirefox implements Browser {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        FirefoxOptions firefoxCapabilities = new FirefoxOptions();
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(Env.getInstance().getDockerUrl()), firefoxCapabilities);

        } catch (MalformedURLException e) {
            LOGGER.error("Not instance driver");
            LOGGER.info(e);
            throw new MyRuntimeException("Not instance driver", e);
        }
        return driver;
    }
}
