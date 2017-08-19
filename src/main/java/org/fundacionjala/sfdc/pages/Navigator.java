package org.fundacionjala.sfdc.pages;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pages.acccounts.AccountHome;
import org.fundacionjala.sfdc.pages.base.BasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.fundacionjala.sfdc.pages.campaigns.CampaignHome;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Final class Navigator to access the different pages.
 */
public final class Navigator {

    /**
     * Private Constructor.
     */
    private Navigator() {

    }

    /**
     * Click and returns an AppLauncher Instance.
     *
     * @return AppLauncher.
     */
    public static AppLauncher clickAppLauncher() {
        return new Home().clickAppLauncher();
    }

    /**
     * Go to Products Home Page.
     *
     * @return ProductHome.
     */
    public static ProductHome goToProductsHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Product")) {
            clickAppLauncher().clickProductsTextLink();
        }
        return new ProductHome();
    }

    /**
     * Go to Chatter Home Page.
     *
     * @return PostForm.
     */
    public static PostForm goToChatterHome() {
        CommonActions.waitForAppear();
        new AppLauncher().clickChatterTextLink();
        return new PostForm();
    }

    /**
     * Go to Opportunity Home Page.
     *
     * @return OpportunityHome.
     */
    public static OpportunityHome goToOpportunityHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Opportunity")) {
            new AppLauncher().clickOpportunityButton();
        }
        return new OpportunityHome();
    }

    /**
     * Go to Campaign Home Page.
     *
     * @return CampaignHome.
     */
    public static CampaignHome goToCampaignHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Campaign")) {
            clickAppLauncher().clickCampaignTextLink();
        }
        return new CampaignHome();
    }

    /**
     * Static method to go to any page on Enum SObject.
     *
     * @param endPoint SObject.
     * @return HomeBase.
     */
    public static BasePage gotoPage(SObject endPoint) {
        switch (endPoint) {
            case ACCOUNT:
                return goToAccountsHome();
            case CHATTER:
                return goToChatterHome();
            case OPPORTUNIT:
                return goToOpportunityHome();
            case CAMPAIGN:
                return goToCampaignHome();
            default:
                return goToProductsHome();
        }
    }

    /**
     * Go to Accounts Home Page.
     *
     * @return ProductHome.
     */
    public static AccountHome goToAccountsHome() {
        if (!DriverManager.getInstance().getDriver().getCurrentUrl().contains("Account")) {
            clickAppLauncher().clickAccountTextLink();
        }
        return new AccountHome();
    }

    /**
     * Static method  to map Actions.
     *
     * @param item SObject.
     * @return HomeBase.
     */
    public static HomeBase mapActions(SObject item) {
        Map<SObject, HomeBase> map = new HashMap<>();
        map.put(SObject.PRODUCT, new ProductHome());
        map.put(SObject.ACCOUNT, new AccountHome());
        map.put(SObject.OPPORTUNIT, new OpportunityHome());
        map.put(SObject.CAMPAIGN, new OpportunityHome());
        return map.get(item);
    }
}
