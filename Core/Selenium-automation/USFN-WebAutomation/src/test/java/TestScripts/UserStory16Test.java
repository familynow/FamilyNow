package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import General.Utilities;
import PageControllers.UsfnPageManager;

public class UserStory16Test {
	
	WebDriver driver;
	
	 @BeforeMethod
	 public void openbrowser() { 
		 Dimension d = new Dimension(1382,1300); 
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
	 
	 @Test
	public void VerifyEditAwaitingScreeningIntake()  {

		 	try {
			// Login to USFN
			UsfnPageManager.LoginPage().Operations().Login();

			// Navigate to Create Cps Page
			UsfnPageManager.IntakeListPage().Operations()
					.NavigateToIntakeListPage();
			UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.IntakeListPage().Operations()
					.ClickAwaitingScreeningDecisionIntake(1);
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(4000);

			Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
					.SaveButton().isEnabled(), "Save button is enabled");
			Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
					.ApplyButton().isEnabled(), "Apply Button is enabled");
			Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
					.SubmitForApproval().isEnabled(), "Submit For Approval Button is enabled");
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Participants");
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.ApplyWait(driver);
			// Add Participant
			Thread.sleep(2000);
			Assert.assertFalse(UsfnPageManager.CpsAddParticipanPage()
					.Elements().SaveButton().isEnabled(),
					"Save button is enabled");
			Assert.assertFalse(UsfnPageManager.CpsAddParticipanPage()
					.Elements().ApplyButton().isEnabled(),
					"Apply Button is enabled");
			Assert.assertFalse(UsfnPageManager.CpsAddParticipanPage()
					.Elements().SubmitForApproval().isEnabled(),
					"Apply Button is enabled");
			
