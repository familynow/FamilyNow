package pages;

import org.openqa.selenium.WebDriver;

import general.Browser;
import pages.BasePage;
import pages.elements.ReferenceElement;
import pages.operations.ReferenceOperation;

public class ReferencePage extends BasePage<ReferenceElement,ReferenceOperation> {
	public WebDriver driver;
	public ReferencePage(){
		this.driver = Browser.driver;
	}

	@Override
	public ReferenceElement Elements() {
		// TODO Auto-generated method stub
		return new ReferenceElement(driver);
	}

	@Override
	public ReferenceOperation Operation() {
		ReferenceElement element =    new ReferenceElement(driver);
		return new ReferenceOperation(element);
	}

}
