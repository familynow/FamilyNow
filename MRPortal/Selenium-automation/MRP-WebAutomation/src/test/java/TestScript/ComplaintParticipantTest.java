package TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import General.Utilities;
import PageControllers.MRPPageManager;


public class ComplaintParticipantTest {

	WebDriver driver;
	
	 @BeforeMethod
	 public void openbrowser() { 
		  driver = Browser.getBrowser(GetConfigValue.GetBrowser());
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
	 public void SaveComplaintParticipantWithRequiredFieldOnly(){
		 MRPPageManager.LoginPage().Operations().Login();
		
		  try {
			  MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  MRPPageManager.PersonProfilePage().Elements().SaveContinue().click();
			  MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  String Fname =Utilities.GetRandomString(10);
			  String Lname =Utilities.GetRandomString(10);
			  String name =Lname+ ", "+Fname;
			  String[] Roles = new String[]{"Alleged Perpetrator (AP)"};
			  Thread.sleep(700);
			  MRPPageManager.ComplaintParticipantPage().Operations().EnterRequiredField(Fname, Lname, Roles,"Male");
			  MRPPageManager.ComplaintParticipantPage().Elements().SaveAdd().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  Thread.sleep(1000);
			  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Operations().IsColumnValueAvailable(name,"Alleged Perpetrator (AP)"),"Participant is not created");
			  Assert.assertEquals(MRPPageManager.ComplaintParticipantPage().Operations().GetComplaintName(), name, "Complaint Name is not set");
			  Thread.sleep(600);
			  MRPPageManager.ComplaintParticipantPage().Operations().ClickId(name);
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  Thread.sleep(1000);
			  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().Fname().getAttribute("value").contains(Fname),"First Name is not Saved");
			  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().Lname().getAttribute("value").contains(Lname),"Last Name is not Saved");
			  Assert.assertEquals("Male",    MRPPageManager.ComplaintParticipantPage().Elements().GenderDropdown().getFirstSelectedOption().getText());
			 
		 }
		 
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	   @Test
	 public void DeleteComplaintParticipant(){
		 MRPPageManager.LoginPage().Operations().Login();
			
		  try {
			  MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  MRPPageManager.PersonProfilePage().Elements().SaveContinue().click();
		      MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  String Fname =Utilities.GetRandomString(10);
			  String Lname =Utilities.GetRandomString(10);
			  String name =Lname+ ", "+Fname;
			  String[] Roles = new String[]{"Alleged Perpetrator (AP)"};
			  Thread.sleep(500);
			  MRPPageManager.ComplaintParticipantPage().Operations().EnterRequiredField(Fname, Lname, Roles,"Male");
			  MRPPageManager.ComplaintParticipantPage().Elements().SaveAdd().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  Thread.sleep(1000);
			  MRPPageManager.ComplaintParticipantPage().Operations().PerformAction(name, "Delete");
			  Assert.assertEquals("Participant selected as complaint name cannot be deleted.",    MRPPageManager.ComplaintParticipantPage().Operations().GetModalDialogMessage());
			  MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Operations().IsColumnValueAvailable(name,"Alleged Perpetrator (AP)"),"Participant is not created");
			  Assert.assertEquals(MRPPageManager.ComplaintParticipantPage().Operations().GetComplaintName(), name, "Complaint Name is not set");
			  String Sfname =Utilities.GetRandomString(10);
			  String Slname =Utilities.GetRandomString(10);
			  String Sname =Slname+ ", "+Sfname;
			  MRPPageManager.ComplaintParticipantPage().Operations().EnterRequiredField(Sfname, Slname, Roles,"Male");
			  MRPPageManager.ComplaintParticipantPage().Elements().SaveAdd().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  MRPPageManager.ComplaintParticipantPage().Operations().PerformAction(Sname, "Make Complaint Name");
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  Assert.assertEquals(MRPPageManager.ComplaintParticipantPage().Operations().GetComplaintName(), Sname, "Complaint Name is not set");
			  MRPPageManager.ComplaintParticipantPage().Operations().PerformAction(name, "Delete");
			  MRPPageManager.ComplaintParticipantPage().Elements().ConfirmationDialoogOKButton().click();
			  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			  Assert.assertFalse(MRPPageManager.ComplaintParticipantPage().Operations().IsColumnValueAvailable(name,"Alleged Perpetrator (AP)"), "First Participant is not deleted");
			  
		  }
		  
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
	@Test
	 public void VerifySameAsAddress(){
		try{
		 MRPPageManager.LoginPage().Operations().Login();
		 MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
		 MRPPageManager.PersonProfilePage().Operations().ApplyWait(driver);
		 MRPPageManager.PersonProfilePage().Elements().SaveContinue().click();
		 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
		 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		 String Fname =Utilities.GetRandomString(10);
		  String Lname =Utilities.GetRandomString(10);
		  String name =Lname+ ", "+Fname;
		  String[] Roles = new String[]{"Alleged Perpetrator (AP)"};
		  MRPPageManager.ComplaintParticipantPage().Operations().EnterRequiredField(Fname, Lname, Roles,"Male");
		  String Paddress1 = "perpetrator Add1";
		  String Paddress2 = "perpetrator Add2";
		  String Pcity = "Bangalore";
		  String Pstate = "Alabama";
		  String PZip ="54321";
		  MRPPageManager.ComplaintParticipantPage().Operations().EnterAddressDetails(Paddress1, Paddress2, Pcity, Pstate, PZip);
		  MRPPageManager.ComplaintParticipantPage().Elements().SaveAdd().click();
		  MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		  MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
		  MRPPageManager.ComplaintParticipantPage().Elements().SameDropdown().selectByVisibleText(name);
		  Thread.sleep(1000);
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().AddressLine1().getAttribute("value").contains(Paddress1),"Address line 1 is not correct");
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().AddressLine2().getAttribute("value").contains(Paddress2),"Address line 2 is not correct");
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().City().getAttribute("value").contains(Pcity),"City is not correct");
		  Assert.assertEquals("Alabama",    MRPPageManager.ComplaintParticipantPage().Elements().State().getFirstSelectedOption().getText());
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().Zip().getAttribute("value").contains(PZip),"Zip is not correct");
		}
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
	 }
	 
	 @Test
	 public void VerifyUnkownAddress(){
		 MRPPageManager.LoginPage().Operations().Login();
		 MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
		 MRPPageManager.PersonProfilePage().Operations().ApplyWait(driver);
		 MRPPageManager.PersonProfilePage().Elements().SaveContinue().click();
		 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
		 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		 String Paddress1 = "perpetrator Add1";
		  String Paddress2 = "perpetrator Add2";
		  String Pcity = "Bangalore";
		  String Pstate = "Alabama";
		  String PZip ="54321";
		  MRPPageManager.ComplaintParticipantPage().Operations().EnterAddressDetails(Paddress1, Paddress2, Pcity, Pstate, PZip);
		  MRPPageManager.ComplaintParticipantPage().Elements().AddressUnknown().click();
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().AddressLine1().getAttribute("value").contains(""),"Address line 1 is not cleared");
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().AddressLine2().getAttribute("value").contains(""),"Address line 2 is not cleared");
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().City().getAttribute("value").contains(""),"City is not cleared");
		  Assert.assertTrue(MRPPageManager.ComplaintParticipantPage().Elements().Zip().getAttribute("value").contains(""),"Zip is not cleared");
		  Assert.assertEquals("Select",    MRPPageManager.ComplaintParticipantPage().Elements().State().getFirstSelectedOption().getText());
	 }
	 
	 
}
