package careApp;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ 
	cannotForgotPasswordProccess.class,
	 invalidLogin.class,
	LoginSuccessfully.class,
	 resetPassword.class,
	 switchLanguage.class,
	 guestBookAppointment.class,
	 doctorLogin.class,
	 doctorInvalidLogin.class,
	 
	})
public class testSuite {
	

}
