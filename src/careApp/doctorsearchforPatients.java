package careApp;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class doctorsearchforPatients extends setUpBeforeTest{
	String userName = "hms";
	String password = "1234567";
	String ptFileNo = "21212";
	
	@Test()
	public void doctorsearchforPatients() throws InterruptedException {
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
		// search for patient
		Actions action = new Actions(driver);
		WebElement search =	driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_patient_id"));
		Thread.sleep(1000);
		Actions action1 = new Actions(driver);
        action1.moveToElement(search).sendKeys(ptFileNo).sendKeys(Keys.ENTER).build().perform();
		// validate if the patient after the search has the same fileNo no which i searched on 
		String fileNumberAfterSearch = driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_patient_code")).getText();
		assertEquals(fileNumberAfterSearch, "#"+ptFileNo);
		
	}

}
