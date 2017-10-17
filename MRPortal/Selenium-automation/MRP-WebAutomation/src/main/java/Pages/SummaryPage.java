package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.SummaryElement;
import Pages.Operations.SummaryOperation;

public class SummaryPage extends BasePage<SummaryElement,SummaryOperation>{
	
	public WebDriver driver;
	public SummaryPage(){
         this.driver  = Browser.driver;

	} 


	@Override
	public SummaryElement Elements() {
		
		return new SummaryElement(driver) ;
	}

	@Override
	public SummaryOperation Operations() {
		
		SummaryElement element= new SummaryElement(driver);
		return new SummaryOperation(element);
	}

}
