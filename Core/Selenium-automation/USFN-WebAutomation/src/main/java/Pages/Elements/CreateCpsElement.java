package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCpsElement  extends BaseElements {

	public CreateCpsElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public WebElement GetIntakeTime()
	{
		
 		WebElement IntakeTime= Driver.findElement(By.xpath("//input[@name='recievedTime']"));
        return IntakeTime;
	}
	
	public WebElement GetIntakeDate()
	{
		
 		WebElement IntakeDate= Driver.findElement(By.xpath("//input[@id='receivedDate']"));
        return IntakeDate;
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
	
	public WebElement GetWantToRemainAnonymous()
	{
		
 		WebElement WantToRemainAnonymous= Driver.findElement(By.xpath("//*[contains(text(),'Want to remain anonymous')]"));
        return WantToRemainAnonymous;
	}
	
	public WebElement GetRequestedTheInformation()
	{
		
 		WebElement RequestedTheInformation= Driver.findElement(By.xpath("//input[@ng-model='intakeData.reporters[0].repRequestInfoFlag' AND @type='checkbox']"));
        return RequestedTheInformation;
	}
	
	public WebElement GetWasInformedOfTheInformationHeIsEntitledToReceive()
	{
		
 		WebElement WasInformedOfTheInformationHeIsEntitledToReceive= Driver.findElement(By.xpath("//input[@ng-model='intakeData.reporters[0].repInformedInfoEntitlFlag' AND @type='checkbox']"));
        return WasInformedOfTheInformationHeIsEntitledToReceive;
	}
	
	public WebElement GetRefusedToGiveAnyIdentificationInformation()
	{
		
 		WebElement RefusedToGiveAnyIdentificationInformation= Driver.findElement(By.xpath("//*input[@ng-model='intakeData.reporters[0].repRefuseIdInfoFlag' AND @type='checkbox']"));
        return RefusedToGiveAnyIdentificationInformation;
	}
	
	public WebElement GetIsMandatoryReporterInformation()
	{
		
 		WebElement IsMandatoryReporterInformation= Driver.findElement(By.xpath("//input[@ng-model='intakeData.reporters[0].mandatedReporterFlag' AND @type='checkbox']"));
        return IsMandatoryReporterInformation;
	}
   
	public WebElement LinkPersonButton(){
		
		
        return  Driver.findElement(By.xpath("//button[@id='linkPerson']")) ;
		
	}
	
	public WebElement GetAlligationNotes(){
		
		WebElement AlligationNotes = Driver.findElement(By.xpath("//*[contains(@id,'taTextElement')]")) ;
		return AlligationNotes;
	}
	
	public WebElement SaveButton(){
		
		return GetButton("//button[@id='save']");
	}
	
	public WebElement ApplyButton(){
		
		return GetButton("//button[@id='apply']");
	}
	
  public WebElement SubmitForApproval(){
		
		return GetButton("//button[@id='approval']");
	}
	
	
	

	public Select SelectIntakeMethod(){
		return GetDropDown("methodCode");
	}
	
	public Select CountyOfResponsibility(){
		return GetDropDown("county");
	}
	
	public Select PersonCategory(){
		return GetDropDown("personCategory");
	}
	
	public Select PersonRole(){
		return GetDropDown("personRole");
	}
	
	
	
	public Select FeedbackRequested(){
		return GetDropDown("feedbackRequested");
	}
	
	 public List<WebElement> GetAllDropDowns(){
	    	List<WebElement>  AllDropDowns =   Driver.findElements(By.xpath(".//select"));
	    	
	    	return AllDropDowns;
	    	
	    }
	 
	 public List<WebElement> GetAllCheckBox(){
	    	List<WebElement>  AllCheckBox =   Driver.findElements(By.xpath("//input[@type='checkbox']"));
	    	
	    	return AllCheckBox;
	    	
	    }
	 
	
	public static void CloseBrowser(){
		Driver = null;
	}
}
