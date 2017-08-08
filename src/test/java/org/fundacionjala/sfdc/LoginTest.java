package org.fundacionjala.sfdc;

import org.fundacionjala.sfdc.pages.Home;
import org.fundacionjala.sfdc.pages.Login;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Simon on 07/08/2017.
 */
public class LoginTest {


    /**
     *
     */
    @Test
    public void testLoginSuccessfully() {
        final String username = "ovidio.miranda@fundacion-jala.org";
        final String password = "2017.Atmt";
        final String expectedResult = "Login";
        Home homePage = Login.loginInitial(username, password);
        assertTrue(homePage.clickLinkLogOut().getPageTitle().contains(expectedResult));
    }

    /**
     *
     */
    @Test
    public void testVerifyCorrectUser() {
        final String username = "ovidio.miranda@fundacion-jala.org";
        final String password = "2017.Atmt";
        String secondUsername = "cynthia.terrazas.g@gmail.com";
        String secondPassword = "fundacion000";
        Login.loginInitial(secondUsername, secondPassword);
        Home home = Login.loginInitial(username, password);
        assertTrue(home.clickProfileLinkLabel().isCorrectUserLogged(username));
    }

    /**
     *
     */
    @Test
    public void testCurrenUserIsLogged() {
        final String username = "ovidio.miranda@fundacion-jala.org";
        final String password = "2017.Atmt";
        Login.loginInitial(username, password);
        Home home = Login.loginInitial(username, password);
        assertTrue(home.clickProfileLinkLabel().isCorrectUserLogged(username));
    }

    /**
     *
     */
    @Test
    public void testLoginUnsuccessfully() {
        final String username = "OvidioMiranda@fundacadasdion-jala.com";
        final String password = "2017.Atmtasfg";
        Home homePage = Login.loginInitial(username, password);
        assertTrue(homePage.isErrorMessageDisplayed());
    }

    /**
     *
     */
    @Test
    public void testLoginVerifyNameUser() {
        final String username = "Ovidio.Miranda@fundacion-jala.org";
        final String password = "2017.Atmt";
        Home homePage = Login.loginInitial(username, password);
        final String actualResult = homePage.getUserNameOfHomePage();
        final String expectedResult = "Simon Miranda";
        assertEquals(actualResult, expectedResult);
    }


}
