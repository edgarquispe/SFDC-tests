package org.example.sfdc.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.example.sfdc.core.CommonActions;
import org.example.sfdc.core.ui.DriverManager;
import org.example.sfdc.entities.Helper;
import org.example.sfdc.pages.Navigator;
import org.example.sfdc.pages.SObject;

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
    public CommonSteps(final Helper helper) {
        this.helper = helper;
    }

    @ParameterType(".*")
    public SObject sObject(final String sObject) {
        return SObject.valueOf(sObject.toUpperCase());
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(final String cell) {
        return cell;
    }

    /**
     * Step to go to Item Home Page.
     *
     * @param sObject SObject.
     */
    @Given("I go to {sObject} Home Page")
    public void iGoToHomePage(final SObject sObject) {
        CommonActions.waitFixedTime();
        Navigator.gotoPage(sObject);
    }

    /**
     * Step to click on New Button.
     *
     * @param sObject SObject.
     */
    @And("I click on New {sObject}")
    public void iClickOnNew(final SObject sObject) {
        CommonActions.waitFixedTime();
        Navigator.mapActions(sObject).clickNewButton();
    }

    /**
     * Click on Edit Button.
     *
     * @param sObject SObject.
     */
    @When("I click on Edit {sObject}")
    public void iClickOnEditSObject(final SObject sObject) {
        Navigator.mapActions(sObject).clickEditButton(helper.getItemName());
    }

    /**
     * Delete the selected Object.
     *
     * @param sObject SObject.
     */
    @And("I delete the {sObject}")
    public void iDeleteThe(final SObject sObject) {
        Navigator.mapActions(sObject).deleteElement(helper.getItemName());
    }

    /**
     * Click on a specified item of the list.
     *
     * @param sObject SObject.
     */
    @And("I click on the {sObject} item")
    public void iClickOnTheItem(final SObject sObject) {
        Navigator.mapActions(sObject).clickItemList(helper.getItemName());
    }

    /**
     * This method refresh page.
     */
    @And("^refresh page$")
    public void refreshPage() {
        DriverManager.getInstance().getDriver().navigate().refresh();
        CommonActions.waitFixedTime();
    }
}
