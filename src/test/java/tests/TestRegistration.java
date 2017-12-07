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
import utility.TakeScreenshot;
import utility.TestManager;

public class TestRegistration {

    @Parameters("browser")
    @BeforeMethod(groups = {"Negative"})
    public void setUpBrowser(String browser) {
        TestManager.setUpBrowser(browser);
    }

    @Test(groups = {"Negative"}, dataProvider = "registrationInvalidData", dataProviderClass = DataProviders.class)
    public void negativeRegistrationTestScenario(String name, String surname, String email, String password) {
        Navigation.openLinkedInSignUpPage();
        LinkedInSignUpPage.signUp(name, surname, email, password);
        Assert.assertNotEquals(TestManager.getBrowser().getCurrentUrl(), ConfigReader.getProfilePageURL());
        Assert.assertTrue(LinkedInSignUpPage.isErrorMessageDisplayed(), "Error message is displayed");
    }

    @AfterMethod(groups = {"Negative"})
    public void afterMethod() {
        TestManager.getBrowser().quit();
    }

    }


