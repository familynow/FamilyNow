package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Elements.ComplaintParticipantElement;



public class ComplaintParticipantOperation extends BaseOperations<ComplaintParticipantElement>{

	public ComplaintParticipantOperation(ComplaintParticipantElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
public void SelectRoles(String[] Roles){
		
		
		for(String role:Roles)
		{
			
			Element.AvailableRole().selectByVisibleText(role);
			
	  }
		
	 Element.MoveItemRight(1).click();	
	}

   public void SelectGender(String Gender){
	Element.GenderDropdown().selectByVisibleText(Gender);
   }

	
	public void EnterDOB(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[3]/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/span/i","html/body/div[1]/div[3]/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/span/ul/li[1]/div/table/tbody");
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
	
public boolean IsColumnValueAvailable(String participantName,String columnValueToBeSearched){
		
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='participantSummary']/tbody");
		for(WebElement trElement : tr_collection){
			if(trElement.getAttribute("class").contains("ng-hide"))
    			continue;
			WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
            if(cell.getText().contains(participantName)){ 
                	WebElement getParentRow =  cell.findElement(By.xpath("./.."));              	
                	if(getParentRow.getText().contains(columnValueToBeSearched)){
                		columnValue = true;
                		break;	
               }
            }
            if(columnValue){
				 
				 break;
			 } 
        }
		
		return columnValue;
	}

public void PerformAction(String participantName,String ActionName){
	 boolean actionPerformed = false;
	 List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='participantSummary']/tbody");
	 for(WebElement trElement : tr_collection){
		 if(trElement.getAttribute("class").contains("ng-hide"))
 			continue;
		 WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
		
			 if(cell.getText().contains(participantName)){
				 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
				  getParentRow.findElement(By.xpath("td[7]//span[@tooltip='"+ActionName+"']")).click();;
				 actionPerformed=true;
				 break;
			 
		 }
		 
       if(actionPerformed){
			 
			 break;
		 }
		 
	 }
}
	public void ClickId(String Name){
		 boolean actionPerformed = false;
		 List<WebElement> td_collection=null;
		 List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='participantSummary']/tbody");
		 for(WebElement trElement : tr_collection){
			 if(trElement.getAttribute("class").contains("ng-hide"))
		 			continue;
			    WebElement cell=trElement.findElement(By.xpath("td"+"[2]"));
				
				 if(cell.getText().contains(Name)){
					 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					 try{
					 Thread.sleep(500);
					 getParentRow.findElement(By.xpath(".//td[1]/a")).click();
					 actionPerformed=true;
					 break;
					 }
					 
					 catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 
				 
			 }
			 
			 if(actionPerformed){
				 
				 break;
			 }
			 
		 }
		
	}
	public void EnterRequiredField(String Fname,String Lname,String[] Roles,String Gender){
		Element.Fname().sendKeys(Fname);
		Element.Lname().sendKeys(Lname);
		SelectGender(Gender);
		SelectRoles(Roles);
		
	}
	
	public void EnterContactInformation(String WorkNo, String MobNo){
		Element.WorkNumber().click();
		Element.WorkNumber().sendKeys(WorkNo);
		Element.Mobile().click();
		Element.Mobile().sendKeys(MobNo);
		
	}
	
	public void EnterAddressDetails(String Address1, String Address2,String City,String State, String Zip){
		Element.AddressLine1().sendKeys(Address1);
		Element.AddressLine2().sendKeys(Address2);
		Element.City().sendKeys(City);
		Element.State().selectByVisibleText(State);
		Element.Zip().sendKeys(Zip);
		//Element.GenderDropdown().selectByVisibleText(Gender);
		
	}
	
	public String GetComplaintName(){
		return Element.ComplaintNameDiv().getText();
		
	}

}
