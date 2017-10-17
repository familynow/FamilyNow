package testScripts;

import general.Browser;
import general.GetConfigValue;
import general.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageControllers.ProviderPageManager;

public class SignUpTest {
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
	 public void VerifySignUp(){

		 ProviderPageManager.LoginPage().Navigate(GetConfigValue.GetUrl());
	   	 try{
				Thread.sleep(1000);
				ProviderPageManager.LoginPage().Elements().SignUp().click();
	   	        String Fname =Utilities.GetRandomString(10);
			    String Lname =Utilities.GetRandomString(10);
			    String Email = Fname+"@"+Lname+".com";
			    ProviderPageManager.LoginPage().Operation().EnterRequiredField(Fname, Lname, Email, "12345678", "12345678");
			    ProviderPageManager.LoginPage().Elements().SignUpButton().click();
			    Thread.sleep(1000);
			    Assert.assertTrue(ProviderPageManager.PersonProfilePage().Elements().Fname().getAttribute("value").contains(Fname),"First Name is not Saved");
			    Assert.assertTrue( ProviderPageManager.PersonProfilePage().Elements().Lname().getAttribute("value").contains(Lname),"Last Name is not Saved");
			    ProviderPageManager.PersonProfilePage().Elements().ProfileCancelButton().click();
			    Thread.sleep(500);
			    ProviderPageManager.MyApplicationPage().Elements().LogOut().click();
			    Thread.sleep(500);
			    ProviderPageManager.LoginPage().Operation().Login(Email, "12345678");
			    Thread.sleep(500);
			    Assert.assertTrue(ProviderPageManager.MyApplicationPage().Elements().CreateNewProviderApplicationButton().isDisplayed(),"Login is created");
	   	 }
	   	 catch (InterruptedException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 	} 
	   	 
	    }
	 
	@Test
	public void VerifyUniqueUserName() {
		ProviderPageManager.LoginPage().Navigate(GetConfigValue.GetUrl());
		try {

			// Apply Wait
			Thread.sleep(1000);
			ProviderPageManager.LoginPage().Elements().SignUp().click();
			String Fname = Utilities.GetRandomString(10);
			String Lname = Utilities.GetRandomString(10);
			String Email = Fname + "@" + Lname + ".com";
			ProviderPageManager.LoginPage().Operation().EnterRequiredField(Fname, Lname, Email, "12345678","12345678");
			ProviderPageManager.LoginPage().Elements().SignUpButton().click();
			Thread.sleep(1000);
			Assert.assertTrue(ProviderPageManager.PersonProfilePage().Elements().Fname().getAttribute("value").contains(Fname),"First Name is not Saved");
			Assert.assertTrue(ProviderPageManager.PersonProfilePage().Elements().Lname().getAttribute("value").contains(Lname),"Last Name is not Saved");
			ProviderPageManager.PersonProfilePage().Elements().ProfileCancelButton().click();
			Thread.sleep(1000);
			ProviderPageManager.MyApplicationPage().Elements().LogOut().click();
			Thread.sleep(1000);
			ProviderPageManager.LoginPage().Elements().SignUp().click();
			ProviderPageManager.LoginPage().Operation().EnterRequiredField(Fname, Lname, Email, "12345678","12345678");
			ProviderPageManager.LoginPage().Elements().SignUpButton().click();
			Thread.sleep(1000);
			Assert.assertTrue(ProviderPageManager.LoginPage().Operation().VerifyRequiredFieldMessage("The User ID you have entered already exits. Please choose a different User Id."),"User is able to loogin with duplicate User");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	    

}
