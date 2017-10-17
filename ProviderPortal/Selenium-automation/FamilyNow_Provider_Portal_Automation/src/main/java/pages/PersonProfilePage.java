package pages;

import general.Browser;
import org.openqa.selenium.WebDriver;
import pages.elements.PersonProfileElement;
import pages.operations.PersonProfileOperation;

public class PersonProfilePage extends BasePage<PersonProfileElement, PersonProfileOperation> {
	public WebDriver driver;
	public PersonProfilePage(){
         this.driver  = Browser.driver;

	} 

	@Override
	public PersonProfileElement Elements() {
		return new PersonProfileElement(driver);
	}

	@Override
	public PersonProfileOperation Operation() {
		PersonProfileElement element=  new PersonProfileElement(driver);
        return new PersonProfileOperation(element);
	}

}
