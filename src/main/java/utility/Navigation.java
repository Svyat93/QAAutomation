package utility;

import org.openqa.selenium.support.PageFactory;
import pages.*;


public class Navigation {

    public static LinkedInSignUpPage openLinkedInSignUpPage(){
        TestManager.getBrowser().get(ConfigReader.getSignUpPageURL());
        return  PageFactory.initElements(TestManager.getBrowser(), LinkedInSignUpPage.class);
    }

    public static LinkedInSignInPage openLinkedInSignInPage(){
        TestManager.getBrowser().get(ConfigReader.getSignInPageURL());
        return  PageFactory.initElements(TestManager.getBrowser(), LinkedInSignInPage.class);
    }

    public static LinkedInChangePasswordPage openLinkedInChangePasswordPage(){
        TestManager.getBrowser().get(ConfigReader.getChangePasswordPageURL());
        return  PageFactory.initElements(TestManager.getBrowser(), LinkedInChangePasswordPage.class);

    }

    public static LinkedInEmailPage openLinkedInEmailPage(){
        TestManager.getBrowser().get(ConfigReader.getEmailPageURL());
        return  PageFactory.initElements(TestManager.getBrowser(), LinkedInEmailPage.class);

    }

    public static LinkedInResetPasswordPage openLinkedInResetPasswordPage(){
        TestManager.getBrowser().get(ConfigReader.getResetPasswordPage());
        return  PageFactory.initElements(TestManager.getBrowser(), LinkedInResetPasswordPage.class);

    }






}
