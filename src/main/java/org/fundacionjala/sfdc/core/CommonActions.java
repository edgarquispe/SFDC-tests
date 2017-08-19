package org.fundacionjala.sfdc.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.core.driver.DriverManager;

/**
 * Class containing the common actions for the framework.
 */
public final class CommonActions {

    /**
     * Constructor private.
     */
    private CommonActions() {
    }

    /**
     * This method waits and clear the WebElement.
     *
     * @param webElement WebElement to wait and clear.
     */
    public static void clearTextField(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * This method set a Input Field.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public static void setInputField(WebElement webElement, String text) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        clearTextField(webElement);
        webElement.sendKeys(text);
    }

    /**
     * This method waits and click on the webElement.
     *
     * @param webElement WebElement to wait and click.
     */
    public static void clickElement(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method waits and get the text of an WebElement.
     *
     * @param webElement WebElement to wait and get the text.
     * @return Text of element.
     */
    public static String getTextElement(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * This method verify that Web element is Displayed.
     *
     * @param webElement WebElement.
     * @return True if the element is Displayed.
     */
    public static boolean isElementDisplayed(WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }

    /**
     * Check if the element is selected.
     *
     * @param element WebElement.
     * @return boolean.
     */
    public static boolean isElementSelected(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        return element.isSelected();
    }

    /**
     * Set Check Box status.
     *
     * @param element WebElement.
     * @param flag    boolean.
     */
    public static void setCheckBox(WebElement element, boolean flag) {
        if (!isElementSelected(element) && flag) {
            clickElement(element);
        }
    }

    /**
     * Method for wait 1 second.
     */
    public static void waitForAppear() {
        try {
            DriverManager.getInstance().setUpdateWait(1);
            DriverManager.getInstance().getWait()
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Just For Wait']")));
        } catch (TimeoutException e) {

        } finally {
            DriverManager.getInstance().backPreviousWait();
        }
    }
}
