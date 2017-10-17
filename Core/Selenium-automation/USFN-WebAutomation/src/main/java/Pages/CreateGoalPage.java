package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.CreateGoalElement;
import Pages.Operations.CreateGoalOperation;

public class CreateGoalPage extends BasePage<CreateGoalElement,CreateGoalOperation> {
	
	public WebDriver Driver;
	public CreateGoalPage(){
		this.Driver = Browser.driver;
		
	}

	@Override
	public CreateGoalElement Elements() {
		
		return new CreateGoalElement(Driver);
	}

	@Override
	public CreateGoalOperation Operations() {
		CreateGoalElement element = new CreateGoalElement(Driver);
		return new CreateGoalOperation(element);
	}

}
