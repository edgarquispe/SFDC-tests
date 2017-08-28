package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.And;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import org.fundacionjala.sfdc.entities.Helper;

/**
 * Common assert step definitions.
 */
public class CommonAssertionSteps {

    private Helper helper;

    private Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CommonAssertionSteps(Helper helper) {
        this.helper = helper;
        assertion = this.helper.getAssertion();
    }


    /**
     * This method executes all soft asserts.
     */
    @And("^Assert all$")
    public void assertAll() {
        if (assertion instanceof SoftAssert) {
            ((SoftAssert) assertion).assertAll();
        }
    }
}
