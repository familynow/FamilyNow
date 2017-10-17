package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.NonCpsListParticipantElement;
import Pages.Operations.NonCpsListParticipantOperation;



public class NonCpsListParticipantPage extends BasePage<NonCpsListParticipantElement, NonCpsListParticipantOperation> {

	public WebDriver driver;
	public NonCpsListParticipantPage()
	{
         this.driver  = Browser.driver;

	} 
	@Override
	public NonCpsListParticipantElement Elements() {
		// TODO Auto-generated method stub
		return new NonCpsListParticipantElement(driver);
	}

	@Override
	public NonCpsListParticipantOperation Operations() {
		NonCpsListParticipantElement element=  new NonCpsListParticipantElement(driver);
	       return new NonCpsListParticipantOperation(element);
	}

}
