package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.Navigator;

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
        Navigator.goToProductsHome().deleteElement(helper.getItemName());
    }

    /**
     * Delete Post.
     */
    @After(value = "@deletePost")
    public void deleteCreatedIPost() {
        Navigator.goToChatterHome().deletePost(helper.getPostMessage());
    }

    /**
     * Delete Item.
     */
    @After(value = "@deleteAccount")
    public void deleteCreatedAccount() {
        Navigator.goToAccountsHome().deleteElement(helper.getItemName());
    }
}
