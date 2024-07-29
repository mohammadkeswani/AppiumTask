package careApp;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class doctorLogin extends setUpBeforeTest{
	String userName = "hms";
	String password = "1234567";
	String expectedDoctorName = "Ali Mohammad";
	// doctor Login using a valid information 
	@Test
	public void DoctorLogin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ats.ksa.care.patient.dev:id/card_doctor")));
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_doctor")).click();
		// Select Hospital
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/lyt_select_hospital")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ats.ksa.care.patient.dev:id/name\" and @text=\"CareWare Hospital*STG*\"]")).click();
		// Valid username and password 
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"User Name\"]")).sendKeys(userName);
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys(password);
		// click on login button 
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_login")).click();
		//fill verification code 
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("2369");
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_forget")).click();
		String docName = driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_dr_name")).getText();
		System.out.println("**************************");
		System.out.println("Doctor login successfully and the doctor name is " + docName);
		System.out.println("**************************");
		assertEquals(docName, expectedDoctorName);
	
	}

}
