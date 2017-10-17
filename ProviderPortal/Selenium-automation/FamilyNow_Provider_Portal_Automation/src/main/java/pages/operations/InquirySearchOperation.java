package pages.operations;

import general.Browser;
import general.GetConfigValue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




import pageControllers.ProviderPageManager;
import pages.elements.InquirySearchElement;

public class InquirySearchOperation extends BaseOperation<InquirySearchElement>{

	public InquirySearchOperation(InquirySearchElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
public boolean IsInquiryAvailable(String InquiryName){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='providerTable']/tbody");
		for(WebElement trElement : tr_collection) {
			
			  WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
	            if(cell.getText().contains(InquiryName)){ 
	              columnValue = true;
	              break; 	
	        	
	           
	        }
	        if(columnValue){
				 
				 break;
			 } 
	    }
		
		return columnValue;
	}

	public void Login() {
		String getUrl = GetConfigValue.MainPortalUrl();
		Browser.driver.get(getUrl);
		try {
			Thread.sleep(2000);
			Element.Email().sendKeys("familynow@unisys.com");
			Element.Password().sendKeys("Welcome1");
			Element.LoginButton().click();
			Thread.sleep(1000);
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void SearhInquiry(String Fname,String Lname ){
		Element.Organization().selectByVisibleText("Ingham County");
		Element.FirstName().sendKeys(Fname);
		Element.LastName().sendKeys(Lname);
		Element.SearchButton().click();
	}
	
	public void NavigateToInquirySearchPage(){
		Browser.driver.findElement(By.linkText("View All Inquiries")).click();
		
	}

}
