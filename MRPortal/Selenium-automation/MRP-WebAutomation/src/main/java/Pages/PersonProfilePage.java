package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.PersonProfileElement;
import Pages.Operations.PersonProfileOperation;



public class PersonProfilePage extends BasePage<PersonProfileElement, PersonProfileOperation>{
	
	public WebDriver driver;
	public PersonProfilePage(){
         this.driver  = Browser.driver;

	} 

	@Override
	public PersonProfileElement Elements() {
		return new PersonProfileElement(driver);
	}

	@Override
	public PersonProfileOperation Operations() {
		PersonProfileElement element=  new PersonProfileElement(driver);
        return new PersonProfileOperation(element);
	}

}