			UsfnPageManager.CreateCpsPage().Operations()
			.ClickLeftHandMenu("Maltreatments");
			UsfnPageManager.CpsMaltreatmentPage().Operations().ApplyWait(driver);
			Thread.sleep(2000); 
				Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements().AddAlligationButton().isEnabled(),
					"Add Allegation Button is enabled");
				Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
					.SaveButton().isEnabled(), "Save button is enabled");
			Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
					.ApplyButton().isEnabled(), "Apply Button is enabled");
			Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
					.SubmitForApproval().isEnabled(), "Submit For Approval Button is enabled");
	
			UsfnPageManager.CreateCpsPage().Operations()
			.ClickLeftHandMenu("Response Priority");
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(2000); 
			Assert.assertFalse(UsfnPageManager.ResponsePriorityPage().Elements()
					.SaveButton().isEnabled(), "Save button is enabled");
			Assert.assertFalse(UsfnPageManager.ResponsePriorityPage().Elements()
					.ApplyButton().isEnabled(), "Apply Button is enabled");
			Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
					.SubmitForApproval().isEnabled(), "Submit For Approval Button is enabled");
			UsfnPageManager.CreateCpsPage().Operations()
			.ClickLeftHandMenu("Decision");
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(2000); 
			Assert.assertTrue(UsfnPageManager.CpsDecisionPage().Elements()
					.SubmitDecisionButton().isEnabled(), "Submit Decision button is enabled");
			
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
	 
	 
	 @Test
	 public void VerifyEditSubmittedIntake(){
		 
		 try {
				// Login to USFN
				UsfnPageManager.LoginPage().Operations().Login();

				// Navigate to Create Cps Page
				UsfnPageManager.IntakeListPage().Operations()
						.NavigateToIntakeListPage();
				UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
				Thread.sleep(4000);
				UsfnPageManager.IntakeListPage().Operations()
						.ClickSubmittedIntake(1);
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(4000);

				Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
						.SaveButton().isEnabled(), "Save button is enabled");
				Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
						.ApplyButton().isEnabled(), "Apply Button is enabled");
				Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
						.SubmitForApproval().isEnabled(), "Submit For Approval Button is enabled");
				UsfnPageManager.CreateCpsPage().Operations()
						.ClickLeftHandMenu("Participants");
				UsfnPageManager.CpsAddParticipanPage().Operations()
						.ApplyWait(driver);
				// Add Participant
				Thread.sleep(2000);
				Assert.assertFalse(UsfnPageManager.CpsAddParticipanPage()
						.Elements().SaveButton().isEnabled(),
						"Save button is enabled");
				Assert.assertFalse(UsfnPageManager.CpsAddParticipanPage()
						.Elements().ApplyButton().isEnabled(),
						"Apply Button is enabled");
				Assert.assertFalse(UsfnPageManager.CpsAddParticipanPage()
						.Elements().SubmitForApproval().isEnabled(),
						"Apply Button is enabled");
				
				UsfnPageManager.CreateCpsPage().Operations()
				.ClickLeftHandMenu("Maltreatments");
				UsfnPageManager.CpsMaltreatmentPage().Operations().ApplyWait(driver);
				Thread.sleep(2000); 
					Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements().AddAlligationButton().isEnabled(),
						"Add Allegation Button is enabled");
					Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
						.SaveButton().isEnabled(), "Save button is enabled");
				Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
						.ApplyButton().isEnabled(), "Apply Button is enabled");
				Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
						.SubmitForApproval().isEnabled(), "Submit For Approval Button is enabled");
		
				UsfnPageManager.CreateCpsPage().Operations()
				.ClickLeftHandMenu("Response Priority");
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(2000); 
				Assert.assertFalse(UsfnPageManager.ResponsePriorityPage().Elements()
						.SaveButton().isEnabled(), "Save button is enabled");
				Assert.assertFalse(UsfnPageManager.ResponsePriorityPage().Elements()
						.ApplyButton().isEnabled(), "Apply Button is enabled");
				Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Elements()
						.SubmitForApproval().isEnabled(), "Submit For Approval Button is enabled");
				UsfnPageManager.CreateCpsPage().Operations()
				.ClickLeftHandMenu("Decision");
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(2000); 
				Assert.assertFalse(UsfnPageManager.CpsDecisionPage().Elements()
						.SubmitDecisionButton().isDisplayed(), "Submit Decision button is displaying");
				
			}

			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	 }
	 
	@Test
	public void DeletePendingIntake() {
		try {
			// Login to USFN
			UsfnPageManager.LoginPage().Operations().Login();
			UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager
					.CreateCpsPage()
					.Operations()
					.EnterAlltheRequiredFields("E-mail", "11:15",
							"PM", "CT", "Alger", "AlligationNotes");
			UsfnPageManager.CreateCpsPage().Elements().ApplyButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);

			Thread.sleep(2000);
			String getIntakeId = UsfnPageManager.CreateCpsPage().Operations()
					.GetIntakeId();
			UsfnPageManager.CreateCpsPage().Elements().CancelButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(5000);
			 Assert.assertTrue(UsfnPageManager.IntakeListPage().Operations().VerifyInatkeIsAvailable(getIntakeId),"Intake is not created");
			 UsfnPageManager.IntakeListPage().Operations ().DeletePendingIntake(getIntakeId);
			 Alert alert = Browser.driver.switchTo().alert(); 
			 alert.accept();
			 Thread.sleep(5000);
			 Assert.assertFalse(UsfnPageManager.IntakeListPage().Operations().VerifyInatkeIsAvailable(getIntakeId),"Intake is not deleted");

		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void VerifyAnonymousReportingPerson() {
		try {
			// Login to USFN
			UsfnPageManager.LoginPage().Operations().Login();
			UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager
			.CreateCpsPage()
			.Operations()
			.EnterAlltheRequiredFields("E-mail", "11:15",
					"PM", "CT", "Alger", "AlligationNotes");
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectPersonCategory("BCAL");
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectPersonRole("DMH Facility Personnel");
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectReportingPersonCheckBox(2);
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectReportingPersonCheckBox(3);
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectReportingPersonCheckBox(4);
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectReportingPersonCheckBox(5);
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectFeedbackRequested("None Requested");
			UsfnPageManager.CreateCpsPage().Elements().ApplyButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);

			Thread.sleep(2000);
			
			UsfnPageManager.CreateCpsPage().Operations()
					.SelectReportingPersonCheckBox(1);
			Assert.assertTrue(UsfnPageManager.CreateCpsPage().Operations()
					.VerifyReportingWhenAnonymous(),
					"Reproting Person drop down and checkboxes are enabled");
			Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
					.GetFirstName().isEnabled(), "First Name is enabled");
			Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
					.GetMiddleName().isEnabled(), "Middle Name is enabled");
			Assert.assertFalse(UsfnPageManager.CreateCpsPage().Elements()
					.GetLastName().isEnabled(), "Last Name is enabled");
			Assert.assertEquals("None Requested", UsfnPageManager.CreateCpsPage().Elements().FeedbackRequested().getFirstSelectedOption().getText());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
	@Test
	public void VerifyCreateCPS() {

		try {
			String firstName = Utilities.GetRandomFirstName();
			String lastName = Utilities.GetRandomLasttName();
			// Login to USFN
			UsfnPageManager.LoginPage().Operations().Login();
			UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager
					.CreateCpsPage()
					.Operations()
					.EnterAlltheRequiredFields("E-mail", "11:15", "PM", "CT",
							"Alger", "AlligationNotes");
			UsfnPageManager.CreateCpsPage().Elements().GetFirstName().sendKeys(firstName);
			UsfnPageManager.CreateCpsPage().Elements().GetLastName().sendKeys(lastName);
			UsfnPageManager.CreateCpsPage().Elements().ApplyButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(2000);
			String getIntakeId = UsfnPageManager.CreateCpsPage().Operations()
					.GetIntakeId();
			UsfnPageManager.CreateCpsPage().Elements().CancelButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(5000);
			Assert.assertTrue(UsfnPageManager.IntakeListPage().Operations()
					.VerifyInatkeIsAvailable(getIntakeId),
					"Intake is not created");
			UsfnPageManager.IntakeListPage().Operations().ClickPendingIntake(getIntakeId,false);
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertEquals(firstName, UsfnPageManager.CreateCpsPage().Elements().GetFirstName().getAttribute("value").trim());
			Assert.assertEquals(lastName, UsfnPageManager.CreateCpsPage().Elements().GetLastName().getAttribute("value").trim());
			UsfnPageManager.CreateCpsPage().Elements().LinkPersonButton().click();
			UsfnPageManager.PersonSearchPage().Elements().AddPersonhButton()
			.click();
	UsfnPageManager.CpsListParticipantPage().Operations()
			.ApplyWait(driver);
	Thread.sleep(3000);
			UsfnPageManager.PersonBasicPage().Elements().ApplyButton().click();
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(3000);
			String getPersonId = UsfnPageManager.PersonBasicPage().Operations().GetPersonId();
			UsfnPageManager.PersonBasicPage().Elements().SaveButton().click();
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(3000);
			Assert.assertEquals( UsfnPageManager.CreateCpsPage().Operations().GetReportingPerson().trim(), lastName + ", " + firstName+" "+"("+getPersonId+")");
			UsfnPageManager.CreateCpsPage().Elements().SaveButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(5000);
	
		UsfnPageManager.IntakeListPage().Operations().ClickPendingIntake(getIntakeId,true);
		UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
		Thread.sleep(2000);
		Assert.assertEquals( UsfnPageManager.CreateCpsPage().Operations().GetReportingPerson().trim(), lastName + ", " + firstName+" "+"("+getPersonId+")");
			

		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
