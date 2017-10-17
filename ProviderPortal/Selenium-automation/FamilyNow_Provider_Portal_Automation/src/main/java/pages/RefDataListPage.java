package pages;

import general.Browser;
import org.openqa.selenium.WebDriver;
import pages.elements.RefDataListElement;
import pages.operations.RefDataListOperation;

public class RefDataListPage extends BasePage<RefDataListElement,RefDataListOperation> {
	
	public WebDriver driver;
	public RefDataListPage(){
         this.driver  = Browser.driver;
	}
	

	@Override
	public RefDataListElement Elements() {
		
		return new RefDataListElement(driver);
	}

	@Override
	public RefDataListOperation Operation() {
		RefDataListElement element = new RefDataListElement(driver);
		return new RefDataListOperation(element);
	}

}
