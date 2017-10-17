package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import general.Browser;
import general.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageControllers.ProviderPageManager;
import pages.elements.ApplicationSummaryElement;
import pages.operations.ApplicationSummaryOperation;

public class ApplicationSummaryPage extends BasePage<ApplicationSummaryElement,ApplicationSummaryOperation>{
	
	public WebDriver driver;
	public ApplicationSummaryPage(){
		this.driver =Browser.driver;
	}

	@Override
	public ApplicationSummaryElement Elements() {
		// TODO Auto-generated method stub
		return new ApplicationSummaryElement(driver);
	}

	@Override
	public ApplicationSummaryOperation Operation() {
		ApplicationSummaryElement element = new ApplicationSummaryElement(driver);
		return new ApplicationSummaryOperation(element);
	}
	
	

}
