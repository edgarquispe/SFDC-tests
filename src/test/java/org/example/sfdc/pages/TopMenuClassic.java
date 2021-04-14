package org.example.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuClassic extends TopMenu {
    @FindBy(id = "userNavLabel")
    private WebElement userProfileLink;

    @FindBy(css = "a[class='switch-to-lightning']")
    private WebElement switchThemeLink;

    @Override
    public void switchExperience() {
        action.clickElement(userProfileLink);
        action.clickElement(switchThemeLink);
    }
}
