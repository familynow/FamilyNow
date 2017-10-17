package General;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GetConfigValue  {
			
	
	
	public static String GetBrowser() {
	    
		String browser = null;
		try {
			
		File src = new File("./src/main/java/Configuration/Config.property");
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);
		browser=  pro.getProperty("Browser");
		}
		
		catch (Exception e){
			
		}
	
		return browser;
	}
	
	public static String GetUrl() {

		String Url = null;
		try {
			File src = new File("./src/main/java/Configuration/Config.property");
			FileInputStream fis = new FileInputStream(src);
			Properties pro = new Properties();
			pro.load(fis);
			String test = pro.getProperty("env");
			if (pro.getProperty("env").contains("Test")) {
				Url = pro.getProperty("TestUrl");
			} else if (pro.getProperty("env").contains("Dev")) {
				Url = pro.getProperty("DevUrl");
			} else {
				Url = pro.getProperty("TestUrl");
			}
		}

		catch (Exception e) {

		}

		return Url;
	}
	
	public static String getUserName() {
		String userName = null;
		try {
			File src = new File("./src/main/java/Configuration/Config.property");
			FileInputStream fis = new FileInputStream(src);
			Properties pro = new Properties();
			pro.load(fis);
			userName = pro.getProperty("UserName");
          
		} catch (Exception e) {

		}
		return userName;

	}
	
}
