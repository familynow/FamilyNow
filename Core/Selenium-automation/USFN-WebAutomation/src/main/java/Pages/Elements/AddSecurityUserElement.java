package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddSecurityUserElement extends BaseElements  {

	public AddSecurityUserElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
   public WebElement UserId(){
		
		return Driver.findElement(By.id("loginUserId"));
	}
   
   
   public WebElement AccessStartDate(){
		
		return Driver.findElement(By.id("startDateField"));
	}
   
   public WebElement AccessEndDate(){
		
		return Driver.findElement(By.id("endDateField"));
	}
   public WebElement SaveButton(){
		
		return Driver.findElement(By.xpath("//button[@id='save']"));
	}
   public WebElement ApplyButton(){
		
		return Driver.findElement(By.xpath("//button[@id='apply']"));
	}
   public WebElement  UnLinkEmployee(){
		
		return Driver.findElement(By.xpath("//button[contains(text(),'UnLink Employee')]"));
	}
  
  
   public WebElement Comments(){
		
		return GetButton("//*[contains(@id,'taTextElement')]");
	}
   
   public WebElement LinkEmployeeButton(){
		
	   return Driver.findElement(By.id("linkEmployeeBtn"));
	}
   
   public WebElement Name(){
	 
	   return Driver.findElements(By.xpath("//div[@class='panel data-card widget ng-scope']//div[@class='widget-body panel-collapse collapse in padding-div']//div[@class='col-lg-4 form-field']//div[@class='col-lg-7 field-wrap']")).get(0);
   }
   
   public WebElement Organization(){
	  
	   return Driver.findElements(By.xpath("//div[@class='panel data-card widget ng-scope']//div[@class='widget-body panel-collapse collapse in padding-div']//div[@class='col-lg-4 form-field']//div[@class='col-lg-7 field-wrap ng-binding']")).get(0);
   }
   
   public WebElement GetErrorMessage(){
	   return Driver.findElement(By.xpath("//div[@class='has-error ng-scope']"));
	   
   }

}
