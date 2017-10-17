package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class UserStoryIN04Test {
	WebDriver driver;
	
	 @BeforeMethod
	 public void openbrowser() { 
		  WebDriver driver = Browser.getBrowser(GetConfigValue.GetBrowser());
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }

	 //@AfterMethod defines this method has to run after every @Test methods
	 @AfterMethod
	 public void closebrowser() {
		 driver = null;
		 Browser.driver.close();
		
	 }
	 
	
	 @Test
	 public void VerifyEditAwaitingScreeningIntake(){
	 
		// Login to USFN 
		  UsfnPageManager.LoginPage().Operations().Login("sw", "sw");
		  UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
		  UsfnPageManager.NonCpsIntakeListPage().Operations().ClickCompletedIntake(1);
		  try {
				Thread.sleep(1000);
		
		  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetIntakeTime().isEnabled(),"Intake Time Field is Enabled");
		  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Operations().VerifyAllDropDownDisable(), "Drop downs are enabled");
		  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Operations(). VerifyAllCheckboxDisable(), "Check boxed are enabled");
		  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetAlligationNotes().isEnabled(),"Intake Time Field is Enabled");
		  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetFirstName().isEnabled(),"First Name Field is Enabled");
		  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetMiddleName().isEnabled(),"Middle Name Field is Enabled");
		  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetLastName().isEnabled(),"Last Name Field is Enabled");
		  }
		 
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}
