package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.ConfigReader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestManager {

    static WebDriver browser;

    public static void setUpBrowser(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
                System.setProperty("webdriver.chrome.driver",ConfigReader.getChromeDriverPath());
                browser = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver",ConfigReader.getFirefoxDriverPath());
            browser = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver",ConfigReader.getMicrosoftDriverPath());
            browser = new EdgeDriver();
        }
    }
    public static void setLogFile(){
        new ConfigReader();
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File(ConfigReader.getlog4j2xmlFilePath());
        context.setConfigLocation(file.toURI());
    }

    public static WebDriver getBrowser(){
        return browser;
    }


    public static void setWindowHandle(){
        String windowHandle = browser.getWindowHandle();
        try{
            browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            for(String newWindowHandle:browser.getWindowHandles()){
                if(!newWindowHandle.equalsIgnoreCase(windowHandle)){
                    browser.switchTo().window(newWindowHandle);
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



}
