package pages.operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.elements.MyApplicationElement;
import pages.operations.BaseOperation;

public class MyApplicationOperation   extends BaseOperation<MyApplicationElement>{
	public MyApplicationOperation(MyApplicationElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public boolean IsColumnAvailabeInApplicationGrid(String Name ,String ColumntoBeSearched){
		   
	    do
	    {
	    	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='providerList']/tbody");
	    	
	    	for(WebElement trElement : tr_collection){
	    		
	    		if(trElement.getAttribute("class").contains("no-results ng-hide"))
	    			continue;
	    		 WebElement cell =  trElement.findElement(By.xpath("td[1]"));
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
	
	public boolean IsDeleteIconAvailabe(String Name){
		 do
		    {
		    	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='providerList']/tbody");
		    	
		    	for(WebElement trElement : tr_collection){
		    		
		    		if(trElement.getAttribute("class").contains("no-results ng-hide"))
		    			continue;
		    		 WebElement cell =  trElement.findElement(By.xpath("td[1]"));
		    		 if(cell.getText().contains(Name)){
		    			 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
		    			 try{
		    			 getParentRow.findElement(By.xpath("td[6]//span[@class='fa fa-trash-o clickable ng-scope']"));
		    			 return true;
		    			 }
		    			 catch (Exception exp){
		    				 return false;
		    				 
		    			 }
		    			 
		    		 }
		    	}
		    } while (PaginationClickNext());
		    NavigateToFirstPage();
		    
		    return false;
		
	}
	
	

}
