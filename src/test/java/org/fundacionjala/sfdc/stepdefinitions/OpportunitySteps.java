package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityFormField;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by Administrator on 8/16/2017.
 */
public class OpportunitySteps {

    private Helper helper;

    private Map<OpportunityFormField, String> map;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public OpportunitySteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Opportunity Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Opportunity form with:$")
    public void iFillTheOpportunityFormWith(Map<OpportunityFormField, String> formMapData) {
        map = formMapData;
        helper.setOpportunityName(formMapData.get(OpportunityFormField.OPPORTUNITY_NAME));
        new OpportunityForm().fillAndSaveForm(formMapData);
    }

    /**
     * Click on Edit inside Opportunity Detail.
     */
    @When("^I click on Edit Opportunity$")
    public void iClickOnEditOpportunity() {
        DriverManager.getInstance().getWait().until(ExpectedConditions.titleContains(helper.getOpportunityName()));
        DriverManager.getInstance().getDriver().navigate().refresh();
        new OpportunityDetail().clickEditButton();
    }


    /**
     * The Opportunity data should be displayed on Opportunity Detail Page.
     */
    @Then("^the Opportunity should be displayed$")
    public void theOpportunityShouldBeDisplayed() {
        OpportunityDetail opportunityDetail1Detail = new OpportunityDetail();
        opportunityDetail1Detail.waitObjectNameIs(helper.getOpportunityName());
        OpportunityDetail opportunityDetail = new OpportunityDetail();
        assertTrue(opportunityDetail.getOpportunityNameText().equals(map.get(OpportunityFormField.OPPORTUNITY_NAME)));
        assertTrue(opportunityDetail.getOpportunityAccountText()
                .equals(map.get(OpportunityFormField.OPPORTUNITY_ACCOUNT)));
        assertTrue(opportunityDetail.getOpportunityAmountText()
                .contains(map.get(OpportunityFormField.OPPORTUNITY_AMOUNT)));
    }


    /**
     * The Opportunity Data should be displayed on Opportunity Home Page.
     */
    @And("^the Opportunity should be displayed on Home Page$")
    public void theOpportunityShouldBeDisplayedOnHomePage() {
        OpportunityHome opportunityHome = new OpportunityHome();
        DriverManager.getInstance().getWait().until(ExpectedConditions.urlContains("Opportunity"));
        assertTrue(opportunityHome.isDisplayedItem(map.get(OpportunityFormField.OPPORTUNITY_NAME)));
        assertTrue(opportunityHome.isOpportunityLinkDisplayed(
                map.get(OpportunityFormField.OPPORTUNITY_NAME),
                map.get(OpportunityFormField.OPPORTUNITY_ACCOUNT)));
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Opportunity")
    public void iClickOnDeleteFromOpportunity() {
        DriverManager.getInstance().getWait().until(ExpectedConditions.titleContains(helper.getOpportunityName()));
        DriverManager.getInstance().getDriver().navigate().refresh();
        new OpportunityDetail().deleteItem();
    }

    /**
     * The Product shouldn't be displayed on Home Page After Delete.
     */
    @Then("^the Opportunity should not be displayed on Home Page$")
    public void theOpportunityShouldNotBeDisplayedOnHomePage() {
        OpportunityHome opportunityHome = new OpportunityHome();
        assertFalse(opportunityHome.isDisplayedItem(map.get(OpportunityFormField.OPPORTUNITY_NAME)));
    }

    /**
     * Click on New Opportunity special for a weird behavior.
     */
    @And("^I click on New Opportunit$")
    public void iClickOnNewOpportunit() {
        CommonActions.waitForAppear();
        DriverManager.getInstance().getDriver().navigate().refresh();
        new OpportunityHome().clickNewButton();
    }
}
