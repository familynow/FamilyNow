package testScripts;

import general.Browser;
import general.GetConfigValue;
import general.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageControllers.ProviderPageManager;

public class ApplicationSummaryTest {
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
	 public void VerifyApplicationSummary(){
		 SoftAssert sa = new SoftAssert();
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		 Date date = new Date();
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
			    String Address =ProviderPageManager.AddressInformationPage().Operation().EnterRequiredField();
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
				Thread.sleep(3000);
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetApplicationType().contains("Adoptive Parent"), "Application Type is not correct");
				sa.assertEquals(new SimpleDateFormat("MM/dd/yyyy").format(date),ProviderPageManager.ApplicationSummaryPage().Operation().GetApplicationDate());
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetAddressDetail().contains(Address), "Address is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetRentInfo().contains("Own"), "Rent info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetWeponInfo().contains("Yes"), "Wepon Info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetWaterInfo().contains("Yes"), "Water Info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetAppliedForAdoptionInfo().contains("No"), "Applied for adoption info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetLicensedForFosterCareInfo().contains("No"), "Licensed for FosterCare Info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetChildIdentifiedInfo().contains("No"), "Child Identified Info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetAgeInfo().contains("10 - 15 Years"), "Age Info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetGenderInfo().contains("Both"), "Gender Info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().GetEthinicityInfo().contains("Asian"), "Ethinicity Info is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().IsColumnAvailable("Male"), "Application participant detail is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().IsColumnAvailable("0"), "Application participant detail is not correct");
				sa.assertTrue(ProviderPageManager.ApplicationSummaryPage().Operation().IsColumnAvailable("Applicant 1"), "Application participant detail is not correct");
			 
			 
		 }
		 
		 catch (Exception exp) {

				Assert.fail(exp.getMessage());
			}
	 }
	 
	 @Test
	 public void VerifySubmittedApplication(){
		 SoftAssert sa = new SoftAssert();
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		 Date date = new Date();
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
				Thread.sleep(2000);
				ProviderPageManager.ApplicationSummaryPage().Elements().ClickOK().click();
				ProviderPageManager.ApplicationSummaryPage().Operation().ApplyWait(driver);
				Thread.sleep(1000);
				ProviderPageManager.ApplicationSummaryPage().Elements().CloseButton().click();
				ProviderPageManager.ApplicationSummaryPage().Operation().ApplyWait(driver);
				Thread.sleep(1000);
				sa.assertTrue(ProviderPageManager.MyApplicationPage().Operation().IsColumnAvailabeInApplicationGrid(Lname + ", " + Fname, "Submitted"),"Application Status is not updated");
				sa.assertFalse(ProviderPageManager.MyApplicationPage().Operation().IsDeleteIconAvailabe(Lname + ", " + Fname),"Submitted Application can be deleted");
				sa.assertAll();
			 
			 
		 }
		 
		 catch (Exception exp) {

				Assert.fail(exp.getMessage());
			}
	 }

}
