package pages.operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.elements.UserListElement;

public class UserListOperation extends BaseOperation<UserListElement> {

	public UserListOperation(UserListElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	 public boolean IsProfileAvailable(String ProfileName){
			boolean columnValue = false;
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='providerMaintainUserList']/tbody");
				for(WebElement trElement : tr_collection){
					  if(trElement.getAttribute("class").contains("no-results ng-hide"))
				 			continue;
					   WebElement cell=trElement.findElement(By.xpath("td"+"[1]"));
					
						 if(cell.getText().contains(ProfileName)){ 
							 columnValue = true;
		                		break;
						
					 }
					 if(columnValue){
						 
						 break;
					 } 	 
				}
				
			
			return columnValue;
		}

}
