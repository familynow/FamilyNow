package TestScripts;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
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

public class CreateGoalTest {
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
	 public void VerfyGoalCreated(){
		 try{
			
			 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
			 UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
			 String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateUnsafeAssessment();
			 String[] assessmentDetailsParts = assessmentDetails.split(",");
			 String  assessmentId = assessmentDetailsParts[0];
			 Thread.sleep(1500);
			 Assert.assertTrue(assessmentId.trim().length()>0 ,"Assessment Id is not availablele");
			 Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Safety Plan is created for Safe Assessment");
			 Thread.sleep(500);
			 UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
			 Thread.sleep(500);
			 UsfnPageManager.CreateGoalPage().Operations().NavigateToGoalPage();
			 Thread.sleep(500);
			 String goal = Utilities.GetRandomString(10);
			 UsfnPageManager.CreateGoalPage().Elements().Goal().sendKeys(goal);
			 UsfnPageManager.CreateGoalPage().Elements().HarmFactorsButton().click();
			 for(int i=0;i<=1;i++){
				 UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(i);
			 }
			 
			 UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
			 Thread.sleep(500);
			 UsfnPageManager.CreateGoalPage().Elements().Save().click();
			 UsfnPageManager.CreateGoalPage().Elements().InformationDialoogOKButton().click();
			 UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			 Thread.sleep(500);
			 Assert.assertTrue( UsfnPageManager.CreateGoalPage().Operations().IsGoalCreated(goal, goal) ,"Goal is not created for Safe Assessment");
			 List<String> ActualHarmFactors = UsfnPageManager.CreateGoalPage().Operations().GetHarmFactorAddressed(goal);
			 List<String> ExcpectedHarmFactors = Arrays.asList("1. Caretaker caused serious harm to the child and/or made a plausible threat",
						"2. Caretaker(s) has previously maltreated a child in their care and the severity of the maltreatment");
			 Assert.assertTrue(ActualHarmFactors.containsAll(ExcpectedHarmFactors)&& ExcpectedHarmFactors.containsAll(ActualHarmFactors),"Correct harm factor is not displaying in Grid");
			 
			 UsfnPageManager.CreateGoalPage().Operations().ClickDeleteIcon(goal);
			 
			 UsfnPageManager.CreateGoalPage().Elements().ConfirmationDialoogOKButton().click();
			 UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			 Thread.sleep(1500);
			 Assert.assertFalse( UsfnPageManager.CreateGoalPage().Operations().IsGoalCreated(goal, goal) ,"Goal is not deleted");
		
			 
		 }
		 catch (Exception e){
			  Assert.fail(e.getMessage());
		  }
		 
	 }
/*	@Test 
	 public void EditHarmFactor(){
		 try{
		 
			 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
			 UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
			 String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateUnsafeAssessment();
			 String[] assessmentDetailsParts = assessmentDetails.split(",");
			 String  assessmentId = assessmentDetailsParts[0];
			 Thread.sleep(1500);
			 Assert.assertTrue(assessmentId.trim().length()>0 ,"Assessment Id is not available");
			 Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Safety Plan is created for Safe Assessment");
			 Thread.sleep(500);
			 UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
			 Thread.sleep(500);
			 UsfnPageManager.CreateGoalPage().Operations().NavigateToGoalPage();
			 Thread.sleep(500);
			 UsfnPageManager.CreateGoalPage().Elements().HarmFactorsButton().click();
			 for(int i=0;i<=1;i++){
				 UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(i);
			 }
		 
		 List<String> ActualHarmFacors =  UsfnPageManager.CreateGoalPage().Operations().GetHarmFactor();
		 Thread.sleep(500);
		 UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
		 Thread.sleep(500);
		 List<String> ExpectedHarmFacors = UsfnPageManager.CreateGoalPage().Operations().SelectedHarmFactor();
		 
		 Assert.assertTrue(ActualHarmFacors.containsAll(ExpectedHarmFacors)&& ExpectedHarmFacors.containsAll(ActualHarmFacors),"Correct harm factor is not displaying");
		 
		 // Click Edit button 
		 Thread.sleep(500);
		 UsfnPageManager.CreateGoalPage().Elements().EditHarmFactorsButton().click();
		 Thread.sleep(500);
		 for(int i=0;i<=1;i++){
			 Assert.assertTrue( UsfnPageManager.CreateGoalPage().Operations().IsHarmFactorChecked(i) ,"Harm Factor is not checked");
		 }
		 
		 // Click Edit harm factor 
		 UsfnPageManager.CreateGoalPage().Operations().SelectHarmFactor(1);
		 ActualHarmFacors =  UsfnPageManager.CreateGoalPage().Operations().GetHarmFactor();
		 
		 UsfnPageManager.CreateGoalPage().Elements().PopUpSave().click();
		 Thread.sleep(500);
		 
		 ExpectedHarmFacors = UsfnPageManager.CreateGoalPage().Operations().SelectedHarmFactor();
		 
		 Assert.assertTrue(ActualHarmFacors.containsAll(ExpectedHarmFacors)&& ExpectedHarmFacors.containsAll(ActualHarmFacors),"Correct harm factor is not displaying");
		 }
		 
		 catch (Exception e){
			  Assert.fail(e.getMessage());
		  }
		 
	 }*/

}
