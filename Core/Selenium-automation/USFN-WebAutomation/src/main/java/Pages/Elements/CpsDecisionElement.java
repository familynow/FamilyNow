package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CpsDecisionElement extends BaseElements {

	public CpsDecisionElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public Select AgreewithRecommendedPriorityAsSubmitted(){
			return GetDropDown("decisionAgreePriority");
		}
	 
	 public Select OverridePriority(){
			return GetDropDown("decisionOverridePriority");
		}
	 
	 public Select IntakeAction(){
			return GetDropDown("screeningDecisionCode");
		}
	 
	 public WebElement PriorityCommentsAsSubmitted(){
			return Driver.findElements(By.xpath("//*[contains(@id,'taTextElement')]")).get(0);
		}
	 
	 public WebElement PriorityComments(){
			return Driver.findElements(By.xpath("//*[contains(@id,'taTextElement')]")).get(1);
		}
	 
	 public WebElement SubmitDecisionButton(){
			
			return GetButton("//button[@id='saveDecision']");
		}
		
		public WebElement ApplyButton(){
			
			return GetButton("//*[contains(text(),'Apply')]");
		}
	 
}
