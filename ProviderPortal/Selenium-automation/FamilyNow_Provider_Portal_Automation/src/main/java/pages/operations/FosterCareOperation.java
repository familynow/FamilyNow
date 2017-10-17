package pages.operations;

import general.Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageControllers.ProviderPageManager;
import pages.elements.FosterCareElement;
import pages.operations.BaseOperation;

public class FosterCareOperation extends BaseOperation<FosterCareElement> {
	public FosterCareOperation(FosterCareElement element) {
		super(element);
		
	}
	
	
	public void DateOfBirth(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[5]/ng-include/div/div[1]/div[2]/form/div/div[4]/div/div/div[3]/div[3]/div/span/i","html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[5]/ng-include/div/div[1]/div[2]/form/div/div[4]/div/div/div[3]/div[3]/div/span/div/ul/li[1]/div/div/div/table/tbody");
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
	public void NavigateAndFillRequiredField(){
		 ClickNavigationWizard("Foster Care/ Adoption History");
		 ApplyWait(Browser.driver);
		 Element.Adoption().selectByVisibleText("No");
		 Element.Fostercare().selectByVisibleText("No");
		 Element.ChildIdentifiedCode().selectByVisibleText("No");
		
	}

}
