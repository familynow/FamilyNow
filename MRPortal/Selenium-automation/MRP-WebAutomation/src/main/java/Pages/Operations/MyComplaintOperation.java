package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Elements.MyComplaintElement;

public class MyComplaintOperation extends BaseOperations<MyComplaintElement> {

	public MyComplaintOperation(MyComplaintElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
public boolean IsComplaintAvailable(String ComplaintId){
	
	do{
		try{
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='complaints']/tbody");
			for(WebElement trElement : tr_collection){
				  WebElement cell =  trElement.findElement(By.xpath("td"+"[1]"));
				 if(cell.getText().contains(ComplaintId)){
					 NavigateToFirstPage();
					 return true;
				 }
				
			}
		}
		
		catch (Exception e)
	    {

	    }
	}while (PaginationClickNext());
		
	 NavigateToFirstPage();
		return false;
	}

public String GetStatus(String ComplaintId){
    String status = null;
    do
    {
    	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='complaints']/tbody");
    	for(WebElement trElement : tr_collection){
    		 WebElement cell =  trElement.findElement(By.xpath("td"+"[1]"));
    		 if(cell.getText().contains(ComplaintId)){
    			 status= trElement.findElement(By.xpath("td"+"[4]")).getText();
    			 break;
    		 }
    		
    	}
    } while (PaginationClickNext());
    NavigateToFirstPage();
    
    return status;
}

public void ClickComplaint(String ComplaintId){
	do
    {
    	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='complaints']/tbody");
    	for(WebElement trElement : tr_collection){
    		 WebElement cell =  trElement.findElement(By.xpath("td"+"[1]"));
    		 if(cell.getText().contains(ComplaintId)){
    			 trElement.findElement(By.xpath("td[1]/a")).click();
    			 break;
    		 }
    		
    	}
    } while (PaginationClickNext());
    
	  
}



public boolean IsComplaintNameAvailable(String ComplaintName){
	do{
		try{
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='complaints']/tbody");
			for(WebElement trElement : tr_collection){
				if(trElement.getAttribute("class").contains("ng-hide"))
	    			continue;
				  WebElement cell =  trElement.findElement(By.xpath("td[2]/span/span"));
				 
				 if(cell.getText().contains(ComplaintName)){
					 NavigateToFirstPage();
					 return true;
				 }
				
			}
		}
		
		catch (Exception e)
	    {

	    }
	}while (PaginationClickNext());
		
	 NavigateToFirstPage();
		return false;
	
}

public void ClickDeleteIcon(String ComplaintId){
	do{
		try{
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='complaints']/tbody");
			for(WebElement trElement : tr_collection){
				  WebElement cell =  trElement.findElement(By.xpath("td"+"[1]"));
				 if(cell.getText().contains(ComplaintId)){
					 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					 getParentRow.findElement(By.xpath(".//td[7]/a/span[@tooltip='Delete']")).click();
					 break;
					 
				 }
					
				
			}
		}
		
		catch (Exception e)
	    {

	    }
	}while (PaginationClickNext());
		
	  NavigateToFirstPage();
	
	
}


	
	

}
