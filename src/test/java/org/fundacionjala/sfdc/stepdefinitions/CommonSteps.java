package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.SObject;

/**
 * Common Steps for all features.
 */
public class CommonSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CommonSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Step to go to Item Home Page.
     *
     * @param sObject SObject.
     */
    @Given("^I go to \"([^\"]*)\" Home Page$")
    public void iGoToHomePage(SObject sObject) {
        Navigator.gotoPage(sObject);
        DriverManager.getInstance().getWait().until(ExpectedConditions.titleContains("Product"));
        //TODO Check if this wait can be implemented inside and be dynamic
    }

    /**
     * Step to click on New Button.
     *
     * @param sObject SObject.
     */
    @And("^I click on New \"([^\"]*)\"$")
    public void iClickOnNew(SObject sObject) {
        Navigator.mapActions(sObject).clickNewButton();
    }

    /**
     * Click on Edit Button.
     * @param sObject SObject.
     */
    @When("^I click on Edit \"([^\"]*)\"$")
    public void iClickOnEdit(SObject sObject) {
        Navigator.mapActions(sObject).clickEditButton(helper.getItemName());
    }
}
