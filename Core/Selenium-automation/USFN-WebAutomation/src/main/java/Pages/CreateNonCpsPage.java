package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.CreateNonCpsElement;
import Pages.Elements.NonCpsIntakeListElement;
import Pages.Operations.CreateCpsOperation;
import Pages.Operations.CreateNonCpsOperation;
import Pages.Operations.NonCpsIntakeListOperation;



public class CreateNonCpsPage extends BasePage<CreateNonCpsElement, CreateNonCpsOperation>{

	public WebDriver driver;
	public CreateNonCpsPage()
	{
         this.driver  = Browser.driver;

	}
	@Override
	public CreateNonCpsElement Elements() {
		return new CreateNonCpsElement(driver);
	}
	@Override
	public CreateNonCpsOperation Operations() {
		CreateNonCpsElement element=  new CreateNonCpsElement(driver);
	       return new CreateNonCpsOperation(element);  
	}

}
