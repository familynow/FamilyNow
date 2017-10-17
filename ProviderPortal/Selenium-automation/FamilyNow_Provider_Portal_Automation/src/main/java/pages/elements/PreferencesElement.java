package pages.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PreferencesElement extends BaseElement {
	public PreferencesElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public WebElement MinAge(){
			return Driver.findElement(By.id("startAge"));
		}
	 public WebElement MaxAge(){
			return Driver.findElement(By.id("endAge"));
		}
	 public WebElement MaleRadioButton(){
			return Driver.findElement(By.id("MALE"));
		}
	 public WebElement FemaleRadioButton(){
			return Driver.findElement(By.id("FEMALE"));
		}
	 public WebElement BothRadioButton(){
			return Driver.findElement(By.id("BOTH"));
		}
	 public Select AvailableRace(){
			Select availableRace = new Select(Driver.findElement(By.id("availableRace")));
			return availableRace;
		}
	 
	 public Select SelectedRace(){
			Select selectedRace = new Select(Driver.findElement(By.id("selectedRace")));
			return selectedRace;
		}
	 
	 public WebElement MoveItemRight(int index){
			
			List<WebElement> moveRightButton = Driver.findElements(By.xpath(".//*[@id='move-item-right']"));
			  return moveRightButton.get(index);
	    }
			
	 public WebElement MoveItemLeft(int index){
				
		    List<WebElement> moveLeftButton = Driver.findElements(By.xpath(".//*[@id='move-item-left']"));
		    return moveLeftButton.get(index);
		}
	 
	 public WebElement PreferenceSave(){
		 return Driver.findElement(By.xpath("//div[@id='preferences']//button[3]"));
		 
	 }
	 
	 public WebElement PreferenceSaveContinue(){
		 return Driver.findElement(By.xpath("//div[@id='preferences']//button[4]"));
		 
	 }
	 
	 public WebElement PreferencePrevious(){
		 return Driver.findElement(By.xpath("//div[@id='preferences']//button[2]"));
		 
	 }
	 
	 public WebElement PreferenceCancel(){ 
		 return Driver.findElement(By.xpath("//button[@id='cancel']"));
		 
	 }

}
