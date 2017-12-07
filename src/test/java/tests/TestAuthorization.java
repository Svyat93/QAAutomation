package tests;

import data.DataProviders;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LinkedInProfilePage;
import pages.LinkedInSignInPage;
import utility.ConfigReader;
import utility.Navigation;
import utility.TestManager;



public class TestAuthorization {

    @Parameters("browser")
    @BeforeMethod(groups={"Positive", "Negative"})
    public void setUpBrowser(String browser) {
        TestManager.setUpBrowser(browser);
    }

    @Test(priority =1, groups={"Positive"}, dataProvider = "authorizationValidData", dataProviderClass = DataProviders.class)
    public void positiveAuthorizationTestScenario(String email, String password) {
        Navigation.openLinkedInSignInPage();
        LinkedInSignInPage.signIn(email, password);
        Assert.assertEquals(LinkedInProfilePage.getTitle(),"LinkedIn");
    }

    @Test(priority =2, groups={"Negative"}, dataProvider = "authorizationInvalidData", dataProviderClass = DataProviders.class)
    public void negativeAuthorizationTestScenario(String email, String password){
        Navigation.openLinkedInSignInPage();
        LinkedInSignInPage.signIn(email, password);
        Assert.assertNotEquals(TestManager.getBrowser().getCurrentUrl(), ConfigReader.getProfilePageURL());
    }

    @Test(priority =3, groups={"Negative"}, dataProvider = "authorizationIncorrectPassword", dataProviderClass = DataProviders.class)
    public void checkAlertMessageTestScenario(String email, String password){
        Navigation.openLinkedInSignInPage();
        LinkedInSignInPage.signIn(email, password);
        Assert.assertTrue(LinkedInSignInPage.isAlertMessageDisplayed(), "Incorrect password message is displayed");
    }

    @AfterMethod (groups={"Positive", "Negative"})
    public void afterMethod() {
        TestManager.getBrowser().quit();
    }
}


