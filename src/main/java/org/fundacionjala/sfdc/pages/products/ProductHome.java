package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * Class containing Product Home Page.
 */
public class ProductHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton(String name) {
        clickDropDownListLink(name);
        CommonActions.clickElement(editButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetailBase clickDisplayedItem(String name) {
        isDisplayedItem(name);
        CommonActions.clickElement(displayedItem);
        return new ProductDetail();
    }
}
