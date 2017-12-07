package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class ConfigReader {

    static Properties p;
    public ConfigReader(){
        String path = "src/main/resources/config.properties";
        try(BufferedReader bR = Files.newBufferedReader(Paths.get(path))){
            p = new Properties();
            p.load(bR);
        } catch(IOException ioe){
            System.out.println("File not found" + ioe.getMessage());
        }
    }

    public static String getChromeDriverPath(){
             return p.getProperty("ChromeDriver");
    }

    public static String getFirefoxDriverPath(){
        return p.getProperty("FirefoxDriver");
    }

    public static String getMicrosoftDriverPath(){
        return p.getProperty("MicrosoftWebDriver");
    }

    public static String getSignUpPageURL(){
        return p.getProperty("signUpPageURL");
    }

    public static String getSignInPageURL(){
        return p.getProperty("signInPageURL");
    }

    public static String getProfilePageURL(){ return p.getProperty("profilePageURL"); }

    public static String getChangePasswordPageURL(){
        return p.getProperty("changePasswordPageURL");
    }

    public static String getResetPasswordPage(){return p.getProperty("resetPasswordPageURL"); }

    public static String getResetPasswordSubmittedPage(){return p.getProperty("resetPasswordSubmittedPageURL"); }

    public static String getEmailPageURL(){return p.getProperty("emailPageURL"); }

    public static String getEmail(){ return p.getProperty("email"); }

    public static String getPassword(){ return p.getProperty("password"); }

    public static void setPassword(String nPass){
        p.setProperty("password", nPass);
    }

    public static String getlog4j2xmlFilePath(){
        return p.getProperty("log4j2Path");
    }


}
