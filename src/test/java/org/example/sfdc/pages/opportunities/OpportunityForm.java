package org.example.sfdc.pages.opportunities;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.sfdc.pages.SFDCEnvironment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.core.Env;
import org.example.sfdc.pages.IStrategySteps;
import org.example.sfdc.pages.base.FormBase;
import org.openqa.selenium.support.ui.Select;

/**
 * Class containing Opportunity Form Page..
 */
public class OpportunityForm extends FormBase {

    @FindAll({
            @FindBy(css = "#opp3"),

            @FindBy(xpath = "//label[text()='Opportunity Name']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityNameInputField;

    @FindAll({
            @FindBy(css = "#opp4"),

            @FindBy(xpath = "//label[text()='Account Name']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityAccountNameInputField;

    @FindAll({
            @FindBy(css = "#opp5"),

            @FindBy(xpath = "//label[text()='Type']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityTypeInputField;

    @FindBy(xpath = "//span[contains(text(),'Primary Campaign Source')]/parent::label"
            + "/following-sibling::div/descendant::input")
    private WebElement opportunityCampaignInputField;

    @FindAll({
            @FindBy(css = "#opp9"),

            @FindBy(xpath = "//label[text()='Close Date']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityDateInputField;

    @FindBy(xpath = "//*[text()='Today']")
    private WebElement selectOpportunityDateInputField;

    @FindAll({
            @FindBy(css = "#opp11"),

            @FindBy(xpath = "//label[text()='Stage']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityStageInputField;

    @FindBy(xpath = "//span[contains(text(),'Probability (%)')]/parent::label/following-sibling::input")
    private WebElement opportunityProbabilityInputField;

    @FindAll({
            @FindBy(css = "#opp7"),

            @FindBy(xpath = "//label[text()='Amount']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityAmountInputField;

    @FindAll({
            @FindBy(css = "#opp6"),

            @FindBy(xpath = "//label[text()='Lead Source']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityLeadInputField;

    @FindAll({
            @FindBy(css = "#opp10"),

            @FindBy(xpath = "//label[text()='Next Step']/following-sibling::div/descendant::input")
    })
    private WebElement opportunityNextStepInputField;

    @FindAll({
            @FindBy(css = "#opp14"),

            @FindBy(xpath = "//label[text()='Description']/following-sibling::div/descendant::textarea")
    })
    private WebElement opportunityDescriptionInputField;

    @FindBy(className = "errorsList")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[contains(text(),'Account Name')]/ancestor::div/following-sibling::ul")
    private WebElement errorFieldInvalidAccount;

    @FindBy(xpath = "//span[contains(text(),'Primary Campaign Source')]/ancestor::div/following-sibling::ul")
    private WebElement errorFieldInvalidCampaign;


    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * @param opportunityName field.
     * @return this.
     */
    public OpportunityForm setOpportunityNameInputText(final String opportunityName) {
        action.setInputField(opportunityNameInputField, opportunityName);
        return this;
    }

    /**
     * This method perform a click in the account name text box.
     */
    public void clickAccountName() {
        action.clickElement(opportunityAccountNameInputField);
    }

    /**
     * @param accountName field.
     * @return this.
     */
    public OpportunityForm setAccountNameSelect(final String accountName) {
        clickAccountName();
        if (SFDCEnvironment.isLightningExperience()) clickDeleteAccountIcon(accountName);
        action.setInputField(opportunityAccountNameInputField, accountName);
        if (SFDCEnvironment.isLightningExperience())
            action.clickElement(selectComboBoxFormElement(accountName));

        return this;
    }

    /**
     * Select ComboBox Form Element.
     *
     * @param element String.
     * @return WebElement.
     */
    public WebElement selectComboBoxFormElement(final String element) {
        String selector = String.format("//strong[text()='%s']", element);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    /**
     * @param opportunityType field.
     * @return this.
     */
    public OpportunityForm setTypeSelect(final String opportunityType) {
        action.clickElement(opportunityTypeInputField);
        selectedAformElement(opportunityType);
        return this;
    }

    /**
     * This method perform a click in the campaign input name.
     */
    public void clickCampaignInputName() {
        action.clickElement(opportunityCampaignInputField);
    }

    /**
     * @param campaignName field.
     * @return this.
     */
    public OpportunityForm setPrimaryCampaignSourceSelect(final String campaignName) {
        clickCampaignInputName();
        action.clickElement(selectedDivFormElement(campaignName));
        return this;
    }

    /**
     * @return this.
     */
    public OpportunityForm setCloseDateSelect() {

        action.clickElement(opportunityDateInputField);
        action.clickElement(selectOpportunityDateInputField);

        return this;
    }

    /**
     * @param stage field.
     * @return this.
     */
    public OpportunityForm setStageSelect(final String stage) {

        if (!SFDCEnvironment.isLightningExperience()) action.clickElement(opportunityAccountNameInputField);
        action.clickElement(opportunityStageInputField);
        selectedAformElement(stage);

        return this;
    }

    /**
     * @param probability field.
     * @return this.
     */
    public OpportunityForm setProbabilityInputText(final String probability) {
        action.setInputField(opportunityProbabilityInputField, probability);
        return this;
    }

    /**
     * @param amount field.
     * @return this.
     */
    public OpportunityForm setAmountInputText(final String amount) {

        action.setInputField(opportunityAmountInputField, amount);
        return this;
    }

    /**
     * @param lead field.
     * @return this.
     */
    public OpportunityForm setLeadSourceSelect(final String lead) {

        action.clickElement(opportunityLeadInputField);
        selectedAformElement(lead);
        return this;
    }

    /**
     * @param nextStep field.
     * @return this.
     */
    public OpportunityForm setNextStepInputText(final String nextStep) {

        action.setInputField(opportunityNextStepInputField, nextStep);
        return this;
    }

    /**
     * @param description field.
     * @return this.
     */
    public OpportunityForm setDescriptionTextArea(final String description) {
        action.setInputField(opportunityDescriptionInputField, description);
        return this;
    }

    /**
     * @param formMap strategy.
     * @return strategyMap.
     */
    private Map<OpportunityFormField, IStrategySteps> getStrategyMap(final Map<OpportunityFormField, String> formMap) {
        EnumMap<OpportunityFormField, IStrategySteps> strategyMap = new EnumMap<>(OpportunityFormField.class);

        strategyMap.put(OpportunityFormField.OPPORTUNITY_NAME,
                () -> setOpportunityNameInputText(formMap.get(OpportunityFormField.OPPORTUNITY_NAME)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_ACCOUNT,
                () -> setAccountNameSelect(formMap.get(OpportunityFormField.OPPORTUNITY_ACCOUNT)));

        strategyMap.put(OpportunityFormField.DATE, this::setCloseDateSelect);

        strategyMap.put(OpportunityFormField.OPPORTUNITY_TYPE,
                () -> setTypeSelect(formMap.get(OpportunityFormField.OPPORTUNITY_TYPE)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_PROBABILITY,
                () -> setProbabilityInputText(formMap.get(OpportunityFormField.OPPORTUNITY_PROBABILITY)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_CAMPAIGN,
                () -> setPrimaryCampaignSourceSelect(formMap.get(OpportunityFormField.OPPORTUNITY_CAMPAIGN)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_AMOUNT,
                () -> setAmountInputText(formMap.get(OpportunityFormField.OPPORTUNITY_AMOUNT)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_LEAD,
                () -> setLeadSourceSelect(formMap.get(OpportunityFormField.OPPORTUNITY_LEAD)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_NEXT,
                () -> setNextStepInputText(formMap.get(OpportunityFormField.OPPORTUNITY_NEXT)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_DESCRIPTION,
                () -> setDescriptionTextArea(formMap.get(OpportunityFormField.OPPORTUNITY_DESCRIPTION)));

        strategyMap.put(OpportunityFormField.OPPORTUNITY_STAGE,
                () -> setStageSelect(formMap.get(OpportunityFormField.OPPORTUNITY_STAGE)));
        return strategyMap;
    }

    /**
     * @param element web.
     */
    public void selectedAformElement(final String element) {

        String selector;

        if (SFDCEnvironment.isLightningExperience()) {
            selector = String.format("//span[contains(@title,'%s')]", element);

        } else {
            selector = String.format("//option[contains(text(),'%s')]", element);
        }

        driver.findElement(By.xpath(selector)).click();
    }

    /**
     * Selected Div Form Element.
     *
     * @param element String.
     * @return WebElement.
     */
    public WebElement selectedDivFormElement(final String element) {
        String selector = String.format("span[title = '%s']", element);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }

    /**
     * {@inheritDoc}
     */
    public OpportunityDetail fillAndSaveForm(final Map<OpportunityFormField, String> formMapData) {
        formMapData.forEach((key, value) -> getStrategyMap(formMapData).get(key).performStep());
        clickSaveButton();
        return new OpportunityDetail();
    }

    /**
     * @param accountName field.
     */
    public void clickDeleteAccountIcon(final String accountName) {
        String xpathSelector = String.format("//*[contains(@placeholder, '%s')]/parent::div/descendant::button", accountName);
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            wait.withTimeout(Duration.ofSeconds(3));
            driver.findElement(By.xpath(xpathSelector)).click();
        } catch (NotFoundException e) {
            LOGGER.error("Timeout exception triggered");
        } finally {
            driver.manage().timeouts().implicitlyWait(Env.getInstance().getImplicitTimeWait(), TimeUnit.SECONDS);
            wait.withTimeout(Duration.ofSeconds(Env.getInstance().getExplicitTimeWait()));
        }
    }

    /**
     * This method verify error message.
     *
     * @param message is error message.
     * @return if message is correct.
     */
    public Boolean messageIsDisplayed(final String message) {
        return errorMessage.getText().contains(message);
    }

    /**
     * This method verify error message.
     *
     * @param error is error.
     * @return if message is correct.
     */
    public boolean messageFieldInvalidIsDisplayed(final String error) {
        return errorFieldInvalidAccount.getText().contains(error)
                && errorFieldInvalidCampaign.getText().contains(error);
    }
}
