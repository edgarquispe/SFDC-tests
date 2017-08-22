package org.fundacionjala.sfdc.core.driver;

import org.fundacionjala.sfdc.core.Env;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * SauceLabs class that implements IBrowsers.
 */
public class SauceLabs implements IBrowser {
  private static final Env ENV = Env.getInstance();

  private static final String USERNAME = ENV.getRemoteUserName();
  private static final String ACCESS_KEY = ENV.getRemoteKey();
  private static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
  private static final String PLATFORM = "platform";
  private static final String RESOLUTION = "resolution";

  /**
   * This method save all capabilities.
   *
   * @return setting capabilities SauceLabs.
   */
  private DesiredCapabilities setCapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability(PLATFORM, String.format("%s %s",
        ENV.getRemotePlatform(),
        ENV.getRemotePlatformVersion()));
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
    WebDriver driver;
    try {
      System.out.print("-->" + setCapabilities());
      driver = new RemoteWebDriver(new URL(URL), setCapabilities());
    } catch (MalformedURLException e) {
      throw new RuntimeException();
    }
    return driver;
  }
}
