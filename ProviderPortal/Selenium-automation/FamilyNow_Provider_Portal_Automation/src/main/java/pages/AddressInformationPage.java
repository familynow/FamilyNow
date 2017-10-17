package pages;

import org.openqa.selenium.WebDriver;

import general.Browser;
import pages.BasePage;
import pages.elements.AddressInformationElement;
import pages.operations.AddressInformationOperation;

public class AddressInformationPage extends BasePage<AddressInformationElement,AddressInformationOperation> {
	public WebDriver driver;
	public AddressInformationPage(){
		this.driver =Browser.driver;
	}

	@Override
	public AddressInformationElement Elements() {
		// TODO Auto-generated method stub
		return new AddressInformationElement(driver) ;
	}

	@Override
	public AddressInformationOperation Operation() {
		AddressInformationElement element =  new AddressInformationElement(driver);
		return new AddressInformationOperation(element);
	}

}
