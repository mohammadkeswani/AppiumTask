package careApp;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class resetPassword extends setUpBeforeTest {
	
	String newPassword = "1234567";
	String fileNo = "57695";
	String mobileNo = "0500000000";
	Random rand = new Random();
	int i = 100 + rand.nextInt(900);
	String verificationCode = "2369";
	
	

	
	  // patient reset password using fileNo and mobileNo
		@Test
		public void patientResetPassword() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_forget_pass")).click();
	  		// fill file No 
	  		driver.findElement(By.xpath("//android.widget.EditText[@text=\"National ID / Iqama NO. / File NO.\"]")).sendKeys(fileNo);
	  		// fill mobile No
	  		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Mobile Number\"]")).sendKeys(mobileNo);
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_forget")).click();
	  		Thread.sleep(2000);
	  		// fill verification code 
	  		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys(verificationCode);
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_forget")).click();
	  		//set new password 
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys(newPassword + i);
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_conf_password")).sendKeys(newPassword + i);
			System.out.println("**************************");
	  		System.out.println(" New Password is : " +newPassword + i);
	  		//Save 
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_save")).click();
	  		String successfullyMessage = 	driver.findElement(By.xpath("//android.widget.Toast[@text=\"Update password successfully!\"]")).getText();
		  	Assert.assertEquals(successfullyMessage, "Update password successfully!");
			System.out.println("Password update passed.");

	  		
	  		// login using new password
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_username")).sendKeys(fileNo);
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys(newPassword + i);
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_login")).click();
			String patientName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ats.ksa.care.patient.dev:id/tv_patient_name\"]")).getText();
			System.out.println("**************************");
			System.out.println(patientName);
			System.out.println("**************************");
			driver.quit();
		}
}



