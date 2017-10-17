package pages;

import general.Browser;
import org.openqa.selenium.WebDriver;
import pages.elements.AddRefDataElement;
import pages.operations.AddRefDataOperation;

public class AddRefDataPage extends BasePage<AddRefDataElement,AddRefDataOperation> {
	
	public WebDriver driver;
	public AddRefDataPage(){
		this.driver =Browser.driver;
	}


	@Override
	public AddRefDataElement Elements() {
	
		return new AddRefDataElement(driver);
	}

	@Override
	public AddRefDataOperation Operation() {
		AddRefDataElement element = new AddRefDataElement(driver);
		return new AddRefDataOperation(element);
	}

}
