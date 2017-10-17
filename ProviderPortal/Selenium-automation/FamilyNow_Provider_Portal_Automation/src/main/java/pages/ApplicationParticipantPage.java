package pages;

import org.openqa.selenium.WebDriver;

import general.Browser;
import pages.BasePage;
import pages.elements.ApplicationParticipantElement;
import pages.operations.ApplicationParticipantOperation;

public class ApplicationParticipantPage extends BasePage<ApplicationParticipantElement,ApplicationParticipantOperation> {
	public WebDriver driver;
	public ApplicationParticipantPage(){
         this.driver  = Browser.driver;
	}
	
	@Override
	public ApplicationParticipantElement Elements() {
		// TODO Auto-generated method stub
		return new ApplicationParticipantElement(driver);
	}

	@Override
	public ApplicationParticipantOperation Operation() {
		ApplicationParticipantElement element =  new ApplicationParticipantElement(driver);
		return new ApplicationParticipantOperation(element);
	}

}
