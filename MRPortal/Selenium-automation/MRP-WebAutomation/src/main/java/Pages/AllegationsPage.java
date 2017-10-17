package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.AllegationsElement;
import Pages.Operations.AllegationsOperation;




public class AllegationsPage extends BasePage<AllegationsElement, AllegationsOperation> {
	
	public WebDriver driver;
	public AllegationsPage(){
         this.driver  = Browser.driver;

	} 

	@Override
	public AllegationsElement Elements() {
		// TODO Auto-generated method stub
		return new AllegationsElement(driver);
	}

	@Override
	public AllegationsOperation Operations() {
		AllegationsElement element=  new AllegationsElement(driver);
        return new AllegationsOperation(element);
	}

}
