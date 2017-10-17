package testScripts;

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

import general.Browser;
import general.GetConfigValue;
import general.Utilities;
import pageControllers.ProviderPageManager;

public class ReferenceTest {
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
	public void SaveReference() {
		try {

			SoftAssert sa = new SoftAssert();
			// Enter data in ApplicationType Page and navigate to ApplicationParticipan tPage
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
			Thread.sleep(2000);

			// Enter data in Preferences Page and Navigate to Reference Page
			ProviderPageManager.PreferencesPage().Operation().NavigateAndFillRequiredField();
			ProviderPageManager.PreferencesPage().Elements().PreferenceSaveContinue().click();
			ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			String App1ReferenceName1 = Utilities.GetRandomString(10);
			ProviderPageManager.ReferencePage().Elements().App1ReferenceName1().sendKeys(App1ReferenceName1);
			ProviderPageManager.ReferencePage().Elements().ReferenceSaveContinue().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(900);
			Assert.assertEquals(ProviderPageManager.ReferencePage().Operation().GetModalDialogMessage(),"Information saved successfully. All the references have to be entered to continue to 'Supporting Documentation' screen.");
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(900);
			ProviderPageManager.ReferencePage().Elements().App1Contact1().click();
			ProviderPageManager.ReferencePage().Elements().App1Contact1().sendKeys("111-111-1111");
			ProviderPageManager.ReferencePage().Elements().ReferenceSaveContinue().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(900);
			Assert.assertEquals(ProviderPageManager.ReferencePage().Operation().GetModalDialogMessage(),"Information saved successfully. All the references have to be entered to continue to 'Supporting Documentation' screen.");
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			String App1ReferenceName2 = Utilities.GetRandomString(10);
			Thread.sleep(900);
			ProviderPageManager.ReferencePage().Elements().App1ReferenceName2().sendKeys(App1ReferenceName2);
			ProviderPageManager.ReferencePage().Elements().App1Contact2().click();
			ProviderPageManager.ReferencePage().Elements().App1Contact2().sendKeys("222-222-2222");
			String App1ReferenceName3 = Utilities.GetRandomString(10);

			ProviderPageManager.ReferencePage().Elements().App1ReferenceName3().sendKeys(App1ReferenceName3);
			ProviderPageManager.ReferencePage().Elements().App1Contact3().click();
			ProviderPageManager.ReferencePage().Elements().App1Contact3().sendKeys("333-333-3333");
			ProviderPageManager.ReferencePage().Elements().ReferenceSaveContinue().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			ProviderPageManager.FosterCarePage().Operation().ClickNavigationWizard("References");
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(900);
			sa.assertTrue(ProviderPageManager.ReferencePage().Elements().App1ReferenceName1().getAttribute("value").contains(App1ReferenceName1),"Reference Name1 is not Saved");
			sa.assertTrue(ProviderPageManager.ReferencePage().Elements().App1ReferenceName2().getAttribute("value").contains(App1ReferenceName2),"Reference Name2 is not Saved");
			sa.assertTrue(ProviderPageManager.ReferencePage().Elements().App1ReferenceName3().getAttribute("value").contains(App1ReferenceName3),"Reference Name3 is not Saved");
			sa.assertTrue(ProviderPageManager.ReferencePage().Elements().App1Contact1().getAttribute("value").contains("111-111-1111"), "Contact 1 is not Saved");
			sa.assertTrue(ProviderPageManager.ReferencePage().Elements().App1Contact2().getAttribute("value").contains("222-222-2222"), "Contact 2 is not Saved");
			sa.assertTrue(ProviderPageManager.ReferencePage().Elements().App1Contact3().getAttribute("value").contains("333-333-3333"), "Contact 2 is not Saved");
			sa.assertAll();

		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	@Test
	public void DeleteApplicant() {
		try {
			SoftAssert sa = new SoftAssert();
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			String todayDate = dateFormat.format(date);
			// Enter data in ApplicationType Page and navigate to
			// ApplicationParticipan tPage
			ProviderPageManager.LoginPage().Operation().Login();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			ProviderPageManager.ApplicationTypePage().Operation()
					.NavigateAndFillRequiredField();
			ProviderPageManager.ApplicationTypePage().Elements().SaveContinue()
					.click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ApplicationParticipantPage().Elements()
					.SuccessDialogOkButton().click();
			Thread.sleep(1000);
			// Enter data in ApplicationParticipant Page and navigate to
			// AddressInformation Page
			String Fname = "kumar" + Utilities.GetRandomString(2);
			String Lname = "pushyamitra" + Utilities.GetRandomString(2);
			String name = Lname + ", " + Fname;
			ProviderPageManager.ApplicationParticipantPage().Elements().Fname()
					.clear();
			ProviderPageManager.ApplicationParticipantPage().Elements().Lname()
					.clear();
			ProviderPageManager.ApplicationParticipantPage().Elements().Fname()
					.sendKeys(Fname);
			ProviderPageManager.ApplicationParticipantPage().Elements().Lname()
					.sendKeys(Lname);
			ProviderPageManager.ApplicationParticipantPage().Elements()
					.SaveAddButton().click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			ProviderPageManager.AddressInformationPage().Elements()
					.SuccessDialogOkButton().click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			Assert.assertTrue(ProviderPageManager.ApplicationParticipantPage()
					.Operation().IsParticipantAvailable(name),
					"Applicant1 is not added");
			// Add Second Applicant
			String App2Fname = Utilities.GetRandomString(10);
			String App2Lname = Utilities.GetRandomString(10);
			String App2Name = App2Lname + ", " + App2Fname;
			ProviderPageManager
					.ApplicationParticipantPage()
					.Operation()
					.EnterRequiredField("Applicant 2", App2Fname, App2Lname,
							"Male", todayDate, "Asian",
							"Attended or graduated from technical school",
							"1111111111");
			ProviderPageManager.ApplicationParticipantPage().Elements()
					.SaveContinue().click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.AddressInformationPage().Elements()
					.SuccessDialogOkButton().click();
			Thread.sleep(1000);
			ProviderPageManager.AddressInformationPage().Operation()
					.EnterRequiredField();
			ProviderPageManager.AddressInformationPage().Elements()
					.AddressSaveButton().click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			Thread.sleep(1000);

			ProviderPageManager.FosterCarePage().Elements()
					.SuccessDialogOkButton().click();
			Thread.sleep(1000);

			// Enter data in FosterCare Page and Navigate to PreferencesPage
			ProviderPageManager.FosterCarePage().Operation()
					.NavigateAndFillRequiredField();
			ProviderPageManager.FosterCarePage().Elements().FosterSave()
					.click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.FosterCarePage().Elements()
					.SuccessDialogOkButton().click();
			Thread.sleep(2000);

			// Enter data in Preferences Page and Navigate to Reference Page
			ProviderPageManager.PreferencesPage().Operation()
					.NavigateAndFillRequiredField();
			ProviderPageManager.PreferencesPage().Elements()
					.PreferenceSaveContinue().click();
			ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ReferencePage().Elements()
					.SuccessDialogOkButton().click();
			ProviderPageManager.ReferencePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);

			sa.assertEquals(ProviderPageManager.ReferencePage().Operation()
					.GetApplicant1Name(), name + " (Applicant 1)");
			sa.assertEquals(ProviderPageManager.ReferencePage().Operation()
					.GetApplicant2Name(), App2Name + " (Applicant 2)");

			ProviderPageManager.ReferencePage().Elements().ReferencePrevious()
					.click();
			ProviderPageManager.AddressInformationPage().Operation()
					.ApplyWait(driver);
			Thread.sleep(500);
			ProviderPageManager.PreferencesPage().Elements()
					.PreferencePrevious().click();
			ProviderPageManager.AddressInformationPage().Operation()
					.ApplyWait(driver);
			Thread.sleep(500);
			ProviderPageManager.FosterCarePage().Elements().FosterPrevious()
					.click();
			ProviderPageManager.AddressInformationPage().Operation()
					.ApplyWait(driver);
			Thread.sleep(500);
			ProviderPageManager.AddressInformationPage().Elements()
					.PreviousButton().click();

			ProviderPageManager.AddressInformationPage().Operation()
					.ApplyWait(driver);
			Thread.sleep(500);
			ProviderPageManager.ApplicationParticipantPage().Operation()
					.DeleteApplicant(App2Name);
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			ProviderPageManager.ApplicationTypePage().Operation()
					.ConfirmationDialoogOKButton().click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			ProviderPageManager.ReferencePage().Elements()
					.SuccessDialogOkButton().click();
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			ProviderPageManager.ApplicationTypePage().Operation()
					.ClickNavigationWizard("References");
			ProviderPageManager.ApplicationTypePage().Operation()
					.ApplyWait(driver);
			sa.assertFalse(ProviderPageManager.ReferencePage().Operation()
					.IsApplicantAvailable(App2Name),
					"Applicant 2 is not deleted");
			sa.assertAll();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
