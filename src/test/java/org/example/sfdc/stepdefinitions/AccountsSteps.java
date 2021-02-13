package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.When;

import org.example.sfdc.entities.Helper;
import org.example.sfdc.pages.acccounts.AccountDetail;
import org.example.sfdc.pages.acccounts.AccountForm;
import org.example.sfdc.pages.acccounts.AccountFormField;
import org.example.sfdc.pages.acccounts.AccountHome;

/**
 * Create Steps for Accounts.
 */
public class AccountsSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public AccountsSteps(final Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Account Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Account form with:$")
    public void iFillTheAccountFormWith(final Map<AccountFormField, String> formMapData) {
        helper.setItemName(formMapData.get(AccountFormField.ACCOUNT_NAME));
        helper.setAccountMap(formMapData);
        new AccountForm().fillAndSaveForm(helper.getAccountMap());
        new AccountHome().waitUntilSpinnerIsHidden();
    }

    /**
     * Click on Edit from Account.
     */
    @When("^I edit the Account$")
    public void iEditTheAccount() {
        new AccountDetail().clickEditButton();
    }

    /**
     * Click on Delete from Account.
     */
    @When("^I Click on Delete from Account$")
    public void iClickOnDeleteFromAccount() {
        new AccountDetail().deleteItem();
    }
}
