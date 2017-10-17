package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class DiscontinueTest {
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
	public void VerifyDiscontinuePlan() {
		try {
			 DateFormat dateFormat = new SimpleDateFormat("dd");
		     Date date = new Date();
		     String todayDate = dateFormat.format(date);
			UsfnPageManager.LoginPage().Operations()
					.Login("familynow@unisys.com", "Welcome1");

			UsfnPageManager.MyOrganizerPage().Operations()
					.ClickFirstInvestigation();
			String assessmentDetails = UsfnPageManager.SafteyAssessmentPage()
					.Operations().CreateUnsafeAssessment();
			String[] assessmentDetailsParts = assessmentDetails.split(",");
			String assessmentId = assessmentDetailsParts[0];
			Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations()
					.IsSafteyPlanCreated(assessmentId, assessmentId),
					"Safety Plan is not created for Safe Assessment");
		 UsfnPageManager.SafteyPlanListPage().Operations().ClickDiscontinue(assessmentId, false);
		 UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
	     Thread.sleep(2000);
		 UsfnPageManager.DiscontinuePage().Elements().Save().click();
		 Assert.assertTrue(UsfnPageManager.DiscontinuePage().Operations()
					.VerifyRequiredFieldWarningMessage("Please enter 'Discontinued Date'."),
					"Warning message is not displaying for Discontinued date");
		
	     UsfnPageManager.DiscontinuePage().Operations().EnterDiscontinuedDate(todayDate);
	    String  DiscontinuedDate = Browser.driver.findElement(By.xpath("//input[@id='discontinuedDate']")).getAttribute("value");
	     UsfnPageManager.DiscontinuePage().Elements().Save().click();
	     Assert.assertTrue(UsfnPageManager.DiscontinuePage().Operations()
					.VerifyRequiredFieldWarningMessage("Please select 'Reason for Discontinuation'."),
					"Warning message is not displaying for Reason for Discontinuation");
	     UsfnPageManager.DiscontinuePage().Elements().ReasonForDiscontinuation().selectByVisibleText("Agency Decision");
	     UsfnPageManager.DiscontinuePage().Elements().Save().click();
	     Thread.sleep(500);
	     Assert.assertTrue(UsfnPageManager.DiscontinuePage().Operations()
					.VerifyRequiredFieldWarningMessage("Please enter 'Additional Details'."),
					"Warning message is not displaying for Additional Details");
	     Thread.sleep(2000);
	     UsfnPageManager.DiscontinuePage().Elements().AdditionalDetails().sendKeys("Additional Details");
	     UsfnPageManager.DiscontinuePage().Elements().PartiesNotified().click();
	     UsfnPageManager.DiscontinuePage().Operations().EnterNotificationDate(todayDate);
	     UsfnPageManager.DiscontinuePage().Elements().Save().click();
	     Thread.sleep(2000);
	     UsfnPageManager.CreateGoalPage().Elements().InformationDialoogOKButton().click();
		
	     Thread.sleep(4000);
	     Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId,DiscontinuedDate),"Discontinue Date is not updated");
	     Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId,"Discontinued"),"Saftey Plan Status is not updated");
	     
		 
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}
	
	@Test
	public void VerifyDiscontinuePlanNonEditable(){
		try {
			 DateFormat dateFormat = new SimpleDateFormat("dd");
		     Date date = new Date();
		     String todayDate = dateFormat.format(date);
			UsfnPageManager.LoginPage().Operations()
					.Login("familynow@unisys.com", "Welcome1");

			UsfnPageManager.MyOrganizerPage().Operations()
					.ClickFirstInvestigation();
			String assessmentDetails = UsfnPageManager.SafteyAssessmentPage()
					.Operations().CreateUnsafeAssessment();
			String[] assessmentDetailsParts = assessmentDetails.split(",");
			String assessmentId = assessmentDetailsParts[0];
			Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations()
					.IsSafteyPlanCreated(assessmentId, assessmentId),
					"Safety Plan is not created for Safe Assessment");
		 UsfnPageManager.SafteyPlanListPage().Operations().ClickDiscontinue(assessmentId, false);
		 UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
	     Thread.sleep(2000);
		 UsfnPageManager.DiscontinuePage().Elements().Save().click();
		 Assert.assertTrue(UsfnPageManager.DiscontinuePage().Operations()
					.VerifyRequiredFieldWarningMessage("Please enter 'Discontinued Date'."),
					"Warning message is not displaying for Discontinued date");
		
	     UsfnPageManager.DiscontinuePage().Operations().EnterDiscontinuedDate(todayDate);
	     UsfnPageManager.DiscontinuePage().Elements().Save().click();
	     Assert.assertTrue(UsfnPageManager.DiscontinuePage().Operations()
					.VerifyRequiredFieldWarningMessage("Please select 'Reason for Discontinuation'."),
					"Warning message is not displaying for Reason for Discontinuation");
	     UsfnPageManager.DiscontinuePage().Elements().ReasonForDiscontinuation().selectByVisibleText("Agency Decision");
	     UsfnPageManager.DiscontinuePage().Elements().Save().click();
	     Thread.sleep(500);
	     Assert.assertTrue(UsfnPageManager.DiscontinuePage().Operations()
					.VerifyRequiredFieldWarningMessage("Please enter 'Additional Details'."),
					"Warning message is not displaying for Additional Details");
	     Thread.sleep(2000);
	     UsfnPageManager.DiscontinuePage().Elements().AdditionalDetails().sendKeys("Additional Details");
	     UsfnPageManager.DiscontinuePage().Elements().PartiesNotified().click();
	     UsfnPageManager.DiscontinuePage().Operations().EnterNotificationDate(todayDate);
	     UsfnPageManager.DiscontinuePage().Elements().Save().click();
	     Thread.sleep(2000);
	     UsfnPageManager.CreateGoalPage().Elements().InformationDialoogOKButton().click();
		
	     Thread.sleep(4000);
	     UsfnPageManager.SafteyPlanListPage().Operations().ClickDiscontinue(assessmentId, false);
	     UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
	     Thread.sleep(2000);
			
		
	     Assert.assertFalse(Browser.driver.findElement(By.xpath("//input[@id='discontinuedDate']")).isEnabled(),"Discontinued Date is enabled");
	     Assert.assertFalse(UsfnPageManager.DiscontinuePage().Elements().ReasonForDiscontinuation().getFirstSelectedOption().isEnabled(),"Reason For Discontinuation is enabled");
	     Assert.assertFalse(Browser.driver.findElement(By.xpath("//input[@id='notificationDate']")).isEnabled(),"Notification Date is enabled");
	     Assert.assertFalse(Browser.driver.findElement(By.xpath("//input[@id='approproatePartiesNotified']")).isEnabled(), "Appropiate Person notified checkbox is enabled");
	     
		 
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}

}
