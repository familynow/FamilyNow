package pages;

import org.openqa.selenium.WebDriver;
import general.Browser;
import pages.BasePage;
import pages.elements.MyApplicationElement;
import pages.operations.MyApplicationOperation;

public class MyApplicationPage extends BasePage<MyApplicationElement , MyApplicationOperation> {
	public WebDriver driver;
	public MyApplicationPage(){
		
	     this.driver  = Browser.driver;

	}

	@Override
	public MyApplicationElement Elements() {
		// TODO Auto-generated method stub
		return new MyApplicationElement(driver);
	}

	@Override
	public MyApplicationOperation Operation() {
		MyApplicationElement element = new MyApplicationElement(driver);
		return new MyApplicationOperation(element);
	}

}
