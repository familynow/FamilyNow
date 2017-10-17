package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyOrganizerElement extends BaseElements {
	
	public MyOrganizerElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
  
	public WebElement GetViewAll()
	{
		
 		WebElement ViewAll= Driver.findElement(By.id("intakeViewAll"));
        return ViewAll;
	}
	
	public WebElement ViewAllInvestigation(){
		WebElement ViewAll= Driver.findElement(By.id("investigationViewAll"));
        return ViewAll;
		
	}
	
	public static void CloseBrowser(){
		Driver = null;
	}

}
