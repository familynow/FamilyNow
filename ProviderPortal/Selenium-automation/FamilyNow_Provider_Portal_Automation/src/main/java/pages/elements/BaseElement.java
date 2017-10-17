package pages.elements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
	protected static WebDriver Driver;
	protected BaseElement(WebDriver driver){
		Driver = driver;
		
	}
	
	public List<WebElement> GetAllDate(String CalenderIcon, String CalenderTbBody){
		 Driver.findElement(By.xpath(CalenderIcon)).click();
		 WebElement tbody_element = Driver.findElement(By.xpath(CalenderTbBody));
		 List<WebElement> tr_collection=tbody_element.findElements(By.xpath(".//tr"));
	     return tr_collection;
	}
   
   public WebElement SaveButton(){
		 return Driver.findElement(By.id("save"));
		}
   public WebElement CancelButton(){
		 return Driver.findElement(By.id("cancel"));
		}
  public WebElement SaveContinue(){
	 return Driver.findElement(By.id("saveContinue"));
	}

public List<WebElement> GetTableBodyRows(String tbody){
	
	 WebElement tbody_element = Driver.findElement(By.xpath(tbody));
	 List<WebElement> tr_collection=tbody_element.findElements(By.xpath(".//tr"));
	 return tr_collection;
	 
}
public List<WebElement> GetTopLevelList(){
	
	List<WebElement> allElements = Driver.findElements(By.xpath(".//*[@id='applicationNavigationWizard']//ul/li")); 
	return allElements;
 }
 
public WebElement SuccessDialogOkButton(){
	 return Driver.findElement(By.xpath("//div[@id='msgModal']//button[@id='modal-ok']"));
	}
public String DialogMessge(){
	 return Driver.findElement(By.xpath("//div[@id='msgModal']//div[@class='msg-body ng-binding']")).getText();
	}
public WebElement ConfirmationDialoogOKButton(){
	   return Driver.findElement(By.xpath("//div[@id='confirm-popup']//div[@class='msg-footer']/button[text()='Yes']"));
}

}
