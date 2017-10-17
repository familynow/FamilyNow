package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.MyComplaintElement;
import Pages.Operations.MyComplaintOperation;



public class MyComplaintPage extends BasePage<MyComplaintElement, MyComplaintOperation>{
	public WebDriver driver;
	public MyComplaintPage(){
         this.driver  = Browser.driver;

	} 

	@Override
	public MyComplaintElement Elements() {
		return new MyComplaintElement(driver);
	}

	@Override
	public MyComplaintOperation Operations() {
		MyComplaintElement element=  new MyComplaintElement(driver);
        return new MyComplaintOperation(element);
	}

}
