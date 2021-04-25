package org.example.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuLightning extends TopMenu {
    @FindBy(css = ".branding-user-profile")
    private WebElement userProfileLink;

    @FindBy(css = "div.profile-card-footer > a")
    private WebElement switchThemeLink;

    @Override
    public void switchExperience() {
        wait.until(ExpectedConditions.visibilityOf(userProfileLink));
        wait.until(ExpectedConditions.elementToBeClickable(userProfileLink));
        action.jsClick(userProfileLink);
        action.jsClick(switchThemeLink);
    }

}
