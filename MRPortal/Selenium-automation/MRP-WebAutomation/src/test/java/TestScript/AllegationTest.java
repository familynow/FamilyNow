package TestScript;

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
import PageControllers.MRPPageManager;


public class AllegationTest {
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
	 
	 private void AddParticipant(String Fname,String Lname,String[] Roles,String Gender){
		 try {
			 Thread.sleep(800);
			 MRPPageManager.PersonProfilePage().Elements().SaveContinue().click();
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 String name =Lname+ ", "+Fname;
			 MRPPageManager.ComplaintParticipantPage().Operations().EnterRequiredField(Fname, Lname, Roles,Gender);
			 MRPPageManager.ComplaintParticipantPage().Elements().SaveContinue().click();
			 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			 
		 }
		 
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 
	 @Test
	 public void SaveAllegationWithRequiredFieldOnly(){
		 MRPPageManager.LoginPage().Operations().Login();
		 try {
		 
		    MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
		    MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		    String Fname =Utilities.GetRandomString(10);
		    String Lname =Utilities.GetRandomString(10);
		    String name =Lname+ ", "+Fname;
		    String[] Roles = new String[]{"Alleged Victim (AV)","Alleged Perpetrator (AP)"};
		    AddParticipant(Fname, Lname, Roles,"Male");
		     DateFormat dateFormat = new SimpleDateFormat("dd");
			 Date date = new Date();
			 String todayDate = dateFormat.format(date);
			 MRPPageManager.AllegationsPage().Operations().EnterRequiredField(todayDate, "11:15", "Abandonment");
			 MRPPageManager.AllegationsPage().Operations().SelectVictim(name);
			 MRPPageManager.AllegationsPage().Operations().SelectPerpetator(name);
			 MRPPageManager.AllegationsPage().Elements().AddAllegationButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 Thread.sleep(9000);
			 Assert.assertTrue(MRPPageManager.AllegationsPage().Operations().IsVictimAvailable(name), "Victim is not added to alligation");
			 Assert.assertTrue(MRPPageManager.AllegationsPage().Operations().IsPerpetatorAvailable(name), "Perpetrator is not added to alligation");
	
		 }
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 @Test
	 public void DeleteAllegation(){
		 MRPPageManager.LoginPage().Operations().Login();
		 try {
		 
		    MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
			MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		    String Fname =Utilities.GetRandomString(10);
		    String Lname =Utilities.GetRandomString(10);
		    String name =Lname+ ", "+Fname;
		    String[] Roles = new String[]{"Alleged Victim (AV)","Alleged Perpetrator (AP)"};
		    AddParticipant(Fname, Lname, Roles,"Male");
		     DateFormat dateFormat = new SimpleDateFormat("dd");
			 Date date = new Date();
			 String todayDate = dateFormat.format(date);
			 MRPPageManager.AllegationsPage().Operations().EnterRequiredField(todayDate, "11:15", "Abandonment");
			 MRPPageManager.AllegationsPage().Operations().SelectVictim(name);
			 MRPPageManager.AllegationsPage().Operations().SelectPerpetator(name);
			 MRPPageManager.AllegationsPage().Elements().AddAllegationButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			  Thread.sleep(8000);
			  MRPPageManager.AllegationsPage().Operations().DeleteAllegation(name);
			  MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			  MRPPageManager.AllegationsPage().Elements().ConfirmationDialoogOKButton().click();
			  Thread.sleep(2000);
			  Assert.assertFalse(MRPPageManager.AllegationsPage().Operations().IsVictimAvailable(name), "Victim is not deleted");
			
		 }
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	  @Test 
	 public void EditAllegation(){
		 MRPPageManager.LoginPage().Operations().Login();
		 try {
		 
		    MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
		    MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		    Thread.sleep(4000);
		    String Fname =Utilities.GetRandomString(10);
		    String Lname =Utilities.GetRandomString(10);
		    String name =Lname+ ", "+Fname;
		    String[] Roles = new String[]{"Alleged Victim (AV)","Alleged Perpetrator (AP)"};
		    AddParticipant(Fname, Lname, Roles,"Male");
		    DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			 String todayDate = dateFormat.format(date);
			 MRPPageManager.AllegationsPage().Operations().EnterRequiredField(todayDate, "11:15", "Abandonment");
			 MRPPageManager.AllegationsPage().Operations().SelectVictim(name);
			 MRPPageManager.AllegationsPage().Operations().SelectPerpetator(name);
			 MRPPageManager.AllegationsPage().Elements().AddAllegationButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 Thread.sleep(9000);
			 MRPPageManager.AllegationsPage().Operations().ClickId(name);
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 MRPPageManager.AllegationsPage().Operations().SelectAllegation("Birth Match");
			
			 MRPPageManager.AllegationsPage().Elements().SaveAllegationButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 MRPPageManager.AllegationsPage().Operations().ApplyWait(driver);
			 Thread.sleep(9000);
			 Assert.assertTrue(MRPPageManager.AllegationsPage().Operations().IsVictimAvailable(name), "Victim is not added to allegation");
			 Assert.assertTrue(MRPPageManager.AllegationsPage().Operations().IsPerpetatorAvailable(name), "Perpetrator is not added to allegation");
			
		 }
		 
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }

}
