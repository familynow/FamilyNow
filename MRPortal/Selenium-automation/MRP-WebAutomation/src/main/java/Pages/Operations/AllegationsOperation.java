package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.AllegationsElement;



public class AllegationsOperation extends BaseOperations<AllegationsElement> {

	public AllegationsOperation(AllegationsElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public void DateofAllegedAbuse(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/form/fieldset/div[1]/div[2]/div[1]/div[1]/div[1]/span/i","html/body/div[1]/div[3]/div/div/div[2]/div/div[3]/form/fieldset/div[1]/div[2]/div[1]/div[1]/div[1]/span/ul/li[1]/div/table/tbody");
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
	
	
	public void SelectAllegation(String AllegationType){
		Element.AllegationTypeDropdown().selectByVisibleText(AllegationType);
	}
	public void SelectAMPM(String APPM){
		Element.AMPMDropdown().selectByVisibleText(APPM);
	}
	
	public void SelectTimeZone(String TimeZone){
		Element.TimezoneDropdown().selectByVisibleText(TimeZone);
	}
	
	public void EnterRequiredField(String Date,String Time,String AllegationType){
		DateofAllegedAbuse(Date);
		Element.TimeofAllegedAbuse().click();
		Element.TimeofAllegedAbuse().sendKeys(Time);
		SelectAMPM("AM");
		SelectTimeZone("ET");
		SelectAllegation(AllegationType);
		
	}
	
	public void SelectVictim(String VictimName){
		boolean isClicked = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='victims']/tbody");
		for(WebElement trElement : tr_collection){
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[2]"));
				 if(cell.getText().contains(VictimName)){ 
					 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					 getParentRow.findElement(By.xpath("td[5]/label/span")).click();
					 isClicked=true;
					  break;
			 }
			 
			 if(isClicked){
				  break;
				  
			  }
		}
	}
	
	public void SelectPerpetator(String PerpetatorName){
		boolean isClicked = false;
		List<WebElement> tr_collection = Browser.driver.findElements(By.xpath("//table[@id='perpetrators']/tbody/tr"));
		for(WebElement trElement : tr_collection){
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[2]"));
			
				 if(cell.getText().contains(PerpetatorName)){ 
					  WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					  getParentRow.findElement(By.xpath("td[5]/label/span")).click();
					  isClicked=true;
					  break;
				 
			 }
			 
			 if(isClicked){
				  break;
				  
			  } 
		}
	}
	
	public boolean IsVictimAvailable(String VictimName){
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegations']/tbody");{
			for(WebElement trElement : tr_collection){
				if(trElement.getAttribute("class").contains("ng-hide"))
	    			continue;
				try{
				 WebElement cell=trElement.findElement(By.xpath("td"+"[4]"));
				
					 if(cell.getText().contains(VictimName)){ 
						 columnValue = true;
						 break;
					 }
				  
			  }
				
			catch (Exception e){
				
				 columnValue = false;
				 break;
			  }
			}
			
		}
		return columnValue;
	}
	
	public void DeleteAllegation(String VictimName){
		 boolean actionPerformed = false;
		 List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegations']/tbody");
		 for(WebElement trElement : tr_collection){
			 if(trElement.getAttribute("class").contains("ng-hide"))
	 			continue;
			 WebElement cell=trElement.findElement(By.xpath("td"+"[4]"));
			
				 if(cell.getText().contains(VictimName)){
					 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					  getParentRow.findElement(By.xpath("td[6]//span[@tooltip='Delete']")).click();;
					 actionPerformed=true;
					 break;
				 
			 }
			 
	       if(actionPerformed){
				 
				 break;
			 }
			 
		 }
		
		//Browser.driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/div/table/tbody/tr[2]/td[6]/a/span")).click();
					 
	}
	
	public boolean IsPerpetatorAvailable(String PerpetatorName){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegations']/tbody");
		for(WebElement trElement : tr_collection) {
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			  WebElement cell=trElement.findElement(By.xpath("td"+"[5]"));
	            if(cell.getText().contains(PerpetatorName)){ 
	              columnValue = true;
	              break; 	
	        	
	           
	        }
	        if(columnValue){
				 
				 break;
			 } 
	    }
		
		return columnValue;
	}
	
public boolean IsAllegationTypeAvailable(String AllegationType){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegations']/tbody");
		for(WebElement trElement : tr_collection) {
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			 WebElement cell=trElement.findElement(By.xpath("td"+"[3]"));
	            if(cell.getText().contains(AllegationType)){ 
	            	
	            		columnValue = true;
	            		break;
	        }
	        if(columnValue){
				 
				 break;
			 } 
	    }
		
		return columnValue;
	}
	
	public void ClickId(String PerpetatorName){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegations']/tbody");
		for(WebElement trElement : tr_collection)
	{
	  List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[5]"));
	  
	  for(WebElement tdElement : td_collection)
	  {

	  	          	
	  	if(tdElement.getText().contains(PerpetatorName)){
	  		
	  		WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
	  	 	getParentRow.findElement(By.xpath(".//td[1]/a")).click();
	  		
	  		    columnValue=true;
	  		    break;
	  		   
	  	}
	    
	  }
	  
	  if(columnValue){
	  	break;
	  }
	}
		
		
	}
	
}
