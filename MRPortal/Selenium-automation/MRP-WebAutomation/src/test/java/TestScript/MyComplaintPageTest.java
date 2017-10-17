package TestScript;

import java.net.MalformedURLException;
import java.net.URL;
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

public class MyComplaintPageTest {
	
	WebDriver driver;
	
	 @BeforeMethod
	 public void openbrowser() { 
		  driver = Browser.getBrowser(GetConfigValue.GetBrowser());
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }


	 @AfterMethod
	 public void closebrowser() {
		 driver = null;
		 Browser.driver.close();
		
	 }
	 
	 private String AddParticipant(String Fname,String Lname,String[] Roles,String Gender){
		 String ComplaintId = "";
		 try {
			 Thread.sleep(800);
			 MRPPageManager.PersonProfilePage().Elements().SaveContinue().click();
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 String name =Lname+ ", "+Fname;
			 MRPPageManager.ComplaintParticipantPage().Operations().EnterRequiredField(Fname, Lname, Roles,Gender);
			 MRPPageManager.ComplaintParticipantPage().Elements().SaveAdd().click();
			 MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 ComplaintId= MRPPageManager.ComplaintParticipantPage().Operations().GetComplaintId();
			 Thread.sleep(800);
			
			 
		 }
		 
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return ComplaintId;
	 }
	 
	 
	 @Test
	 public void VerifyInProgressComplaint(){
		 MRPPageManager.LoginPage().Operations().Login();
		 try {
		 
		    MRPPageManager.PersonProfilePage().Operations().NavigateToPersonProfilePage();
		    Thread.sleep(3000);
		    String Fname =Utilities.GetRandomString(10);
		    String Lname =Utilities.GetRandomString(10);
		    String name =Lname+ ", "+Fname;
		    String[] Roles = new String[]{"Alleged Victim (AV)","Alleged Perpetrator (AP)"};
		    String ComplaintId = AddParticipant(Fname, Lname, Roles,"Male");
		    MRPPageManager.ComplaintParticipantPage().Elements().CancelButton().click();
		    MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		    Assert.assertEquals(MRPPageManager.MyComplaintPage().Operations().GetStatus(ComplaintId), "In Progress");
		    Assert.assertTrue(MRPPageManager.MyComplaintPage().Operations().IsComplaintAvailable(ComplaintId), "Complaint is not created");
		    Assert.assertTrue(MRPPageManager.MyComplaintPage().Operations().IsComplaintNameAvailable(name), "Complaint name is not set");
		    MRPPageManager.MyComplaintPage().Operations().ClickComplaint(ComplaintId);
		    MRPPageManager.MyComplaintPage().Operations().ApplyWait(driver);
		    String pageUrl= driver.getCurrentUrl();
		    URL aURL = new URL(pageUrl);
		    String path =  aURL.getPath();
		    String[] pathParts = path.split("/");
		    Assert.assertEquals(pathParts[3], "personProfile");
		    MRPPageManager.ComplaintParticipantPage().Elements().CancelButton().click();
		    MRPPageManager.ComplaintParticipantPage().Operations().ApplyWait(driver);
		    MRPPageManager.MyComplaintPage().Operations().ClickDeleteIcon(ComplaintId);
		    MRPPageManager.MyComplaintPage().Elements().ConfirmationDialoogOKButton().click();
		    MRPPageManager.MyComplaintPage().Operations().ApplyWait(driver);
			 MRPPageManager.ComplaintParticipantPage().Elements().SuccessDialogOkButton().click();
			 MRPPageManager.MyComplaintPage().Operations().ApplyWait(driver);
			 Thread.sleep(800);
			 Assert.assertFalse(MRPPageManager.MyComplaintPage().Operations().IsComplaintAvailable(ComplaintId), "Complaint is not deleted");
		  
		    
	
		 }
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 
	 }
	 

}
