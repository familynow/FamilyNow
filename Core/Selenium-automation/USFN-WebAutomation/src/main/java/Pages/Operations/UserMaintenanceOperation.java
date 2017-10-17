package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.UserMaintenanceElement;

public class UserMaintenanceOperation extends BaseOperations<UserMaintenanceElement> {

	public UserMaintenanceOperation(UserMaintenanceElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void NavigateToUserMaintenancePage(){
		
		List<WebElement> allElements = Browser.driver.findElements(By.xpath("//ul[@class='to-do-list administration-list']//li"));
		int size = allElements.size();
		for (WebElement element : allElements) {
			
		String test = element.getText();

			if (element.getText().contains("Security")) {
				element.findElement(By.linkText("Security")).click();
				break;
			}

		}
		
	}
	
public boolean IsColumnValueAvailable(String userId,String columnValueToBeSearched){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@class='table table-striped flip-content']/tbody");
		for(WebElement trElement : tr_collection)
        {
			if(trElement.getAttribute("class").contains("no-results ng-hide"))
    			continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[2]"));
			 String test = cell.getText();
                if(cell.getText().contains(userId)){ 
                	WebElement getParentRow =  cell.findElement(By.xpath("./.."));
                	if(getParentRow.getText().contains(columnValueToBeSearched)){
                		columnValue = true;
                		break;
            	
               }
            }
           
        }
		
		return columnValue;
	}

public void ClickEdit(String userId){
	
	
	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@class='table table-striped flip-content']/tbody");
	for(WebElement trElement : tr_collection)
    {
		if(trElement.getAttribute("class").contains("no-results ng-hide"))
			continue;
		 WebElement cell =  trElement.findElement(By.xpath("td[2]"));
		 String test = cell.getText();
            if(cell.getText().contains(userId)){ 
            	WebElement getParentRow =  cell.findElement(By.xpath("./.."));
            	getParentRow.findElement(By.xpath(".//td[1]/a")).click();
        	
           }
        }
       
    }
	
	

	
	public String GetColumnValue(String userId, int ColumnIndex) {
        String searchedValue ="";
		List<WebElement> tr_collection = Element
				.GetTableBodyRows("//table[@class='table table-striped flip-content']/tbody");
		for (WebElement trElement : tr_collection) {
			if (trElement.getAttribute("class").contains("no-results ng-hide"))
				continue;
			WebElement cell = trElement.findElement(By.xpath("td[2]"));

			if (cell.getText().contains(userId)) {

				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				searchedValue =	getParentRow.findElement(By.xpath(".//td["+String.valueOf(ColumnIndex)+"]")).getText();

				break;

			}

		}
		
		return searchedValue;

	}

}
