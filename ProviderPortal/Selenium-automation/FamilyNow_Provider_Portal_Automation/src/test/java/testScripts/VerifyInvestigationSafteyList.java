package testScripts;

import general.Browser;
import general.GetConfigValue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageControllers.ProviderPageManager;

public class VerifyInvestigationSafteyList {
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
	 public void VerifySafteyPlanList(){
		 ProviderPageManager.LoginPage().Operation().Login();
	   	 try{
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);

				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);

				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
				Thread.sleep(1000);
	   	 }
	   	catch (Exception exp) {
        	exp.printStackTrace();
        }
	}	 


}
