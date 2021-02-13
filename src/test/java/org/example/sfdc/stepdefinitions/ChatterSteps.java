package org.example.sfdc.stepdefinitions;

import io.cucumber.java.en.When;

import org.example.sfdc.core.ui.DriverManager;
import org.example.sfdc.entities.Helper;
import org.example.sfdc.pages.chatter.PostForm;

/**
 * Create Steps for Chatter.
 */
public class ChatterSteps {

    private Helper helper;
    private PostForm postForm;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ChatterSteps(final Helper helper) {
        this.helper = helper;
        this.postForm = new PostForm();
    }

    /**
     * Create a new Post.
     *
     * @param message String.
     */
    @When("^I create a new Post with \"([^\"]*)\"$")
    public void iCreateANewPostWith(final String message) {
        helper.setPostMessage(message);
        postForm.savePost(message);

    }

    //Edit

    /**
     * Edit a the post.
     *
     * @param newMessage String.
     */
    @When("^I Edit the Post with \"([^\"]*)\"$")
    public void iEditThePostWith(final String newMessage) {
        postForm.editPost(helper.getPostMessage(), newMessage);
        helper.setPostMessage(newMessage);
    }

    //Delete

    /**
     * Delete a the post.
     */
    @When("^I Delete the Post$")
    public void iDeleteThePost() {
        postForm.deletePost(helper.getPostMessage());
        DriverManager.getInstance().getDriver().navigate().refresh();
    }

    //Comment

    /**
     * Comment in Post.
     *
     * @param comment String.
     */
    @When("^I comment in Post \"([^\"]*)\"$")
    public void iCommentInPost(final String comment) {
        helper.setCommentPostMessage(comment);
        postForm.commentPost(helper.getPostMessage(), helper.getCommentPostMessage());
    }

    /**
     * This Step save post with a defined number of characters.
     *
     * @param number this variable contains the number of characters.
     */
    @When("^I set post with \"([^\"]*)\" characters$")
    public void iCreateANewPostWithCharacters(final String number) {
        postForm.savePost(postForm.generatePostMessage(number));
    }

    /**
     * This Step edit post with a defined number of characters.
     *
     * @param number this variable contains the number of characters.
     */
    @When("^I Edit the Post with \"([^\"]*)\" characters$")
    public void iEditThePostWithCharacters(final String number) {
        postForm.editPost(helper.getPostMessage(), postForm.generatePostMessage(number));
    }

}
