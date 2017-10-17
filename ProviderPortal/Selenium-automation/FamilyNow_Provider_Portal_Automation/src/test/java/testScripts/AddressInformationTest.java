package testScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import general.Browser;
import general.GetConfigValue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageControllers.ProviderPageManager;

public class AddressInformationTest {
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
	public void SaveAddressInformation() {

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
			ProviderPageManager.ApplicationTypePage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			ProviderPageManager.AddressInformationPage().Operation().ClickTopLevelMenu("Application Participants");
			ProviderPageManager.AddressInformationPage().Operation().ApplyWait(driver);
			Thread.sleep(200);
			ProviderPageManager.AddressInformationPage().Operation().ClickTopLevelMenu("Address Information");
			ProviderPageManager.AddressInformationPage().Operation().ApplyWait(driver);
			Thread.sleep(1000);
			Assert.assertEquals("Own", ProviderPageManager.AddressInformationPage().Elements().DoYouOwnRentOrLease().getFirstSelectedOption().getText());
			Assert.assertEquals("Yes", ProviderPageManager.AddressInformationPage().Elements().AreThereBodiesOfWaterNearYourHome().getFirstSelectedOption().getText());
			Assert.assertEquals("Yes", ProviderPageManager.AddressInformationPage().Elements().AreThereWeaponsInHome().getFirstSelectedOption().getText());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
