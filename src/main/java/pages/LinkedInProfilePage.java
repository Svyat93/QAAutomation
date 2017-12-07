package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TestManager;

public class LinkedInProfilePage {
    public static String getTitle(){
        try {
            WebDriverWait wait = new WebDriverWait(TestManager.getBrowser(), 5);
            wait.until(ExpectedConditions.titleIs("LinkedIn"));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        return TestManager.getBrowser().getTitle();
    }


}
