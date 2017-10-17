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
import pageControllers.ProviderPageManager;

public class ApplicationTypeTest {
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
		driver.get(GetConfigValue.GetUrl());
		SoftAssert sa = new SoftAssert();
		try {
			
			//Login to Application
			ProviderPageManager.LoginPage().Operation().Login();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			
			// Navigate to ApplicationType Page
			ProviderPageManager.ApplicationTypePage().Operation().NavigateToApplicationTypePage();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			
			// Enter all the required field
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			String todayDate = dateFormat.format(date);
			ProviderPageManager.ApplicationTypePage().Operation().EnterRequiredField("Adoptive Parent", todayDate);
			
			// Navigate to ApplicationParticipant Page
			ProviderPageManager.ApplicationTypePage().Elements().SaveContinue().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			ProviderPageManager.ApplicationParticipantPage().Elements().SuccessDialogOkButton().click();
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			
			// Navigate back to  ApplicationType Page
			ProviderPageManager.AddressInformationPage().Operation().ClickTopLevelMenu("Application Type");
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(200);
			
			// Verify that all the data is correct
			sa.assertEquals(new SimpleDateFormat("MM/dd/yyyy").format(date),ProviderPageManager.ApplicationTypePage().Elements().ApplicationDate().getAttribute("value").trim());
			sa.assertEquals("Adoptive Parent", ProviderPageManager.ApplicationTypePage().Elements().YouCanStartBySelectingApplicationType().getFirstSelectedOption().getText().trim());
			sa.assertAll();
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
