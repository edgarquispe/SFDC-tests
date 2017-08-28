package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.When;

import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

/**
 * Create Steps for Chatter.
 */
public class ChatterSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ChatterSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Create a new Post.
     *
     * @param message String.
     */
    @When("^I create a new Post with \"([^\"]*)\"$")
    public void iCreateANewPostWith(String message) {
        helper.setPostMessage(message);
        PostForm postForm = new PostForm();
        postForm.savePost(message);

    }

    //Edit

    /**
     * Edit a the post.
     *
     * @param newMessage String.
     */
    @When("^I Edit the Post with \"([^\"]*)\"$")
    public void iEditThePostWith(String newMessage) {
        new PostForm().editPost(helper.getPostMessage(), newMessage);
        helper.setPostMessage(newMessage);
    }

    //Delete

    /**
     * Delete a the post.
     */
    @When("^I Delete the Post$")
    public void iDeleteThePost() {
        new PostForm().deletePost(helper.getPostMessage());
        DriverManager.getInstance().getDriver().navigate().refresh();
    }

    //Comment

    /**
     * Comment in Post.
     *
     * @param comment String.
     */
    @When("^I comment in Post \"([^\"]*)\"$")
    public void iCommentInPost(String comment) {
        helper.setCommentPostMessage(comment);
        PostForm postForm = new PostForm();
        postForm.commentPost(helper.getPostMessage(), helper.getCommentPostMessage());
    }


}
