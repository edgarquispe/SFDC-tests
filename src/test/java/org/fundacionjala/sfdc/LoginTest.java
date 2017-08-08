package org.fundacionjala.sfdc;

import org.fundacionjala.sfdc.pages.Home;
import org.fundacionjala.sfdc.pages.Login;
import org.fundacionjala.sfdc.pages.Profile;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Simon on 07/08/2017.
 */
public class LoginTest {


    @Test
    public void test01LoginSuccessfully() {
        final String username = "Ovidio.Miranda@fundacion-jala.org";
        final String password = "2017.Atmt";
        final String expectedResult = "lightning.force.com/one/one.app#/home";
        Home homePage = Login.loginInitial(username, password);
        homePage.clickLinkLogOut();
//        assertTrue(Login.loginInitial(username, password).getPageTitle().contains(expectedResult));
    }

    @Test
    public void test01LoginSuccessfully2() {
        final String username = "Ovidio.Miranda@fundacion-jala.org";
        final String password = "2017.Atmt";
        String username2 = "cynthia.terrazas.g@gmail.com";
        String password2 = "fundacion000";
        Home home = Login.loginInitial(username2, password2);
        Home home2 = Login.loginInitial(username, password);

    }

    @Test
    public void test_LoginUnsuccessfully() {
        final String username = "OvidioMiranda@fundacadasdion-jala.com";
        final String password = "2017.Atmtasfg";
        Home homePage = Login.loginInitial(username, password);
        assertTrue(homePage.isErrorMessageDisplayed());
    }

    @Test
    public void test_LoginVerifyNameUser() {
        final String username = "Ovidio.Miranda@fundacion-jala.org";
        final String password = "2017.Atmt";
        Home homePage = Login.loginInitial(username, password);
        final String actualResult = homePage.getUserNameOfHomePage();
        final String expectedResult = "Simon Miranda";
        assertEquals(actualResult, expectedResult);
    }


}
