package org.fundacionjala.sfdc.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;

/**
 * Hooks Class for actions to run before and after Scenarios.
 */
public class Hooks {

    private Helper helper;

    /**
     * Default Constructor.
     *
     * @param helper Helper.
     */
    public Hooks(Helper helper) {
        this.helper = helper;
    }

    /**
     * Delete Product.
     */
    @After(value = "@deleteProduct", order = 10)
    public void deleteCreatedItem() {
        Navigator.goToProductsHome().deleteElement(helper.getItemName());
    }

    /**
     * Delete Post.
     */
    @After(value = "@deletePost", order = 10)
    public void deleteCreatedIPost() {
        Navigator.goToChatterHome().deletePost(helper.getPostMessage());
    }

    /**
     * Delete Account.
     */
    @After(value = "@deleteAccount", order = 10)
    public void deleteCreatedAccount() {
        Navigator.goToAccountsHome().deleteElement(helper.getItemName());
    }

    /**
     * Delete Campaign.
     */
    @After(value = "@deleteCampaign", order = 9)
    public void deleteCreatedItemCampaign() {
        Navigator.goToCampaignHome().deleteElement(helper.getCampaignName());
    }

    /**
     * Refresh Page for an initial fresh state.
     */
    @After(order = 5)
    public void refreshCurrentPage() {
        DriverManager.getInstance().getDriver().navigate().refresh();
    }

    /**
     * Clean the helper.
     */
    @After(order = 5)
    public void cleanHelper() {
        helper = new Helper();
    }

    /**
     * Takes a snapshot when a scenario fails.
     *
     * @param scenario variable for Cucumber features.
     */
    @After
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    /**
     * Set a instance of Soft Assert to helper.
     */
    @Before(value = "@SoftAssert", order = 10)
    public void assertSelection() {
        helper.setAssertion(new SoftAssert());
    }

    /**
     * wait two seconds.
     */
    @Before(order = 15)
    public void waitBefore() {
        CommonActions.waitFixedTime();
    }

}
