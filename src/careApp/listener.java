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
         setUpBeforeTest testInstance = (setUpBeforeTest) result.getInstance();
         WebDriver driver = testInstance.driver;

         if (driver == null) {
             extenttest.get().log(Status.FAIL, "WebDriver instance was null.");
             return;
         }

         String filePath = null;
         try {
             filePath = testInstance.getScreenshot(result.getMethod().getMethodName(), driver);
         } catch (IOException e) {
             e.printStackTrace();
             extenttest.get().log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
         }
         if (filePath != null) {
             extenttest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
         } else {
             extenttest.get().log(Status.FAIL, "Screenshot path is null.");
         }
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
