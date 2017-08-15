package org.fundacionjala.sfdc.utilities;

import org.fundacionjala.sfdc.pages.Navigator;
import org.fundacionjala.sfdc.pages.base.HomeBase;

import java.util.HashMap;
import java.util.Map;

/**
 * Manager Class to go to pages dinamically.
 */
public final class CommonManager {

    /**
     * Private Constructor.
     */
    private CommonManager() {

    }

    /**
     * Static method to go to any page on Enum Items.
     * @param endPoint Items.
     * @return HomeBase.
     */
    public static HomeBase gotoPage(Items endPoint) {
        Map<Items, HomeBase> map = new HashMap<>();
        map.put(Items.PRODUCT, Navigator.goToProductsHome());
        return map.get(endPoint);
    }
}
