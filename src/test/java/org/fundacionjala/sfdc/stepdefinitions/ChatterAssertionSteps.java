package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.Then;
import org.testng.asserts.Assertion;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

/**
 * Chatter assert step definitions.
 */
public class ChatterAssertionSteps {

    private Helper helper;

    private Assertion assertion;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ChatterAssertionSteps(Helper helper) {
        this.helper = helper;
        this.assertion = helper.getAssertion();
    }

    /**
     * The post edited should be displayed.
     *
     * @param message String.
     */
    @Then("^On the Chatter page should not display the \"([^\"]*)\"$")
    public void onTheChatterPageShouldNotDisplayThe(String message) {
        PostForm postForm = new PostForm();
        assertion.assertFalse(postForm.isPostDisplayed(message));
    }

    /**
     * The comment for the Post should be displayed.
     */
    @Then("^On the Chatter page the comment should be displayed$")
    public void onTheChatterPageTheCommentShouldBeDisplayed() {
        PostForm postForm = new PostForm();
        assertion.assertTrue(postForm.isPostDisplayed(helper.getCommentPostMessage()));
    }

    /**
     * The Chatter page should be displayed.
     */
    @Then("^On the Chatter page should be displayed$")
    public void onTheChatterPageShouldBeDisplayed() {
        PostForm postForm = new PostForm();
        assertion.assertTrue(postForm.isPostDisplayed(helper.getPostMessage()));
    }
}
