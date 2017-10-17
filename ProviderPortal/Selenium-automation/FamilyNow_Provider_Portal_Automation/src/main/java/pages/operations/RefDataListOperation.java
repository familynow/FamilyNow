package pages.operations;

import general.Browser;

import org.openqa.selenium.By;

import pages.elements.RefDataListElement;

public class RefDataListOperation extends BaseOperation<RefDataListElement>{

	public RefDataListOperation(RefDataListElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public boolean IsColumnAvailable(String ColumnValue){
		boolean columnValue = false;
		
		
		
				try{
					String TableValues = Browser.driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[10]/ng-include/div/div[1]/div/div[2]/div/div/div/table/tbody/tr[2]")).getText();
				
					 if(TableValues.contains(ColumnValue)){ 
						
						 columnValue = true;
						 
					 }
				  
			  }
				
			catch (Exception e){
				
				 columnValue = false;
				
			  }
			
			
		
		return columnValue;
	}

}
