package pages;

import org.openqa.selenium.WebDriver;

import general.Browser;
import pages.BasePage;
import pages.elements.ApplicationTypeElement;
import pages.operations.ApplicationTypeOperation;

public class ApplicationTypePage extends BasePage<ApplicationTypeElement, ApplicationTypeOperation> {
	public WebDriver driver;
	public ApplicationTypePage(){
         this.driver  = Browser.driver;
	} 

	@Override
	public ApplicationTypeElement Elements() {
		// TODO Auto-generated method stub
		return new ApplicationTypeElement(driver);
	}

	@Override
	public ApplicationTypeOperation Operation() {
		ApplicationTypeElement element = new ApplicationTypeElement(driver);
		return new ApplicationTypeOperation(element);
	}

}
