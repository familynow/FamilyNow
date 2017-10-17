package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyComplaintElement extends BaseElements {

	public MyComplaintElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement AddNewReportButton(){
		
		 WebElement Button = Driver.findElement(By.id("addNewReport"));
		 return Button;
	  }
}
