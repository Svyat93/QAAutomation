package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestManager;

public class LinkedInAddEmailPage {

    @FindBy(id="add-email-address")
    static WebElement emailField;

    @FindBy(xpath="//button[@class='send-verification']")
    static WebElement sendVerificationBtn;

    @FindBy(xpath="//form[@class='password-prompt active']")
    static WebElement enterPassForm;

    public static void enterEmailandSendVerification(String email){
        emailField.clear();

        emailField.sendKeys(email);
        sendVerificationBtn.click();
    }

    public static boolean isEnterPasswordFormDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='password-prompt active']")));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return enterPassForm.isDisplayed();
    }
}
