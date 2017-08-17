package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.pages.acccounts.AccountHome;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.BasePage;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Class for the App Launcher.
 */
public class AppLauncher extends BasePage {

    @FindBy(css = ".modal-header")
    private WebElement windowModal;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Products']")
    private WebElement productsTextLink;

    @FindBy(css = ".salesforceIdentityAppLauncherDesktopInternal .uiButton")
    private WebElement openAllAppsButton;

    //@FindBy(css = "one-app-launcher-header")
    @FindBy(xpath = "//button[@class='slds-button']")
    private WebElement openAllItemsButton;

    @FindBy(css = "a[title='Chatter']")
    private WebElement chatterButton;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Accounts']")
    private WebElement accountsTextLink;

    /**
     * Waits for the modal is displayed.
     */
    private void waitModal() {
        CommonActions.isElementDisplayed(windowModal);
    }

    /**
     * Clicks the Product Text Link.
     *
     * @return ProductHome.
     */
    public ProductHome clickProductsTextLink() {
            waitModal();
            CommonActions.clickElement(openAllAppsButton);
            CommonActions.clickElement(productsTextLink);
        return new ProductHome();
    }

    /**
     * Clicks the Chatter Text Link.
     *
     * @return PostForm
     */
    public PostForm clickChatterTextLink() {
        CommonActions.clickElement(chatterButton);
        return new PostForm();
    }

    /**
     * Clicks the Product Text Link.
     *
     * @return ProductHome.
     */
    public AccountHome clickAccountTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        CommonActions.clickElement(accountsTextLink);
        return new AccountHome();
    }
}
