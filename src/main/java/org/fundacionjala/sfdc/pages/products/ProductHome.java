package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.openqa.selenium.By;

/**
 * Class containing Product Home Page.
 */
public class ProductHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickEditButton(String name) {
        clickDropDownListLink(name);
        CommonActions.clickElement(editButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetail clickDisplayedItem(String name) {
        isDisplayedItem(name);
        displayedItem.click();
        return new ProductDetail();
    }

    /**
     * Determines if the Product Field Data is displayed on Home Page.
     *
     * @param productName  Product Name for row.
     * @param productField Product Field like Code, Family.
     * @return boolean.
     */
    public boolean isProductFieldDisplayed(String productName, String productField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::span[text()='%s']",
                productName, productField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
