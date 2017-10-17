package pages;

import org.openqa.selenium.WebDriver;

import general.Browser;
import pages.BasePage;
import pages.elements.SupportingDocumentElement;
import pages.operations.SupportingDocumentOperation;

public class SupportingDocumentPage extends BasePage<SupportingDocumentElement,SupportingDocumentOperation> {
	public WebDriver driver;
	public SupportingDocumentPage(){
		this.driver = Browser.driver;
	}

	@Override
	public SupportingDocumentElement Elements() {
		// TODO Auto-generated method stub
		return new SupportingDocumentElement(driver);
	}

	@Override
	public SupportingDocumentOperation Operation() {
		SupportingDocumentElement element=  new SupportingDocumentElement(driver);
		return new SupportingDocumentOperation(element);
	}

}
