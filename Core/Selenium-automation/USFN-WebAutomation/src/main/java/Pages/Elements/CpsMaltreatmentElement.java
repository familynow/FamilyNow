package Pages.Elements;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import General.Browser;


public class CpsMaltreatmentElement extends BaseElements {

	public CpsMaltreatmentElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
   public WebElement ApplyButton(){
		
		return GetButton(".//*[@id='Apply']");
	}
   
   public Select AllegationType(){
	   return GetDropDown("AllegationType");
   }
   
   public WebElement AddAlligationButton(){
		System.out.println("In Add alligation button");
		return  Driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div[2]/div/div/form/div[2]/div[3]/div[2]/div[4]/button"));
		
	}
   
   public WebElement SaveButton(){
		return GetButton("//button[@id='Save']");
	}
   



 public WebElement SubmitForApproval(){
		
		return GetButton("//button[@id='approval']");
	}
   
   public WebElement DuplicateWarning(){
		
	 return  Driver.findElement(By.xpath("//div[@type='danger']"));
		
	}
   
   public Select RiskFactor(){
		return GetDropDown("availableRiskFactors");
	}
   
   public Select RemoveRiskFactor(){
		return GetDropDown("selectedRiskFactors");
	}
   
   public Select  LivingArrangementAtTheTimeOfIntake(){
		return GetDropDown("livingArrangements");
	}
   
   public Select  LivingArrangementAtTheTimeOfOccurrence(){
		return GetDropDown("allegationLivingArrangement");
	}
   
   
   
  
   
   public WebElement MoveItemRight(int index){
		
		List<WebElement> moveRightButton = Driver.findElements(By.xpath(".//*[@id='move-item-right']"));
		  return moveRightButton.get(index);
		}
		
  public WebElement MoveItemLeft(int index){
			
			List<WebElement> moveLeftButton = Driver.findElements(By.xpath(".//*[@id='move-item-left']"));
			  return moveLeftButton.get(index);
			}


}
