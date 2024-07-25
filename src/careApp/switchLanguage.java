package careApp;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class switchLanguage extends setUpBeforeTest {
	
	  // change application crash when change language language 
	  @Test
	  public void changeLanguage () throws InterruptedException {
		  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
		  		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_username")).sendKeys("21212");
				driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_password")).sendKeys("123456");
				driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_login")).click();
	// forloop for change the language 3 times.
		    for (int i =0; i<=3; i++) {
			 String patientName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ats.ksa.care.patient.dev:id/tv_patient_name\"]")).getText();
	// if the application language English will print PatientName in English and Change the language to Arabic
			 if (patientName.contains("Mohammad Alrajehi")) {
				  System.out.println(patientName + " the application language is EN");
				  driver.findElement(By.id("ats.ksa.care.patient.dev:id/iv_menu")).click();	
				  driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ats.ksa.care.patient.dev:id/rv_side_menu\"]/android.widget.RelativeLayout[9]")).click();
				  driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_arabic")).click();
				  driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
  }
	// if the application language Arabic  will print PatientName in Arabic and Change the language to English
			 else if (patientName.contains("محمد الراجحي")) {
			  	  System.out.println(" أسم المستخدم باللغة العربية  " +  patientName);
			  	  driver.findElement(By.id("ats.ksa.care.patient.dev:id/iv_menu")).click();	
			  	  driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ats.ksa.care.patient.dev:id/rv_side_menu\"]/android.widget.RelativeLayout[9]")).click();
			  	  driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_english")).click();
			  	  driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
  }
   	  		else {System.err.println("Cann't find Patient Name");}
	  }
	  }

}
