package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestManager;

public class LinkedInEmailPage {

    @FindBy(xpath="//button[@class='add-email-address']")
    static WebElement addEmailBtn;

    public static LinkedInAddEmailPage addEmail(){
        addEmailBtn.click();
        return PageFactory.initElements(TestManager.getBrowser(),LinkedInAddEmailPage.class);
    }

}
