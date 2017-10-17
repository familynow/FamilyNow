package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NonCpsAddParticipantElement extends BaseElements {

	public NonCpsAddParticipantElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement FirstName()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath(".//*[@id='firstName']"));
        return FirstName;
	}
	
	public WebElement LastName()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath(".//*[@id='lastName']"));
        return FirstName;
	}
	
	public Select AvailableRoles(){
		return GetDropDown("availableRoles");
	}
	
	public Select SelectedRoles(){
		return GetDropDown("selectedRoles");
	}
	
	public Select Gender(){
		return GetDropDown("genderCode");
	}
	
	
	public WebElement MoveItemRight(int index){
	
	List<WebElement> moveRightButton = Driver.findElements(By.xpath(".//*[@id='move-item-right']"));
	  return moveRightButton.get(index);
	}
	
	public WebElement MoveItemLeft(int index){
		
		List<WebElement> moveLeftButton = Driver.findElements(By.xpath(".//*[@id='move-item-left']"));
		  return moveLeftButton.get(index);
		}
	
	
	public WebElement SaveButton(){
		return GetButton("//button[text()='Save']");
	}
	
   
}
