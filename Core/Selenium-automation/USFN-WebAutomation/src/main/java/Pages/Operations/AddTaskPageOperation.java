package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Elements.AddTaskPageElement;

public class AddTaskPageOperation extends BaseOperations<AddTaskPageElement> {

	public AddTaskPageOperation(AddTaskPageElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public boolean IsResponsiblePartyAddedd(String Name,String ColumnValueToBeSearched){
		boolean responsiblePartyAddedd = false;
		
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
		for (WebElement trElement : tr_collection) {
			if (trElement.getAttribute("class").contains("no-results ng-hide"))
				continue;
			WebElement cell = trElement.findElement(By.xpath("td[2]"));
			if (cell.getText().contains(Name)) {
				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				if (getParentRow.getText().contains(ColumnValueToBeSearched)) {
					responsiblePartyAddedd = true;
					 break;

				}
				
			}

		}
		
		return responsiblePartyAddedd;
		
	}
	
	public void EnterFromDate(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div/form[1]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/span/i","html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div/form[1]/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div/span/ul/li[1]/div/table/tbody");
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
	
	public void EnterToDate(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div/form[1]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/span/i","html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div/form[1]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/span/ul/li[1]/div/table/tbody");
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
	
	public void EnterAddResponsiblePartyRequiredField(String ContactType,String Contact,String Role){
		Element.SelectParticipant().selectByIndex(1);
		Element.ContactType().selectByVisibleText(ContactType);
		Element.Contact().sendKeys(Contact);
		Element.Role().selectByVisibleText(Role);
		
	}

}
