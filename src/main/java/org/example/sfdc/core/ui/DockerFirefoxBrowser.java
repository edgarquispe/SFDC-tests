package org.example.sfdc.core.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.example.sfdc.core.Env;
import org.example.sfdc.core.MyRuntimeException;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerFirefoxBrowser implements Browser {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
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
