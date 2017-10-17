package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CpsListParticipantElement extends BaseElements {

	public CpsListParticipantElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    
	public static void CloseBrowser(){
		Driver = null;
	}
	
	public WebElement AddParticipantButton(){
		return GetButton("//button[text()='Add Participant']");
	}
}
