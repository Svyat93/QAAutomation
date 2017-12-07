package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;
import utility.TestManager;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class LinkedInSignUpPage {

    @FindBy(id="first-name")
    static WebElement nameField;

    @FindBy(id="last-name")
    static WebElement surnameField;

    @FindBy(id="join-email")
    static WebElement emailField;

    @FindBy(id="join-password")
    static WebElement passwordField;

    @FindBy(xpath="//button[@type='submit']")
    static WebElement signUpBtn;

    @FindBy(xpath="//button[@type='button']")
    static WebElement signInFbBtn;

    @FindBy(xpath="//div[@class='uno-alert error hidden']")
    static WebElement alertMsg;

    @FindBy(xpath="//div[@class='uno-alert success hidden']")
    static WebElement fbSuccessNotification;

    public static void signUp(String name, String surname, String email, String password){
        nameField.clear();
        surnameField.clear();
        emailField.clear();
        passwordField.clear();

        nameField.sendKeys(name);
        surnameField.sendKeys(surname);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signUpBtn.click();
    }

    public static SignInFacebookPage signUpWithFacebookAccount(){
        signInFbBtn.click();
        return PageFactory.initElements(TestManager.getBrowser(),SignInFacebookPage.class);
    }

    public static boolean isfbSuccessNotificationDisplayed(){
        TestManager.setWindowHandle();
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uno-alert success hidden']")));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return fbSuccessNotification.isDisplayed();
    }

    public static boolean isErrorMessageDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uno-alert error hidden']")));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return alertMsg.isDisplayed();
    }

}
