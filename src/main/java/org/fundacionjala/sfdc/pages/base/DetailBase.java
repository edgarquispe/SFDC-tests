package org.fundacionjala.sfdc.pages.base;

import org.fundacionjala.sfdc.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abelb on 8/9/2017.
 */
public abstract class DetailBase extends BasePage {

    @FindBy(css = "a[title='Edit']")
    protected WebElement editButton;

    @FindBy(css = "[title='Delete']")
    protected WebElement deleteButton;

    @FindBy(css = "button[title='Delete']")
    protected WebElement confirmDeleteButton;

    /**
     * Returns the text content of the Item.
     *
     * @param name String.
     * @return String.
     */
    public String getItemName(String name) {
        String cssSelector = String.format("h1[title='%s']", name);
        WebElement createdItem = driver.findElement(By.cssSelector(cssSelector));
        return createdItem.getText();
    }

    /**
     * Opens the Form page for editing.
     *
     * @return FormBase.
     */
    public abstract FormBase clickEditButton();

    /**
     * Click the delete button of the current Item.
     */
    public void clickDeleteButton() {
        CommonActions.clickElement(deleteButton);
    }

    /**
     * Click the Confirm Delete Button from the current Item.
     */
    public void clickConfirmDeleteButton() {
        CommonActions.clickElement(confirmDeleteButton);
    }

    /**
     * Deletes the current Item.
     *
     * @return HomeBase.
     */
    public abstract HomeBase deleteItem();
}
