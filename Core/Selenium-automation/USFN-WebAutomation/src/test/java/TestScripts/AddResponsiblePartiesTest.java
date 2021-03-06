package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import General.Utilities;
import PageControllers.UsfnPageManager;

public class AddResponsiblePartiesTest {
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
	 public void VerifyAddResponsibleParty(){
		try {
			UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
			UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
			Thread.sleep(1000);
			String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateSafeWithServices();
			String[] assessmentDetailsParts = assessmentDetails.split(",");
			String assessmentId = assessmentDetailsParts[0];
			Assert.assertTrue(assessmentId.trim().length() > 0,"Assessment Id is not availablele");
			Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Saftey Plan is not created for Safe Assessment");
			Thread.sleep(500);
			UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
			Thread.sleep(500);
			UsfnPageManager.CreateGoalPage().Operations().NavigateToGoalPage();
			Thread.sleep(500);
		
			UsfnPageManager.CreateGoalPage().Elements().AddTaskButton().click();
			String task = Utilities.GetRandomString(10);
			UsfnPageManager.AddTaskPage().Elements().TaskTextBox().sendKeys(task);
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			String todayDate = dateFormat.format(date);
			UsfnPageManager.AddTaskPage().Operations().EnterFromDate(todayDate);
			UsfnPageManager.AddTaskPage().Operations().EnterToDate(todayDate);
			UsfnPageManager.AddTaskPage().Elements().AddResponsiblePartyButton().click();
			Thread.sleep(1000);
			String Contact = Utilities.GetRandomString(10);
			UsfnPageManager.AddTaskPage().Operations().EnterAddResponsiblePartyRequiredField("Home Phone", Contact, "Attorney of Record");
			UsfnPageManager.AddTaskPage().Elements().ResponsiblePopUpOkButton().click();
			Thread.sleep(1000);
			 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, Contact) ,"Responsible Parties is not added");
			 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Home Phone") ,"Contact Type is not correct for Responsible Parties");
			 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Attorney of Record") ,"Role is not correct for Responsible Parties");
			UsfnPageManager.AddTaskPage().Elements().OkButton().click();
			Thread.sleep(500);
			String goal = Utilities.GetRandomString(10);
			UsfnPageManager.CreateGoalPage().Elements().Goal().sendKeys(goal);
			UsfnPageManager.CreateGoalPage().Elements().HarmFactorsButton().click();
			UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(0);
			UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
			Thread.sleep(500);
			UsfnPageManager.CreateGoalPage().Elements().Save().click();
		    UsfnPageManager.CreateGoalPage().Elements().InformationDialoogOKButton().click();
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(1500);
			Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsGoalCreated(goal, goal),"Goal is not created for Safe Assessment");
			UsfnPageManager.CreateGoalPage().Operations().ClickEditIcon(goal);
			UsfnPageManager.AddTaskPage().Operations().ApplyWait(driver);
			Thread.sleep(500);
			Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations()
					.IsTaskCreated(task, task), "Task is not created");
			UsfnPageManager.CreateGoalPage().Operations().EditTask(task);
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(1500);
			 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, Contact) ,"Responsible Parties is not added");
			 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Home Phone") ,"Contact Type is not correct for Responsible Parties");
			 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Attorney of Record") ,"Role is not correct for Responsible Parties");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	 }
	 @Test
	 public void VerifyResponsiblePartiesWithoutGoal(){
		 try {
				UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
				UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
				Thread.sleep(1000);
				String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateSafeWithServices();
				String[] assessmentDetailsParts = assessmentDetails.split(",");
				String assessmentId = assessmentDetailsParts[0];
				Assert.assertTrue(assessmentId.trim().length() > 0,"Assessment Id is not availablele");
				Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Saftey Plan is not created for Safe Assessment");
				Thread.sleep(500);
				UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
				Thread.sleep(500);
				UsfnPageManager.CreateGoalPage().Operations().NavigateToGoalPage();
				Thread.sleep(500);
				
				
				UsfnPageManager.CreateGoalPage().Elements().AddTaskButton().click();
				String task = Utilities.GetRandomString(10);
				UsfnPageManager.AddTaskPage().Elements().TaskTextBox().sendKeys(task);
				DateFormat dateFormat = new SimpleDateFormat("dd");
				Date date = new Date();
				String todayDate = dateFormat.format(date);
				UsfnPageManager.AddTaskPage().Operations().EnterFromDate(todayDate);
				UsfnPageManager.AddTaskPage().Operations().EnterToDate(todayDate);
				UsfnPageManager.AddTaskPage().Elements().OkButton().click();
				String goal = Utilities.GetRandomString(10);
				UsfnPageManager.CreateGoalPage().Elements().Goal().sendKeys(goal);
				UsfnPageManager.CreateGoalPage().Elements().HarmFactorsButton().click();
				UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(0);
				UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
				Thread.sleep(500);
				UsfnPageManager.CreateGoalPage().Elements().Apply().click();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				 UsfnPageManager.CreateGoalPage().Elements().InformationDialoogOKButton().click();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(500);
				UsfnPageManager.CreateGoalPage().Operations().EditTask(task);
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(1500);
				
				UsfnPageManager.AddTaskPage().Elements().AddResponsiblePartyButton().click();
				Thread.sleep(1000);
				String Contact = Utilities.GetRandomString(10);
				UsfnPageManager.AddTaskPage().Operations().EnterAddResponsiblePartyRequiredField("Home Phone", Contact, "Attorney of Record");
				UsfnPageManager.AddTaskPage().Elements().ResponsiblePopUpOkButton().click();
				Thread.sleep(1000);
				 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, Contact) ,"Responsible Parties is not added");
				 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Home Phone") ,"Contact Type is not correct for Responsible Parties");
				 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Attorney of Record") ,"Role is not correct for Responsible Parties");
				UsfnPageManager.AddTaskPage().Elements().OkButton().click();
				Thread.sleep(500);
				UsfnPageManager.CreateGoalPage().Elements().Cancel().click();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(1000);
				UsfnPageManager.CreateGoalPage().Operations().ClickEditIcon(goal);
				UsfnPageManager.AddTaskPage().Operations().ApplyWait(driver);
				Thread.sleep(500);
				Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations()
						.IsTaskCreated(task, task), "Task is not created");
				UsfnPageManager.CreateGoalPage().Operations().EditTask(task);
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(1500);
				
				 Assert.assertFalse(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, Contact) ,"Responsible Parties is not deleted");
				
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		 
	 }
	 @Test
	 public void DeleteResponsibleParties(){
			try {
				UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
				UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
				Thread.sleep(1000);
				String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateSafeWithServices();
				String[] assessmentDetailsParts = assessmentDetails.split(",");
				String assessmentId = assessmentDetailsParts[0];
				Assert.assertTrue(assessmentId.trim().length() > 0,"Assessment Id is not availablele");
				Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Saftey Plan is not created for Safe Assessment");
				Thread.sleep(500);
				UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
				Thread.sleep(500);
				UsfnPageManager.CreateGoalPage().Operations().NavigateToGoalPage();
				Thread.sleep(500);
			
				UsfnPageManager.CreateGoalPage().Elements().AddTaskButton().click();
				String task = Utilities.GetRandomString(10);
				UsfnPageManager.AddTaskPage().Elements().TaskTextBox().sendKeys(task);
				DateFormat dateFormat = new SimpleDateFormat("dd");
				Date date = new Date();
				String todayDate = dateFormat.format(date);
				UsfnPageManager.AddTaskPage().Operations().EnterFromDate(todayDate);
				UsfnPageManager.AddTaskPage().Operations().EnterToDate(todayDate);
				UsfnPageManager.AddTaskPage().Elements().AddResponsiblePartyButton().click();
				Thread.sleep(1000);
				String Contact = Utilities.GetRandomString(10);
				UsfnPageManager.AddTaskPage().Operations().EnterAddResponsiblePartyRequiredField("Home Phone", Contact, "Attorney of Record");
				UsfnPageManager.AddTaskPage().Elements().ResponsiblePopUpOkButton().click();
				Thread.sleep(1000);
				 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, Contact) ,"Responsible Parties is not added");
				 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Home Phone") ,"Contact Type is not correct for Responsible Parties");
				 Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Attorney of Record") ,"Role is not correct for Responsible Parties");
				UsfnPageManager.AddTaskPage().Elements().OkButton().click();
				Thread.sleep(500);
				String goal = Utilities.GetRandomString(10);
				UsfnPageManager.CreateGoalPage().Elements().Goal().sendKeys(goal);
				UsfnPageManager.CreateGoalPage().Elements().HarmFactorsButton().click();
				UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(0);
				UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
				Thread.sleep(500);
				UsfnPageManager.CreateGoalPage().Elements().Save().click();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			    UsfnPageManager.CreateGoalPage().Elements().InformationDialoogOKButton().click();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(1500);
				Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations().IsGoalCreated(goal, goal),"Goal is not created for Safe Assessment");
				UsfnPageManager.CreateGoalPage().Operations().ClickEditIcon(goal);
				UsfnPageManager.AddTaskPage().Operations().ApplyWait(driver);
				Thread.sleep(500);
				Assert.assertTrue(UsfnPageManager.CreateGoalPage().Operations()
						.IsTaskCreated(task, task), "Task is not created");
				UsfnPageManager.CreateGoalPage().Operations().EditTask(task);
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(1500);
				UsfnPageManager.CreateGoalPage().Operations().ClickResponsiblePartieskDeleteIcon(Contact);
				 UsfnPageManager.CreateGoalPage().Elements().ConfirmationDialoogOKButton().click();
				 UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				 Thread.sleep(1500);
				 Assert.assertFalse(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, Contact) ,"Responsible Parties is not added");
				 Assert.assertFalse(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Home Phone") ,"Contact Type is not correct for Responsible Parties");
				 Assert.assertFalse(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Attorney of Record") ,"Role is not correct for Responsible Parties");
				 UsfnPageManager.AddTaskPage().Elements().OkButton().click();
					UsfnPageManager.CreateGoalPage().Elements().Save().click();
					UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				    UsfnPageManager.CreateGoalPage().Elements().InformationDialoogOKButton().click();
					UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
					Thread.sleep(1500);
					UsfnPageManager.CreateGoalPage().Operations().ClickEditIcon(goal);
					UsfnPageManager.AddTaskPage().Operations().ApplyWait(driver);
					Thread.sleep(500);
					UsfnPageManager.CreateGoalPage().Operations().EditTask(task);
					UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
					Thread.sleep(1500);
					 Assert.assertFalse(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, Contact) ,"Responsible Parties is not added");
					 Assert.assertFalse(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Home Phone") ,"Contact Type is not correct for Responsible Parties");
					 Assert.assertFalse(UsfnPageManager.CreateGoalPage().Operations().IsResponsiblePartiesCreated(Contact, "Attorney of Record") ,"Role is not correct for Responsible Parties");
	
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		 
	 }

}
