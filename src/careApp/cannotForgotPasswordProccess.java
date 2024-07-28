package careApp;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.testng.Assert;

public class cannotForgotPasswordProccess extends setUpBeforeTest {
	
	@Test
	public void cannotChangePassword() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_forget_pass")).click();
		// fill file No 
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"National ID / Iqama NO. / File NO.\"]")).sendKeys("57695");
		// fill invalid mobileNo
  		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Mobile Number\"]")).sendKeys("0511111111");
  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_forget")).click();
		// check error massage 
		String actualMessage = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Please contact the hospital and update your file information (Mobile No/National ID) to be able to use the application...\"]")).getText();
		Assert.assertEquals(actualMessage, "Please contact the hospital and update your file information (Mobile No/National ID) to be able to use the application...");
	}
}
