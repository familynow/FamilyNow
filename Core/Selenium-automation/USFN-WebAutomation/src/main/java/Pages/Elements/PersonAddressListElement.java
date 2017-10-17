package Pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonAddressListElement extends BaseElements {

	public PersonAddressListElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   
	
	 public WebElement AddContact(){
			
			return GetButton("//*[contains(text(),'Add Phone/Contact')]");
		}
	 
}
