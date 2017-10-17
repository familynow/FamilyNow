package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.NonCpsListParticipantElement;
import Pages.Elements.PersonDemographicElement;
import Pages.Operations.NonCpsListParticipantOperation;
import Pages.Operations.PersonDemographicOperation;



public class PersonDemographicPage extends BasePage<PersonDemographicElement, PersonDemographicOperation> {
	
	public WebDriver driver;
	public PersonDemographicPage()
	{
         this.driver  = Browser.driver;

	}

	@Override
	public PersonDemographicElement Elements() {
		return new PersonDemographicElement(driver);
	}

	@Override
	public PersonDemographicOperation Operations() {
		PersonDemographicElement element=  new PersonDemographicElement(driver);
	       return new PersonDemographicOperation(element);
	}

}
