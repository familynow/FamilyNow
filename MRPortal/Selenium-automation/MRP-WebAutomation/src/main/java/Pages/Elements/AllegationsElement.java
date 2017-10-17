package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllegationsElement  extends BaseElements{

	public AllegationsElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement TimeofAllegedAbuse(){
		return Driver.findElement(By.id("timeOfAbuse"));
	}
	
	 public Select AMPMDropdown(){
			Select amDropdown = new Select(Driver.findElement(By.id("ampm")));
			return amDropdown;
		}
	 public Select TimezoneDropdown(){
			Select timezoneDropdown = new Select(Driver.findElement(By.id("timeZoneOfAbuseOrNeglect")));
			return timezoneDropdown;
		}
	 
	 public Select AllegationTypeDropdown(){
			Select allegationTypeDropdown = new Select(Driver.findElement(By.id("AllegationType")));
			return allegationTypeDropdown;
		}
	 
	 public WebElement AddAllegationButton(){
		 return Driver.findElement(By.id("addAllegation"));
		}
	 public WebElement SaveAllegationButton(){
		 return Driver.findElement(By.id("allegationSave"));
		}
	 
	 public WebElement Narrative(){
			
			return Driver.findElement(By.xpath("//*[contains(@id,'taTextElement')]")); 
		}
	 

	
}
