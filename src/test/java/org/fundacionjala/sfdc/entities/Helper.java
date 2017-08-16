package org.fundacionjala.sfdc.entities;

/**
 * Helper class with Dependency Injection for all Steps.
 */
public class Helper {

    private String itemName;

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
}
