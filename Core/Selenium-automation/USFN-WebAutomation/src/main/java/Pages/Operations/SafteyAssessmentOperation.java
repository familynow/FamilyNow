package Pages.Operations;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import General.Utilities;
import PageControllers.UsfnPageManager;
import Pages.Elements.SafteyAssessmentElement;

public class SafteyAssessmentOperation extends BaseOperations<SafteyAssessmentElement>{

	public SafteyAssessmentOperation(SafteyAssessmentElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	
	 public void NavigateToSfteyAssesmentPage(boolean Expand){
		 
		 try {
			 
				Thread.sleep(1000);
				if(Expand){
				Browser.driver.findElement(By.xpath("//li[@id='invTasksNode']/a")).click();
				Thread.sleep(1000);
				}
				List<WebElement> allElements = Element.GetInvestigationTaskMenuList();

				for (WebElement element: allElements) {
					
					if(element.getText().contains("Safety Assessment")){
				     
					  element.findElement(By.linkText("Safety Assessment")).click();
					  break;
					}
				
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
			
		
		
		public String CreateSafeAssesment() throws InterruptedException, MalformedURLException{
			NavigateToSfteyAssesmentPage(true);
			Element.AddSafteyAssessmentButton().click();
			Thread.sleep(500);
		    String assessmentDate =	DateOfAssessment(Utilities.GetRandomDate());
			
			Element.SafetyAssessmentDetailsSaveButton().click();
	
			do {
				
				
				
			} while (ClickNext());
			Element.ImmediateHarmFactorSaveButton().click();
			Thread.sleep(4000);
			Element.SafteyDecisionNoCheckbox().click();
			Element.CreatePlanButton().click();
			Thread.sleep(500);
			UsfnPageManager.SafteyPlanListPage().Elements().CancelButton().click();
			Thread.sleep(500);
			NavigateToSfteyAssesmentPage(false);
			 String assessmentId = ClickEditIcon(assessmentDate);
			 return assessmentId+","+assessmentDate;
			
			
		}
		
		 public String DateOfAssessment(String date){
			
			
			 Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/ng-include/div/fieldset/div[2]/form/div/div/div/div/span/i")).click();
			 Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/ng-include/div/fieldset/div[2]/form/div/div/div/div/span/ul/li[1]/div/table/thead/tr[1]/th[1]/button")).click();
			 WebElement tbody_element = Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/ng-include/div/fieldset/div[2]/form/div/div/div/div/span/ul/li[1]/div/table/tbody"));
			 List<WebElement> tr_collection=tbody_element.findElements(By.xpath(".//tr"));
		   
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
		      
		      return  Browser.driver.findElement(By.xpath("//input[@id='assessmentDate']")).getAttribute("value");
				
			}
		 
		 public String ClickEditIcon(String AssessmentDate) throws MalformedURLException, InterruptedException{
			 String assessMentId = "";
			 boolean clicked = false;
			 do{
				 List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='assessmentLog']/tbody");
				 for (WebElement trElement : tr_collection) {
					 if (trElement.getAttribute("class").contains("no-results ng-hide"))
							continue;
					 WebElement cell = trElement.findElement(By.xpath("td[7]"));
					 if (cell.getText().contains(AssessmentDate)) {
						 WebElement getParentRow = cell.findElement(By.xpath("./.."));
						 getParentRow.findElement(By.xpath(".//td[1]/a/span")).click();
						 Thread.sleep(1000);
						 String pageUrl= Browser.driver.getCurrentUrl();
						 Thread.sleep(500);
							URL aURL = new URL(pageUrl);
							String path =  aURL.getPath();
							String[] pathParts = path.split("/");
							 assessMentId =pathParts[pathParts.length-1];
							 Element.SafetyAssessmentDetalCancelButton().click();
							 clicked = true;
							 break;
							
						 
					 }
				 }
			   if(clicked){
				   break ;
			   }
			 }while (PaginationClickNext());
			 
			
			 
			 return  assessMentId;
		 }
		
		public String CreateSafeWithServices() throws InterruptedException, MalformedURLException{
			NavigateToSfteyAssesmentPage(true);
			Thread.sleep(1000);
			Element.AddSafteyAssessmentButton().click();
			Thread.sleep(500);
		    String assessmentDate =	DateOfAssessment(Utilities.GetRandomDate());
			
			Element.SafetyAssessmentDetailsSaveButton().click();
			int j=0;
	        do {

	        	if(j==0){
	        		
	        	Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[2]/div[1]/div[2]/div/label/span")).click();
	        	Element.ExplainTextArea().sendKeys("Create Safe With Services Assessment");
	        	
	        	}
	        	if(j==1){
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[3]/div[1]/div[8]/div/label/span")).click();
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[3]/div[1]/div[15]/div/div/div/div[2]/div[3]")).sendKeys("Create Safe With Services Assessment");
		        	
	        	}
	        	if(j==2){
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[4]/div[1]/div[14]/div/label/span")).click();
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[4]/div[1]/div[15]/div/div/div/div[2]/div[3]")).sendKeys("Create Safe With Services Assessment");
	        		//
	        	}
				
				j++;
				
			} while (ClickNext());
	        Element.ImmediateHarmFactorSaveButton().click();
			Thread.sleep(4000);
			Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[4]/ng-include/form/fieldset/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]")).click();
			
			
			Element.SfteyResponseTextArea().sendKeys("Create Safe With Services Assessment");
			Element.InterventionSaveSaveButton().click();
			Thread.sleep(4000);
			Element.SafteyDecisionNoCheckbox().click();
			Element.CreatePlanButton().click();
			Thread.sleep(1000);
			UsfnPageManager.SafteyPlanListPage().Elements().CancelButton().click();
			Thread.sleep(1000);
			NavigateToSfteyAssesmentPage(false);
			Thread.sleep(1500);
			
			 String assessmentId = ClickEditIcon(assessmentDate);
			 return assessmentId+","+assessmentDate;
			
			
		
		}
		
		public String CreateUnsafeAssessment() throws InterruptedException, MalformedURLException{
			NavigateToSfteyAssesmentPage(true);
			Thread.sleep(1000);
			Element.AddSafteyAssessmentButton().click();
			Thread.sleep(500);
			String getDate = Utilities.GetRandomDate();
		    String assessmentDate =	DateOfAssessment(getDate);
			Element.SafetyAssessmentDetailsSaveButton().click();
			int j=0;
	        do {

	        	if(j==0){
	        	Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[2]/div[1]/div[2]/div/label/span")).click();
	        	Element.ExplainTextArea().sendKeys("Create Safe With Services Assessment");
	        	
	        	}
	        	if(j==1){
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[3]/div[1]/div[8]/div/label/span")).click();
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[3]/div[1]/div[15]/div/div/div/div[2]/div[3]")).sendKeys("Create Safe With Services Assessment");
		        	
	        	}
	        	if(j==2){
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[4]/div[1]/div[14]/div/label/span")).click();
	        		Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[3]/ng-include/div[1]/fieldset/div[4]/div[1]/div[15]/div/div/div/div[2]/div[3]")).sendKeys("Create Safe With Services Assessment");
	        		//
	        	}
				
				j++;
				
			} while (ClickNext());
	        Element.ImmediateHarmFactorSaveButton().click();
			Thread.sleep(4000);
			Browser.driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[4]/ng-include/form/fieldset/div/div/div[1]/div[2]/div/div[8]/div/label/span")).click();
			Element.SfteyResponseTextArea().sendKeys("Create Un-Safe  Assessment");
			Element.LegalActionTextArea().sendKeys("Create Un-Safe  Assessment");
			Element.InterventionSaveSaveButton().click();
			Thread.sleep(4000);
			Element.SafteyDecisionYesCheckbox().click();
			Element.YoungestInjured().selectByVisibleText("11 years");
			Element.SeriousInjury().selectByVisibleText("Medical treatment required but no hospitalization");
			Thread.sleep(1000);
			Element.CreatePlanButton().click();
			Thread.sleep(1000);
			UsfnPageManager.SafteyPlanListPage().Elements().CancelButton().click();
			Thread.sleep(500);
			NavigateToSfteyAssesmentPage(false);
			Thread.sleep(1500);
            String assessmentId = ClickEditIcon(assessmentDate);
			return assessmentId+","+assessmentDate;
			
		}
		
	public List<String> GetAllParticipant(boolean NavigateToListPage) {
		if (NavigateToListPage) {
			NavigateToSfteyAssesmentPage(false);
		}
		Element.AddSafteyAssessmentButton().click();
		List<String> Participant = new ArrayList<String>();
		do {

			List<WebElement> tr_collection = Element
					.GetTableBodyRows("//table[@id='assessmentDetails']/tbody");
			for (WebElement trElement : tr_collection) {
				if (trElement.getAttribute("class").contains(
						"no-results ng-hide"))
					continue;
				Participant.add(trElement.findElement(By.xpath("td[1]"))
						.getText()
						+ " "
						+ trElement.findElement(By.xpath("td[2]")).getText());

			}
		} while (PaginationClickNext());
		Element.SafteyAssessmentCancelButton().click();
		return Participant;

	}
		
		 public boolean ClickNext()
		  {
			  boolean success = true;
		      try
		      {
		    	  Thread.sleep(1000);
		    	  Element.NextButton().click();
		    	
		         
		      }
		      catch (Exception e)
		      {
		          success = false; // We couldn't click the -> arrow
		      }
		    
		     
		      return success;
		  }
		 
		
		 
			public boolean IsDeleteIconDisable(String AssessmentDate){
				   
			    do
			    {
			    	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='assessmentLog']/tbody");
			    	
			    	for(WebElement trElement : tr_collection){
			    		
			    		if(trElement.getAttribute("class").contains("no-results ng-hide"))
			    			continue;
			    		 WebElement cell =  trElement.findElement(By.xpath("td[7]"));
			    		 String Test = cell.getText();
			    		 if(cell.getText().contains(AssessmentDate)){
			    			 WebElement getParentRow =  cell.findElement(By.xpath("./.."));

			    			 if(getParentRow.findElement(By.xpath("//td[10]/span[3]")).getAttribute("class").contains("fa fa-trash-o clickable disabled"))
								 return true;
			    			 
			    		 }
			    	}
			    } while (PaginationClickNext());
			    NavigateToFirstPage();
			    
			    return false;
			}
}
