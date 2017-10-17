package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
public static WebDriver driver;
	
	public static WebDriver getBrowser(String browserType) {
	
		String value = browserType;
		if ("firefox".equals(value )) {
			return	driver = new FirefoxDriver();
		}
		else if ("chrome".equals(value )) {
			return	driver = new ChromeDriver();
		}
		else if ("IE".equals(value )) {
			return	driver = new InternetExplorerDriver();
		}
		else {
			return driver = new FirefoxDriver();
		}
		
		
	}

}
