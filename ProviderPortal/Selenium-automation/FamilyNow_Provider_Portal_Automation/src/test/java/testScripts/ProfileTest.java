package testScripts;

import general.Browser;
import general.GetConfigValue;
import general.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageControllers.ProviderPageManager;

public class ProfileTest {
	
	WebDriver driver;
	 @BeforeMethod
	 public void openbrowser() { 
		  driver = Browser.getBrowser(GetConfigValue.GetBrowser());
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
	public void SaveReporterProfileWithRequiredFieldOnly() {

		 ProviderPageManager.LoginPage().Navigate(GetConfigValue.GetUrl());
		try {
			Thread.sleep(1000);
			DateFormat dateFormat = new SimpleDateFormat("dd");
			 Date date = new Date();
			String DOB = dateFormat.format(date);
			ProviderPageManager.LoginPage().Elements().SignUp().click();
			String Fname = Utilities.GetRandomString(10);
			String Lname = Utilities.GetRandomString(10);
			String Email = Fname + "@" + Lname + ".com";
			String Address1 =Utilities.GetRandomString(10);
			 String Address2 =Utilities.GetRandomString(10);
			 String city =Utilities.GetRandomString(10);
			ProviderPageManager.LoginPage().Operation().EnterRequiredField(Fname, Lname, Email, "12345678","12345678");
			ProviderPageManager.LoginPage().Elements().SignUpButton().click();
			Thread.sleep(2000);
			Assert.assertTrue(ProviderPageManager.PersonProfilePage().Elements().Fname().getAttribute("value").contains(Fname),"First Name is not Saved");
			Assert.assertTrue(ProviderPageManager.PersonProfilePage().Elements().Lname().getAttribute("value").contains(Lname),"Last Name is not Saved");
			Assert.assertTrue(ProviderPageManager.PersonProfilePage().Elements().ContactEmail().getAttribute("value").contains(Email),"Contact Email is not Saved");
			ProviderPageManager.PersonProfilePage().Operation().EnterRequired("Male", DOB, "Asian", "Attended or graduated from technical school", "9999999999", Address1, Address2, city, "Alaska", "12345");
			ProviderPageManager.PersonProfilePage().Elements().ProfileCancelButton().click();
			ProviderPageManager.MyApplicationPage().Elements().LogOut().click();
			Thread.sleep(1000);
			 ProviderPageManager.LoginPage().Operation().Login("TestEmail@gmail.com","Welcome1");
			 Thread.sleep(1000);
			 ProviderPageManager.UserListPage().Elements().SearchText().sendKeys(Fname);
			 Assert.assertTrue( ProviderPageManager.UserListPage().Operation().IsProfileAvailable(Email),"Profile is not created");
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 

}
