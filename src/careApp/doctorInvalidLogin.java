package careApp;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class doctorInvalidLogin extends setUpBeforeTest {
	String invalidUsername = "Mohammad";
	String invalidPassowrd = "456789";
	String expectedMessage = "Invalid username or password!";
	@Test
	public void doctorFillInvalidData() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ats.ksa.care.patient.dev:id/card_doctor")));
	driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_doctor")).click();
	// Select Hospital
	driver.findElement(By.id("ats.ksa.care.patient.dev:id/lyt_select_hospital")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ats.ksa.care.patient.dev:id/name\" and @text=\"CareWare Hospital*STG*\"]")).click();
	// Valid username and password 
	driver.findElement(By.xpath("//android.widget.EditText[@text=\"User Name\"]")).sendKeys(invalidUsername);
	driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys(invalidPassowrd);
	// click on login button 
	driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_login")).click();
	// validate alert message 
	String actulInvalidMessage = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Invalid username or password!\"]")).getText();
	assertEquals(actulInvalidMessage, expectedMessage);
	}
}
