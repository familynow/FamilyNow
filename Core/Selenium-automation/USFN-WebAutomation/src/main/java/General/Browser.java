package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.IntakeListPage;
import Pages.Elements.CpsAddParticipanElement;
import Pages.Elements.CpsListParticipantElement;
import Pages.Elements.CreateCpsElement;
import Pages.Elements.IntakeListElement;
import Pages.Elements.LoginElement;
import Pages.Elements.MyOrganizerElement;
import Pages.Elements.PersonSearchElement;

public class Browser {
	
	public static WebDriver driver;
	private static String fileSeperator = System.getProperty("file.separator");
	public static WebDriver getBrowser(String browserType){
		String value = browserType;
		if ("firefox".equals(value )) {
			return	driver = new FirefoxDriver();
		}
		else if ("chrome".equals(value )) {
			String chromeDriverPath ="resources"+ fileSeperator + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			return	driver = new ChromeDriver();
		}
		else if ("IE".equals(value )) {
		
			String ieDriverPath ="resources"+ fileSeperator + "IEDriverServer.exe";
			 System.setProperty("webdriver.ie.driver", ieDriverPath);
			 
			 // Create the DesiredCapability object of InternetExplorer
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 // Settings to Accept the SSL Certificate in the Capability object
			 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			return	driver = new InternetExplorerDriver(capabilities);
		}
		else {
			
			
			return driver = new FirefoxDriver();
		}
	}
	
}
