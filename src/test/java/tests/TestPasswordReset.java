package tests;

import data.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LinkedInResetPasswordPage;
import pages.LinkedInResetPasswordSubmittedPage;
import utility.ConfigReader;
import utility.Navigation;
import utility.TestManager;

public class TestPasswordReset {

    @Parameters("browser")
    @BeforeMethod(groups={"Positive", "Negative"})
    public void setUpBrowser(String browser) {
        TestManager.setUpBrowser(browser);
    }

   @Test(priority =1, groups={"Positive"}, dataProvider = "resetPasswordValidData", dataProviderClass = DataProviders.class)
    public void positivePasswordResetTestScenario(String email) {
        Navigation.openLinkedInResetPasswordPage();
        LinkedInResetPasswordPage.resetPassword(email);
        Assert.assertEquals(LinkedInResetPasswordSubmittedPage.isLinkedInResetPasswordSubmittedPageDisplayed(), ConfigReader.getResetPasswordSubmittedPage());
    }

    @Test(priority =2, groups={"Negative"}, dataProvider = "resetPasswordInvalidData", dataProviderClass = DataProviders.class)
    public void negativePasswordResetTestScenario(String email){
        Navigation.openLinkedInResetPasswordPage();
        LinkedInResetPasswordPage.resetPassword(email);
        Assert.assertTrue(LinkedInResetPasswordPage.isErrorMessageDisplayed(), "Error message is displayed");
    }

    @AfterMethod (groups={"Positive", "Negative"})
    public void afterMethod() {
        TestManager.getBrowser().quit();
    }
}


