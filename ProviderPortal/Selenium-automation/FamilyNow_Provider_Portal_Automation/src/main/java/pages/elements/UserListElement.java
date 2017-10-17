package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserListElement extends BaseElement {

	public UserListElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public WebElement SearchText(){
		
		return Driver.findElement(By.id("search"));
	  }

}
