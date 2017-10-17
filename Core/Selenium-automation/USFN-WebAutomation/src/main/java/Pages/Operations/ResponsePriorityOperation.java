package Pages.Operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.ResponsePriorityElement;



public class ResponsePriorityOperation  extends BaseOperations<ResponsePriorityElement>  {

	public ResponsePriorityOperation(ResponsePriorityElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectProvideRecommendedPriority(String Priority){
		
		Element.ProvideRecommendedPriority().selectByVisibleText(Priority);
   }
	
	
	public String GetPiriority(){
		 
			   List<WebElement> parentDivs =  Browser.driver.findElements(By.xpath("//div[@class='col-lg-6 col-md-12 col-sm-12 col-xs-12 profile-stats']//div[@class='row']"));
			   String[] parts = parentDivs.get(4).getText().split(":");
			   String part1 = parts[0]; // 004
			   String part2 = parts[1].trim(); // 034556
				return part2;

	   }
	
	
	
	public boolean ClickPiriorityTool(String Allegation){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
		for(WebElement trElement : tr_collection)
	{
	  List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[2]"));
	  
	  for(WebElement tdElement : td_collection)
	  {
       
		  String test = tdElement.getText();
	  	          	
	  	if(tdElement.getText().contains(Allegation)){
	  		
	  		WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
	  		test = getParentRow.getText();
	  	 	getParentRow.findElement(By.xpath(".//td[5]/span/a")).click();
	  		
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
	
public boolean EditPiriorityTool(String Allegation){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
		for(WebElement trElement : tr_collection)
	{
	  List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[2]"));
	  
	  for(WebElement tdElement : td_collection)
	  {
       
		  String test = tdElement.getText();
	  	          	
	  	if(tdElement.getText().contains(Allegation)){
	  		
	  		WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
	  		test = getParentRow.getText();
	  	 	getParentRow.findElement(By.xpath(".//td[1]/span/a")).click();
	  	 	
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



   public boolean IsPiriorityToolAvailable(){
		boolean available = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
		String test = tr_collection.get(0).findElement(By.xpath("td")).getText();
		if(tr_collection.get(0).findElement(By.xpath("td")).getText().contains("A maltreatment type other than Threatened Harm or Birth Match must be added to enable a Priority question set.")){
			available = true;
		}
		
		return available;
	   
   }
	
    public boolean VerifyPiriority(String Allegation,String Piriority){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
		for(WebElement trElement : tr_collection)
	{
	  List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[2]"));
	  
	  for(WebElement tdElement : td_collection)
	  {        	
	  	 if(tdElement.getText().contains(Allegation)){
	  		
	  		WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
	  		
	  		if(getParentRow.findElement(By.xpath(".//td[3]/span")).getText().contains(Piriority)){
	  		
	  		    columnValue=true;
	  		    break;
	  		}
	  		   
	  	}
	    
	  }
	  
	  if(columnValue){
	  	break;
	  }
	}
		
		return columnValue;
	}
}
