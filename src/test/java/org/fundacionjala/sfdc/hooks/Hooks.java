package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.acccounts.AccountHome;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Hooks Class for actions to run before and after Scenarios.
 */
public class Hooks {

    private Helper helper;

    /**
     * Default Constructor.
     * @param helper Helper.
     */
    public Hooks(Helper helper) {
        this.helper = helper;
    }

    /**
     * Delete Item.
     */
    @After(value = "@deleteProduct")
    public void deleteCreatedItem() {
        new ProductHome().deleteElement(helper.getItemName());
    }

    /**
     * Delete Post.
     */
    @After(value = "@deletePost")
    public void deleteCreatedIPost() {
        new PostForm().deletePost(helper.getPostMessage());
    }

    /**
     * Delete Item.
     */
    @After(value = "@deleteAccount")
    public void deleteCreatedAccount() {
        new AccountHome().deleteElement(helper.getItemName());
    }
}
