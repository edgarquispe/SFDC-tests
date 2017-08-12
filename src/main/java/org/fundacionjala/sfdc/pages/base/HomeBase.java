package org.fundacionjala.sfdc.pages.base;

import org.fundacionjala.sfdc.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abelb on 8/8/2017.
 */
public abstract class HomeBase extends BasePage {

    @FindBy(css = "a[title='New']")
    protected WebElement newButton;

    protected WebElement displayedItem;

    protected WebElement dropDownListLink;

    @FindBy(css = "a[title='Edit']")
    protected WebElement editButton;

    @FindBy(css = "a[title='Delete']")
    protected WebElement deleteButton;

    @FindBy(css = "button[title='Delete']")
    protected WebElement confirmDeleteButton;

    /**
     * Gets the Displayed Item.
     *
     * @return WebElement displayed.
     */
    public WebElement getDisplayedItem() {
        return displayedItem;
    }

    /**
     * Get the DropDown List Link of the Object.
     *
     * @param name String.
     */
    public void getDropDownListLink(String name) {
        String xpathSelector = String.format("//a[contains(text(),'%s')]/ancestor::tr/"
                + "descendant::a[contains(@class,'slds-button slds-button--icon-x-small')]", name);
        dropDownListLink = driver.findElement(By.xpath(xpathSelector));
    }

    /**
     * Determines if the Item is Displayed on the Page.
     *
     * @param name String.
     * @return Boolean.
     */
    public boolean isDisplayedItem(String name) {
        String xpathSelector = String.format("//a[contains(text(),'%s')]", name);
        boolean flag = true;
        try {
            displayedItem = driver.findElement(By.xpath(xpathSelector));

        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }

    /**
     * Clicks the Displayed Item.
     *
     * @param name String.
     * @return DetailBase.
     */
    public abstract DetailBase clickDisplayedItem(String name);

    /**
     * Clicks the New Button to open Form Base.
     *
     * @return FormBase.
     */
    public abstract FormBase clickNewButton();

    /**
     * Clicks the Edit Button to open Form Base.
     *
     * @param name String.
     * @return FormBase.
     */
    public abstract FormBase clickEditButton(String name);

    /**
     * Click the DropDown List of the Item.
     *
     * @param name String.
     */
    public void clickDropDownListLink(String name) {
        getDropDownListLink(name);
        CommonActions.clickElement(dropDownListLink);
    }

    /**
     * Clicks the Delete Button.
     */
    public void clickDeleteButton() {

        CommonActions.clickElement(deleteButton);
    }

    /**
     * Clicks the Confirm Delete Button.
     */
    public void clickConfirmDeleteButton() {
        CommonActions.clickElement(confirmDeleteButton);
    }

    /**
     * Deletes the Element.
     *
     * @param name String.
     */
    public void deleteElement(String name) {
        clickDropDownListLink(name);
        clickDeleteButton();
        clickConfirmDeleteButton();
    }
}
