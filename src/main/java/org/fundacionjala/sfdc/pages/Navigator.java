package org.fundacionjala.sfdc.pages;

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
}
