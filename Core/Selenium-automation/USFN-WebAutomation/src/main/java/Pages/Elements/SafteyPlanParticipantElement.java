package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SafteyPlanParticipantElement extends BaseElements {

	public SafteyPlanParticipantElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement CancelButton(){
		return Driver.findElement(By.xpath("//form[@id='participants']//button[@id='cancel']"));
	}

}
