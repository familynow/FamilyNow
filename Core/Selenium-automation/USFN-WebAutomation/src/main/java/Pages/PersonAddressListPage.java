package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.PersonAddressListElement;
import Pages.Operations.PersonAddressListOperation;



public class PersonAddressListPage extends BasePage<PersonAddressListElement, PersonAddressListOperation> {

	
	public WebDriver driver;
	public PersonAddressListPage()
	{
         this.driver  = Browser.driver;

	} 
	@Override
	public PersonAddressListElement Elements() {
		// TODO Auto-generated method stub
		return new PersonAddressListElement(driver);
	}

	@Override
	public PersonAddressListOperation Operations() {
		PersonAddressListElement element=  new PersonAddressListElement(driver);
        return new PersonAddressListOperation(element);
	}

}
