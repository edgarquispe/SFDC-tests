package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignFormField;
import org.fundacionjala.sfdc.pages.campaigns.CampaignHome;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 8/16/2017.
 */
public class CampaignSteps {

    private Helper helper;
    private Map<CampaignFormField, String> map;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CampaignSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Campaign Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Campaign form with:$")
    public void iFillTheCampaignFormWith(Map<CampaignFormField, String> formMapData) {
        map = formMapData;
        helper.setCampaignName(formMapData.get(CampaignFormField.CAMPAIGN_NAME));
        new CampaignForm().fillAndSaveForm(formMapData);
    }

    /**
     * Click on Edit inside Campaign Detail.
     */
    @When("^click on Edit Campaign $")
    public void iClickOnEditCampaign() {
        new CampaignDetail().clickEditButton();
    }

    /**
     * The Campaign data should be displayed on Campaign Detail Page.
     */
    @Then("^the Campaign should be displayed$")
    public void theCampaignShouldBeDisplayed() {
        CampaignDetail campaignDetail = new CampaignDetail();
        campaignDetail.waitObjectNameIs(helper.getCampaignName());
        assertTrue(campaignDetail.getCampaignNameText().equals(map.get(CampaignFormField.CAMPAIGN_NAME)));
    }

    /**
     * The Campaign Data should be displayed on Campaign Home Page.
     */
    @And("^the Campaign should be displayed on Home Page$")
    public void theCampaignShouldBeDisplayedOnHomePage() {
        CampaignHome campaignHome = new CampaignHome();
        DriverManager.getInstance().getWait().until(ExpectedConditions.urlContains("Campaign"));
        assertTrue(campaignHome.isDisplayedItem(map.get(CampaignFormField.CAMPAIGN_NAME)));

    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Campaign")
    public void iClickOnDeleteFromCampaign() {
        new CampaignDetail().deleteItem();
    }

    /**
     * The Campaign shouldn't be displayed on Home Page After Delete.
     */
    @Then("^the Campaign should not be displayed on Home Page$")
    public void theCampaignShouldNotBeDisplayedOnHomePage() {
        CampaignHome campaignHome = new CampaignHome();
        assertFalse(campaignHome.isDisplayedItem(map.get(CampaignFormField.CAMPAIGN_NAME)));
    }

}
