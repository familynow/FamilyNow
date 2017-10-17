package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.SafteyPlanParticipantElement;
import Pages.Operations.SafteyPlanParticipantOperation;

public class SafteyPlanParticipantPage extends BasePage<SafteyPlanParticipantElement,SafteyPlanParticipantOperation> {
	
	 public WebDriver Driver;
	 public SafteyPlanParticipantPage(){
		 this.Driver = Browser.driver;
	 }
 

	@Override
	public SafteyPlanParticipantElement Elements() {
		// TODO Auto-generated method stub
		return new SafteyPlanParticipantElement(Driver);
	}

	@Override
	public SafteyPlanParticipantOperation Operations() {
		SafteyPlanParticipantElement element = new SafteyPlanParticipantElement(Driver);
		return new SafteyPlanParticipantOperation(element);
	}

}
