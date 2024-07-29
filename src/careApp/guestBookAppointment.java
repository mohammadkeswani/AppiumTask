package careApp;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class guestBookAppointment extends setUpBeforeTest{
	String bookappointmentmessage = "Your appointment has been booked successfully";
	String ptName = "Saeed";
	String ptLastName = "AbuAlnoor";
	Random rand = new Random();
	int i = 100 + rand.nextInt(900);
	@Test
	
	public void guestBookApp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_patient")).click();
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_continue_guest")).click();
		// click on the appointment button
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/fab")).click();
		// choose in clinic appointment
		driver.findElement(By.xpath("//androidx.cardview.widget.CardView[@resource-id=\"ats.ksa.care.patient.dev:id/card_regular_appt\"]/android.widget.LinearLayout")).click();
		// fill all patient information
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"First Name\"]")).sendKeys(ptName);
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Family Name\"]")).sendKeys(ptLastName);
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"National ID / Iqama NO.\"]")).sendKeys("1224445"+ i );
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Mobile Number\"]")).sendKeys("0556669998");
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_birthdate")).click();
	//	driver.findElement(By.id("android:id/prev")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"25 July 2024\"]")).click(); 
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/edt_gender")).click();
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/card_female")).click();
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_save")).click();
		// fill verification code 
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("2369");
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_verify")).click();
		// choose hospital and clinic 
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_hospital_name")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ats.ksa.care.patient.dev:id/name\" and @text=\"CareWare Hospital*STG*\"]")).click();
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_clinic_name")).click();
		driver.findElement(By.xpath("(//androidx.cardview.widget.CardView[@resource-id=\"ats.ksa.care.patient.dev:id/card_view\"])[2]")).click();
		// click on Search 
		driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_search")).click();
		  try {
	            driver.findElement(By.xpath("//androidx.cardview.widget.CardView/android.widget.LinearLayout")).click();
	        } catch (NumberFormatException e) {
	            System.out.println("Cannot find Doctor in this Clinic and day");
	        }
		  // should change index after every test cause the appointment will booked 
		  driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"ats.ksa.care.patient.dev:id/rv_slots\"]/android.widget.RelativeLayout[3]")).click();
		  driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_confirm")).click();
		  // check message 
		  String successmessage = driver.findElement(By.id("ats.ksa.care.patient.dev:id/tv_message")).getText();
		  driver.findElement(By.id("ats.ksa.care.patient.dev:id/btn_ok")).click();		  
		  Assert.assertEquals(successmessage, bookappointmentmessage);	
	}
}
