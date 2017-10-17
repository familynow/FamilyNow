package pages;

import general.Browser;

import org.openqa.selenium.WebDriver;

import pages.elements.InquirySearchElement;
import pages.operations.InquirySearchOperation;

public class InquirySearchPage extends BasePage<InquirySearchElement,InquirySearchOperation>{
	public WebDriver driver;
	public InquirySearchPage(){
		this.driver = Browser.driver;
	}


	@Override
	public InquirySearchElement Elements() {
		// TODO Auto-generated method stub
		return new InquirySearchElement(driver) ;
	}

	@Override
	public InquirySearchOperation Operation() {
		InquirySearchElement element = new InquirySearchElement(driver);
		return new InquirySearchOperation(element);
	}

}
