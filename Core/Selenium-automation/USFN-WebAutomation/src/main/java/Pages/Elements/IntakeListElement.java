package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntakeListElement extends BaseElements {
	//WebDriver Driver;
		public IntakeListElement(WebDriver driver) {
			super(driver);
			  
			
		}
		
		public WebElement GetCpsButton()
		{
			
	 		WebElement AddCpsIntakeButton= Driver.findElement(By.xpath("//*[contains(text(),'Add CPS Intake')]"));
	        return AddCpsIntakeButton;
		}
		
		public WebElement ViewAllCpsIntake(){
			WebElement ViewAll= Driver.findElement(By.xpath("//a[@id='intakeViewAll']"));
	        return ViewAll;
			
		}
		
		public WebElement GetIntakeList(){
			
			WebElement IntakeList= Driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[5]/a"));
	        return IntakeList;
			
		}
		
	    public WebElement GetIntakeWorkLoad(){
			
			WebElement IntakeWorkLoad= Driver.findElement(By.xpath(".//*[@id='sidebar']/ul/li[2]/a/i[2]"));
	        return IntakeWorkLoad;
			
		}
	    
	    public WebElement GetAwaitingScreeningRow(int RowIndex){
	    	
	    	 WebElement allTableBody=Driver.findElement(By.xpath("//table[@id='awaiting']//tbody"));
	        return allTableBody.findElement(By.xpath(".//tr["+String.valueOf(RowIndex)+"]"));
	    	
	    }
	    
	    public WebElement GetPendingRow(int RowIndex){
	    	
	    	 WebElement allTableBody=Driver.findElements(By.xpath(".//tbody")).get(0);
	        return allTableBody.findElement(By.xpath(".//tr["+String.valueOf(RowIndex)+"]"));
	    	
	    }
	    
	    public WebElement GetSubmittedRow(int RowIndex){
	    	
	    	 WebElement allTableBody=Driver.findElement(By.xpath("//table[@id='submittedCps']//tbody"));
	        return allTableBody.findElement(By.xpath(".//tr["+String.valueOf(RowIndex)+"]"));
	    	
	    }
	    public static void CloseBrowser(){
			Driver = null;
		}

}
