package tests;

import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LinkedInSignUpPage;
import pages.SignInFacebookPage;
import utility.ConfigReader;
import utility.Navigation;
import utility.TestManager;

public class TestRegistrationWithFacebookAccount {

    @Parameters("browser")
    @BeforeMethod(groups = {"Positive", "Negative"})
    public void setUpBrowser(String browser) {
        TestManager.setUpBrowser(browser);
    }

    @Test(priority = 1, groups = {"Positive"}, dataProvider = "signInFacebookValidData", dataProviderClass = DataProviders.class)
    public void positiveRegistrationWithFacebookAccountTestScenario(String email, String password) {
        Navigation.openLinkedInSignUpPage();
        LinkedInSignUpPage.signUpWithFacebookAccount();
        SignInFacebookPage.signIn(email,password);
        Assert.assertTrue(LinkedInSignUpPage.isfbSuccessNotificationDisplayed(), "Successful authentication message is displayed");
    }

    @Test(priority = 2, groups = {"Negative"}, dataProvider = "signInFacebookInvalidData", dataProviderClass = DataProviders.class)
    public void negativeRegistrationWithFacebookAccountTestScenario(String email, String password) {
        Navigation.openLinkedInSignUpPage();
        LinkedInSignUpPage.signUpWithFacebookAccount();
        SignInFacebookPage.signIn(email,password);
        Assert.assertTrue(SignInFacebookPage.isErrorMessageDisplayed(), "Error message is displayed");
    }

    @AfterMethod(groups = {"Positive", "Negative"})
    public void afterMethod() {
        TestManager.getBrowser().quit();
    }

    }


