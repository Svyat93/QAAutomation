package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.timestamp.TSRequest;
import utility.ConfigReader;
import utility.TestManager;

import java.util.concurrent.TimeUnit;


public class SignInFacebookPage {

    @FindBy(id="email")
    static WebElement emailField;

    @FindBy(id="pass")
    static WebElement passwordField;

    @FindBy(xpath="//input[@type='submit']")
    static WebElement signInButton;

    @FindBy(id="error_box")
    static WebElement errorMessage;

    public static LinkedInSignUpPage signIn(String email, String password){
        TestManager.setWindowHandle();
        emailField.clear();
        passwordField.clear();

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(TestManager.getBrowser(),LinkedInSignUpPage.class);

    }

    public static boolean isErrorMessageDisplayed(){

        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_box")));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return errorMessage.isDisplayed();
    }
}
