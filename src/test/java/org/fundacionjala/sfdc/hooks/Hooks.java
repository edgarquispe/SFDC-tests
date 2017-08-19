package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;

import org.fundacionjala.sfdc.core.driver.DriverManager;
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
     * Delete Product.
     */
    @After(value = "@deleteProduct", order = 10)
    public void deleteCreatedItem() {
        Navigator.goToProductsHome().deleteElement(helper.getItemName());
    }

    /**
     * Delete Post.
     */
    @After(value = "@deletePost", order = 10)
    public void deleteCreatedIPost() {
        Navigator.goToChatterHome().deletePost(helper.getPostMessage());
    }

    /**
     * Delete Account.
     */
    @After(value = "@deleteAccount", order = 10)
    public void deleteCreatedAccount() {
        Navigator.goToAccountsHome().deleteElement(helper.getItemName());
    }

    /**
     * Delete Opportunity.
     */
    @After(value = "@deleteOpportunity", order = 10)
    public void deleteCreatedItemOpportunity() {
        Navigator.goToOpportunityHome().deleteElement(helper.getOpportunityName());
    }

    /**
     * Delete Campaign.
     */
    @After(value = "@deleteCampaign", order = 10)
    public void deleteCreatedItemCampaign() {
        Navigator.goToCampaignHome().deleteElement(helper.getCampaignName());
    }

    /**
     * Refresh Page for an initial fresh state.
     */
    @After(order = 5)
    public void refreshCurrentPage() {
        DriverManager.getInstance().getDriver().navigate().refresh();
    }
}
