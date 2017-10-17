package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.DiscontinueElement;
import Pages.Operations.DiscontinueOperation;

public class DiscontinuePage extends BasePage<DiscontinueElement,DiscontinueOperation> {
	
	public WebDriver driver;
	
	public DiscontinuePage(){
		this.driver = Browser.driver;
	}
	

	@Override
	public DiscontinueElement Elements() {
		
		return new DiscontinueElement(driver);
	}

	@Override
	public DiscontinueOperation Operations() {
		
		DiscontinueElement element=	new DiscontinueElement(driver);
		
		return new DiscontinueOperation(element);
	}

}
