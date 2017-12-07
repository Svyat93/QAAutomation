package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestManager;


public class LinkedInResetPasswordPage {

    @FindBy(id="userName-requestPasswordReset")
    static WebElement emailField;

    @FindBy(id="btnSubmitResetRequest")
    static WebElement resetPassBtn;

    @FindBy(id="userName-requestPasswordReset-error")
    static WebElement alertMsg;

    public static LinkedInResetPasswordSubmittedPage resetPassword(String email){
        emailField.clear();

        emailField.sendKeys(email);
        resetPassBtn.click();
        return PageFactory.initElements(TestManager.getBrowser(),LinkedInResetPasswordSubmittedPage.class);
    }

    public static boolean isErrorMessageDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-requestPasswordReset-error")));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return alertMsg.isDisplayed();
    }

}
