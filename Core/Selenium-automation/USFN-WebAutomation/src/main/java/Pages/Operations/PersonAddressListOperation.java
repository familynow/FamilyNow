package Pages.Operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.NonCpsIntakeListElement;
import Pages.Elements.PersonAddressListElement;

public class PersonAddressListOperation  extends BaseOperations<PersonAddressListElement> {

	public PersonAddressListOperation(PersonAddressListElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	
public boolean IsColumnValueAvailable(String contact,String columnValueToBeSearched){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='personContact']/tbody");
		for(WebElement trElement : tr_collection)
        {
			
			if(!trElement.getText().contains("No Results Found.")){
			 List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[3]"));
            
            for(WebElement tdElement : td_collection){          	
                if(tdElement.getText().contains(contact)){ 
                	WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
                	
                	if(getParentRow.getText().contains(columnValueToBeSearched)){
                		columnValue = true;
                		break;
                		
                	}
            	
               }
            }
            if(columnValue){
				 
				 break;
			 } 
         }
        }
		
		return columnValue;
      }

public void DeleteContact(String contact){
	  
    boolean actionPerformed = false;
    List<WebElement> td_collection=null;
	  List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='personContact']/tbody");
	  for(WebElement trElement : tr_collection){
		
		
		      td_collection=trElement.findElements(By.xpath("td"+"[3]"));
		 
		 for(WebElement tdElement : td_collection){
				if(tdElement.getText().contains(contact)){
					WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
					WebElement getActionColumn =   getParentRow.findElement(By.xpath(".//td[6]"));
					
						
						getActionColumn.findElement(By.xpath("//span[@tooltip='Delete']")).click();
						Alert alert = Browser.driver.switchTo().alert();
						   alert.accept();
						   actionPerformed=true;
						   break;
						
					
					
					
				}
				 if(actionPerformed){
					 
					 break;
				 }
		 }
		 if(actionPerformed){
			 
			 boolean test = actionPerformed;
			 
			 break;
		 }
	  }
  }
}
