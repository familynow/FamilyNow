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

import general.Browser;
import general.GetConfigValue;
import general.Utilities;
import pageControllers.ProviderPageManager;

public class FosterCareTest {
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
	 public void SaveQuestionnaire(){
		 try {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String todayDate = dateFormat.format(date);	
		 ProviderPageManager.LoginPage().Operation().Login();
		 Thread.sleep(2000);
		// Enter data in ApplicationType Page and navigate to ApplicationParticipantPage
		ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
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
		
		/* ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
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
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 ProviderPageManager.AddressInformationPage().Operation().SelectRentLease("Own");
	     ProviderPageManager.AddressInformationPage().Operation().SelectWeponInfo("Yes");
	     ProviderPageManager.AddressInformationPage().Operation().SelectWaterNearYourHome("Yes");
	     ProviderPageManager.AddressInformationPage().Elements().AddressSaveButton().click();
	     ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();*/
		 ProviderPageManager.FosterCarePage().Operation().ClickNavigationWizard("Foster Care/ Adoption History");
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(1000);
		 ProviderPageManager.FosterCarePage().Elements().Adoption().selectByVisibleText("Yes");
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(1000);
		 ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(1000);
		 ProviderPageManager.FosterCarePage().Elements().FosterSaveContinue().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertEquals("Information saved successfully. To continue to next screen, please answer all the questions.",    ProviderPageManager.FosterCarePage().Operation().GetModalDialogMessage());
		 Thread.sleep(1000);
		 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
		 Thread.sleep(600);
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 ProviderPageManager.FosterCarePage().Elements().Fostercare().selectByVisibleText("Yes");
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(1000);
		 ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
		 Thread.sleep(1000);
		 ProviderPageManager.FosterCarePage().Elements().FosterSaveContinue().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(900);
		 Assert.assertEquals("Information saved successfully. To continue to next screen, please answer all the questions.",    ProviderPageManager.FosterCarePage().Operation().GetModalDialogMessage());
		 ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(1000);
		 ProviderPageManager.FosterCarePage().Elements().ChildIdentifiedCode().selectByVisibleText("Yes");
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please enter the First Name of the identified Child before saving the record."), "First Name is not a required field");
		 String ChildFname =Utilities.GetRandomString(10);
		 ProviderPageManager.FosterCarePage().Elements().Fname().sendKeys(ChildFname);
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 String ChildMname =Utilities.GetRandomString(10);
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please enter the Middle Name of the identified Child before saving the record."), "Middle Name is not a required field");
		 ProviderPageManager.FosterCarePage().Elements().Mname().sendKeys(ChildMname);
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click(); 
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please enter the Last Name of the identified Child before saving the record."), "Last Name is not a required field");
		 String ChildLname =Utilities.GetRandomString(10);
		 ProviderPageManager.FosterCarePage().Elements().Lname().sendKeys(ChildLname);
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click(); 
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please enter the Gender of the identified Child before saving the record."), "Gender is not a required field");
		 ProviderPageManager.FosterCarePage().Elements().Gender().selectByVisibleText("Male");
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please enter the Race of the identified Child before saving the record."), "Race is not a required field");
		 ProviderPageManager.FosterCarePage().Elements().Race().selectByVisibleText("Asian");
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please enter the Date of Birth of the identified Child before saving the record."), "DOB is not a required field");
		 ProviderPageManager.FosterCarePage().Operation().DateOfBirth(todayDate);
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please enter the Relationship of the Applicant with the identified Child before saving the record."), "Relationship is not a required field");
		 ProviderPageManager.FosterCarePage().Elements().Relationship().selectByVisibleText("Brother");
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Assert.assertTrue( ProviderPageManager.FosterCarePage().Operation().VerifyRequiredFieldWarningMessage("Please select Yes if the Child is currently in home."), "CurrentlyHome is not a required field");
		 ProviderPageManager.FosterCarePage().Elements().CurrentlyHome().selectByVisibleText("Yes");
		 ProviderPageManager.FosterCarePage().Elements().FosterSave().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(1000);
		 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(1000);
		 ProviderPageManager.FosterCarePage().Elements().FosterSaveContinue().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 ProviderPageManager.FosterCarePage().Elements().SuccessDialogOkButton().click();
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 ProviderPageManager.FosterCarePage().Operation().ClickNavigationWizard("Foster Care/ Adoption History");
		 ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		 Thread.sleep(3000);
		  Assert.assertTrue(ProviderPageManager.FosterCarePage().Elements().Fname().getAttribute("value").contains(ChildFname),"First Name is not Saved");
		  Assert.assertTrue(ProviderPageManager.FosterCarePage().Elements().Mname().getAttribute("value").contains(ChildMname),"Middle Name is not Saved");
		  Assert.assertTrue(ProviderPageManager.FosterCarePage().Elements().Lname().getAttribute("value").contains(ChildLname),"Last Name is not Saved");
		  Assert.assertEquals("Male",    ProviderPageManager.FosterCarePage().Elements().Gender().getFirstSelectedOption().getText());
		  Assert.assertEquals("Asian",    ProviderPageManager.FosterCarePage().Elements().Race().getFirstSelectedOption().getText());
		  Assert.assertEquals("Brother",    ProviderPageManager.FosterCarePage().Elements().Relationship().getFirstSelectedOption().getText());
		  Assert.assertEquals("Yes",    ProviderPageManager.FosterCarePage().Elements().CurrentlyHome().getFirstSelectedOption().getText());
		 
		 }
		 
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	      
	 }

}
