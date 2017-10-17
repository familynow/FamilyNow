package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NonCpsDecisionElement extends BaseElements {

	public NonCpsDecisionElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
   public Select Decision(){
		return GetDropDown("decision");
	}
	
	public Select RejectWithdrawReason(){
		return GetDropDown("rejectWithdrawReason");
	}
	
   public WebElement SaveButton(){
		
		return GetButton("//*[contains(text(),'Save')]");
	}
	
	public WebElement ApplyButton(){
		
		return GetButton("//*[contains(text(),'Apply')]");
	}
    
   public WebElement Comments(){
		
	 
	   return Driver.findElement(By.xpath("//*[contains(@id,'taTextElement')]")) ;
		 
	}
}
