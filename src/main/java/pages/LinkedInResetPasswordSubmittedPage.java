package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;
import utility.TestManager;

public class LinkedInResetPasswordSubmittedPage {

    public static String isLinkedInResetPasswordSubmittedPageDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.urlMatches(ConfigReader.getResetPasswordSubmittedPage()));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return TestManager.getBrowser().getCurrentUrl();
    }
}
