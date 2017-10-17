package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.PersonSearchElement;

public class PersonSearchOperation extends BaseOperations<PersonSearchElement>  {

	public PersonSearchOperation(PersonSearchElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void EnterPersonId(String personId){
		
		Element.GetPersonId().sendKeys(personId);
	}
	
	public void ClickSearch(){
		Element.GetSearchButton().click();
	}
	
	public void SelectFirstRecord(){
		
		Browser.driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[1]/a")).click();
	}

public void SelectRecord(int RowIndex){
		
		
			Browser.driver.findElement(By.xpath("//table[@id='personSearchResults']/tbody/tr["+String.valueOf(RowIndex+1)+"]/td[1]/a")).click();
            
           

	}

   public String GetName(int RowIndex){
	   String Name = null;
	   Name=Browser.driver.findElement(By.xpath("//table[@id='personSearchResults']/tbody/tr["+String.valueOf(RowIndex+1)+"]/td[3]")).getText();
	   return Name;
       }
        
   public boolean VerifyPersonIsAvailable(String personId){
		boolean intakeAvailable = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("html/body/div[1]/div[4]/div/div/div/div/div/div[6]/div[2]/div/table/tbody");
		for(WebElement trElement : tr_collection){
			 List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[2]"));
	            
	            for(WebElement tdElement : td_collection){
	            	
	            	String test = tdElement.getText();
	                if(tdElement.getText().contains(personId)){ 
	                	intakeAvailable =true;
	                	break;
	                }
			
		}
		
	   }
		return intakeAvailable;
	}
       
   
}
