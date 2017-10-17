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
import PageControllers.UsfnPageManager;

public class UserStoryIN10Test {
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
	 
	 private String AddParticipant(String fname,String lname,String[] roles){
		 
		   DateFormat dateFormat = new SimpleDateFormat("dd");
		   Date date = new Date();
		   String todayDate = dateFormat.format(date);
		   String getIntakeId ="";
		   
		// Login to USFN 
		  UsfnPageManager.LoginPage().Operations().Login("sw", "sw");
		  UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
		 
		  UsfnPageManager.NonCpsIntakeListPage().Elements().AddNonCpsButton().click();
		  
		
	       
			  // Add Cps Intake 
			  UsfnPageManager.CreateNonCpsPage().Operations().EnterRequiredField("Adoption Dissolution", "E-mail", todayDate,"11:15", "Central Intake", "Central Intake", "Narrative");
			  UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
			  
			 try {
					Thread.sleep(800);
			        getIntakeId =  UsfnPageManager.CreateNonCpsPage().Operations().GetIntakeId();
			        UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Participants");
			        Thread.sleep(800);
			          UsfnPageManager.NonCpsAddParticipantPage().Operations().EnterFirstName(fname);
					  UsfnPageManager.NonCpsAddParticipantPage().Operations().EnterLastName(lname);
					  UsfnPageManager.NonCpsAddParticipantPage().Operations().SelectRoles(roles);
					  UsfnPageManager.NonCpsAddParticipantPage().Elements().SaveButton().click();
			  }
			   
			   catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			  return getIntakeId;
			 
		 }
	 
	 @Test
	 public void VerifyDecisionForPending(){
		 String firstName = "ParticipantFName";
		 String lastName = "ParticipantLname";
		 String[] Roles = new String[]{"MDHHS Children's Services Employee","Employee of a Licensed/Registered Child Care Organization"};
		 AddParticipant(firstName,lastName,Roles);
		 
		 UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Decision");
		 try{
			 Thread.sleep(500);
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().VerifyDecisionIsNotEnabled(), "Decision is enable for pending status Intake");
		 }
		
