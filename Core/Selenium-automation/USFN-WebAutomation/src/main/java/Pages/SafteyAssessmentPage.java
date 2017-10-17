package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.SafteyAssessmentElement;
import Pages.Operations.SafteyAssessmentOperation;

public class SafteyAssessmentPage extends BasePage<SafteyAssessmentElement,SafteyAssessmentOperation> {
	
	public WebDriver driver;
	
	public SafteyAssessmentPage(){
		this.driver = Browser.driver;
	}

	@Override
	public SafteyAssessmentElement Elements() {
		// TODO Auto-generated method stub
		return new SafteyAssessmentElement(driver);
	}

	@Override
	public SafteyAssessmentOperation Operations() {
		SafteyAssessmentElement element =new SafteyAssessmentElement(driver);
		return new SafteyAssessmentOperation(element);
	}
	
   

}
