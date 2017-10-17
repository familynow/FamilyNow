package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.CpsAddParticipanElement;
import Pages.Operations.CpsAddParticipanOperation;



public class CpsAddParticipanPage extends BasePage<CpsAddParticipanElement, CpsAddParticipanOperation> {
	
	public WebDriver driver;
	public CpsAddParticipanPage()
	{
         this.driver  = Browser.driver;

	} 
	@Override
	public CpsAddParticipanElement Elements() {
		return new CpsAddParticipanElement(driver);
	}

	@Override
	public CpsAddParticipanOperation Operations() {
		CpsAddParticipanElement element=  new CpsAddParticipanElement(driver);
	       return new CpsAddParticipanOperation(element);  
	}


}
