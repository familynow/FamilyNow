package pages;

import general.Browser;

import org.openqa.selenium.WebDriver;

import pages.elements.PreferencesElement;
import pages.operations.PreferencesOperation;

public class PreferencesPage extends BasePage<PreferencesElement,PreferencesOperation>{
	
	public WebDriver driver;
	public PreferencesPage(){
         this.driver  = Browser.driver;
	}
	

	@Override
	public PreferencesElement Elements() {
		// TODO Auto-generated method stub
		return new PreferencesElement(driver);
	}

	@Override
	public PreferencesOperation Operation() {
		PreferencesElement element = new PreferencesElement(driver);
		return new PreferencesOperation(element);
	}

}
