package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.SObject;

import static org.testng.Assert.assertTrue;

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
        CommonActions.waitForAppear();
        Navigator.gotoPage(sObject);
    }

    /**
     * Step to click on New Button.
     *
     * @param sObject SObject.
     */
    @And("^I click on New \"([^\"]*)\"$")
    public void iClickOnNew(SObject sObject) {
        CommonActions.waitForAppear();
        Navigator.mapActions(sObject).clickNewButton();
    }

    /**
     * Click on Edit Button.
     *
     * @param sObject SObject.
     */
    @When("^I click on Edit \"([^\"]*)\"$")
    public void iClickOnEdit(SObject sObject) {
        Navigator.mapActions(sObject).clickEditButton(helper.getItemName());
    }

    /**
     * Delete the selected Object.
     *
     * @param sObject SObject.
     */
    @And("^I delete the \"([^\"]*)\"$")
    public void iDeleteThe(SObject sObject) {
        Navigator.mapActions(sObject).deleteElement(helper.getItemName());
    }

    /**
     * Click on a specified item of the list.
     *
     * @param sObject SObject.
     */
    @And("^I click on the \"([^\"]*)\" item$")
    public void iClickOnTheItem(SObject sObject) {
        Navigator.mapActions(sObject).clickItemList(helper.getItemName());
    }

    /**
     * Assertion step to verify the error message displayed.
     *
     * @param msg     error message that should be displayed.
     * @param sObject SObject enum parameter.
     */
    @Then("^\"([^\"]*)\" message should be displayed in \"([^\"]*)\" form$")
    public void messageShouldBeDisplayedInForm(String msg, SObject sObject) {
        assertTrue(Navigator.mapForm(sObject).errorNotificationText().contains(msg));
    }
}
