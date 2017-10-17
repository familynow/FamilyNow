package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DiscontinueElement extends BaseElements {

	public DiscontinueElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	 public Select ReasonForDiscontinuation(){
		 Select ReasonForDiscontinuationDropdown = new Select(Driver.findElement(By.id("reasonForDiscontinuation")));
		 return ReasonForDiscontinuationDropdown;
			
		}
	 public WebElement AdditionalDetails(){
			
			return GetButton("//*[contains(@id,'taTextElement')]");
		}
	 
	 public WebElement PartiesNotified(){
		 return Driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div/div/div/div[2]/form/div[1]/div[4]/div/label/span"));
	 }
	 
	 public WebElement DiscontinuedDate(){
		 return Driver.findElement(By.xpath("//input[@id='discontinuedDate']"));
	 }
	 
	 
	   
	   public WebElement Save(){
		   return Driver.findElement(By.id("save"));
	   }

}
