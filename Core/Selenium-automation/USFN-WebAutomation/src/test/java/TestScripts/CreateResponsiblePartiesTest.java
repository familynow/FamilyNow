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

public class CreateResponsiblePartiesTest {
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
	 public void AddResponsibleParties(){
		 try{
			 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
			 UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
			 
			 Thread.sleep(8000);
			 Thread.sleep(8000);
		 }
		 catch (Exception e){
			  Assert.fail(e.getMessage());
		  }
	 }
	 
	 @Test
	 public void AddResponsiblePartiesWithoutGoal(){
		 try{
			 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
			 UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
			 
			 Thread.sleep(8000);
			 Thread.sleep(8000);
			 Thread.sleep(8000);
		 }
		 catch (Exception e){
			  Assert.fail(e.getMessage());
		  }
	 }
	 
	 @Test
	 public void DeleteResponsibleParties(){
		 try{
			 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
			 UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
			 
			 Thread.sleep(8000);
			 Thread.sleep(8000);
			 Thread.sleep(8000);
			 Thread.sleep(5000);
		 }
		 catch (Exception e){
			  Assert.fail(e.getMessage());
		  }
	 }

}
