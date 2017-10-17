package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.ResponsePriorityElement;
import Pages.Operations.ResponsePriorityOperation;

public class ResponsePriorityPage extends BasePage<ResponsePriorityElement, ResponsePriorityOperation>{
	
	public WebDriver driver;
	public ResponsePriorityPage()
	{
         this.driver  = Browser.driver;

	} 

	@Override
	public ResponsePriorityElement Elements() {
		// TODO Auto-generated method stub
		
		return new ResponsePriorityElement(driver);
		
	}

	@Override
	public ResponsePriorityOperation Operations() {
		// TODO Auto-generated method stub
		
		ResponsePriorityElement element=  new ResponsePriorityElement(driver);
        return new ResponsePriorityOperation(element);
		
	}

}
