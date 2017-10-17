package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonDemographicElement extends BaseElements {

	public PersonDemographicElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public WebElement SaveButton(){
			
	  return GetButton("//*[contains(text(),'Save')]");
	}
	
	public WebElement ApplyButton(){
		
		return GetButton("//*[contains(text(),'Apply')]");
	}
		
	public WebElement CancelButton(){
			
	  return GetButton("//*[contains(text(),'Cancel')]");
	}
	public WebElement Feet()
	{
		
 	  return	Driver.findElement(By.xpath(".//*[@id='inches']"));
       
	}
	
	public WebElement Inches()
	{
		
 	  return	Driver.findElement(By.xpath(".//*[@id='cms']"));
       
	}
	
	public Select AvailableLanguage(){
		return GetDropDownByXpath("html/body/div[1]/div/div[3]/div/div[2]/div[2]/div/div[3]/form/div[7]/div[2]/div/div/div[1]/div/div/div[1]/select");
	}
	
	public Select SelectedLanguage(){
		return GetDropDownByXpath("html/body/div[1]/div/div[3]/div/div[2]/div[2]/div/div[3]/form/div[7]/div[2]/div/div/div[1]/div/div/div[3]/select");
	}
	
	public WebElement MoveItemRight(int index){
		
		List<WebElement> moveRightButton = Driver.findElements(By.xpath(".//*[@id='move-item-right']"));
		int size = moveRightButton.size();
		  return moveRightButton.get(index);
		}
		
	public WebElement MoveItemLeft(int index){
			
		List<WebElement> moveLeftButton = Driver.findElements(By.xpath(".//*[@id='move-item-left']"));
		return moveLeftButton.get(index);
	}
	
	public WebElement OtherAncestry(){
		
		return Driver.findElement(By.xpath(".//*[@id='otherancestry']"));

	}
	

	public Select PrimaryLanguage(){
		return GetDropDown("primaryLanguage");
	}
	
	public Select HairColor(){
		return GetDropDown("haircolor");
	}
	
	public Select DeathVerificationSource(){
		return GetDropDown("source");
	}
	
	public Select Religion(){
		return GetDropDown("personReligion");
	}
	
	//
	
	

}
