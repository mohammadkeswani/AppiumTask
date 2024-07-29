package careApp;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginSuccessfully extends setUpBeforeTest{
	  
	  // patient login and check the patient name
		@Test
		public void patientLogin() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_username")).sendKeys("21212");
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys("123456");
			driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_login")).click();
			String patientName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ats.ksa.care.patient.dev:id/tv_patient_name\"]")).getText();
			System.out.println("**************************");
			System.out.println("Login Successfully and the patient name is : "  + patientName);
			System.out.println("**************************");
			Assert.assertEquals(patientName, "Mohammad Alrajehi");
		}

}
