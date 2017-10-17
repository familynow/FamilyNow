package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.elements.BaseElement;

public class MyApplicationElement extends BaseElement {
	public MyApplicationElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement CreateNewProviderApplicationButton(){
		return Driver.findElement(By.id("createApplication"));
	}
	
	 public WebElement LogOut(){
		   return Driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
		   
	   }

}
