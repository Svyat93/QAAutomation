package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestManager;

import java.util.concurrent.TimeUnit;

public class LinkedInSignInPage {

    @FindBy(name="session_key")
    static WebElement emailField;

    @FindBy(name="session_password")
    static WebElement passwordField;

    @FindBy(name="signin")
    static WebElement signInBtn;

    @FindBy(id="session_password-login-error")
    static WebElement alertIncorrectPasswordMsg;

    public static LinkedInProfilePage signIn(String email,String password){
        emailField.clear();
        passwordField.clear();

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();
        return PageFactory.initElements(TestManager.getBrowser(),LinkedInProfilePage.class);
    }

    public static boolean isAlertMessageDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("session_password-login-error")));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return alertIncorrectPasswordMsg.isDisplayed();
    }

}
