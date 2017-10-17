package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.ComplaintParticipantElement;
import Pages.Operations.ComplaintParticipantOperation;

public class ComplaintParticipantPage extends BasePage<ComplaintParticipantElement, ComplaintParticipantOperation> {
	
	public WebDriver driver;
	public ComplaintParticipantPage(){
         this.driver  = Browser.driver;
	} 

	@Override
	public ComplaintParticipantElement Elements() {
		return new ComplaintParticipantElement(driver);
	}

	@Override
	public ComplaintParticipantOperation Operations() {
		ComplaintParticipantElement element=  new ComplaintParticipantElement(driver);
        return new ComplaintParticipantOperation(element);
	}

}
