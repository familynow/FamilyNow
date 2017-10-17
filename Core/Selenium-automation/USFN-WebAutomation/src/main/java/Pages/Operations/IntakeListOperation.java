package Pages.Operations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import General.Browser;
import PageControllers.UsfnPageManager;
import Pages.Elements.IntakeListElement;

public class IntakeListOperation extends BaseOperations<IntakeListElement>{


	public IntakeListOperation(IntakeListElement element) {
		super(element);
		
	}
	
	public void ClickCpsIntakeButton()
	{
		Element.GetCpsButton().click();
	}
	
	public void NavigateToIntakeListPage()
	{
		UsfnPageManager.MyOrganizerPage().Elements().GetViewAll().click();
	//	WaitForPageLoad(Browser.driver);
		try{
		
					Thread.sleep(8000);
		}
		 catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	
	}
	
	public void ClickPendingIntakeId(int RowIndex){
		
		boolean clicked = false;
		List<WebElement> tr_collection = Element.GetTableRow("html/body/div[1]/div[3]/div/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/table/tbody",RowIndex);
		for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td[2]/a"));
            
            for(WebElement tdElement : td_collection)
            {
            	          	
            	   tdElement.click();
            	   clicked=true;
            	   break;
            		
            	}
            
         if(clicked){
            	break;
            	
            }
              
       }
		
	}
	
	public List<String> GetHeaderColumn(){
		// List Columns = Columns;
		 List<String> Columns = new ArrayList<String>();
		List<WebElement> tr_collection = Element.GetTableColumnElement("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/div/div/table", "html/body/div[1]/div[3]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/div/div/table/thead/tr");
		for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("th"));
            
            for(WebElement tdElement : td_collection)
            {
            	Columns.add(tdElement.getText());
               
            }
        }
		
		return Columns;
	}
	
	public void NavigateToCpsPage() throws InterruptedException{
		Element.ViewAllCpsIntake().click();
		Thread.sleep(3000);
		Element.GetCpsButton().click();
	}
	
	public boolean IsColumnValueAvailable(String columnValueToBeSearched,int columnIndex){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div[1]/div[3]/div/div/div[2]/div/div/table/tbody");
		for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"["+String.valueOf(columnIndex)+"]"));
            
            for(WebElement tdElement : td_collection)
            {
            	          	
            	if(tdElement.getText().equals(columnValueToBeSearched)){
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
	
	
	
	public void ClickAwaitingScreeningDecisionIntake(int RowIndex){
		try{
		WebElement row = Element.GetAwaitingScreeningRow(RowIndex);
		row.findElement(By.xpath(".//td[1]/a")).click();
		}
		catch(NoSuchElementException e){
			Assert.fail("Awaiting Screening Intake record is not available");
		}
		
		
	}
	
	public void DeletePendingIntake(String intakeId){
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='pending']/tbody");
		for(WebElement trElement : tr_collection){
			 WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
			 if(cell.getText().contains(intakeId)){ 
				 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
				  getParentRow.findElement(By.xpath("td[9]//span[@tooltip='Delete']")).click();;
					
					 break;
				 
			 }
		}
		
	}
	
	public int GetPendingStatusCount(){
	
		 WebElement tbody_element = Browser.driver.findElements(By.xpath("//table[@id='pending']/tbody")).get(0);
		 List<WebElement> tr_collection=tbody_element.findElements(By.xpath(".//tr"));
	     int count= tr_collection.size(); 
	     return count;
	
	}
	
	public void ClickPendingIntake(int RowIndex){
		WebElement row = Element.GetPendingRow(RowIndex);
		
		row.findElement(By.xpath(".//td[1]/a")).click();
		
	}
	
	public void ClickPendingIntake(String IntakeId,boolean ClickColumn){
		if(ClickColumn){
			ClickColumns(1);
		}
		
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='pending']/tbody");
		for(WebElement trElement : tr_collection){
			 WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
				  if(cell.getText().contains(IntakeId)){ 
					  WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					  getParentRow.findElement(By.xpath(".//td[1]/a")).click();
					  break;	  
				  }
			 }

		
		
	}
	
	
	public void ClickSubmittedIntake(int RowIndex){
		try{
		WebElement row = Element.GetSubmittedRow(RowIndex);
		
		row.findElement(By.xpath(".//td[1]/a")).click();
		}
		catch(NoSuchElementException e){
			Assert.fail("Awaiting Screening Intake record is not available");
		}
		
	}
	
public boolean VerifyIntakeName(String intakeId,String intakeName){
		
		boolean columnValue = false;
		ClickColumns(1);
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='pending']/tbody");
		for(WebElement trElement : tr_collection)
        {
			 WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
				
            	
                if(cell.getText().contains(intakeId)){ 
                	WebElement getParentRow =  cell.findElement(By.xpath("./.."));
                	if(getParentRow.getText().contains(intakeName)){
                		columnValue = true;
                		break;
            	
               }
            }
           
        }
		
		return columnValue;
	}

 public void ClickColumns(int ColumnIndex){
	 List<WebElement> th_collection =Browser.driver.findElements(By.xpath("//table[@id='pending']/thead/tr/th"));
	 th_collection.get(ColumnIndex).click();
	 
 }
	
	public boolean VerifyInatkeIsAvailable(String intakeId){
		boolean intakeAvailable = false;
		ClickColumns(1);
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='pending']/tbody");
		for(WebElement trElement : tr_collection){
			try{
			 WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
			
	                if(cell.getText().contains(intakeId)){ 
	                	intakeAvailable =true;
	                	break;
	                }
			}
			
			catch (Exception e){
				
				intakeAvailable = false;
				 break;
			  }
		
		
	   }
		return intakeAvailable;
	}
}
