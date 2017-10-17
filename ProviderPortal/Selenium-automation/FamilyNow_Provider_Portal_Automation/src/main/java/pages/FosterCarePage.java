package pages;

import org.openqa.selenium.WebDriver;
import general.Browser;
import pages.BasePage;
import pages.elements.FosterCareElement;
import pages.operations.FosterCareOperation;

public class FosterCarePage extends BasePage<FosterCareElement,FosterCareOperation> {
	public WebDriver driver;
	public FosterCarePage(){
		this.driver = Browser.driver;
	}


	@Override
	public FosterCareElement Elements() {
		// TODO Auto-generated method stub
		return new FosterCareElement(driver);
	}

	

	@Override
	public FosterCareOperation Operation() {
		FosterCareElement element = new FosterCareElement(driver);
		return new FosterCareOperation(element);
	}

}
