package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.SafteyPlanListElement;
import Pages.Operations.SafteyPlanListOperation;

public class SafteyPlanListPage extends BasePage<SafteyPlanListElement,SafteyPlanListOperation> {
	
	WebDriver driver;
	public SafteyPlanListPage(){
		this.driver = Browser.driver;
		
	}

	@Override
	public SafteyPlanListElement Elements() {
		return new SafteyPlanListElement(driver);
	}

	@Override
	public SafteyPlanListOperation Operations() {
		SafteyPlanListElement element = new SafteyPlanListElement(driver);
		return new SafteyPlanListOperation(element);
	}

}
