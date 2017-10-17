package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.elements.BaseElement;

public class ApplicationTypeElement  extends BaseElement {
	public ApplicationTypeElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 public Select YouCanStartBySelectingApplicationType(){
			Select stateDropdown = new Select(Driver.findElement(By.id("applicationType")));
			return stateDropdown;
		}
	 public WebElement ApplicationDate(){
		 return Driver.findElement(By.id("applicationDate"));
	 }

}
