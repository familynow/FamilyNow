package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryElement extends BaseElements{

	public SummaryElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
   public WebElement SubmitButton(){
		return Driver.findElement(By.id("saveSummary"));
		
	  }

}
