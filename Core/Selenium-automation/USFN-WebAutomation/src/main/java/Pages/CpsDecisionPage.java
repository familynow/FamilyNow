package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.CpsDecisionElement;
import Pages.Operations.CpsDecisionOperation;



public class CpsDecisionPage extends BasePage<CpsDecisionElement, CpsDecisionOperation> {
	
	public WebDriver driver;
	public CpsDecisionPage()
	{
         this.driver  = Browser.driver;

	}

	@Override
	public CpsDecisionElement Elements() {
		// TODO Auto-generated method stub
		return  new CpsDecisionElement(driver);
	}

	@Override
	public CpsDecisionOperation Operations() {
		CpsDecisionElement element=  new CpsDecisionElement(driver);
	       return new CpsDecisionOperation(element);  
	}

}
