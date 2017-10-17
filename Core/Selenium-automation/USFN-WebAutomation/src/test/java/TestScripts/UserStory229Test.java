package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class UserStory229Test {
	
	WebDriver driver;
	 @BeforeMethod
	 public void openbrowser() { 
		    Dimension d = new Dimension(1382, 1300);
			WebDriver driver = Browser.getBrowser(GetConfigValue.GetBrowser());
			driver.manage().window().setSize(d);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }

	 //@AfterMethod defines this method has to run after every @Test methods
	 @AfterMethod
	 public void closebrowser() {
		 driver = null;
		 Browser.driver.close();
		
	 }
	 
	 private String AddPersonBasicInformation(String fName,String lName,String ssn,boolean login){
		 
		   DateFormat dateFormat = new SimpleDateFormat("dd");
		   Date date = new Date();
		   String todayDate = dateFormat.format(date);
		   String personId ="";
		   try{
		   UsfnPageManager.LoginPage().Operations().Login("sw1234", "sw");
		   UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
		   UsfnPageManager.CreateCpsPage().Elements().LinkPersonButton().click();
		   UsfnPageManager.PersonSearchPage().Elements().GetPersonId().sendKeys("12");
		   UsfnPageManager.PersonSearchPage().Elements().GetSearchButton().click();
		   UsfnPageManager.PersonSearchPage().Elements().AddPersonhButton().click();
		   UsfnPageManager.PersonBasicPage().Operations().EnterDOB(todayDate);
		   UsfnPageManager.PersonBasicPage().Elements().MaleCheckBox().click();
		   UsfnPageManager.PersonBasicPage().Operations().SelectPrefix("Dr.");
		   UsfnPageManager.PersonBasicPage().Elements().FirstName().sendKeys(fName);
		   UsfnPageManager.PersonBasicPage().Elements().Lastname().sendKeys(lName);
		   UsfnPageManager.PersonBasicPage().Elements().SSN().sendKeys(ssn);
		   UsfnPageManager.PersonBasicPage().Operations().SelectSuffix("II");
		   UsfnPageManager.PersonBasicPage().Elements().ApplyButton().click();
		 
			  Thread.sleep(500);
			   personId = 	 UsfnPageManager.PersonBasicPage().Operations().GetPersonId(); 
		   }
		   catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   
		   return personId;
	 }
	 
	@Test
	public void VerifySubmitForApproval() {

		try {
			UsfnPageManager.LoginPage().Operations().Login();

			UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager
					.CreateCpsPage()
					.Operations()
					.EnterAlltheRequiredFields("E-mail", "11:15", "PM", "CT",
							"Alger", "AlligationNotes");
			UsfnPageManager.CreateCpsPage().Elements().ApplyButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);

			Thread.sleep(1000);
			String getIntakeId = UsfnPageManager.CreateCpsPage().Operations()
					.GetIntakeId();
			UsfnPageManager.CreateCpsPage().Elements().SubmitForApproval()
					.click();
			Thread.sleep(1000);
			List<String> actualApprovalmsg = UsfnPageManager.CreateCpsPage()
					.Operations().GetApprovalWarningMessages();
			List<String> excpectedApprovalmsg = Arrays
					.asList("All Intake Participants should be associated with a Person ID",
							"No intake reporter found.",
							"Accept Recomended Priority Must Be Selected.");
			Assert.assertTrue(
					actualApprovalmsg.containsAll(excpectedApprovalmsg)
							&& excpectedApprovalmsg
									.containsAll(actualApprovalmsg),
					"User is able to submit intake in Basic Information page ");
			UsfnPageManager.CreateCpsPage().Operations()
			.SelectReportingPersonCheckBox(1);
			UsfnPageManager.CreateCpsPage().Elements().SubmitForApproval()
			.click();
	    Thread.sleep(1000);
	     actualApprovalmsg = UsfnPageManager.CreateCpsPage()
				.Operations().GetApprovalWarningMessages();
		 excpectedApprovalmsg = Arrays
				.asList("All Intake Participants should be associated with a Person ID",
						"Accept Recomended Priority Must Be Selected.");
		Assert.assertTrue(
				actualApprovalmsg.containsAll(excpectedApprovalmsg)
						&& excpectedApprovalmsg
								.containsAll(actualApprovalmsg),
				"User is able to submit intake in Basic Information page ");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
