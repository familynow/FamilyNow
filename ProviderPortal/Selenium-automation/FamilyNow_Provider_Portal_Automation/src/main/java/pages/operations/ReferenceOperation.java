package pages.operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import general.Browser;
import general.Utilities;
import pageControllers.ProviderPageManager;
import pages.elements.ReferenceElement;
import pages.operations.BaseOperation;

public class ReferenceOperation extends BaseOperation<ReferenceElement> {
	public ReferenceOperation(ReferenceElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public String GetApplicant1Name(){
		
	return	Browser.driver.findElement(By.id("supportDocumentForm")).findElements(By.xpath("//h5[@class='ng-binding']")).get(0).getText();
		
		
	}
	
	public String GetApplicant2Name(){
		
		return	Browser.driver.findElement(By.id("supportDocumentForm")).findElements(By.xpath("//h5[@class='ng-binding']")).get(1).getText();
			
			
		}
	
	public boolean IsApplicantAvailable(String ApplicantName){
		boolean isAvailable = false;
		List<WebElement> headers = Browser.driver.findElement(By.id("supportDocumentForm")).findElements(By.xpath("//h5[@class='ng-binding']"));
		for(WebElement header : headers){
			if(header.getText().contains(ApplicantName)){
				isAvailable = true;
				break;
				
			}
			
		}
		
		return isAvailable;
		
	}
	
	public void EnterApplicant1References(){
		 String App1ReferenceName1 =Utilities.GetRandomString(10);
		 ProviderPageManager.ReferencePage().Elements().App1ReferenceName1().sendKeys(App1ReferenceName1);
		 ProviderPageManager.ReferencePage().Elements().App1Contact1().click();
		 ProviderPageManager.ReferencePage().Elements().App1Contact1().sendKeys("111-111-1111");
		 String App1ReferenceName2 =Utilities.GetRandomString(10);
		 ProviderPageManager.ReferencePage().Elements().App1ReferenceName2().sendKeys(App1ReferenceName2);
		 ProviderPageManager.ReferencePage().Elements().App1Contact2().click();
		 ProviderPageManager.ReferencePage().Elements().App1Contact2().sendKeys("222-222-2222");
		 String App1ReferenceName3 =Utilities.GetRandomString(10);
		 ProviderPageManager.ReferencePage().Elements().App1ReferenceName3().sendKeys(App1ReferenceName3);
		 ProviderPageManager.ReferencePage().Elements().App1Contact3().click();
		 ProviderPageManager.ReferencePage().Elements().App1Contact3().sendKeys("333-333-3333");
	}

}
