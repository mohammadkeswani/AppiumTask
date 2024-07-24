// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
package careApp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.manipulation.Alphanumeric;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import junit.framework.Assert;

//@TestMethodOrder(OrderAnnotation.class)

public class setUpBeforeTest {
	
	// ScreenShot
		public String getScreenshot(String TestCaseName , WebDriver driver) throws IOException {
			TakesScreenshot src = ((TakesScreenshot) driver);
			
			File SrcFile = src.getScreenshotAs((OutputType.FILE));

			File Dest = new File (System.getProperty ("user.dir") + "//reports//" + TestCaseName + ".png");
			
	          FileUtils.copyFile (SrcFile,Dest);
			return System.getProperty ("user.dir") + "//reports//" + TestCaseName + ".png";
		} 
		
		//Create report
		public static ExtentReports report() {

			 String path = System.getProperty("user.dir") + "/reports/index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Mohammad Alkeswani Report");
				reporter.config().setDocumentTitle("Title Alkeswani");
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Alkeswani");
				return extent;
			
		}
	
  public AndroidDriver driver;
  // setup to connect with server and emulator 
  @BeforeEach
  public void setUp() throws InterruptedException {
    var options = new BaseOptions()
        .amend("appium:platformName", "Android")
        .amend("appium:deviceName", "MK")
        .amend("appium:app", "C:\\Users\\MohammadAlkeswani\\eclipse-workspace\\appium\\src\\Care.apk")
        .amend("appium:newCommandTimeout", 3600)
        .amend("appium:connectHardwareKeyboard", true);

    try {
      // Create URL directly within setUp
      URL url = new URL("http://127.0.0.1:4723/wd/hub/");
      driver = new AndroidDriver(url, options);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
