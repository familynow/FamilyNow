package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Elements.SummaryElement;

public class SummaryOperation extends BaseOperations<SummaryElement> {

	public SummaryOperation(SummaryElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public boolean IsColumnAvailabeInSummaryGrid(String Name ,String ColumntoBeSearched){
	   
	    do
	    {
	    	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='participantSummary']/tbody");
	    	
	    	for(WebElement trElement : tr_collection){
	    		
	    		if(trElement.getAttribute("class").contains("ng-hide"))
	    			continue;
	    		 WebElement cell =  trElement.findElement(By.xpath("td[2]"));
	    		 if(cell.getText().contains(Name)){
	    			 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
	    			 String test = getParentRow.getText();
	    			 if(getParentRow.getText().contains(ColumntoBeSearched))
						 return true;
	    			 
	    		 }
	    	}
	    } while (PaginationClickNext());
	    NavigateToFirstPage();
	    
	    return false;
	}
	
	public boolean IsVictimAvailable(String VictimName){
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegations']/tbody");{
			for(WebElement trElement : tr_collection){
				if(trElement.getAttribute("class").contains("ng-hide"))
	    			continue;
				 WebElement cell = trElement.findElement(By.xpath("td"+"[4]"));
					 if(cell.getText().contains(VictimName)){ 
						 columnValue = true;
	                		break;
					 }
				 if(columnValue){
					 
					 break;
				 } 	 
			}
			
		}
		return columnValue;
	}
	
  public boolean IsPerpetatorAvailable(String PerpetatorName){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegations']/tbody");
		for(WebElement trElement : tr_collection)
	    {
			 List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[5]"));
	        for(WebElement tdElement : td_collection){
	        	String test = tdElement.getText();
	            if(tdElement.getText().contains(PerpetatorName)){ 
	              columnValue = true;
	              break; 	
	        	
	           }
	        }
	        if(columnValue){
				 
				 break;
			 } 
	    }
		
		return columnValue;
	}

}
