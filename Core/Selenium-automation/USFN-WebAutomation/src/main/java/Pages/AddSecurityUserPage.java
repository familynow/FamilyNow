package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.AddSecurityUserElement;
import Pages.Operations.AddSecurityUserOperation;

public class AddSecurityUserPage extends BasePage<AddSecurityUserElement,AddSecurityUserOperation> {
	
public WebDriver driver; 
	
	public AddSecurityUserPage(){
		this.driver = Browser.driver;
		
	}

	@Override
	public AddSecurityUserElement Elements() {
		// TODO Auto-generated method stub
		return new AddSecurityUserElement(driver) ;
	}

	@Override
	public AddSecurityUserOperation Operations() {
		AddSecurityUserElement element = new AddSecurityUserElement(driver) ;
		return new AddSecurityUserOperation(element);
	}

}
