package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.DriverManager;
import org.fundacionjala.sfdc.pages.base.BasePage;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Simon on 07/08/2017.
 */
public class Login extends BasePage {

    private static final String URL = "https://login.salesforce.com";
    private static final String URL_HOME = "https://na59.lightning.force.com";
    private static final int TIME_WAIT_DURATION = 5;

    //All WebElements are identified by @FindBy annotation.
    @FindBy(id = "username")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    /**
     * Constructor for Default.
     */
    public Login() {
        loadUrlPage(URL);
    }

    /**
     * Set user name in input field.
     *
     * @param username User Name for Sales Force.
     * @return Login pageObject.
     */
    public Login setUserName(String username) {
        CommonActions.setInputField(userNameInputField, username);
        return this;
    }

    /**
     * Set password in password input field.
     *
     * @param password Password for Sales Force.
     * @return Login pageObject.
     */
    public Login setPassword(String password) {
        CommonActions.setInputField(passwordInputField, password);
        return this;
    }

    /**
     * This method make click on login button.
     *
     * @return Home pageObject.
     */
    public Home clickLogin() {
        CommonActions.clickElement(loginBtn);
        return new Home();
    }

    /**
     * This Method make a login to Salesforce application.
     * @param username  User Name for Sales Force.
     * @param password Password for Sales Force.
     * @return Home page after login to Salesforce application.
     */
    public Home loginAs(String username, String password) {
        return setUserName(username).setPassword(password).clickLogin();
    }

    /**
     * This Method make a login with other user to Salesforce application.
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login to Salesforce application.
     */
    public Home loginOtherUser(String userName, String password) {
        Home homePage;
        try {
            DriverManager.getInstance().setUpdateWait(TIME_WAIT_DURATION);
            homePage = new Home();
            Profile profile = homePage.clickProfileLinkLabel();
            if (!profile.isCorrectUserLogged(userName)) {
                homePage.clickLinkLogOut();
                homePage = loginAs(userName, password);
            }
            homePage.clickHomeLink();
        } catch (WebDriverException e) {
            DriverManager.getInstance().getDriver().get(URL);
            homePage = loginAs(userName, password);
        } finally {
            DriverManager.getInstance().backPreviousWait();
        }
        return homePage;
    }

    /**
     * This method verify is the user is logged.
     * @return True if the user is logged.
     */
    public boolean isUserLogged() {
        DriverManager.getInstance().getDriver().get(URL_HOME);
        return getPageTitle().contains("Home");
    }


    /**
     * This method make a login Initial.
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login to Salesforce application.
     */
    public static Home loginInitial(String userName, String password) {
        Login login = new Login();
        return login.isUserLogged() ? login.loginOtherUser(userName, password) : login.loginAs(userName, password);
    }

}
