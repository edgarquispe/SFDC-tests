package org.fundacionjala.sfdc.stepdefinitions;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityFormField;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;

/**
 * Create steps for opportunities.
 */
public class OpportunitySteps {

    private Helper helper;

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
        helper.setOpportunityMap(formMapData);
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
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Opportunity")
    public void iClickOnDeleteFromOpportunity() {
        DriverManager.getInstance().getWait().until(ExpectedConditions.titleContains(helper.getOpportunityName()));
        DriverManager.getInstance().getDriver().navigate().refresh();
        new OpportunityDetail().deleteItem();
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
