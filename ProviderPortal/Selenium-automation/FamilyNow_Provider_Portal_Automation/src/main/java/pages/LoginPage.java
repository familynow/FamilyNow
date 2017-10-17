package pages;

import general.Browser;
import org.openqa.selenium.WebDriver;
import pages.elements.LoginPageElement;
import pages.operations.LoginPageOperation;

public class LoginPage extends BasePage<LoginPageElement, LoginPageOperation> {
	public WebDriver driver;
	public LoginPage(){
         this.driver  = Browser.driver;

	} 

	@Override
	public LoginPageElement Elements() {
		// TODO Auto-generated method stub
		return new LoginPageElement(driver);
	}

	@Override
	public LoginPageOperation Operation() {
		LoginPageElement element=  new LoginPageElement(driver);
        return new LoginPageOperation(element);
	}
	
	public void Navigate(String Url){
		driver.get(Url);
		
		
	}
	

}
