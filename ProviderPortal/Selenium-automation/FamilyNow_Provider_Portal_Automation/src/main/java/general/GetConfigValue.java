package general;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GetConfigValue {
	public static String GetBrowser(){
		String browser = null;
		try{
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
	public static String GetUrl(){
		String Url=null;
		try {
		File src = new File("./src/main/java/Configuration/Config.property");
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);
		Url  = pro.getProperty("Url");
		}
	  
       catch (Exception e){
			
		}
	
		return Url;
	}
	
	public static String MainPortalUrl(){
		String Url=null;
		try {
		File src = new File("./src/main/java/Configuration/Config.property");
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);
		Url  = pro.getProperty("MainPortalUrl");
		}
	  
       catch (Exception e){
			
		}
	
		return Url;
	}

}
