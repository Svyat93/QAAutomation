package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class TakeScreenshot {

  public static void getScreenshot(String name){

    File source=((TakesScreenshot)TestManager.getBrowser()).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFileToDirectory(source,
              new File("./Screenshots/"+ TestManager.getBrowser().getClass().getSimpleName()+ " " + name));
    } catch(IOException ioe){
      System.out.println("Can't take the screenshot" + ioe.getMessage());
      ioe.printStackTrace();
    }
  }
}