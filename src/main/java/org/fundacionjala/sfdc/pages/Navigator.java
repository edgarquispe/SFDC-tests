package org.fundacionjala.sfdc.pages;

/**
 * Created by abelb on 8/12/2017.
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
}
