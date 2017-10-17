package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.SafteyApprovalElement;
import Pages.Operations.SafteyApprovalOperation;

public class SafteyApprovalPage extends BasePage<SafteyApprovalElement,SafteyApprovalOperation> {
	
	public WebDriver driver;
	public SafteyApprovalPage()
	{
		
         this.driver  = Browser.driver;
		
	}

	@Override
	public SafteyApprovalElement Elements() {
		// TODO Auto-generated method stub
		return new SafteyApprovalElement(driver);
	}

	@Override
	public SafteyApprovalOperation Operations() {
		// TODO Auto-generated method stub
		return null;
	}

}
