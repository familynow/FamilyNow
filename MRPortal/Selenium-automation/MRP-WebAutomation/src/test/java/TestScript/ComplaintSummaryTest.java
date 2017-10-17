package TestScript;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import General.Utilities;
import PageControllers.MRPPageManager;

public class ComplaintSummaryTest {
	
	WebDriver driver;
	
	 @BeforeMethod
	 public void openbrowser() { 
		  driver = Browser.getBrowser(GetConfigValue.GetBrowser());
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 // driver.manage().
	 }

	 //@AfterMethod defines this method has to run after every @Test methods
	 @AfterMethod
	 public void closebrowser() {
		 driver = null;
		 Browser.driver.close();
		
	 }
	 
	 private String AddParticipant(String Fname,String Lname,String[] Roles,String Gender,String WPhone,String Mnumber,String Address1,String Address2,String City,String State,String Zip,String AccessToVictim,boolean Continue){
		 String ComplaintId = "";
		 try {
			  
			
			 MRPPageManager.ComplaintParticipantPage().Operations().EnterRequiredField(Fname, Lname, Roles,Gender);
			 MRPPageManager.ComplaintParticipantPage().Operations().EnterContactInformation(WPhone, Mnumber);
			 MRPPageManager.ComplaintParticipantPage().Operations().EnterAddressDetails(Address1, Address2, City, State, Zip);
			 MRPPageManager.ComplaintParticipantPage().Elements().AccessToVictimDropdown().selectByVisibleText(AccessToVictim);
			 if(Continue){
				 MRPPageManager.ComplaintParticipantPage().Elements().SaveContinue().click();;
				 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			 }
			
			 else {
			 MRPPageManager.ComplaintParticipantPage().Elements().SaveAdd().click();
			 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 ComplaintId= MRPPageManager.ComplaintParticipantPage().Operations().GetComplaintId();
			 Thread.sleep(1500);
			 }
			
			 
		 }
		 
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return ComplaintId;
	 }
	 
	 
	 @Test 
	 public void SubmitTheComplaint(){
		 MRPPageManager.LoginPage().Operations().Login();
		 try {
			    Thread.sleep(3000);
			    MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
			    MRPPageManager.PersonProfilePage().Operations().ApplyWait(driver);
			    MRPPageManager.PersonProfilePage().Elements().SaveContinue().click();
			    MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			    // Add Complaint Victim 
			    String Fname =Utilities.GetRandomString(10);
			    String Lname =Utilities.GetRandomString(10);
			    String victim =Lname+ ", "+Fname;
			    String[] Roles = new String[]{"Alleged Victim (AV)"};
			    String VwPhone = "111-111-1111";
			    String Vmnumber = "222-222-2222";
			    String Vaddress1 = "Vicitm Add1";
			    String Vaddress2 = "Victim Add2";
			    String Vcity = "Bangalore";
			    String Vstate = "Alabama";
			    String VZip ="12345";
			    String VaccessToVictim = "No";
			    String VictimAddressDetail = Vaddress1+", "+Vaddress2+", "+Vcity+", "+Vstate+", "+VZip;
			    String  ComplaintId = AddParticipant(Fname, Lname, Roles,"Male",VwPhone,Vmnumber,Vaddress1,Vaddress2,Vcity,Vstate,VZip,VaccessToVictim,false);
			    // Add Complaint Perpetrator 
			    Fname =Utilities.GetRandomString(10);
			    Lname =Utilities.GetRandomString(10);
			    String perpetrator =Lname+ ", "+Fname;
			    Roles = new String[]{"Alleged Perpetrator (AP)"};
			    String PwPhone = "333-333-3333";
			    String Pmnumber = "444-444-4444";
			    String Paddress1 = "perpetrator Add1";
			    String Paddress2 = "perpetrator Add2";
			    String Pcity = "Bangalore";
			    String Pstate = "Alabama";
			    String PZip ="54321";
			    String PaccessToVictim = "Don't know";
			    String PerpetratorAddressDetail = Paddress1+", "+Paddress2+", "+Pcity+", "+Pstate+", "+PZip;
	            AddParticipant(Fname, Lname, Roles,"Male",PwPhone,Pmnumber,Paddress1,Paddress2,Pcity,Pstate,PZip,PaccessToVictim,true);
	            
	            // Add allegation 
	            DateFormat dateFormat = new SimpleDateFormat("dd");
				 Date date = new Date();
				 String todayDate = dateFormat.format(date);
				 MRPPageManager.AllegationsPage().Operations().EnterRequiredField(todayDate, "11:15", "Abandonment");
				 MRPPageManager.AllegationsPage().Operations().SelectVictim(victim);
				 MRPPageManager.AllegationsPage().Operations().SelectPerpetator(perpetrator);
				 MRPPageManager.AllegationsPage().Elements().AddAllegationButton().click();
				 
				 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
				 Thread.sleep(7000);
				 Assert.assertTrue(MRPPageManager.AllegationsPage().Operations().IsVictimAvailable(victim), "Victim is not added to alligation");
				 Assert.assertTrue(MRPPageManager.AllegationsPage().Operations().IsPerpetatorAvailable(perpetrator), "Perpetrator is not added to alligation");
				 MRPPageManager.AllegationsPage().Elements().SaveContinue().click();
				// MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
				 Thread.sleep(4000);
				 
				 // Verify Complaint Summary
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(victim, VictimAddressDetail),"Victim Address is not correct");
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(victim, Vmnumber+"(M)"),"Victim Mob number is not correct");
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(victim, VwPhone+"(W)"),"Victim Work Phone is not correct");
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(victim, "Alleged Victim (AV)"),"Victim role is not correct");
			     Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(victim, VaccessToVictim),"Victim access is not correct");
			     
			      Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(perpetrator, PerpetratorAddressDetail),"Perpetrator Address is not correct");
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(perpetrator, Pmnumber+"(M)"),"Perpetrator Mob number is not correct");
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(perpetrator, PwPhone+"(W)"),"Perpetrator Work Phone is not correct");
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(perpetrator, "Alleged Perpetrator (AP)"),"Perpetrator role is not correct");
			     Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsColumnAvailabeInSummaryGrid(perpetrator, "Don't Know"),"Perpetrator access is not correct");
				 
			     
				 // Verify Allegation Summary 
			     Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsVictimAvailable(victim), "Victim is not added to alligation");
				 Assert.assertTrue(MRPPageManager.SummaryPage().Operations().IsPerpetatorAvailable(perpetrator), "Perpetrator is not added to alligation");
				 MRPPageManager.SummaryPage().Elements().SubmitButton().click();
				 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
				 MRPPageManager.MyComplaintPage().Elements().SuccessDialogOkButton().click();
				// MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
				 Thread.sleep(4000);
			     Assert.assertEquals(MRPPageManager.MyComplaintPage().Operations().GetStatus(ComplaintId), "Submitted");
			     MRPPageManager.MyComplaintPage().Operations().ClickComplaint(ComplaintId);
				    String pageUrl= driver.getCurrentUrl();
				    URL aURL = new URL(pageUrl);
				    String path =  aURL.getPath();
				    String[] pathParts = path.split("/");
				    Assert.assertEquals(pathParts[3], "complaintSummary");
		     }
		 
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }

}
