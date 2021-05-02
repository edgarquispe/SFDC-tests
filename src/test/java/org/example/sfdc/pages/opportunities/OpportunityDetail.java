package org.example.sfdc.pages.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.example.sfdc.pages.base.DetailBase;

/**
 * Class containing Opportunity Detail Page.
 */
public class OpportunityDetail extends DetailBase {

    @FindAll({
            @FindBy(css = "#opp3_ileinner"),

            @FindBy(xpath = "//span[text()='Opportunity Name']/parent::div/following-sibling::div/descendant::lightning-formatted-text")
    })
    private WebElement opportunityNameText;

    @FindAll({
            @FindBy(css = "#opp4_ileinner"),

            @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/descendant::span[@force-hoverablelink_hoverablelink]")
    })
    private WebElement accountNameText;

    @FindAll({
            @FindBy(css = "#opp9_ileinner"),

            @FindBy(xpath = "//p[contains(text(), 'Close Date')]/following-sibling::P")
    })
    private WebElement closeDateText;

    @FindAll({
            @FindBy(css = "#opp7_ileinner"),

            @FindBy(xpath = " //p[contains(text(), 'Amount')]/following-sibling::P")
    })
    private WebElement amountText;

    /**
     * {@inheritDoc}
     */
    @Override
    public OpportunityForm clickEditButton() {
        action.jsClick(editButton);
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
        return action.getTextElement(opportunityNameText);
    }

    /**
     * Gets the Opportunity Account Text.
     *
     * @return String.
     */
    public String getOpportunityAccountText() {
        return action.getTextElement(accountNameText);
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

