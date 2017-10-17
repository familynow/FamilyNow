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

public class ApplicationParticipantTest {
	
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
	public void SaveApplicationType() {
		ProviderPageManager.LoginPage().Operation().Login();
		SoftAssert sa = new SoftAssert();
		try {
			// Navigate to Profile page and get the profile info 
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			ProviderPageManager.PersonProfilePage().Operation().NavigateToProfilePage();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(700);
			String FirstName = ProviderPageManager.PersonProfilePage().Elements().Fname().getAttribute("value").trim();
			String LastName = ProviderPageManager.PersonProfilePage().Elements().Lname().getAttribute("value").trim();
			String Gender = ProviderPageManager.PersonProfilePage().Elements().Gender().getFirstSelectedOption().getText().trim();
			String DOB = ProviderPageManager.PersonProfilePage().Elements().DOB().getAttribute("value").trim();
			String Race = ProviderPageManager.PersonProfilePage().Elements().Race().getFirstSelectedOption().getText().trim();
			String HighestEducation = ProviderPageManager.PersonProfilePage().Elements().HeighestEducation().getFirstSelectedOption().getText().trim();
			String HomeMobilePhone = ProviderPageManager.PersonProfilePage().Elements().Mobile().getAttribute("value").trim();
			String EmployerName = ProviderPageManager.PersonProfilePage().Elements().EmployerName().getAttribute("value").trim();
			String EmployerAddressLine1 = ProviderPageManager.PersonProfilePage().Elements().EmployerAddressLine1().getAttribute("value").trim();
			String EmployerAddressLine2 = ProviderPageManager.PersonProfilePage().Elements().EmployerAddressLine2().getAttribute("value").trim();
			String EmployerCity = ProviderPageManager.PersonProfilePage().Elements().EmployerCity().getAttribute("value").trim();
			String EmployerState = ProviderPageManager.PersonProfilePage().Elements().EmployerState().getFirstSelectedOption().getText().trim();
			String EmployerZip = ProviderPageManager.PersonProfilePage().Elements().EmployerZip().getAttribute("value").trim();
			String EmployerWorkPhone = ProviderPageManager.PersonProfilePage().Elements().EmployerWorkPhone().getAttribute("value").trim();
			String Occupation = ProviderPageManager.PersonProfilePage().Elements().Occupation().getAttribute("value").trim();
			String AnnualIncome = ProviderPageManager.PersonProfilePage().Elements().AnnualIncome().getFirstSelectedOption().getText().trim();
			boolean profilepageEmployedCheckbox = ProviderPageManager.PersonProfilePage().Operation().IsUnemployedChecked();
			Thread.sleep(1000);
			ProviderPageManager.PersonProfilePage().Elements().ProfileCancelButton().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			
			// Enter data in ApplicationType Page and navigate to ApplicationParticipantPage
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			String todayDate = dateFormat.format(date);
			Thread.sleep(3000);
			ProviderPageManager.ApplicationTypePage().Operation().NavigateAndFillRequiredField();
			ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
			Thread.sleep(1000);
			
			// Verify Applicant 1 data displaying correctly
			sa.assertEquals("Applicant 1", ProviderPageManager.ApplicationParticipantPage().Elements().ApplicantRole().getFirstSelectedOption().getText());
			sa.assertEquals(FirstName, ProviderPageManager.ApplicationParticipantPage().Elements().Fname().getAttribute("value").trim());
			sa.assertEquals(LastName, ProviderPageManager.ApplicationParticipantPage().Elements().Lname().getAttribute("value").trim());
			sa.assertEquals(Gender, ProviderPageManager.ApplicationParticipantPage().Elements().Gender().getFirstSelectedOption().getText().trim());
			sa.assertEquals(DOB, ProviderPageManager.ApplicationParticipantPage().Elements().DOB().getAttribute("value").trim());
			sa.assertEquals(Race, ProviderPageManager.ApplicationParticipantPage().Elements().Race().getFirstSelectedOption().getText().trim());
			sa.assertEquals(HighestEducation, ProviderPageManager.ApplicationParticipantPage().Elements().HighestLevelofEducationCompleted().getFirstSelectedOption().getText().trim());
			sa.assertEquals(HomeMobilePhone, ProviderPageManager.ApplicationParticipantPage().Elements().HomeMobilePhone().getAttribute("value").trim());
			ProviderPageManager.ApplicationParticipantPage().Operation().Expand();
			Thread.sleep(500);

			if (profilepageEmployedCheckbox) {
				sa.assertTrue(ProviderPageManager.ApplicationParticipantPage().Operation().IsUnemployedChecked(),"UnEmployed check box is not Checked");

			}

			else {
				sa.assertEquals(EmployerName, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerName().getAttribute("value").trim());
				sa.assertEquals(EmployerAddressLine1, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerAddressLine1().getAttribute("value").trim());
				sa.assertEquals(EmployerAddressLine2, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerAddressLine2().getAttribute("value").trim());
				sa.assertEquals(EmployerAddressLine2, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerAddressLine2().getAttribute("value").trim());
				sa.assertEquals(EmployerCity, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerCity().getAttribute("value").trim());
				sa.assertEquals(EmployerState, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerState().getFirstSelectedOption().getText().trim());
				sa.assertEquals(EmployerZip, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerZip().getAttribute("value").trim());
				sa.assertEquals(EmployerWorkPhone, ProviderPageManager.ApplicationParticipantPage().Elements().EmployerWorkPhone().getAttribute("value").trim());
				sa.assertEquals(Occupation, ProviderPageManager.ApplicationParticipantPage().Elements().Occupation().getAttribute("value").trim());
				sa.assertEquals(AnnualIncome, ProviderPageManager.ApplicationParticipantPage().Elements().AnnualIncome().getFirstSelectedOption().getText().trim());
			}

			ProviderPageManager.ApplicationParticipantPage().Elements().SaveAddButton().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Assert.assertTrue(ProviderPageManager.ApplicationParticipantPage().Operation().IsParticipantAvailable(LastName + ", " + FirstName),"Applicant1 is not added");
			// Add Second Applicant
			String Fname = Utilities.GetRandomString(10);
			String Lname = Utilities.GetRandomString(10);
			ProviderPageManager.ApplicationParticipantPage().Operation().EnterRequiredField("Applicant 2", Fname, Lname, "Male",todayDate, "Asian","Attended or graduated from technical school","1111111111");
			ProviderPageManager.ApplicationParticipantPage().Elements().SaveAddButton().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(500);
			ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(500);
			// Verify Applicant Information is saved correctly 
			Assert.assertTrue(ProviderPageManager.ApplicationParticipantPage().Operation().IsParticipantAvailable(Lname + ", " + Fname),"Applicant2 is not added");
			ProviderPageManager.ApplicationParticipantPage().Operation().CilckParticipantId(Lname + ", " + Fname);
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(500);
			sa.assertEquals(Fname, ProviderPageManager.ApplicationParticipantPage().Elements().Fname().getAttribute("value").trim());
			sa.assertEquals(Lname, ProviderPageManager.ApplicationParticipantPage().Elements().Lname().getAttribute("value").trim());
			sa.assertEquals("Male", ProviderPageManager.ApplicationParticipantPage().Elements().Gender().getFirstSelectedOption().getText().trim());
			sa.assertEquals(new SimpleDateFormat("MM/dd/yyyy").format(date),ProviderPageManager.ApplicationParticipantPage().Elements().DOB().getAttribute("value").trim());
			sa.assertEquals("Asian", ProviderPageManager.ApplicationParticipantPage().Elements().Race().getFirstSelectedOption().getText().trim());
			sa.assertEquals("Attended or graduated from technical school",ProviderPageManager.ApplicationParticipantPage().Elements().HighestLevelofEducationCompleted().getFirstSelectedOption().getText().trim());
			sa.assertEquals("111-111-1111", ProviderPageManager.ApplicationParticipantPage().Elements().HomeMobilePhone().getAttribute("value").trim());
			sa.assertAll();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void VerifyRequiredFieldValidation() {
		SoftAssert s_assert = new SoftAssert();
		ProviderPageManager.LoginPage().Operation().Login();
		try {
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			
			// Enter data in ApplicationType Page and navigate to ApplicationParticipant Page
			Thread.sleep(3000);
			ProviderPageManager.ApplicationTypePage().Operation().NavigateAndFillRequiredField();
			ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
			Thread.sleep(1000);
			// Verify required field message
			ProviderPageManager.ApplicationParticipantPage().Elements().ClearButton().click();
			ProviderPageManager.ApplicationParticipantPage().Elements().SaveAddButton().click();
			s_assert.assertTrue(ProviderPageManager.ApplicationParticipantPage().Operation().VerifyRequiredFieldWarningMessage("Applicant Role is a required field"),"Applicant Role required field validation message is not displayed");
			ProviderPageManager.ApplicationParticipantPage().Operation().SelectApplicantRole("Applicant 1");
			ProviderPageManager.ApplicationParticipantPage().Elements().Fname().clear();
			ProviderPageManager.ApplicationParticipantPage().Elements().SaveAddButton().click();
			s_assert.assertTrue(ProviderPageManager.ApplicationParticipantPage().Operation().VerifyRequiredFieldWarningMessage("First Name is a required field"),"First Name required field validation message is not displayed");
			ProviderPageManager.ApplicationParticipantPage().Elements().Fname().sendKeys("Martin");
			ProviderPageManager.ApplicationParticipantPage().Elements().Lname().clear();
			ProviderPageManager.ApplicationParticipantPage().Elements().SaveAddButton().click();
			s_assert.assertTrue(ProviderPageManager.ApplicationParticipantPage().Operation().VerifyRequiredFieldWarningMessage("Last Name is a required field"),"Last Name required field validation message is not displayed");
			ProviderPageManager.ApplicationParticipantPage().Elements().Lname().sendKeys("Martin");
			ProviderPageManager.ApplicationParticipantPage().Elements().DOB().clear();
			ProviderPageManager.ApplicationParticipantPage().Elements().SaveAddButton().click();
			s_assert.assertAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
		@Test
	public void VerifyUnEmployedCheckBox(){
		SoftAssert sa = new SoftAssert();
		ProviderPageManager.LoginPage().Operation().Login();
		try {
			Thread.sleep(3000);
			ProviderPageManager.ApplicationTypePage().Operation().NavigateAndFillRequiredField();
			ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
			Thread.sleep(1000);
			ProviderPageManager.ApplicationParticipantPage().Operation().Expand();
	        Thread.sleep(500);
	        // Verify all the value is cleared when Unemployed CheckBox 
	        if(!ProviderPageManager.ApplicationParticipantPage().Operation().IsUnemployedChecked()){
	        	ProviderPageManager.ApplicationParticipantPage().Elements().UnemployedCheckBox().click();
	        	sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerName().getAttribute("value").trim());
				sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerAddressLine1().getAttribute("value").trim());
				sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerAddressLine2().getAttribute("value").trim());
				sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerAddressLine2().getAttribute("value").trim());
				sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerCity().getAttribute("value").trim());
				sa.assertEquals("Select", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerState().getFirstSelectedOption().getText().trim());
				sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerZip().getAttribute("value").trim());
				sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().EmployerWorkPhone().getAttribute("value").trim());
				sa.assertEquals("", ProviderPageManager.ApplicationParticipantPage().Elements().Occupation().getAttribute("value").trim());
				sa.assertEquals("Select", ProviderPageManager.ApplicationParticipantPage().Elements().AnnualIncome().getFirstSelectedOption().getText().trim());
	        	
	        	
	        }
	        
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void CreatedApplicationInApplicationPage()
			throws InterruptedException {
		SoftAssert sa = new SoftAssert();
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
		ProviderPageManager.ApplicationParticipantPage().Elements().SaveAddButton().click();
		ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		ProviderPageManager.AddressInformationPage().Elements().SuccessDialogOkButton().click();
		ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
		Thread.sleep(1000);
		ProviderPageManager.ApplicationParticipantPage().Elements().CancelButton().click();
		ProviderPageManager.MyApplicationPage().Operation().ApplyWait(driver);
		Thread.sleep(1000);
		sa.assertTrue(ProviderPageManager.MyApplicationPage().Operation().IsColumnAvailabeInApplicationGrid(Lname + ", " + Fname, Lname + ", " + Fname),"Application is not displaying");
		sa.assertTrue(ProviderPageManager.MyApplicationPage().Operation().IsColumnAvailabeInApplicationGrid(Lname + ", " + Fname, "Pending Inquiry"),"Application status is not correct");
	}


}
