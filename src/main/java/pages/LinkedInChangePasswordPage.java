package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestManager;

public class LinkedInChangePasswordPage {

    @FindBy(id="cp-current-pw")
    static WebElement currentPassField;

    @FindBy(id="cp-new-pw")
    static WebElement newPassField;

    @FindBy(id="cp-repeat-pw")
    static WebElement newRepeatPassField;

    @FindBy(id="save-new-password")
    static WebElement savePassBtn;

    @FindBy(xpath="//div[@class='error-container']")
    static WebElement errorMessage;

    public static void changePassword(String cPass, String nPass) {
        currentPassField.clear();
        newRepeatPassField.clear();
        newRepeatPassField.clear();

        currentPassField.sendKeys(cPass);
        newPassField.sendKeys(nPass);
        newRepeatPassField.sendKeys(nPass);
        savePassBtn.click();
    }

    public static boolean isErrorMessageDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-container']")));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return errorMessage.isDisplayed();
    }

}
