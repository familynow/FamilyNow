package pages.elements;

import general.Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationSummaryElement extends BaseElement{

	public ApplicationSummaryElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement GetApplicationTypeDiv(){
		List<WebElement> allElements = Driver.findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")); 
		int size = allElements.size();
		String test = allElements.get(0).getText();
		
		return allElements.get(0);

		
		
	}
	
	public WebElement SubmitButton(){
		return Driver.findElement(By.xpath("//button[@id='submit']")); 
		
	}
	public WebElement CloseButton(){
		return Driver.findElement(By.xpath("//button[@id='close']")); 
		
	}
	
	public WebElement ClickOK(){
		
	   return Driver.findElement(By.xpath("//div[@id='confirmModal']//div[@class='msg-footer']/button[text()='Ok']"));
		
	}

}
