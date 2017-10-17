package testScripts;

import general.Browser;
import general.GetConfigValue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageControllers.ProviderPageManager;

public class RefDataTest {
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
	 public void VerifySearchFunctionality(){
		try{
			Thread.sleep(9000);
		}
		 catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}
		 
	 }
	 
	 @Test
	 public void AddRefData(){
		 try{
				Thread.sleep(6000);
			}
		 catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}
		 
	 }
	 
	 @Test
	 public void EditRefData(){
		 try{
				Thread.sleep(10000);
			}
		 catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}
		 
	 }
}
