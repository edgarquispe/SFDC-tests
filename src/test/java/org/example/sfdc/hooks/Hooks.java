package org.example.sfdc.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import org.example.sfdc.core.CommonActions;
import org.example.sfdc.core.ui.DriverManager;
import org.example.sfdc.entities.Helper;
import org.example.sfdc.pages.Navigator;
import org.example.sfdc.pages.SObject;

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
    public Hooks(final Helper helper) {
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
    @After(value = "@deleteAccount", order = 5)
    public void deleteCreatedAccount() {
        Navigator.goToAccountsHome().clickItemList(SObject.ACCOUNT, helper.getItemName()).deleteItem();
    }

    /**
     * Delete Campaign.
     */
    @After(value = "@deleteCampaign", order = 7)
    public void deleteCreatedItemCampaign() {
        Navigator.goToCampaignHome().clickItemList(SObject.CAMPAIGN, helper.getCampaignName()).deleteItem();
    }

    /**
     * Takes a snapshot when a scenario fails.
     *
     * @param scenario variable for Cucumber features.
     */
    @After
    public void takeScreenShot(final Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    /**
     * Set a instance of Soft Assert to helper.
     */
    @Before(value = "@SoftAssert", order = 10)
    public void setSoftAssertion() {
        helper.setAssertion(new SoftAssert());
    }

    /**
     * Set a instance of Hard Assert to helper.
     */
    @Before(order = 1)
    public void setHardAssertion() {
        helper.setAssertion(new Assertion());
    }


    /**
     * wait two seconds.
     */
    @Before(order = 15)
    public void waitBefore() {
        CommonActions.waitFixedTime();
    }

}
