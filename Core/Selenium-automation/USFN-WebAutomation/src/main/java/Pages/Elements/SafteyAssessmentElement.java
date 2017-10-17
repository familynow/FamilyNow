package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SafteyAssessmentElement extends BaseElements {

	public SafteyAssessmentElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement AddSafteyAssessmentButton(){
	    return	Driver.findElement(By.id("add-safety-assessment"));
	}
	
	public WebElement SafteyAssessmentCancelButton(){
	    return	Driver.findElement(By.id("safetyAssessmentCancel"));
	}
	
	//
	
	public WebElement SafetyAssessmentDetailsSaveButton(){
		return Driver.findElement(By.id("safetyAssessmentSave"));
	}
	public WebElement SafetyDecisionSaveButton(){
		return Driver.findElement(By.xpath("//form[@id='safetyDecision']//button[@id='safetyAssessmentSave']"));
	}
	
	public WebElement SafetyAssessmentDetalCancelButton(){
		return Driver.findElement(By.xpath("//div[@id='safetyAssessmentDetails']//button[@id='safetyAssessmentCancel']"));
	}
	
	public WebElement SafetyDecisionApplyButton(){
		return Driver.findElement(By.xpath("//form[@id='safetyDecision']//button[@id='safetyAssessmentApply']"));
	}
	//
	
	public List<WebElement> ResponseCheckBoxes(){
		return Driver.findElements(By.xpath("//div[@id='safetyHarmFactors']//div[@class='checkbox']/label//span[@class='text']"));
	}
	
	public WebElement NextButton(){
		return  Driver.findElement(By.linkText("Next"));
	}
	
	public WebElement ExplainTextArea(){
		
		return GetButton("//*[contains(@id,'taTextElement')]");
			
	}
	
	public WebElement SfteyResponseTextArea(){
		return Driver.findElement(By.xpath("//div[@id='safetyResponseComments']//*[contains(@id,'taTextElement')]"));
		
	}
	
	public WebElement LegalActionTextArea(){
		return Driver.findElement(By.xpath("//div[@id='LegalActionComments']//*[contains(@id,'taTextElement')]"));
		
	}
	
	public WebElement ImmediateHarmFactorSaveButton(){
	    return	Driver.findElement(By.id("saImmediateHarmFactorSave"));
	}
	
	public WebElement InterventionSaveSaveButton(){
	    return	Driver.findElement(By.id("saInterventionSave"));
	}
	
	
	public WebElement SafteyDecisionNoCheckbox(){
		return Driver.findElements(By.xpath("//span[@class='radio ng-scope']//span[(@class='text ng-binding')]")).get(1);
		
	}
	public WebElement SafteyDecisionYesCheckbox(){
		return Driver.findElements(By.xpath("//span[@class='radio ng-scope']//span[(@class='text ng-binding')]")).get(0);
		
	}
  public Select YoungestInjured(){
		
		Select availableRole = new Select(Driver.findElement(By.xpath("//form[@id='safetyDecision']//select[@id='youngestInjured']")));
		return availableRole;
	}
  
  public Select SeriousInjury(){
		
		Select availableRole = new Select(Driver.findElement(By.xpath("//form[@id='safetyDecision']//select[@id='seriousInjury']")));
		return availableRole;
	}
	
  public WebElement CreatePlanButton(){
	  return Driver.findElement(By.id("safetyAssessmentCreatePlan"));
  }



}
