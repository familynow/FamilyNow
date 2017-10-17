package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class UserStory19Test {
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
	 public void VerifyAnonymousReportingPerson(){
		 try {
		   UsfnPageManager.LoginPage().Operations().Login("sw1234", "sw");
		   UsfnPageManager.IntakeListPage().Operations().NavigateToIntakeListPage();
		   UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
		   UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
		   UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
		   
		  
				   Thread.sleep(500);
				   UsfnPageManager.CreateCpsPage().Operations().SelectPersonCategory("BCAL");
				   UsfnPageManager.CreateCpsPage().Operations().SelectPersonRole("DMH Facility Personnel");
				   UsfnPageManager.CreateCpsPage().Operations().SelectReportingPersonCheckBox(2);
				   UsfnPageManager.CreateCpsPage().Operations().SelectReportingPersonCheckBox(3);
				   UsfnPageManager.CreateCpsPage().Operations().SelectReportingPersonCheckBox(4);
				   UsfnPageManager.CreateCpsPage().Operations().SelectReportingPersonCheckBox(5);
				   UsfnPageManager.CreateCpsPage().Operations().SelectFeedbackRequested("None Requested");
				   UsfnPageManager.CreateCpsPage().Operations().SelectReportingPersonCheckBox(1);
				   Assert.assertTrue(UsfnPageManager.CreateCpsPage().Operations().VerifyReportingWhenAnonymous(),"Reproting Person drop down and checkboxes are enabled");
				   Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetFirstName().isEnabled(),"First Name is enabled");
				   Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetMiddleName().isEnabled(),"Middle Name is enabled");
				   Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().GetLastName().isEnabled(),"Last Name is enabled");
		   }
		   catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		  
	 }
	 
	  @Test 
	 public void VerifyCreateCPS(){
			   DateFormat dateFormat = new SimpleDateFormat("dd");
			   Date date = new Date();
			   String todayDate = dateFormat.format(date);
			   String getIntakeId ="";
			   try {
			   // Login to USFN 
			   UsfnPageManager.LoginPage().Operations().Login("sw1234", "sw");
			  // Navigate to Create Cps Page 
			  UsfnPageManager.IntakeListPage().Operations().NavigateToIntakeListPage();
			  UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
			  UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
			  UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
			  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().ApplyButton().isEnabled(),"Apply Button is enabled");
			  Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().SaveButton().isEnabled(),"Save Button is enabled");
			  // Add Cps Intake 
			  UsfnPageManager.CreateCpsPage().Operations().EnterAlltheRequiredFields("E-mail",  "11:15", "PM", "CT", "Alger", "AlligationNotes");
			  UsfnPageManager.CreateCpsPage().Elements().ApplyButton().click();
			  UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
		 
				Thread.sleep(2000);
		        getIntakeId =  UsfnPageManager.CreateCpsPage().Operations().GetIntakeId();
		        UsfnPageManager.CreateCpsPage().Elements().SaveButton().click();
		        UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
		        Thread.sleep(200);
		        Assert.assertTrue(UsfnPageManager.IntakeListPage().Operations().VerifyInatkeIsAvailable(getIntakeId),"Intake is not created");
		        
	  
		  
		  }
		  
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 
	 @Test 
	 public void EditCPS(){
		   DateFormat dateFormat = new SimpleDateFormat("dd");
		   Date date = new Date();
		   String todayDate = dateFormat.format(date);
		   String getIntakeId ="";
		   try {
		   // Login to USFN 
		   UsfnPageManager.LoginPage().Operations().Login("sw1234", "sw");
		  // Navigate to Create Cps Page 
		   UsfnPageManager.IntakeListPage().Operations().NavigateToIntakeListPage();
		   UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
           UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
           UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
           Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().ApplyButton().isEnabled(),"Apply Button is enabled");
           Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements().SaveButton().isEnabled(),"Save Button is enabled");
		   UsfnPageManager.CreateCpsPage().Operations().EnterAlltheRequiredFields("E-mail",  "11:15", "PM", "CT", "Alger", "AlligationNotes");
		   UsfnPageManager.CreateCpsPage().Elements().ApplyButton().click();
		 
				Thread.sleep(2000);
				getIntakeId =  UsfnPageManager.CreateCpsPage().Operations().GetIntakeId();
				UsfnPageManager.CreateCpsPage().Elements().SaveButton().click();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
		        Thread.sleep(200);
				Assert.assertTrue(UsfnPageManager.IntakeListPage().Operations().VerifyInatkeIsAvailable(getIntakeId),"Intake is not created");
				UsfnPageManager.IntakeListPage().Operations().ClickPendingIntake(getIntakeId,false);
				Thread.sleep(200);
				UsfnPageManager.CreateCpsPage().Operations().SelectIntakeMethod("Facsimile");
				UsfnPageManager.CreateCpsPage().Operations().SelectCountyOfResponsibility("Alpena");
				UsfnPageManager.CreateCpsPage().Operations().EnterAlligationNotes("AlligationNotes Edited");
				UsfnPageManager.CreateCpsPage().Elements().SaveButton().click();
				Thread.sleep(200);
				Assert.assertTrue(UsfnPageManager.IntakeListPage().Operations().VerifyInatkeIsAvailable(getIntakeId),"Intake is not created");
				UsfnPageManager.IntakeListPage().Operations().ClickPendingIntake(getIntakeId,false);
				Thread.sleep(200);
				Assert.assertEquals(UsfnPageManager.CreateCpsPage().Elements().CountyOfResponsibility().getFirstSelectedOption().getText(),"Alpena");
				Assert.assertEquals(UsfnPageManager.CreateCpsPage().Elements().SelectIntakeMethod().getFirstSelectedOption().getText(),"Facsimile");
				
				
	  
		  
		  }
		  
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }

}
