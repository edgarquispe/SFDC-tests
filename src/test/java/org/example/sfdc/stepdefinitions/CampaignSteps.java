package org.example.sfdc.stepdefinitions;

import java.util.Map;

import io.cucumber.java.en.When;

import org.example.sfdc.entities.Helper;
import org.example.sfdc.pages.campaigns.CampaignDetail;
import org.example.sfdc.pages.campaigns.CampaignForm;
import org.example.sfdc.pages.campaigns.CampaignFormField;

/**
 * Create steps for campaign.
 */
public class CampaignSteps {

    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public CampaignSteps(final Helper helper) {
        this.helper = helper;
    }

    /**
     * Fill the Campaign Form.
     *
     * @param formMapData Map.
     */
    @When("^I fill the Campaign form with:$")
    public void iFillTheCampaignFormWith(final Map<CampaignFormField, String> formMapData) {
        helper.setCampaignName(formMapData.get(CampaignFormField.CAMPAIGN_NAME));
        helper.setCampaignMap(formMapData);
        new CampaignForm().fillAndSaveForm(helper.getCampaignMap());
    }

    /**
     * Click on Edit inside Campaign Detail.
     */
    @When("^click on Edit Campaign $")
    public void iClickOnEditCampaign() {
        new CampaignDetail().clickEditButton();
    }

    /**
     * Click on Delete button on Detail Page.
     */
    @When("^I Click on Delete from Campaign")
    public void iClickOnDeleteFromCampaign() {
        new CampaignDetail().deleteItem();
    }
}
