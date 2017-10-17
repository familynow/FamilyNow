package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.AddAdditionalNameElement;
import Pages.Operations.AddAdditionalNameOperation;



public class AddAdditionalNamePage extends BasePage<AddAdditionalNameElement, AddAdditionalNameOperation>{

	
	public WebDriver driver;
	public AddAdditionalNamePage()
	{
         this.driver  = Browser.driver;

	} 
	@Override
	public AddAdditionalNameElement Elements() {
		// TODO Auto-generated method stub
		return new AddAdditionalNameElement(driver);
	}

	@Override
	public AddAdditionalNameOperation Operations() {
		AddAdditionalNameElement element=  new AddAdditionalNameElement(driver);
        return new AddAdditionalNameOperation(element);
	}

}
