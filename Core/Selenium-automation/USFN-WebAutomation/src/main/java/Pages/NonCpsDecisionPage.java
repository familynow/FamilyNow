package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.NonCpsDecisionElement;
import Pages.Operations.NonCpsDecisionOperation;



public class NonCpsDecisionPage  extends BasePage<NonCpsDecisionElement, NonCpsDecisionOperation> {

	
	public WebDriver driver;
	public NonCpsDecisionPage()
	{
         this.driver  = Browser.driver;

	}
	@Override
	public NonCpsDecisionElement Elements() {
		// TODO Auto-generated method stub
		return new NonCpsDecisionElement(driver);
	}

	@Override
	public NonCpsDecisionOperation Operations() {
		NonCpsDecisionElement element=  new NonCpsDecisionElement(driver);
        return new NonCpsDecisionOperation(element);  
	}

}
