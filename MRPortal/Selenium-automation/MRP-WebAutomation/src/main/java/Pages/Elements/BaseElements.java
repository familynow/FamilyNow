package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElements {
	protected static WebDriver Driver;
    protected BaseElements(WebDriver driver) {
    	
		 Driver = driver;	 
   }

    
    public List<WebElement> GetAllDate(String CalenderIcon, String CalenderTbBody){
		 Driver.findElement(By.xpath(CalenderIcon)).click();
		 WebElement tbody_element = Driver.findElement(By.xpath(CalenderTbBody));
		 List<WebElement> tr_collection=tbody_element.findElements(By.xpath(".//tr"));
	     return tr_collection;
	}
    
    public List<WebElement> GetTableBodyRows(String tbody){
		
		
		 WebElement tbody_element = Driver.findElement(By.xpath(tbody));
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
   public WebElement LogOut(){
	   return Driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
	   
   }
   
   public WebElement SuccessDialogOkButton(){
		 return Driver.findElement(By.id("modal-ok"));
		}
   public WebElement ConfirmationDialoogOKButton(){
	   return Driver.findElement(By.xpath("//div[@id='confirm-popup']//div[@class='msg-footer']/button[text()='Yes']"));
   }
   
   public WebElement ComplaintIdDiv(){
	   return Driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/div[2]"));
	   
   }
 
    
}
