package testScripts;

import general.Browser;
import general.GetConfigValue;
import general.Utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageControllers.ProviderPageManager;

public class SupportingDocumentTest {
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
	    
	    private  void setClipboardData(String string) {
			//StringSelection is a class that can be used for copy and paste operations.
			   StringSelection stringSelection = new StringSelection(string);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
	  
	    private  void uploadFile(String fileLocation) {
	        try {
	        	//Setting clipboard with file location
	            setClipboardData(fileLocation);
	         
	            Robot robot = new Robot();
	            Thread.sleep(1000);
	            
	            // Press Enter
	           robot.keyPress(KeyEvent.VK_ENTER);
	           
	          // Release Enter
	           robot.keyRelease(KeyEvent.VK_ENTER);
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            Thread.sleep(1000);
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	        } catch (Exception exp) {
	        	exp.printStackTrace();
	        }
	    }
	    
	     
	@Test
	public void VerifySupportingDocumentIsSaved() {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			String todayDate = dateFormat.format(date);
			// Enter data in ApplicationType Page and navigate to ApplicationParticipant Page
			ProviderPageManager.LoginPage().Operation().Login();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			ProviderPageManager.ApplicationTypePage().Operation().NavigateAndFillRequiredField();
			ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
			Thread.sleep(1000);

			// Enter data in ApplicationParticipant Page and navigate to AddressInformation Page
			String Fname = "kumar" + Utilities.GetRandomString(2);
			String Lname = "pushyamitra" + Utilities.GetRandomString(2);
			ProviderPageManager.ApplicationParticipantPage().Elements().Fname().clear();
			ProviderPageManager.ApplicationParticipantPage().Elements().Lname().clear();
			ProviderPageManager.ApplicationParticipantPage().Elements().Fname().sendKeys(Fname);
			ProviderPageManager.ApplicationParticipantPage().Elements().Lname().sendKeys(Lname);
			ProviderPageManager.ApplicationParticipantPage().Elements().SaveContinue().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
			Thread.sleep(1000);
			ProviderPageManager.AddressInformationPage().Operation().EnterRequiredField();
			ProviderPageManager.AddressInformationPage().Elements().AddressSaveButton().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
			Thread.sleep(1000);
			// Enter data in FosterCare Page and Navigate to PreferencesPage
			ProviderPageManager.FosterCarePage().Operation().NavigateAndFillRequiredField();
			ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
			Thread.sleep(1000);
			// Enter data in Preferences Page and Navigate to Reference Page
			ProviderPageManager.PreferencesPage().Operation().NavigateAndFillRequiredField();
			ProviderPageManager.PreferencesPage().Elements().PreferenceSaveContinue().click();
			ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			// Enter data in Reference Page and Navigate to Supporting Document Page
			ProviderPageManager.ReferencePage().Operation().EnterApplicant1References();
			ProviderPageManager.ReferencePage().Elements().ReferenceSaveContinue().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(2500);
			String filePath = "../FamilyNow_Provider_Portal_Automation/SupportingDocument/PngTestDocument.png";
			File file = new File(filePath);
			String FullPath = file.getCanonicalPath();
			ProviderPageManager.SupportingDocumentPage().Elements().UploadFile().click();
			uploadFile(FullPath);
			Thread.sleep(2000);
			String DocumentName = Utilities.GetRandomString(10);
			ProviderPageManager.SupportingDocumentPage().Operation().EnterRequiredField(Fname + " " + Lname, "Document Type 1",DocumentName, todayDate);
			ProviderPageManager.SupportingDocumentPage().Elements().SupportingDocumentSaveAdd().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1500);
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			Assert.assertTrue(ProviderPageManager.SupportingDocumentPage().Operation().IsDocumentAvailable(DocumentName),"Document is not avaiable");
			ProviderPageManager.SupportingDocumentPage().Elements().SupportingDocumentSaveContinue().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			Assert.assertEquals(ProviderPageManager.SupportingDocumentPage().Operation().GetModalDialogMessage(),"At least two documents should be uploaded for each applicant to move to the 'Application Summary' screen.");
			ProviderPageManager.SupportingDocumentPage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.SupportingDocumentPage().Operation().ApplyWait(driver);
			Thread.sleep(900);
			ProviderPageManager.SupportingDocumentPage().Elements().UploadFile().click();
			uploadFile(FullPath);
			Thread.sleep(2000);
			DocumentName = Utilities.GetRandomString(10);
			ProviderPageManager.SupportingDocumentPage().Operation().EnterRequiredField(Fname + " " + Lname, "Document Type 2",DocumentName, todayDate);
			ProviderPageManager.SupportingDocumentPage().Elements().SupportingDocumentSaveContinue().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
		} catch (Exception exp) {

			Assert.fail(exp.getMessage());
		}
	}
	     
	     @Test
	     public void DeleteDocument(){
	    	 try{
	    		 DateFormat dateFormat = new SimpleDateFormat("dd");
	 			Date date = new Date();
	 			String todayDate = dateFormat.format(date);
	 			// Enter data in ApplicationType Page and navigate to ApplicationParticipant Page
	 			ProviderPageManager.LoginPage().Operation().Login();
	 			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
	 			ProviderPageManager.ApplicationTypePage().Operation().NavigateAndFillRequiredField();
	 			ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
	 			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
	 			Thread.sleep(1000);
	 			ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
	 			Thread.sleep(1000);

	 			// Enter data in ApplicationParticipant Page and navigate to AddressInformation Page
	 			String Fname = "kumar" + Utilities.GetRandomString(2);
	 			String Lname = "pushyamitra" + Utilities.GetRandomString(2);
	 			ProviderPageManager.ApplicationParticipantPage().Elements().Fname().clear();
	 			ProviderPageManager.ApplicationParticipantPage().Elements().Lname().clear();
	 			ProviderPageManager.ApplicationParticipantPage().Elements().Fname().sendKeys(Fname);
	 			ProviderPageManager.ApplicationParticipantPage().Elements().Lname().sendKeys(Lname);
	 			ProviderPageManager.ApplicationParticipantPage().Elements().SaveContinue().click();
	 			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
	 			Thread.sleep(1000);
	 			ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
	 			Thread.sleep(1000);
	 			ProviderPageManager.AddressInformationPage().Operation().EnterRequiredField();
	 			ProviderPageManager.AddressInformationPage().Elements().AddressSaveButton().click();
	 			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
	 			Thread.sleep(1000);
	 			ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
	 			Thread.sleep(1000);
	 			// Enter data in FosterCare Page and Navigate to PreferencesPage
	 			ProviderPageManager.FosterCarePage().Operation().NavigateAndFillRequiredField();
	 			ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
	 			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
	 			Thread.sleep(1000);
	 			ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
	 			Thread.sleep(1000);
	 			// Enter data in Preferences Page and Navigate to Reference Page
	 			ProviderPageManager.PreferencesPage().Operation().NavigateAndFillRequiredField();
	 			ProviderPageManager.PreferencesPage().Elements().PreferenceSaveContinue().click();
	 			ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
	 			Thread.sleep(1000);
	 			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
	 			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
	 			Thread.sleep(1000);
	 			// Enter data in Reference Page and Navigate to Supporting Document Page
	 			ProviderPageManager.ReferencePage().Operation().EnterApplicant1References();
	 			ProviderPageManager.ReferencePage().Elements().ReferenceSaveContinue().click();
	 			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
	 			Thread.sleep(1000);
	 			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
	 			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
	 			Thread.sleep(2500);
			 String filePath = "../FamilyNow_Provider_Portal_Automation/SupportingDocument/PngTestDocument.png";
			 File file = new File(filePath);
			 String FullPath= file.getCanonicalPath();
			 ProviderPageManager.SupportingDocumentPage().Elements().UploadFile().click();
			 uploadFile(FullPath);
			 Thread.sleep(2000);
			 String DocumentName =Utilities.GetRandomString(10);
			 ProviderPageManager.SupportingDocumentPage().Operation().EnterRequiredField(Fname + " " + Lname, "Document Type 1", DocumentName,todayDate);
			 ProviderPageManager.SupportingDocumentPage().Elements().SupportingDocumentSaveAdd().click();
			 ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			 Thread.sleep(1000);
			 ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			 ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			 Thread.sleep(2000);
			 Assert.assertTrue( ProviderPageManager.SupportingDocumentPage().Operation().IsDocumentAvailable(DocumentName), "Document is not avaiable");
			 ProviderPageManager.SupportingDocumentPage().Operation().DeleteDocument(DocumentName);
			 ProviderPageManager.SupportingDocumentPage().Operation().ApplyWait(driver);
			 Thread.sleep(1000);
			 ProviderPageManager.SupportingDocumentPage().Elements().ConfirmationDialoogOKButton().click();
			 ProviderPageManager.SupportingDocumentPage().Operation().ApplyWait(driver);
			 Thread.sleep(1000);
			 ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			 ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			  Thread.sleep(2000);
			  Assert.assertFalse(ProviderPageManager.SupportingDocumentPage().Operation().IsDocumentAvailable(DocumentName), "Document is not deleted");
			 
			 
	    	 }
	    	 catch (Exception exp) {
	    		 Assert.fail(exp.getMessage());
		        }
	    	 
	     }

}
