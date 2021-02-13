package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.sfdc.core.CommonActions;
import org.example.sfdc.core.ui.DriverManager;
import org.example.sfdc.entities.Helper;
import org.example.sfdc.pages.opportunities.OpportunityDetail;
import org.example.sfdc.pages.opportunities.OpportunityForm;
import org.example.sfdc.pages.opportunities.OpportunityFormField;
import org.example.sfdc.pages.opportunities.OpportunityHome;

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
    public OpportunitySteps(final Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Opportunity Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Opportunity form with:$")
    public void iFillTheOpportunityFormWith(final Map<OpportunityFormField, String> formMapData) {
        helper.setOpportunityName(formMapData.get(OpportunityFormField.OPPORTUNITY_NAME));
        helper.setOpportunityMap(formMapData);
        new OpportunityForm().fillAndSaveForm(helper.getOpportunityMap());
        CommonActions.waitFixedTime();
    }

    /**
     * Click on Edit inside Opportunity Detail.
     */
    @When("^I edit the Opportunity$")
    public void iEditTheOpportunity() {
        DriverManager.getInstance().getWait().until(ExpectedConditions.titleContains(helper.getOpportunityName()));
        new OpportunityDetail().clickEditButton();
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Opportunity")
    public void iClickOnDeleteFromOpportunity() {
        DriverManager.getInstance().getWait().until(ExpectedConditions.titleContains(helper.getOpportunityName()));
        new OpportunityDetail().deleteItem();
    }

    /**
     * Click on New Opportunity special for a weird behavior.
     */
    @And("^I click on New Opportunit$")
    public void iClickOnNewOpportunit() {
        CommonActions.waitFixedTime();
        new OpportunityHome().clickNewButton();
    }

}
