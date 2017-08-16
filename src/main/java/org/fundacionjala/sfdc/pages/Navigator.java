package org.fundacionjala.sfdc.pages;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Final class Navigator to access the different pages.
 */
public final class Navigator {
    /**
     * Private Constructor.
     */
    private Navigator() {

    }

    /**
     * Click and returns an AppLauncher Instance.
     *
     * @return AppLauncher.
     */
    public static AppLauncher clickAppLauncher() {
        return new Home().clickAppLauncher();
    }

    /**
     * Go to Products Home Page.
     *
     * @return ProductHome.
     */
    public static ProductHome goToProductsHome() {
        clickAppLauncher().clickProductsTextLink();
        return new ProductHome();
    }

    /**
     * Static method to go to any page on Enum SObject.
     *
     * @param endPoint SObject.
     * @return HomeBase.
     */
    public static HomeBase gotoPage(SObject endPoint) {
        switch (endPoint) {
            default: PRODUCT:
                return Navigator.goToProductsHome();
        }
    }

    /**
     * Static method  to map Actions.
     *
     * @param item SObject.
     * @return HomeBase.
     */
    public static HomeBase mapActions(SObject item) {
        Map<SObject, ProductHome> map = new HashMap<>();
        map.put(SObject.PRODUCT, new ProductHome());
        return map.get(item);
    }
}
