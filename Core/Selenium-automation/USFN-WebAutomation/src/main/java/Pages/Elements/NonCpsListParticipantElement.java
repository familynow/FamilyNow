package Pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NonCpsListParticipantElement extends BaseElements {

	public NonCpsListParticipantElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement AddParticipantButton(){
		return GetButton("//button[text()='Add Participant']");
	}

}
