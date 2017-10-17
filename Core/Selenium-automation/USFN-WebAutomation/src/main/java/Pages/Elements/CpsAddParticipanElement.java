package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CpsAddParticipanElement extends BaseElements {

	public CpsAddParticipanElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement FirstName()
	{
		WebDriverWait wait = new WebDriverWait(Driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='firstName']")));
 		WebElement FirstName= Driver.findElement(By.xpath(".//*[@id='firstName']"));
        return FirstName;
	}
	
	public WebElement LastName()
	{
		WebDriverWait wait = new WebDriverWait(Driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='lastName']")));
 		WebElement FirstName= Driver.findElement(By.xpath(".//*[@id='lastName']"));
        return FirstName;
	}
	
	
	
	public Select Roles(){
		
		Select availableRole = new Select(Driver.findElement(By.id("availableRoles")));
		return availableRole;
	}
	
	public Select RemoveRoles(){
		return GetDropDownByXpath(".//*[@id='selectedRoles']");
	}
	
	public Select Gender(){
		return GetDropDown(".//*[@id='personRole']");
	}
	
	
	public WebElement MoveItemRight(int index){
	
	List<WebElement> moveRightButton = Driver.findElements(By.id("move-item-right"));
	int test = moveRightButton.size();
	  return moveRightButton.get(index);
	}
	
	public WebElement MoveItemLeft(int index){
		
		List<WebElement> moveLeftButton = Driver.findElements(By.xpath(".//*[@id='move-item-left']"));
		  return moveLeftButton.get(index);
		}
	
	
	public WebElement SaveButton(){
		return GetButton("//button[text()='Save']");
	}
	
	public WebElement ApplyButton(){
		return GetButton("//button[@id='apply']");
	}
	 public WebElement SubmitForApproval(){
			
			return GetButton("//button[@id='approval']");
		}
	
	
	
	public static void CloseBrowser(){
		Driver = null;
	}

}
