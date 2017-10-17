package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.NonCpsAddParticipantElement;
import Pages.Operations.NonCpsAddParticipantOperation;



public class NonCpsAddParticipantPage extends BasePage<NonCpsAddParticipantElement, NonCpsAddParticipantOperation> {

	public WebDriver driver;
	public NonCpsAddParticipantPage()
	{
         this.driver  = Browser.driver;

	} 
	
	@Override
	public NonCpsAddParticipantElement Elements() {
		return new NonCpsAddParticipantElement(driver);
	}

	@Override
	public NonCpsAddParticipantOperation Operations() {
		NonCpsAddParticipantElement element=  new NonCpsAddParticipantElement(driver);
	       return new NonCpsAddParticipantOperation(element);  
	}

}
