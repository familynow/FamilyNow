package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.PersonBasicElement;
import Pages.Operations.PersonBasicOperation;



public class PersonBasicPage  extends BasePage<PersonBasicElement, PersonBasicOperation>  {

	public WebDriver driver;
	public PersonBasicPage()
	{
         this.driver  = Browser.driver;

	}
	@Override
	public PersonBasicElement Elements() {
		// TODO Auto-generated method stub
		return new PersonBasicElement(driver);
	}

	@Override
	public PersonBasicOperation Operations() {
		PersonBasicElement element=  new PersonBasicElement(driver);
        return new PersonBasicOperation(element);
	}

}
