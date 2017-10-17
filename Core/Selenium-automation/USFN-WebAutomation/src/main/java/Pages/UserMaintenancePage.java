package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.UserMaintenanceElement;
import Pages.Operations.UserMaintenanceOperation;

public class UserMaintenancePage extends BasePage<UserMaintenanceElement,UserMaintenanceOperation>  {
	
	public WebDriver driver; 
	
	public UserMaintenancePage(){
		this.driver = Browser.driver;
		
	}

	@Override
	public UserMaintenanceElement Elements() {
		// TODO Auto-generated method stub
		return new UserMaintenanceElement(driver);
	}

	@Override
	public UserMaintenanceOperation Operations() {
		UserMaintenanceElement element =	new UserMaintenanceElement(driver);
		return new UserMaintenanceOperation(element);
	}

}
