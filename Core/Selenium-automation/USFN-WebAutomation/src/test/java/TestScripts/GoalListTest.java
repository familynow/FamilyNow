package TestScripts;

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

public class GoalListTest {
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
	 public void DeleteGoal(){
		 try{
			 
			 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
			 UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
			 String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateUnsafeAssessment();
			 String[] assessmentDetailsParts = assessmentDetails.split(",");
			 String  assessmentId = assessmentDetailsParts[0];
			 Assert.assertFalse(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Saftey Plan is created for Safe Assessment");
			 UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
			 UsfnPageManager.CreateGoalPage().Operations().NavigateToGoalPage();
			 String goal = Utilities.GetRandomString(10);
			 UsfnPageManager.CreateGoalPage().Elements().Goal().sendKeys(goal);
			 for(int i=0;i<=1;i++){
				 UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(i);
			 }
			 
			 UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
			 UsfnPageManager.CreateGoalPage().Elements().Save().click();
			 Assert.assertTrue( UsfnPageManager.CreateGoalPage().Operations().IsGoalCreated(goal, goal) ,"Goal is not created for Safe Assessment");
		
			 
		 }
		 catch (Exception e){
			  Assert.fail("Something worn happned please check the automation script");
		  }
		 
	 }
	 @Test 
	 public void VerifySelectedHarmFactor(){
		 try{
		 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
		 Thread.sleep(9000);
		 Thread.sleep(6000);

		 Thread.sleep(9000);
		/* UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
		 String assessmentId = UsfnPageManager.SafteyAssessmentPage().Operations().CreateUnsafeAssessment();
		 Assert.assertFalse(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Saftey Plan is created for Safe Assessment");
		 UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
		 UsfnPageManager.CreateGoalPage().Operations().NavigateToGoalPage();
		 for(int i=0;i<=1;i++){
			 UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(i);
		 }
		 
		 List<String> ActualHarmFacors =  UsfnPageManager.CreateGoalPage().Operations().GetHarmFactor();
		 
		 UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
		 
		 List<String> ExpectedHarmFacors = UsfnPageManager.CreateGoalPage().Operations().SelectedHarmFactor();
		 
		 Assert.assertTrue(ActualHarmFacors.containsAll(ExpectedHarmFacors)&& ExpectedHarmFacors.containsAll(ActualHarmFacors),"Correct harm factor is not displaying");
		 
		 // Click Edit button 
		 for(int i=0;i<=1;i++){
			 Assert.assertTrue( UsfnPageManager.CreateGoalPage().Operations().IsHarmFactorChecked(i) ,"Harm Factor is not checked");
			 UsfnPageManager.CreateGoalPage().Elements().PopUpCancel().click();
		 }
		 
		 // Click Edit harm factor 
		 UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(2);
		 
		 ActualHarmFacors =  UsfnPageManager.CreateGoalPage().Operations().GetHarmFactor();
		 
		 UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
		 
		 ExpectedHarmFacors = UsfnPageManager.CreateGoalPage().Operations().SelectedHarmFactor();
		 
		 Assert.assertTrue(ActualHarmFacors.containsAll(ExpectedHarmFacors)&& ExpectedHarmFacors.containsAll(ActualHarmFacors),"Correct harm factor is not displaying");*/
		 }
		 
		 catch (Exception e){
			  Assert.fail("Something worn happned please check the automation script");
		  }
		 
	 }

}
