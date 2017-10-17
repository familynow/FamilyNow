package Pages.Operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.PersonBasicElement;

public class PersonBasicOperation extends BaseOperations<PersonBasicElement> {

	public PersonBasicOperation(PersonBasicElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	
	public void SelectSuffix(String Suffix){
		
		Element.Suffix().selectByVisibleText(Suffix);
		
	}
	public void SelectPrefix(String Prefix){
		
		Element.Prefix().selectByVisibleText(Prefix);
		
	}
	
	public void EnterDOB(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div/div[3]/div/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div/div[1]/div[1]/div/div/span/i","html/body/div[1]/div/div[3]/div/div[2]/div[2]/div/form/div[3]/div[2]/div[2]/div/div[1]/div[1]/div/div/span/ul/li[1]/div/table/tbody");
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
	
	 public String GetPersonId(){
		   List<WebElement> parentDivs =  Browser.driver.findElements(By.xpath("//div[@class='stats-value black text-left info-header-value col-lg-6 col-md-6 col-sm-6 col-xs-6 ng-binding']"));
			return parentDivs.get(0).getText();
	   }
	 
	 public void ClickLeftHandMenu(String menuName){
		  
		   try {
			Thread.sleep(5000);
			List<WebElement> allElements =  Element.GetLeftMenuList(); 

			for (WebElement element: allElements) {
				
				if(element.getText().contains(menuName)){
			     
				  element.findElement(By.linkText(menuName)).click();
				  break;
				}
			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  }
	 
	 public boolean IsColumnValueAvailable(String additionalFname,String columnValueToBeSearched){
			
			boolean columnValue = false;
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='additionalNames']/tbody");
			for(WebElement trElement : tr_collection)
	        {
				
				if(!trElement.getText().contains("No Results Found.")){
				 List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[5]"));
	            
	            for(WebElement tdElement : td_collection){          	
	                if(tdElement.getText().contains(additionalFname)){ 
	                	WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
	                	
	                	if(getParentRow.getText().contains(columnValueToBeSearched)){
	                		columnValue = true;
	                		break;
	                		
	                	}
	            	
	               }
	            }
	            if(columnValue){
					 
					 break;
				 } 
	         }
	        }
			
			return columnValue;
	      }
	 
	 public void ClickAdditional(int RowIndex){
			WebElement row = Element.GetAdditionalNamegRow(RowIndex);
			
			row.findElement(By.xpath(".//td[1]/a")).click();
			
		}
	 
	 public void DeleteAdditionalName(String additionalFname){
		  
		    boolean actionPerformed = false;
		    List<WebElement> td_collection=null;
			  List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='personContact']/tbody");
			  for(WebElement trElement : tr_collection){
				
				
				      td_collection=trElement.findElements(By.xpath("td"+"[5]"));
				 
				 for(WebElement tdElement : td_collection){
						if(tdElement.getText().contains(additionalFname)){
							WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
							WebElement getActionColumn =   getParentRow.findElement(By.xpath(".//td[9]"));
							
								
								getActionColumn.findElement(By.xpath("//span[@tooltip='Delete']")).click();
								Alert alert = Browser.driver.switchTo().alert();
								   alert.accept();
								   actionPerformed=true;
								   break;
								
							
							
							
						}
						 if(actionPerformed){
							 
							 break;
						 }
				 }
				 if(actionPerformed){
					 
					 boolean test = actionPerformed;
					 
					 break;
				 }
			  }
		  }


}
