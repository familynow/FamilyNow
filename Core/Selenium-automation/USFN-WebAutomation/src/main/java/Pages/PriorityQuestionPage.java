package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.PriorityQuestionElement;
import Pages.Operations.PriorityQuestionOperation;



public class PriorityQuestionPage extends BasePage<PriorityQuestionElement, PriorityQuestionOperation> {
	
	
	public WebDriver driver;
	public PriorityQuestionPage()
	{
         this.driver  = Browser.driver;

	}

	@Override
	public PriorityQuestionElement Elements() {
		
		 return new PriorityQuestionElement(driver);
		
	}

	@Override
	public PriorityQuestionOperation Operations() {
		
		PriorityQuestionElement element=  new PriorityQuestionElement(driver);
        return new PriorityQuestionOperation(element);  
        
	}

}
