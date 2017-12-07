package tests;

import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utility.ConfigReader;
import utility.Navigation;
import utility.TestManager;

public class TestAddEmail {

    @Parameters("browser")
    @BeforeMethod (groups={"Positive"})
    public void setUpBrowser(String browser) {
        TestManager.setUpBrowser(browser);
        Navigation.openLinkedInSignInPage();
        LinkedInSignInPage.signIn(ConfigReader.getEmail(),ConfigReader.getPassword());
        Assert.assertEquals(LinkedInProfilePage.getTitle(), "LinkedIn");
    }

    @Test(groups={"Positive"}, dataProvider = "addEmailData", dataProviderClass = DataProviders.class)
    public void positiveAddEmailTestScenario(String email) {
        Navigation.openLinkedInEmailPage();
        LinkedInEmailPage.addEmail();
        LinkedInAddEmailPage.enterEmailandSendVerification(email);
        Assert.assertTrue(LinkedInAddEmailPage.isEnterPasswordFormDisplayed(), "Enter password form is displayed");
    }

    @AfterMethod (groups={"Positive"})
    public void afterMethod() {
        TestManager.getBrowser().quit();
    }
    }


