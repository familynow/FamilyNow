package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.CpsListParticipantElement;
import Pages.Operations.CpsListParticipantOperation;



public class CpsListParticipantPage extends BasePage<CpsListParticipantElement, CpsListParticipantOperation>{

	public WebDriver driver;
	public CpsListParticipantPage()
	{
         this.driver  = Browser.driver;

	} 
	@Override
	public CpsListParticipantElement Elements() {
		return new CpsListParticipantElement(driver);
	}

	@Override
	public CpsListParticipantOperation Operations() {
		CpsListParticipantElement element=  new CpsListParticipantElement(driver);
	       return new CpsListParticipantOperation(element);  
	}

	
}
