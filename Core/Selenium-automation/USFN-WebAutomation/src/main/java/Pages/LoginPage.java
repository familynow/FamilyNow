package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.LoginElement;
import Pages.Operations.LoginOperation;

public class LoginPage extends BasePage<LoginElement, LoginOperation> {
	
	public WebDriver driver;
	public LoginPage()
	{
		
         this.driver  = Browser.driver;
		
	}
	public  LoginElement Elements(){
		
		return new LoginElement(driver);
       
    }
	  
	public   LoginOperation Operations(){
		  
		LoginElement element=  new LoginElement(driver);
          return new LoginOperation(element);  
     }
	
	public void Navigate(String Url){
		driver.get(Url);
		
		
	}

}
