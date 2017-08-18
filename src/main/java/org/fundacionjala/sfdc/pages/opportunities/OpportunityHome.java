package org.fundacionjala.sfdc.pages.opportunities;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.openqa.selenium.By;

/**
 * Class containing Opportunity Home Page.
 */
public class OpportunityHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickNewButton() {
        CommonActions.clickElement(newButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FormBase clickEditButton(String name) {
        clickDropDownListLink(name);
        CommonActions.clickElement(editButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DetailBase clickDisplayedItem(String name) {
        isDisplayedItem(name);
        CommonActions.clickElement(displayedItem);
        return new OpportunityDetail();
    }

    /**
     * Determines if the Opportunity Field Data is displayed on Home Page.
     *
     * @param opportunityName  Opportunity Name for row.
     * @param opportunityField Opportunity Field like Code, Family.
     * @return boolean.
     */
    public boolean isOpportunityFieldDisplayed(String opportunityName, String opportunityField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::span[text()='%s']",
                opportunityName, opportunityField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }

    /**
     * @param opportunityName  field.
     * @param opportunityField field.
     * @return driver.
     */
    public boolean isOpportunityLinkDisplayed(String opportunityName, String opportunityField) {
        String xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::a[text()='%s']",
                opportunityName, opportunityField);
        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
