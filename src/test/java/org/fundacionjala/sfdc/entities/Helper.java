package org.fundacionjala.sfdc.entities;

import java.util.Map;

/**
 * Helper class with Dependency Injection for all Steps.
 */
public class Helper {

    private String data;
    private Map dataMap;

    /**
     * Get the Data Type.
     *
     * @return String.
     */
    public String getData() {
        return data;
    }

    /**
     * Set the Data Type.
     *
     * @param data String.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Get the Data Map values.
     *
     * @return Map.
     */
    public Map getDataMap() {
        return dataMap;
    }

    /**
     * Set the Data Map values.
     *
     * @param dataMap Map.
     */
    public void setDataMap(Map dataMap) {
        this.dataMap = dataMap;
    }
}
