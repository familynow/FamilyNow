package Pages.Operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.CpsMaltreatmentElement;



public class CpsMaltreatmentOperation extends BaseOperations<CpsMaltreatmentElement> {

	public CpsMaltreatmentOperation(CpsMaltreatmentElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectAllegationType(String AlligationType){
		Element.AllegationType().selectByVisibleText(AlligationType);
	}
	
	public void SelectVictim(String VictimName){
		
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegedVictims']/tbody");
		for(WebElement trElement : tr_collection){
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[3]"));
				  if(cell.getText().contains(VictimName)){ 
					  WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					  getParentRow.findElement(By.xpath(".//td[1]/label/span")).click();
					 
					  break;
				  }
					  
				  }
	}
	
	
	public void SelectPerpetator(String PerpetatorName){
		List<WebElement> tr_collection = Browser.driver.findElements(By.xpath("//table[@id='allegedPerpetrator']/tbody/tr"));
		for(WebElement trElement : tr_collection){
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[3]"));
				  if(cell.getText().contains(PerpetatorName)){ 
					  WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					  getParentRow.findElement(By.xpath("td[1]/label/span")).click();
					  break;
				  }
					  
				  }
			 
			 
	}
	
public boolean IsVictimAvailable(String VictimName){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegationRecords']/tbody");
		for(WebElement trElement : tr_collection){
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			try{
			 WebElement cell =  trElement.findElement(By.xpath("td[4]"));
                if(cell.getText().contains(VictimName)){ 
                	
                		columnValue = true;
                		break;
                		
                	
            	
               }
			}
			catch (Exception e){
				columnValue = false;
				
			}
            }
		return columnValue;
	}


public boolean IsPerpetatorAvailable(String PerpetatorName){
	
	boolean columnValue = false;
	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegationRecords']/tbody");
	for(WebElement trElement : tr_collection) {
		if(trElement.getAttribute("class").contains("ng-hide"))
			continue;
		try{
		 WebElement cell =  trElement.findElement(By.xpath("td[5]"));
            if(cell.getText().contains(PerpetatorName)){ 
            	
            		columnValue = true;
            		break;
           }
		}
		
		catch (Exception e){
			columnValue = false;
			break;
			
		}
        }
       
	
	return columnValue;
}

public boolean ClickEditIcon(String PerpetatorName){
	
	boolean columnValue = false;
	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegationRecords']/tbody");
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
	
	return columnValue;
}


public String GetWarningMessage(){
	
	String warningMessage = Element.DuplicateWarning().getText();
	return warningMessage;
}

public void ClickAlligation(){
	Element.AddAlligationButton().click();
	
}

public void ClickSaveAlligation(){
	Element.SaveButton().click();
	
}

public void DeleteAllegation(String PerpetatorName){
   
	  List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='allegationRecords']/tbody");
	  for(WebElement trElement : tr_collection){
		
		  if(trElement.getAttribute("class").contains("ng-hide"))
				continue;
			 WebElement cell =  trElement.findElement(By.xpath("td[5]"));
				if(cell.getText().contains(PerpetatorName)){
					WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					WebElement getActionColumn =   getParentRow.findElement(By.xpath(".//td[6]"));
						getActionColumn.findElement(By.xpath(".//span[@tooltip='Delete']")).click();
						Alert alert = Browser.driver.switchTo().alert();
						   alert.accept();
						   break;
					
					
				}
				
		 }
		 
}

public void SelectRiskFactor(String[] Risks){
	
	
	for(String risk:Risks)
	{
		
		Element.RiskFactor().selectByVisibleText(risk);
		//selectByVisibleText(MethodName)
  }
	
 Element.MoveItemRight(0).click();	
}


public void SelectLivingArrangementAtTheTimeOfIntake(String LivingArrangement){
	
		Element.LivingArrangementAtTheTimeOfIntake().selectByVisibleText(LivingArrangement);
}

public void SelectLivingArrangementAtTheTimeOfOccurrence(String LivingArrangement){
	
	Element.LivingArrangementAtTheTimeOfOccurrence().selectByVisibleText(LivingArrangement);
}


public void RemoveRiskFactor(String[] Risks){
	
	
	for(String risk:Risks)
	{
		
		Element.RemoveRiskFactor().selectByVisibleText(risk);
		//selectByVisibleText(MethodName)
  }
	
 Element.MoveItemLeft(0).click();	
}

}
