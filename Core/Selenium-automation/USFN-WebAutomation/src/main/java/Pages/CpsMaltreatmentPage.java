package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.CpsAddParticipanElement;
import Pages.Elements.CpsMaltreatmentElement;
import Pages.Operations.CpsAddParticipanOperation;
import Pages.Operations.CpsMaltreatmentOperation;



public class CpsMaltreatmentPage extends BasePage<CpsMaltreatmentElement, CpsMaltreatmentOperation> {
	
	public WebDriver driver;
	public CpsMaltreatmentPage()
	{
         this.driver  = Browser.driver;

	} 
	@Override
	public CpsMaltreatmentElement Elements() {
		return new CpsMaltreatmentElement(driver);
	}

	@Override
	public CpsMaltreatmentOperation Operations() {
		CpsMaltreatmentElement element=  new CpsMaltreatmentElement(driver);
	       return new CpsMaltreatmentOperation(element);  
	}

}
