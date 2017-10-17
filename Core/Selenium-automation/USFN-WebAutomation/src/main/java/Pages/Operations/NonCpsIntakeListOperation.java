package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.NonCpsIntakeListElement;

public class NonCpsIntakeListOperation  extends BaseOperations<NonCpsIntakeListElement> {

	public NonCpsIntakeListOperation(NonCpsIntakeListElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public void ClickHeaderMenu(String HeaderName){
		List<WebElement> allElements =  Element.GetHeaderElements();

		for (WebElement element: allElements){
			if(element.getText().contains(HeaderName)){
				element.findElement(By.linkText(HeaderName)).click();
				break;
				
			}
		}
	}
	
   public void ClickCompletedIntake(int RowIndex){
	   
	   String test = "//table[@id='completed']/tbody/tr["+String.valueOf(RowIndex)+"]";
		
		WebElement getRow=  Browser.driver.findElement(By.xpath("//table[@id='completed']/tbody/tr["+String.valueOf(RowIndex)+"]"));
		getRow.findElement(By.xpath("td[1]/a")).click();
		
		
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
	
   
  
   
   
   public boolean IsIntakeStausReadyToLink(String intakeId){
		boolean intakeAvailable = false;
		List<WebElement> tb_collection = Browser.driver.findElements(By.xpath("//table[@id='readyToLink']/tbody"));
		List<WebElement> tr_collection = tb_collection.get(0).findElements(By.xpath(".//tr"));
		for(WebElement trElement : tr_collection){
			 List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[2]"));
	            
	            for(WebElement tdElement : td_collection){
	            	
	            	String test = tdElement.getText();
	                if(tdElement.getText().contains(intakeId)){ 
	                	intakeAvailable =true;
	                	break;
	                }
			
		}
		
	   }
		return intakeAvailable;
	}
   
   public boolean IsIntakeStausScreenedOut(String intakeId){
		boolean intakeAvailable = false;
		List<WebElement> tb_collection = Browser.driver.findElements(By.xpath("//table[@id='screenedOut']/tbody"));
		List<WebElement> tr_collection = tb_collection.get(0).findElements(By.xpath(".//tr"));
		for(WebElement trElement : tr_collection){
			 List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[2]"));
	            
	            for(WebElement tdElement : td_collection){
	            	
	            	String test = tdElement.getText();
	                if(tdElement.getText().contains(intakeId)){ 
	                	intakeAvailable =true;
	                	break;
	                }
			
		}
		
	   }
		return intakeAvailable;
	}
   
   
	public boolean VerifyIntakeName(String intakeId, String intakeName) {

		boolean columnValue = false;
		ClickColumns(1);
		List<WebElement> tr_collection = Element
				.GetTableBodyRows("//table[@id='pending']/tbody");
		for (WebElement trElement : tr_collection) {
			WebElement cell = trElement.findElement(By.xpath("td" + "[2]"));

			if (cell.getText().contains(intakeId)) {
				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				if (getParentRow.getText().contains(intakeName)) {
					columnValue = true;
					break;

				}

			}
		}

		return columnValue;
	}
   
	public void ClickPendingIntake(String IntakeId) {
		
		ClickColumns(1);
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='pending']/tbody");
		int size =tr_collection.size();

		for (WebElement trElement : tr_collection) {
		
			WebElement cell = trElement.findElement(By.xpath("td[2]"));
			String test = cell.getText();
			if (cell.getText().contains(IntakeId)) {
				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				getParentRow.findElement(By.xpath(".//span[@tooltip='Edit']")).click();
				
				break;
			}

		}

	}
}
