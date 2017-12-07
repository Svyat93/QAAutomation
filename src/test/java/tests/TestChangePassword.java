package tests;

import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LinkedInChangePasswordPage;
import pages.LinkedInProfilePage;
import pages.LinkedInSignInPage;
import utility.ConfigReader;
import utility.Navigation;
import utility.TestManager;

public class TestChangePassword {

    @Parameters("browser")
    @BeforeMethod (groups={"Negative"})
    public void setUpBrowser(String browser) {
        TestManager.setUpBrowser(browser);
        Navigation.openLinkedInSignInPage();
        LinkedInSignInPage.signIn(ConfigReader.getEmail(),ConfigReader.getPassword());
        Assert.assertEquals(LinkedInProfilePage.getTitle(), "LinkedIn");
    }

    @Test(groups={"Negative"}, dataProvider = "invalidChangePasswordData", dataProviderClass = DataProviders.class)
    public void negativeChangePasswordTestScenario(String cPass, String nPass) {
        Navigation.openLinkedInChangePasswordPage();
        LinkedInChangePasswordPage.changePassword(cPass, nPass);
        Assert.assertTrue(LinkedInChangePasswordPage.isErrorMessageDisplayed(), "Incorrect password message is displayed");
    }

    @AfterMethod (groups={"Negative"})
    public void afterMethod() {
        TestManager.getBrowser().quit();
    }
    }