		 catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
		 
	 }
    
	 @Test
	 public void VerifyDecisionIsDisabled(){
		 String firstName = "ParticipantFName";
		 String lastName = "ParticipantLname";
		 String[] Roles = new String[]{"MDHHS Children's Services Employee","Employee of a Licensed/Registered Child Care Organization"};
		 String intakeId= AddParticipant(firstName,lastName,Roles);
		 UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Basic Information");
		 try{
			 Thread.sleep(500);
			 UsfnPageManager.CreateNonCpsPage().Elements().IntakeCompleteCheckbox().click();
			 UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
			 Thread.sleep(300);
			 UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Decision");
			 Thread.sleep(500);
			 UsfnPageManager.NonCpsDecisionPage().Operations().SelectDecision("Assign");
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is Enable");
			 UsfnPageManager.NonCpsDecisionPage().Operations().EnterComments("Comments");
			 UsfnPageManager.NonCpsDecisionPage().Elements().ApplyButton().click();
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is Enable");
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsDecisionEnabled(), "Decision drop down is Enable");
			 UsfnPageManager.NonCpsDecisionPage().Elements().CancelButton().click();
			 Thread.sleep(300);
			 UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
			 Thread.sleep(800);
			 Assert.assertTrue(UsfnPageManager.NonCpsIntakeListPage().Operations().IsIntakeStausReadyToLink(intakeId), "Intake is not changed to Ready to link Stautus");
			
	       }
		 catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	 }
	 
	 @Test
	 public void VerifyRejectDecision(){
		 String firstName = "ParticipantFName";
		 String lastName = "ParticipantLname";
		 String[] Roles = new String[]{"MDHHS Children's Services Employee","Employee of a Licensed/Registered Child Care Organization"};
		 String intakeId= AddParticipant(firstName,lastName,Roles);
		 UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Basic Information");
		 try{
			 Thread.sleep(500);
			 UsfnPageManager.CreateNonCpsPage().Elements().IntakeCompleteCheckbox().click();
			 UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
			 Thread.sleep(300);
			 UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Decision");
			 Thread.sleep(500);
			 UsfnPageManager.NonCpsDecisionPage().Operations().SelectDecision("Reject");
			 Assert.assertTrue(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is disabled");
			 UsfnPageManager.NonCpsDecisionPage().Operations().SelectRejectWithdrawReason("Already Investigated");
			
			 UsfnPageManager.NonCpsDecisionPage().Operations().EnterComments("Comments");
			 
			 UsfnPageManager.NonCpsDecisionPage().Elements().ApplyButton().click();
			 
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is Enable");
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsDecisionEnabled(), "Decision drop down is Enable");
			 
			 UsfnPageManager.NonCpsDecisionPage().Elements().CancelButton().click();
			 Thread.sleep(300);
			 UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
			 Thread.sleep(800);
			 Assert.assertTrue(UsfnPageManager.NonCpsIntakeListPage().Operations().IsIntakeStausScreenedOut(intakeId), "Intake is not changed to Screened Out");
			
	       }
		 catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	 }
	 
	 @Test
	 public void VerifyWithdrawnDecision(){
		 String firstName = "ParticipantFName";
		 String lastName = "ParticipantLname";
		 String[] Roles = new String[]{"MDHHS Children's Services Employee","Employee of a Licensed/Registered Child Care Organization"};
		 String intakeId= AddParticipant(firstName,lastName,Roles);
		 UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Basic Information");
		 try{
			 Thread.sleep(500);
			 UsfnPageManager.CreateNonCpsPage().Elements().IntakeCompleteCheckbox().click();
			 UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
			 Thread.sleep(300);
			 UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Decision");
			 Thread.sleep(500);
			 UsfnPageManager.NonCpsDecisionPage().Operations().SelectDecision("Withdrawn");
			 Assert.assertTrue(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is disabled");
			 UsfnPageManager.NonCpsDecisionPage().Operations().SelectRejectWithdrawReason("Already Investigated");
			
			 UsfnPageManager.NonCpsDecisionPage().Operations().EnterComments("Comments");
			 
			 UsfnPageManager.NonCpsDecisionPage().Elements().ApplyButton().click();
			 
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is Enable");
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsDecisionEnabled(), "Decision drop down is Enable");
			 
			 UsfnPageManager.NonCpsDecisionPage().Elements().CancelButton().click();
			 Thread.sleep(300);
			 UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
			 Thread.sleep(800);
			 Assert.assertTrue(UsfnPageManager.NonCpsIntakeListPage().Operations().IsIntakeStausScreenedOut(intakeId), "Intake is not changed to Screened Out");
			
	       }
		 catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	 }
	 
	 @Test
	 public void VerifyDecisionIsEditable(){
		 
		  UsfnPageManager.LoginPage().Operations().Login("sw", "sw");
		  UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
		  try{
		    Thread.sleep(500);
		    UsfnPageManager.NonCpsIntakeListPage().Operations().ClickCompletedIntake(1);
		    UsfnPageManager.CreateNonCpsPage().Operations().ClickLeftHandMenu("Decision");
			 Thread.sleep(500);
			 String getIntakeId =  UsfnPageManager.CreateNonCpsPage().Operations().GetIntakeId();
			 Assert.assertTrue(UsfnPageManager.NonCpsDecisionPage().Operations().IsDecisionEnabled(), "Decision drop down is Enable");
			 UsfnPageManager.NonCpsDecisionPage().Operations().SelectDecision("Withdrawn");
			 Assert.assertTrue(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is disabled");
			 UsfnPageManager.NonCpsDecisionPage().Operations().SelectRejectWithdrawReason("Already Investigated");
             UsfnPageManager.NonCpsDecisionPage().Operations().EnterComments("Comments");
			 UsfnPageManager.NonCpsDecisionPage().Elements().ApplyButton().click();
			
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsRejectWithdrowReasonEnabled(), "Reject Withdrown Reason drop down is Enable");
			 Assert.assertFalse(UsfnPageManager.NonCpsDecisionPage().Operations().IsDecisionEnabled(), "Decision drop down is Enable");
			 
			 UsfnPageManager.NonCpsDecisionPage().Elements().CancelButton().click();
			 Thread.sleep(300);
			 UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
			 Thread.sleep(800);
			 Assert.assertTrue(UsfnPageManager.NonCpsIntakeListPage().Operations().IsIntakeStausScreenedOut(getIntakeId), "Intake is not changed to Screened Out");
		  }
		  
		  catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		 
		 
	 }
	 
	 
}
