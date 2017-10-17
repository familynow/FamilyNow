package TestScripts;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class VerifySafteyPlanParticipantTest {
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
	 public void VerifySafteyPlanParticipant() {
		 try {
		 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");

	     UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
		 String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateUnsafeAssessment();
		 String[] assessmentDetailsParts = assessmentDetails.split(",");
		 String  assessmentId = assessmentDetailsParts[0];
		 List<String> ActualParticipant = UsfnPageManager.SafteyAssessmentPage().Operations().GetAllParticipant(false);
	     Thread.sleep(700);
		 Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Saftey Plan is created for Safe Assessment");
		 UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
		 List<String> ExpectedParticipant = UsfnPageManager.SafteyPlanParticipantPage().Operations().GetAllParticipant();
		 Assert.assertTrue(ActualParticipant.containsAll(ExpectedParticipant)&& ExpectedParticipant.containsAll(ActualParticipant),"Correct harm factor is not displaying");
		
		
		 }
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	 }
	 
	 @Test
		public void VerifyHarmFactorAnswer() {
			try {

			 UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
	
		 	 UsfnPageManager.MyOrganizerPage().Operations().ClickFirstInvestigation();
				 String assessmentDetails = UsfnPageManager.SafteyAssessmentPage().Operations().CreateUnsafeAssessment();
				 String[] assessmentDetailsParts = assessmentDetails.split(",");
				 String  assessmentId = assessmentDetailsParts[0];
				 Assert.assertTrue(UsfnPageManager.SafteyPlanListPage().Operations().IsSafteyPlanCreated(assessmentId, assessmentId),"Saftey Plan is not created for Safe Assessment");
				 UsfnPageManager.SafteyPlanListPage().Operations().ClickEdit(assessmentId, false);
				Assert.assertEquals(UsfnPageManager.SafteyPlanParticipantPage().Operations().GetSafteyDecision(), "Unsafe");
				List<String> ActualIdentifiedHarmFactors = UsfnPageManager.SafteyPlanParticipantPage().Operations().IdentifiedHarmFactorsAvailable();
				List<String> ExcpectedIdentifiedHarmFactors = Arrays.asList("1. Caretaker caused serious harm to the child and/or made a plausible threat",
								"2. Caretaker(s) has previously maltreated a child in their care and the severity of the maltreatment",
								"3. Caretaker fails to protect child(ren) from serious harm or threatened harm.");
				Assert.assertTrue(ActualIdentifiedHarmFactors.containsAll(ExcpectedIdentifiedHarmFactors)&& ExcpectedIdentifiedHarmFactors.containsAll(ActualIdentifiedHarmFactors),"Correct harm factor is not displaying");
				

			} catch (Exception e) {
				Assert.fail("Something worn happned please check the automation script");
			}

		}
	 

}
 