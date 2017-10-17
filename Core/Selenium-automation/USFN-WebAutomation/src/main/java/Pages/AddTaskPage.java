package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.AddTaskPageElement;
import Pages.Operations.AddTaskPageOperation;

public class AddTaskPage extends BasePage<AddTaskPageElement,AddTaskPageOperation> {
	
	public WebDriver driver; 
	
	public AddTaskPage(){
		this.driver = Browser.driver;
		
	}

	@Override
	public AddTaskPageElement Elements() {
		// TODO Auto-generated method stub
		return new AddTaskPageElement(driver);
	}

	@Override
	public AddTaskPageOperation Operations() {
		AddTaskPageElement element = new AddTaskPageElement(driver);
		return new AddTaskPageOperation(element);
	}

}
