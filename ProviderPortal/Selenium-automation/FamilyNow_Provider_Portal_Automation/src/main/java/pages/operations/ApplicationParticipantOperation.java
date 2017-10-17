package pages.operations;

import general.Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.elements.ApplicationParticipantElement;
import pages.operations.BaseOperation;

public class ApplicationParticipantOperation  extends BaseOperation<ApplicationParticipantElement> {
	public ApplicationParticipantOperation(ApplicationParticipantElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
public void SelectApplicantRole(String Role){
		
		Element.ApplicantRole().selectByVisibleText(Role);
		
	}
	
   public void SelectGender(String Gender){
		
		Element.Gender().selectByVisibleText(Gender);
		
	}
   
   public void SelectRace(String Race){
		
		Element.Race().selectByVisibleText(Race);
		
	}
   
   public void SelectEducation(String Education){
	   Element.HighestLevelofEducationCompleted().selectByVisibleText(Education);
	   
   }
   public void DateOfBirth(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[3]/ng-include/div/form/div[1]/div[2]/div/div[2]/div[2]/div/span/i","html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[3]/ng-include/div/form/div[1]/div[2]/div/div[2]/div[2]/div/span/div/ul/li[1]/div/div/div/table/tbody");
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
   public void EnterRequiredField(String ApplicantRole, String Fname,String Lname,String Gender,String Date,String Race,String Education,String Mobile ){
	   SelectApplicantRole(ApplicantRole);
	   Element.Fname().clear();
	   Element.Lname().clear();
	   Element.Fname().sendKeys(Fname);
	   Element.Lname().sendKeys(Lname);
	   SelectGender(Gender);
	   DateOfBirth(Date);
	   SelectRace(Race);
	   SelectEducation(Education);
	   Element.HomeMobilePhone().sendKeys(Mobile);
	 
   }
   
   public boolean IsParticipantAvailable(String Participant){
		boolean columnValue = false;
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
			for(WebElement trElement : tr_collection){
				  if(trElement.getAttribute("class").contains("ng-hide"))
			 			continue;
				   WebElement cell=trElement.findElement(By.xpath("td"+"[1]"));
				
					 if(cell.getText().contains(Participant)){ 
						 columnValue = true;
	                		break;
					
				 }
				 if(columnValue){
					 
					 break;
				 } 	 
			}
			
		
		return columnValue;
	}
   
   public void CilckParticipantId(String Participant){
	   boolean isClicked = false;
	   List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
	   for(WebElement trElement : tr_collection){
		   if(trElement.getAttribute("class").contains("ng-hide"))
	 			continue;
		   WebElement cell=trElement.findElement(By.xpath("td"+"[1]"));
		  
			   if(cell.getText().contains(Participant)){
				   WebElement getParentRow =  cell.findElement(By.xpath("./.."));
				   getParentRow.findElement(By.xpath(".//td[2]/a")).click();
				   isClicked=true;
				   break;
				   
			   
		   }  
		   if(isClicked){
				 
				 break;
			 }
		   
	   }
   }
   
   public void DeleteApplicant(String ApplicantName){
		 boolean actionPerformed = false;
		 List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='summary']/tbody");
		 for(WebElement trElement : tr_collection){
			 if(trElement.getAttribute("class").contains("ng-hide"))
	 			continue;
			 WebElement cell=trElement.findElement(By.xpath("td"+"[1]"));
			 String test = cell.getText();
			
				 if(cell.getText().contains(ApplicantName)){
					 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					  getParentRow.findElement(By.xpath("td[7]/span")).click();;
					 actionPerformed=true;
					 break;
				 
			 }
			 
	       if(actionPerformed){
				 
				 break;
			 }
			 
		 }
		
		
					 
	}
   
   public Boolean IsUnemployedChecked(){
	  
	   return  Browser.driver.findElement(By.id("checkboxUnEmployed")).isSelected();
   }
   
   public void Expand(){
	   Browser.driver.findElement(By.xpath("//div[@class='panel data-card widget collapsed']//i[@class='fa fa-plus']")).click();
   }
   public void Collapse(){
	   Browser.driver.findElement(By.xpath("//div[@class='panel data-card widget']//i[@class='fa fa-minus']")).click();
	   
   }

}
