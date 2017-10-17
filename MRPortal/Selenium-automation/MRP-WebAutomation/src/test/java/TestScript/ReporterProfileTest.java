package TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import General.Utilities;
import PageControllers.MRPPageManager;




public class ReporterProfileTest {
	

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

    	 MRPPageManager.LoginPage().Navigate(GetConfigValue.GetUrl());
    	 try{
 			Thread.sleep(1000);
    	    MRPPageManager.LoginPage().Elements().SignUp().click();
    	    String Fname =Utilities.GetRandomString(10);
		    String Lname =Utilities.GetRandomString(10);
		    String Email = Fname+"@"+Lname+".com";
		    MRPPageManager.LoginPage().Operations().EnterRequiredField(Fname, Lname, Email, "12345678", "12345678");
		    MRPPageManager.LoginPage().Elements().SignUpButton().click();
		    MRPPageManager.LoginPage().Operations().ApplyWait(driver);
		    Assert.assertTrue(MRPPageManager.PersonProfilePage().Elements().Fname().getAttribute("value").contains(Fname),"First Name is not Saved");
		    Assert.assertTrue( MRPPageManager.PersonProfilePage().Elements().Lname().getAttribute("value").contains(Lname),"Last Name is not Saved");
		    MRPPageManager.PersonProfilePage().Elements().LogOut().click();
		    MRPPageManager.LoginPage().Operations().Login(Email, "12345678");
		    Assert.assertTrue( MRPPageManager.MyComplaintPage().Elements().AddNewReportButton().isDisplayed(),"Login is created");
    	 }
    	 catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 	} 
    	 
     }
     
    @Test 
     public void VerifyUniqueUserName(){
    	 MRPPageManager.LoginPage().Navigate(GetConfigValue.GetUrl());
    	 try{
    		
    		// Apply Wait 
 			Thread.sleep(1000);
    	    MRPPageManager.LoginPage().Elements().SignUp().click();
    	    String Fname =Utilities.GetRandomString(10);
		    String Lname =Utilities.GetRandomString(10);
		    String Email = Fname+"@"+Lname+".com";
		    MRPPageManager.LoginPage().Operations().EnterRequiredField(Fname, Lname, Email, "12345678", "12345678");
		    MRPPageManager.LoginPage().Elements().SignUpButton().click();
		    MRPPageManager.LoginPage().Operations().ApplyWait(driver);
		    Assert.assertTrue(MRPPageManager.PersonProfilePage().Elements().Fname().getAttribute("value").contains(Fname),"First Name is not Saved");
		    Assert.assertTrue( MRPPageManager.PersonProfilePage().Elements().Lname().getAttribute("value").contains(Lname),"Last Name is not Saved");
		    MRPPageManager.PersonProfilePage().Elements().LogOut().click();
		    Thread.sleep(1000);
		    MRPPageManager.LoginPage().Elements().SignUp().click();
		   // MRPPageManager.LoginPage().Operations().ApplyWait(driver);
		    MRPPageManager.LoginPage().Operations().EnterRequiredField(Fname, Lname, Email, "12345678", "12345678");
		    MRPPageManager.LoginPage().Elements().SignUpButton().click();
		    Assert.assertTrue( MRPPageManager.LoginPage().Operations().VerifyRequiredFieldMessage("The User ID you have entered already exits. Please choose a different User Id."),"User is able to loogin with duplicate User");
		    
    	 }
    	 catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 	} 
    	 
     }
	 
	 @Test
	 public void SaveReporterProfileWithRequiredFieldOnly(){
		 
		 MRPPageManager.LoginPage().Operations().Login();
		 try{
	 	 Thread.sleep(1000);
		 MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
		 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		 String Fname =Utilities.GetRandomString(10);
		 String Lname =Utilities.GetRandomString(10);
		 String Address1 =Utilities.GetRandomString(10);
		 String Address2 =Utilities.GetRandomString(10);
		 String city =Utilities.GetRandomString(10);
		 MRPPageManager.PersonProfilePage().Operations().EnterRequired(Fname, Lname, "Birth Match", "DMH Facility Personnel", "Male", "1111111111", "9999999999", Address1, Address2, city, 	"Alaska", "1234");
		 MRPPageManager.PersonProfilePage().Elements().SaveButton().click();
		 Thread.sleep(4000);
		 MRPPageManager.PersonProfilePage().Elements().CancelButton().click();
		 Thread.sleep(1000);
		 MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
		 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		 Thread.sleep(2000);
		 Assert.assertTrue(MRPPageManager.PersonProfilePage().Elements().Fname().getAttribute("value").contains(Fname),"First Name is not Saved");
		 Assert.assertTrue( MRPPageManager.PersonProfilePage().Elements().Lname().getAttribute("value").contains(Lname),"First Name is not Saved");
		 Assert.assertEquals("Birth Match",    MRPPageManager.PersonProfilePage().Elements().ReportingPersonCategory().getFirstSelectedOption().getText());
		 Assert.assertEquals("DMH Facility Personnel",    MRPPageManager.PersonProfilePage().Elements().ReportingPersonRole().getFirstSelectedOption().getText());
		 Assert.assertEquals("Male",    MRPPageManager.PersonProfilePage().Elements().Gender().getFirstSelectedOption().getText());
		 Assert.assertTrue( MRPPageManager.PersonProfilePage().Elements().AddressLine1().getAttribute("value").contains(Address1),"Address1 is not Saved");
		 Assert.assertTrue( MRPPageManager.PersonProfilePage().Elements().AddressLine2().getAttribute("value").contains(Address2),"Address2 is not Saved");
		 Assert.assertTrue( MRPPageManager.PersonProfilePage().Elements().City().getAttribute("value").contains(city),"City is not Saved");
		 Assert.assertEquals("Alaska",    MRPPageManager.PersonProfilePage().Elements().State().getFirstSelectedOption().getText());
		 Assert.assertTrue( MRPPageManager.PersonProfilePage().Elements().Zip().getAttribute("value").contains("1234"),"Zip is not Saved");
		 }
		 catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 	} 
		 
	 }
	 
	  @Test
	 public void VerifyRequiredFieldValidationMessage(){
		 MRPPageManager.LoginPage().Operations().Login();
		 try{
			 Thread.sleep(1000);
			 MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
			 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			 MRPPageManager.PersonProfilePage().Elements().Fname().clear();
			 MRPPageManager.PersonProfilePage().Elements().Lname().clear();
			 MRPPageManager.PersonProfilePage().Operations().SelectCategory("Select");
			 MRPPageManager.PersonProfilePage().Operations().SelectRole("Select");
			 MRPPageManager.PersonProfilePage().Operations().SelectGender("Select");
			 MRPPageManager.PersonProfilePage().Elements().WorkNumber().clear();
			 MRPPageManager.PersonProfilePage().Elements().Mobile().clear();
			 MRPPageManager.PersonProfilePage().Elements().AddressLine1().clear();
			 MRPPageManager.PersonProfilePage().Elements().AddressLine2().clear();
			 MRPPageManager.PersonProfilePage().Elements().City().clear();
			 MRPPageManager.PersonProfilePage().Operations().SelectState("Select");
			 MRPPageManager.PersonProfilePage().Elements().Zip().clear();
			 MRPPageManager.PersonProfilePage().Elements().SaveButton().click();
			 Thread.sleep(2000);
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("First Name cannot be blank."),"Warning message is not displayed for First Name");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Last Name cannot be blank."),"Warning message is not displayed for Last Name");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Select a Reporting Person Category to continue."),"Warning message is not displayed for Reporting Person Category");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Select a Reporting Person Role to continue."),"Warning message is not displayed for Reporting Person Role");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Gender is required."),"Warning message is not displayed for Gender");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Enter 10 digit Number."),"Warning message is not displayed for Mobile");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Address Line 1 cannot be blank."),"Warning message is not displayed for Address Line 1");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Address Line 2 cannot be blank."),"Warning message is not displayed for Address Line 2");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("City cannot be blank."),"Warning message is not displayed for Address Line 2");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Select a State to continue."),"Warning message is not displayed for State");
			 Assert.assertTrue( MRPPageManager.PersonProfilePage().Operations().VerifyRequiredFieldWarningMessage("Please enter 5 digit "),"Warning message is not displayed for Zip");
		 }
		 catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 	} 
		 
		 
	 }
}
