package testScripts;

import general.Browser;
import general.GetConfigValue;

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

public class PreferenceTest {
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
	 public void SavePreference(){
		 try {
			 ProviderPageManager.LoginPage().Operation().Login();
				Thread.sleep(3000);
				ProviderPageManager.ApplicationTypePage().Operation().NavigateAndFillRequiredField();
				ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
				ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
				Thread.sleep(1000);
				ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
				Thread.sleep(1000);
				ProviderPageManager.ApplicationParticipantPage().Elements().SaveContinue().click();
				ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
				Thread.sleep(1000);
				ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
				ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
				Thread.sleep(1000);
				ProviderPageManager.AddressInformationPage().Operation().EnterRequiredField();
				ProviderPageManager.AddressInformationPage().Elements().AddressSaveButton().click();
				ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
				Thread.sleep(1000);
				
				ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
				Thread.sleep(1000);
				
				// Enter data in FosterCare Page and Navigate to PreferencesPage
				ProviderPageManager.FosterCarePage().Operation().NavigateAndFillRequiredField();
				ProviderPageManager.FosterCarePage().Elements().FosterSaveContinue().click();
				ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
				Thread.sleep(1000);
				ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
				Thread.sleep(1000);
				
			/*  ProviderPageManager.LoginPage().Operation().Login();
			  ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			 ProviderPageManager.ApplicationTypePage().Operation().NavigateToApplicationTypePage();
			 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			 DateFormat dateFormat = new SimpleDateFormat("dd");
			 Date date = new Date();
			 String todayDate = dateFormat.format(date);
			 ProviderPageManager.ApplicationTypePage().Operation().EnterRequiredField("Adoptive Parent", todayDate);
			 ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
			 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			 ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
			 String Fname ="Martin";
			 String Lname ="Sommer";
			 String name =Lname+ ", "+Fname;
	         ProviderPageManager.ApplicationParticipantPage().Operation().EnterRequiredField("Applicant 1", Fname, Lname, "Male", todayDate, "Asian", "Attended or graduated from technical school", "1111111111");
	         ProviderPageManager.ApplicationParticipantPage().Elements().SaveContinue().click();
	    	 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			 ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
			 ProviderPageManager.AddressInformationPage().Operation().SelectRentLease("Own");
		     ProviderPageManager.AddressInformationPage().Operation().SelectWeponInfo("Yes");
		     ProviderPageManager.AddressInformationPage().Operation().SelectWaterNearYourHome("Yes");
		     ProviderPageManager.AddressInformationPage().Elements().AddressSaveButton().click();
		     ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
			 ProviderPageManager.FosterCarePage().Operation().ClickNavigationWizard("Foster Care/ Adoption History");
			 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			 ProviderPageManager.FosterCarePage().Elements().Adoption().selectByVisibleText("No");
			 ProviderPageManager.FosterCarePage().Elements().Fostercare().selectByVisibleText("No");
			 ProviderPageManager.FosterCarePage().Elements().ChildIdentifiedCode().selectByVisibleText("No");
			 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
			 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
			 ProviderPageManager.FosterCarePage().Operation().ApplyWait(driver);
			 ProviderPageManager.FosterCarePage().Operation().ClickNavigationWizard("Preferences");
			 ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			 Thread.sleep(500);*/
			 
			 //
			 ProviderPageManager.PreferencesPage().Elements().MinAge().clear();
			 ProviderPageManager.PreferencesPage().Elements().MinAge().sendKeys("12");
			 ProviderPageManager.PreferencesPage().Elements().MaxAge().clear();
			 ProviderPageManager.PreferencesPage().Elements().MaxAge().sendKeys("10");
			 ProviderPageManager.PreferencesPage().Elements().PreferenceSave().click();
			 ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			 Thread.sleep(1000);
			 Assert.assertTrue(ProviderPageManager.PreferencesPage().Operation().VerifyWarningMessage("Minimum Age cannot be greater than or equals to Maximum Age."),"User can enter Min age >Max age");
			 ProviderPageManager.PreferencesPage().Elements().MaxAge().clear();
			 ProviderPageManager.PreferencesPage().Elements().MaxAge().sendKeys("15");
			 ProviderPageManager.PreferencesPage().Elements().PreferenceSave().click();
			 Thread.sleep(1000);
			 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
			 ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			 Thread.sleep(1000);
			 ProviderPageManager.PreferencesPage().Elements().PreferenceSaveContinue().click();
			 ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			 Thread.sleep(1000);
			 Assert.assertEquals( ProviderPageManager.FosterCarePage().Elements().DialogMessge(),"Information saved successfully. To continue to 'References' screen, all Preferences information has to be entered.");
			 String[] Race = new String[]{"Asian"};
			 ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			 Thread.sleep(500);
			 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
			 ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			 Thread.sleep(2000);
			 ProviderPageManager.PreferencesPage().Operation().SelectRace(Race);
			 ProviderPageManager.PreferencesPage().Elements().PreferenceSaveContinue().click();
			 ProviderPageManager.PreferencesPage().Operation().ApplyWait(driver);
			 ProviderPageManager.ReferencePage().Elements().SuccessDialogOkButton().click();
			 
			 
			 
			 
			 
		 }
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }

}
