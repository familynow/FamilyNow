package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.EmployeeSearchElement;
import Pages.Operations.EmployeeSearchOperation;

public class EmployeeSearchPage extends BasePage<EmployeeSearchElement,EmployeeSearchOperation> {
	
	WebDriver driver;
	
	
	public EmployeeSearchPage(){
		this.driver = Browser.driver;
	}
	

	@Override
	public EmployeeSearchElement Elements() {
		// TODO Auto-generated method stub
		return new EmployeeSearchElement(driver);
	}

	@Override
	public EmployeeSearchOperation Operations() {
		EmployeeSearchElement element = new EmployeeSearchElement(driver);
		return new EmployeeSearchOperation(element);
	}

}
