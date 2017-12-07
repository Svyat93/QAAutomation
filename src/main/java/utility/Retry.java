package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
    private int i;
    private int maxTry=1;

    @Override
    public boolean retry(ITestResult result) {

        if(!result.isSuccess()){
            if(i < maxTry){
                i++;
                return true;
            }
        }

        return false;
    }

}
