package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonSearchElement  extends BaseElements {
	
	public PersonSearchElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement GetPersonId()
	{
		
 		WebElement PersonId= Driver.findElement(By.id("personId"));
        return PersonId;
	}
	
	public WebElement GetSearchButton()
	{
		WebElement SearchButton = GetButton("//button[@id='personSearchBottom']");
		return SearchButton;
		
		//return Driver.findElement(By.xpath("//*[contains(text(),'Search')]"));
	}
	
	public WebElement AddPersonhButton()
	{
		
		return Driver.findElement(By.xpath("//*[contains(text(),'Add Person')]"));
	}
	
	
	
	
	public WebElement SSN()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath("//input[@id='ssn']"));
        return FirstName;
	}
	
	
	
	public static void CloseBrowser(){
		Driver = null;
	}

}
