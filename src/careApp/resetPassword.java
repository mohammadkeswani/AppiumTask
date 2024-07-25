package careApp;

import java.time.Duration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import junit.framework.Assert;

public class resetPassword extends setUpBeforeTest {
	
	String newPassword = "12345678";
	String fileNo = "57695";
	
	  // patient reset password using fileNo and mobileNo
		@Test
		@Order(3)
		public void patientResetPassword() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_forget_pass")).click();
	  		// fill file No 
	  		driver.findElement(By.xpath("//android.widget.EditText[@text=\"National ID / Iqama NO. / File NO.\"]")).sendKeys(fileNo);
	  		// fill mobile No
	  		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Mobile Number\"]")).sendKeys("0500000000");
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_forget")).click();
	  		Thread.sleep(2000);
	  		// fill verification code 
	  		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("2369");
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_forget")).click();
	  		//set new password 
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys(newPassword);
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_conf_password")).sendKeys(newPassword);
	  		//Save 
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_save")).click();
	  		String successfullyMessage = 	driver.findElement(By.xpath("//android.widget.Toast[@text=\"Update password successfully!\"]")).getText();
	  		Assert.assertEquals(successfullyMessage, "Update password successfully!");
	  		
	  		// login using new password
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_username")).sendKeys(fileNo);
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys(newPassword);
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_login")).click();
			String patientName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ats.ksa.care.patient.dev:id/tv_patient_name\"]")).getText();
			System.out.println(patientName);
		}

}



