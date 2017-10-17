package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseElements {
	
	 protected static WebDriver Driver;
	 
	 public BaseElements(WebDriver driver)
    {
		 Driver = driver;
		 
    }
	 
	
	 public List<WebElement> GetTableColumnElement(String table,String tr ){
		   
		 
		
		    WebElement table_element = Driver.findElement(By.xpath(table));
	        List<WebElement> tr_collection=Driver.findElements(By.xpath(tr));
	        return tr_collection;
		 
	 }
	 
	 public List<WebElement> GetTableBodyRows(String tbody){
		
		
		 WebElement tbody_element = Driver.findElement(By.xpath(tbody));
		 List<WebElement> tr_collection=tbody_element.findElements(By.xpath(".//tr"));
	     return tr_collection;
		 
	 }
	 
	 
	 
	 public List<WebElement> GetTableRow(String tbBodyXpath,int rowIndex){
		 WebElement tbody_element = Driver.findElement(By.xpath(tbBodyXpath));
		 List<WebElement> tr=tbody_element.findElements(By.xpath(".//tr"+"["+String.valueOf(rowIndex)+"]"));
	     return tr;
		 
	 }
	 
	 
	 public List<WebElement> GetAllDate(String CalenderIcon, String CalenderTbBody){
		 if(!CalenderIcon.contains("NonCps")){
		 Driver.findElement(By.xpath(CalenderIcon)).click();
		 }
		 WebElement tbody_element = Driver.findElement(By.xpath(CalenderTbBody));
		 List<WebElement> tr_collection=tbody_element.findElements(By.xpath(".//tr"));
	     return tr_collection;
	}
	 
	 public Select GetDropDown(String dropDownId){
			
			Select IntakeMethodDropdown = new Select(Driver.findElement(By.id(dropDownId)));
			return IntakeMethodDropdown;
		}
	 
	 public Select GetDropDownByXpath(String dropDownXpath){
			
			Select IntakeMethodDropdown = new Select(Driver.findElement(By.xpath(dropDownXpath)));
			
			return IntakeMethodDropdown;
		}
	 public WebElement GetCheckBox(String xPath){
		 
		 WebElement checkBox = Driver.findElement(By.xpath(xPath));
		 return checkBox;
		 
	 }
	 
    public WebElement GetButton(String xPath){
		 
		 WebElement Button = Driver.findElement(By.xpath(xPath));
		 return Button;
		 
	 }
    
   
	public List<WebElement> GetLeftMenuList(){
		
		
		List<WebElement> allElements = Driver.findElements(By.xpath(".//*[@id='sidebar']/div/div/ul/li")); 
		return allElements;
	}
	
  public List<WebElement> GetInvestigationTaskMenuList(){
		
		
		List<WebElement> allElements = Driver.findElements(By.xpath("//ul[@id='invTasks']/li")); 
		return allElements;
	}
	
	public void GetParticipantMenu(){
		
		// Configure the Action
		
		
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[3]/div/div[1]/div/ul/li[3]/a")));
		WebElement ParticipantMenu = Driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div[1]/div/ul/li[3]/a")); 
		ParticipantMenu.click();
		
		
		
		
	}
	
	public List<WebElement> GetHeaderElements(){
		
		List<WebElement> allElements = Driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li")); 
		return allElements;
		
	}
	
  public WebElement CancelButton(){
	
		return GetButton("//button[contains(text(),'Cancel')]");
	}
  
 public WebElement SubmitForApprovalButton(){
	
	 WebElement Button = Driver.findElement(By.id("approval"));
	 return Button;
  }
 
 public WebElement AlertDiv(){
	 return  Driver.findElement(By.xpath("//div[@role='alert']")); 
 }
 
 public WebElement CloseInformationDialog(){
	 return  Driver.findElement(By.xpath("//div[@class='modal-header']/button[@class='close']/span")); 
 }
 
 public WebElement InformationDialoogOKButton(){
	   return Driver.findElement(By.xpath("//div[@id='popupModal']//div[@class='modal-footer']/button[text()='Ok']"));
 }
 
 public WebElement ConfirmationDialoogOKButton(){
	   return Driver.findElement(By.xpath("//div[@id='confirmModal']//div[@class='modal-footer']/button[text()='Ok']"));
}
 

	

}
