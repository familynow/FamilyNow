package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.LoginPageElement;
import Pages.Operations.LoginPageOperation;



public class LoginPage  extends BasePage<LoginPageElement, LoginPageOperation> {
	
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
	public LoginPageOperation Operations() {
		LoginPageElement element=  new LoginPageElement(driver);
        return new LoginPageOperation(element);
	}
	
	public void Navigate(String Url){
		driver.get(Url);
		
		
	}
	
 

}
