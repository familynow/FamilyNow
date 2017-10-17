package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ResponsePriorityElement  extends BaseElements{

	public ResponsePriorityElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public Select  ProvideRecommendedPriority(){
			return GetDropDown("decisionOverridePriority");
		}
	 
	 
	 public WebElement Comment(){
			
			return GetButton("//*[contains(@id,'taTextElement')]");
			
			
		}
	 
	 public WebElement GetRecommentdedResponse()
		{
			
	 		WebElement MiddleName= Driver.findElement(By.xpath("//div[@id='text-green']"));
	        return MiddleName;
		}
	 
	 public WebElement NoRadioButon(){
		 
		    WebElement parentDiv =  Driver.findElement(By.xpath("//div[@class='form-field']"));
			return parentDiv.findElements(By.xpath("label/span")).get(1);
		}
	 
	 public WebElement YesRadioButon(){
			
		 WebElement parentDiv =  Driver.findElement(By.xpath("//div[@class='form-field']"));
			return parentDiv.findElements(By.xpath("label/span")).get(0);
		}
	 
		public WebElement SaveButton(){
			return GetButton("//button[contains(text(),'Save')]");
		}
		
		public WebElement ApplyButton(){
			return GetButton("//button[contains(text(),'Apply')]");
		}
		 public WebElement SubmitForApproval(){
				
				return GetButton("//button[@id='approval']");
			}
		
		public WebElement ProvideRecommendedPriorityRequireWarningMessage(){
			
			return Driver.findElement(By.xpath("//*[contains(text(),'Please select recommended priority')]"));
			
		}
	 

	 
	


}
