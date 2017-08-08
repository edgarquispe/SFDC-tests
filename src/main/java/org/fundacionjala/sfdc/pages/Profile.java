package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by OvidioMiranda on 8/8/2017.
 */
public class Profile extends BasePage {

    @FindBy(css = ".uiOutputEmail")
    private WebElement currentUserEmail;

    public boolean isCorrectUserLogged(String username) {
        return username.equals(currentUserEmail.getText());
    }
}
