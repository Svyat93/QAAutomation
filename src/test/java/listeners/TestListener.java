package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.ConfigReader;
import utility.TakeScreenshot;
import utility.TestManager;

import java.io.File;


public class TestListener implements ITestListener {
    private final Logger LOG = LogManager.getLogger(Logger.class.getSimpleName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOG.info(iTestResult.getName() + " started.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info(iTestResult.getName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        TakeScreenshot.getScreenshot(iTestResult.getName());
        LOG.info(iTestResult.getName() + " failed.");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOG.info(iTestResult.getName() + " skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        TestManager.setLogFile();
        LOG.info(iTestContext.getName() + " started.");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOG.info(iTestContext.getName()+ " finished.");
    }
}
