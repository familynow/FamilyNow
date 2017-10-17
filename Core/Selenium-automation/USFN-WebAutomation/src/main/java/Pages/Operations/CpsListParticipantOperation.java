package Pages.Operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.CpsListParticipantElement;

public class CpsListParticipantOperation extends BaseOperations<CpsListParticipantElement> {

	public CpsListParticipantOperation(CpsListParticipantElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
public boolean IsColumnValueAvailable(String participantName,String columnValueToBeSearched){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
		for(WebElement trElement : tr_collection)
        {
			if(trElement.getAttribute("class").contains("no-results ng-hide"))
    			continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[3]"));
                if(cell.getText().contains(participantName)){ 
                	WebElement getParentRow =  cell.findElement(By.xpath("./.."));
                	if(getParentRow.getText().contains(columnValueToBeSearched)){
                		columnValue = true;
                		break;
            	
               }
            }
           
        }
		
		return columnValue;
	}

public boolean IsParticipantAllegedPerpetrator(String participantName,int columnIndex){
	
	boolean columnValue= false;
	List<WebElement> tr_collection = Element.GetTableBodyRows("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/div[3]/div/div/div[2]/div/div/table/tbody");
	for(WebElement trElement : tr_collection)
    {
     List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"["+String.valueOf(columnIndex)+"]"));
     
     for(WebElement tdElement : td_collection)
     {
     	String test =tdElement.getText();
     	          	
     	if(tdElement.getText().contains(participantName)){
     		
     		try {
     		
     		   if(tdElement.findElement(By.xpath(".//span/span")).getText().contains("!")){
     		    columnValue=true;
     		    break;
     		   }
     		}
     		
     		catch(Exception e) {
     			
     			 columnValue=false;
     			
     		}
     	}
       
     }
 }
	
	return columnValue;
}

public boolean ClickParticipantId(String participantName){
	
	boolean columnValue = false;
	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
	for(WebElement trElement : tr_collection){
		 if(trElement.getAttribute("class").contains("no-results ng-hide"))
	  			continue;
				 WebElement cell =  trElement.findElement(By.xpath("td[3]"));
  
         	
  	if(cell.getText().contains(participantName)){
  		
  		WebElement getParentRow =  cell.findElement(By.xpath("./.."));
  	 	getParentRow.findElement(By.xpath(".//td[1]/a")).click();
  		
  		   
  		    break;
  		   
 
    
  }
  
  
}
	
	return columnValue;
}

  public void PerformAction(String participantName,String ActionName, boolean closeInformation){
	  
	  List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
	  for(WebElement trElement : tr_collection){
		  if(trElement.getAttribute("class").contains("no-results ng-hide"))
  			continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[3]"));
	
				if(cell.getText().contains(participantName)){
					WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					WebElement getActionColumn =   getParentRow.findElement(By.xpath(".//td[9]"));
					if(ActionName.contains("Make Intake Name")){
						
						getActionColumn.findElement(By.xpath("//span[@tooltip='"+ActionName+"']")).click();
						Alert alert = Browser.driver.switchTo().alert();
						   alert.accept();
						  
						   break;
						
					}
                      if(ActionName.contains("Search and Link")){
						
						getActionColumn.findElement(By.xpath("//span[@tooltip='"+ActionName+"']")).click();
						   break;
						
					}
					
					else {
					   getActionColumn.findElement(By.xpath("//a[@tooltip='"+ActionName+"']")).click();
					   
					   if(closeInformation){
					   
					     Element.InformationDialoogOKButton().click();
					   }
					   
					   else {
						   
							Alert alert = Browser.driver.switchTo().alert();
						    alert.accept();
						   
					   }
					 
					  
					   break;
					}
					
					
				}
				 
	  }
  }
  
  
public boolean VerifyActionIconIsPresent(String participantName,String ActionName){
	  
	  
	  boolean isActionAvailable = false;
	  boolean actionPerformed = false;
	  List<WebElement> td_collection=null;
	  List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
	  for(WebElement trElement : tr_collection){
		  if(trElement.getAttribute("class").contains("no-results ng-hide"))
	  			continue;
				 WebElement cell =  trElement.findElement(By.xpath("td[3]"));
	
	   if(cell.getText().contains(participantName)){
		  WebElement getParentRow =  cell.findElement(By.xpath("./.."));
	      WebElement getActionColumn =   getParentRow.findElement(By.xpath(".//td[9]"));
	    try {
	    	
	      if(ActionName.contains("Make Intake Name")){
	        getActionColumn.findElement(By.xpath("//span[@tooltip='"+ActionName+"']"));
		    isActionAvailable=true;
		    actionPerformed=true;
		     break;
	      }
	      
	      if(ActionName.contains("Search and Link")){
		        getActionColumn.findElement(By.xpath("//span[@tooltip='"+ActionName+"']"));
			    isActionAvailable=true;
			    actionPerformed=true;
			     break;
		      }
	     else {
	       getActionColumn.findElement(By.xpath("//a[@tooltip='"+ActionName+"']"));
		   isActionAvailable=true;
		   actionPerformed=true;
		    break;
		    }
					
		}
		catch (Exception e){
			isActionAvailable = false;
			actionPerformed=true;
			break;
		 }
		}
				 
	   }
		
	
	
	  
	  return isActionAvailable;
  }

}
