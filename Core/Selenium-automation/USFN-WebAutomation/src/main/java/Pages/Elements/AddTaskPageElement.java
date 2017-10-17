package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddTaskPageElement extends BaseElements {

	public AddTaskPageElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement TaskTextBox(){
		return Driver.findElement(By.id("taskGoal"));
	}
	
	public WebElement AdditionalInformation(){
		
		return GetButton("//*[contains(@id,'taTextElement')]");
			
	}
	
   public WebElement AddResponsiblePartyButton(){
		
	   return Driver.findElement(By.id("addResponsibleParty"));
			
	}
   
   public WebElement searchParticipant(){
		
	   return Driver.findElement(By.xpath("//div[@id='addParty']//button[@id='searchParticipant']"));
			
	}
   
   public WebElement SearchButton(){
		
	   return Driver.findElement(By.xpath("//div[@id='addParty']//button[@id='search']"));
			
	}
   
   public WebElement CancelButton(){
		
	   return Driver.findElement(By.xpath("//div[@id='addParty']//button[@id='cancel']"));
			
	}
   
   public WebElement OkButton(){
	   return Driver.findElement(By.xpath("//button[@id='ok']"));
   }
	
   
   
	
   //Add Responsible Party Pop up elements
   public Select SelectParticipant(){
		return GetDropDownByXpath("//div[@class='popup-content']//select[@id='participantList']");
	}
   public Select ContactType(){
		return GetDropDownByXpath("//div[@class='popup-content']//select[@id='contactType']");
	}
   
   public Select Role(){
		return GetDropDownByXpath("//div[@class='popup-content']//select[@id='role']");
	}
   
   public WebElement Contact(){
	   return Driver.findElement(By.xpath("//div[@class='popup-content']//input[@id='contact']"));
   }
   
   public WebElement ResponsiblePopUpOkButton(){
	   return Driver.findElement(By.xpath("//div[@class='safety-footer text-right action-wrap']//button[@id='addPartyOk']"));
   }
   

	

}
