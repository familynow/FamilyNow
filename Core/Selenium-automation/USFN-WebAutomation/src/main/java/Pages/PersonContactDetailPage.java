package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.PersonContactDetailElement;
import Pages.Operations.PersonContactDetailOperation;



public class PersonContactDetailPage extends BasePage<PersonContactDetailElement, PersonContactDetailOperation> {
	
	public WebDriver driver;
	public PersonContactDetailPage()
	{
         this.driver  = Browser.driver;

	} 

	@Override
	public PersonContactDetailElement Elements() {
		// TODO Auto-generated method stub
		return new PersonContactDetailElement(driver);
	}

	@Override
	public PersonContactDetailOperation Operations() {
		PersonContactDetailElement element=  new PersonContactDetailElement(driver);
	       return new PersonContactDetailOperation(element);
	}

}
