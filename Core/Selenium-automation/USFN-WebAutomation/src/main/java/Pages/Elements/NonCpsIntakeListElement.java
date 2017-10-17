package Pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NonCpsIntakeListElement extends BaseElements{

	public NonCpsIntakeListElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	  public WebElement AddNonCpsButton(){
	
		return GetButton("//*[contains(text(),'Add Non CPS Intake')]");
	}

}
