package careApp;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import junit.framework.Assert;

public class invalidLogin extends setUpBeforeTest{
	
	// patient try to login using invalid data 
	  @Test()
	  public void patientCannotLogin() {
		  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_username")).sendKeys("21212");
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys("1234567");
	  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_login")).click();
	  		String alearMessage = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Please check entered information, Invalid Password /Account ID\"]")).getText();
	  		System.out.println(alearMessage);
	  		Assert.assertEquals(alearMessage, "Please check entered information, Invalid Password /Account ID");
}
}
