package pages.operations;

import general.Browser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageControllers.ProviderPageManager;
import pages.elements.ApplicationTypeElement;
import pages.operations.BaseOperation;

public class ApplicationTypeOperation extends BaseOperation<ApplicationTypeElement> {
	public 	WebDriverWait wait;

	public ApplicationTypeOperation(ApplicationTypeElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public void NavigateToApplicationTypePage(){
	
		ProviderPageManager.MyApplicationPage().Elements().CreateNewProviderApplicationButton().click();

	}
	
	public void NavigateAndFillRequiredField(){
		 DateFormat dateFormat = new SimpleDateFormat("dd");
	     Date date = new Date();
	     String todayDate = dateFormat.format(date);
		 NavigateToApplicationTypePage();
		 ApplyWait(Browser.driver);
		 ProviderPageManager.ApplicationTypePage().Operation().EnterRequiredField("Adoptive Parent", todayDate);
		
	}
	
	public void ApplicationType(String ApplicationType){
		Element.YouCanStartBySelectingApplicationType().selectByVisibleText(ApplicationType);
	}
	
	public void ApplicationDate(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/ng-include/form/div/div[2]/div/div/div[2]/div/span/i","html/body/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/ng-include/form/div/div[2]/div/div/div[2]/div/span/ul/li[1]/div/table/tbody");
	      boolean datefound = false;
	      for(WebElement trElement : tr_collection)
	      {
	    	   List<WebElement> allDates=trElement.findElements(By.xpath("td")); 
			for(WebElement ele:allDates)
			{
				
				if(ele.getText().equals(date))
				{
					ele.findElement(By.xpath("button")).click();
					datefound = true;
					break;
				}
				
			}
			
			if(datefound){
				break;
			}
			
	      }
			
		}
	
	public void EnterRequiredField(String ApplicationType,String Date){
		ApplicationType(ApplicationType);
		//ApplicationDate(Date);
		
	}

}
