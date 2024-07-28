package careApp;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listener extends setUpBeforeTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = setUpBeforeTest.report();
    ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extenttest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extenttest.get().log(Status.PASS, "TestPass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	extenttest.get().fail(result.getThrowable());

        // Get the WebDriver instance directly from the test class
        WebDriver driver = ((setUpBeforeTest) result.getInstance()).driver;

        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extenttest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    
    }

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
