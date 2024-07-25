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
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import junit.framework.Assert;

//@TestMethodOrder(OrderAnnotation.class)

public class setUpBeforeTest {	
  public AndroidDriver driver;
  // setup to connect with server and emulator 
  @BeforeEach
  public void setUp() throws InterruptedException {
    var options = new BaseOptions()
        .amend("appium:platformName", "Android")
        .amend("appium:deviceName", "MM")
        .amend("appium:app", "C:\\Users\\MohammadAlkeswani\\eclipse-workspace\\CareApplicationUsingAppium\\src\\careApp\\Care.apk")
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
