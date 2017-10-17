package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateNonCpsElement extends BaseElements {

	public CreateNonCpsElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement GetIntakeTime()
	{
		
 		WebElement IntakeTime= Driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/form/div/fieldset/div[1]/div[2]/div/div[2]/div/div/div[2]/input"));
        return IntakeTime;
	}
	
	public WebElement GetFirstName()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath("//input[@id='firstName']"));
        return FirstName;
	}
	
	public WebElement GetMiddleName()
	{
		
 		WebElement MiddleName= Driver.findElement(By.xpath("//input[@id='middleName']"));
        return MiddleName;
	}
	
	public WebElement GetLastName()
	{
		
 		WebElement LastName= Driver.findElement(By.xpath("//input[@id='lastName']"));
        return LastName;
	}
	
   public WebElement intakeComplete(){
		
		WebElement CheckBox = Driver.findElement(By.xpath("//input[@id='intakeComplete']"));
		
		return CheckBox;
		
	}
   
   
   public WebElement IntakeCompleteCheckbox(){
		return Driver.findElement(By.xpath("//*[contains(text(),'Intake Completed')]"));
	}

    public WebElement SaveButton(){
		
		return GetButton("//*[contains(text(),'Save')]");
	}
    
 public WebElement CancelButton(){
		
		return GetButton("//*[contains(text(),'Cancel')]");
	}
	
    //recievedTime
	public WebElement ApplyButton(){
		
		return GetButton("//*[contains(text(),'Apply')]");
	}
	
  

    public WebElement IntakeTime(){
		
    return	Driver.findElement(By.xpath("//*[contains(@name,'recievedTime')]"));
		
	}
    
    
    public WebElement CompetedDate(){
		
        return	Driver.findElement(By.xpath("//*[contains(text(),'Date Completed')]/label"));
    		
    	}
    
    // 

    public WebElement IntakeDate(){
		
		return GetButton("//*[contains(@name,'receivedDate')]");
	}
	
	
	
   public WebElement LinkPersonButton(){
		
		return GetButton("//*[contains(text(),'Link Person')]");
	}
   
   public WebElement UnLinkPersonButton(){
		
		return GetButton("//*[contains(text(),'Unlink Person')]");
	}
	
   
   public WebElement OtherTextBox(){
		
	   
		return Driver.findElement(By.xpath("//input[@id='reportingRoleOther']"));
	}
   
	
	public Select SelectIntakeType(){
		return GetDropDownByXpath("//*[contains(@name,'intakeType')]");
	}
	
	public Select SelectIntakeMethod(){
		return GetDropDown("intakeMethod");
	}
	public Select OrganizationCategory(){
		
		
		return GetDropDownByXpath("//*[contains(@name,'agency')]");
	}
	
	public Select Organization(){
		
		return GetDropDownByXpath("//*[contains(@name,'county')]");
	}
	
	public Select AMPM(){
		return GetDropDownByXpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/form/div/fieldset/div[1]/div[2]/div/div[2]/div/div/div[3]/select");
	}
	public Select TimeZone(){
		return GetDropDownByXpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/form/div/fieldset/div[1]/div[2]/div/div[2]/div/div/div[4]/select");
	}
	
	 public WebElement IntakeNarrative(){
			
			return GetButton("//*[contains(@id,'taTextElement')]");
		}
	 
	 public Select SelectReportingPerson(){
		 
			return GetDropDownByXpath("//*[contains(@name,'personRole')]");
		}
	 

}
