package testScripts;

import general.Browser;
import general.GetConfigValue;
import general.Utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageControllers.ProviderPageManager;

public class ProviderToMainMapping {
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
	public void VerifyProviderDisplayedInMainApplication() throws IOException {
		try {
			
			// Enter data in ApplicationType Page and navigate to ApplicationParticipantPage
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
			Thread.sleep(2000);
			
			// Upload Supporting document page and Navigate to Application Summary Page
			ProviderPageManager.SupportingDocumentPage().Operation().UploadDocumentWithRequiredFieldAndNavigate(Fname, Lname);
			ProviderPageManager.ApplicationSummaryPage().Operation().ApplyWait(driver);
			ProviderPageManager.ApplicationSummaryPage().Elements().SubmitButton().click();
			ProviderPageManager.ApplicationSummaryPage().Operation().ApplyWait(driver);
			Thread.sleep(3000);
			ProviderPageManager.ApplicationSummaryPage().Elements().ClickOK().click();
			ProviderPageManager.ApplicationSummaryPage().Operation().ApplyWait(driver);
			Thread.sleep(3000);
			
			// Navigate to Main application and Verify Inquiry is visible
			ProviderPageManager.InquirySearchPage().Operation().Login();
			ProviderPageManager.InquirySearchPage().Operation().NavigateToInquirySearchPage();
			Thread.sleep(500);
			ProviderPageManager.InquirySearchPage().Operation().SearhInquiry(Fname,Lname);
			Thread.sleep(1000);
			Assert.assertTrue(ProviderPageManager.InquirySearchPage().Operation().IsInquiryAvailable(Lname + ", " + Fname),"Inquiry is not imported from provider portal");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
