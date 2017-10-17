package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserMaintenanceElement extends BaseElements {

	public UserMaintenanceElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement UserId(){
		
		return Driver.findElement(By.id("userId"));
	}
	
	public WebElement LastName(){
		return Driver.findElement(By.id("lastName"));
	}
	
	public WebElement FirstName(){
		return Driver.findElement(By.id("firstName"));
	}
	
	public Select OrganizationCategory(String dropDownXpath) {

		Select IntakeMethodDropdown = new Select(Driver.findElement(By
				.id("orgCategory")));

		return IntakeMethodDropdown;
	}
	
	public WebElement SearchButton(){
		return Driver.findElement(By.xpath("//button[@id='searchBtn']"));
	}
	
	public WebElement ClearButton(){
		return Driver.findElement(By.xpath("//button[@id='clearBtn']"));
	}
	
	//
	
	public WebElement AddUserButton(){
		return Driver.findElement(By.xpath("//button[@id='addUser']"));
	}
	
	
	

}
