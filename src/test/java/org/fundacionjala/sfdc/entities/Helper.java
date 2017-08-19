package org.fundacionjala.sfdc.entities;

/**
 * Helper class with Dependency Injection for all Steps.
 */
public class Helper {

    private String itemName;

    private String postMessage;

    private String commentPostMessage;

    private String campaignName;

    private String opportunityName;

    /**
     * Get the Item Name for edit and delete purposes.
     *
     * @return String.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the Item Name value.
     *
     * @param itemName String.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Get Post Message.
     *
     * @return String.
     */
    public String getPostMessage() {
        return postMessage;
    }

    /**
     * Set Post Message.
     *
     * @param postMessage String.
     */
    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    /**
     * Get Comment Post Message.
     *
     * @return String.
     */
    public String getCommentPostMessage() {
        return commentPostMessage;
    }

    /**
     * Set Comment Post Message.
     *
     * @param commentPostMessage String.
     */
    public void setCommentPostMessage(String commentPostMessage) {
        this.commentPostMessage = commentPostMessage;
    }

    /**
     * Get Campaign Name.
     * @return String.
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Set Account Name.
     * @param campaignName String.
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     * Get Opportunity Name.
     * @return String.
     */
    public String getOpportunityName() {
        return opportunityName;
    }

    /**
     * Set Opportunity Name.
     * @param opportunityName String.
     */
    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }
}
