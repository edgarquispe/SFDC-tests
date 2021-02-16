package org.example.sfdc.pages.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.sfdc.core.ui.CommonActions;
import org.example.sfdc.pages.base.DetailBase;

/**
 * Class containing Opportunity Detail Page.
 */
public class OpportunityDetail extends DetailBase {

    @FindBy(xpath = "//span[text()='Opportunity Name']/parent::div/following-sibling::div/descendant::lightning-formatted-text")
    private WebElement opportunityNameText;

    @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/descendant::span[@force-hoverablelink_hoverablelink]")
    private WebElement accountNameText;

    @FindBy(xpath = "//p[contains(text(), 'Close Date')]/following-sibling::P")
    private WebElement closeDateText;

    @FindBy(xpath = " //p[contains(text(), 'Amount')]/following-sibling::P")
    private WebElement amountText;

    /**
     * {@inheritDoc}
     */
    @Override
    public OpportunityForm clickEditButton() {
        CommonActions.jsClick(editButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OpportunityHome deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new OpportunityHome();
    }

    /**
     * Gets the Opportunity Name Text.
     *
     * @return String.
     */
    public String getOpportunityNameText() {
        return CommonActions.getTextElement(opportunityNameText);
    }

    /**
     * Gets the Opportunity Account Text.
     *
     * @return String.
     */
    public String getOpportunityAccountText() {
        return CommonActions.getTextElement(accountNameText);
    }

    /**
     * Gets the Opportunity Close date Text.
     *
     * @return String.
     */
    public String getOpportunityCloseDateText() {
        return closeDateText.getText();
    }

    /**
     * Gets the Opportunity Amount Text.
     *
     * @return String.
     */
    public String getOpportunityAmountText() {
        return amountText.getText();
    }

}

