package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeSearchElement extends BaseElements {

	public EmployeeSearchElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public WebElement EmployeeId(){
		return Driver.findElement(By.id("empId"));
	}
	
	public WebElement SearchButton(){
		return Driver.findElement(By.xpath("//button[@id='search']"));
	}

}
