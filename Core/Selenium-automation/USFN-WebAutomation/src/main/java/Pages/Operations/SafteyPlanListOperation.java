package Pages.Operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.SafteyPlanListElement;

public class SafteyPlanListOperation extends BaseOperations<SafteyPlanListElement> {

	public SafteyPlanListOperation(SafteyPlanListElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public boolean NavigateToSfteyPlanPage() {
		boolean safteyPlanMenu = true;

		try {

			Thread.sleep(1000);
			
			List<WebElement> allElements = Element.GetInvestigationTaskMenuList();
			for (WebElement element : allElements) {

				if (element.getText().contains("Safety Plan")) {
					element.findElement(By.linkText("Safety Plan")).click();
					break;
				}

			}
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (NoSuchElementException e) {
			safteyPlanMenu = false;
		}
		
		return safteyPlanMenu;
	}

	public boolean IsSafteyPlanCreated(String AssessmentId,
			String ColumnValueToBeSearched) throws InterruptedException {
		boolean planCreated = false;

		if (!NavigateToSfteyPlanPage()) {
			planCreated = false;
		} else {
			Thread.sleep(1500);
			do {
				Thread.sleep(1000);
				List<WebElement> tr_collection = Element
						.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
				for (WebElement trElement : tr_collection) {
					if (trElement.getAttribute("class").contains(
							"no-results ng-hide"))
						continue;
					WebElement cell = trElement.findElement(By.xpath("td[6]"));
					if (cell.getText().contains(AssessmentId)
							&& cell.getText().trim().length() > 0) {
						WebElement getParentRow = cell.findElement(By
								.xpath("./.."));
						if (getParentRow.getText().contains(
								ColumnValueToBeSearched)) {
							planCreated = true;
							break;

						}
					}

				}
				if (planCreated) {
					break;
				}
			} while (PaginationClickNext());
		}
		NavigateToFirstPage();
		return planCreated;

	}
	
	public void ClickAssessment(String AssessmentId,boolean NavigateToListPage){
		boolean planCreated = false;
		if(NavigateToListPage){
			NavigateToSfteyPlanPage();
		}
		do{
		List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
		for (WebElement trElement : tr_collection) {
			if (trElement.getAttribute("class").contains("no-results ng-hide"))
				continue;
			WebElement cell = trElement.findElement(By.xpath("td[6]"));
			if (cell.getText().contains(AssessmentId)) {
				trElement.findElement(By.xpath("td[6]/a")).click();
				planCreated = true;
				break;
				
			}
			
		}
		if(planCreated){
			break;
		}
		}while (PaginationClickNext());
		
		
		
	}
	
	public void ClickEdit(String AssessmentId,boolean NavigateToListPage){
		if(NavigateToListPage){
			NavigateToSfteyPlanPage();
		}
		
		boolean clicked = false;
		
		do{
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
			for (WebElement trElement : tr_collection) {
				if (trElement.getAttribute("class").contains("no-results ng-hide"))
					continue;
				WebElement cell = trElement.findElement(By.xpath("td[6]"));
				if (cell.getText().contains(AssessmentId)) {
					trElement.findElement(By.xpath("td[1]/a/span[@tooltip='Edit']")).click();
					clicked = true;
					break;
					
				}
				
			}
			
			if(clicked){
				break;
			}
			
		}while (PaginationClickNext());
		
		
	}
	
	public void ClickDiscontinue(String AssessmentId,boolean NavigateToListPage){
		if(NavigateToListPage){
			NavigateToSfteyPlanPage();
		}
		
		boolean clicked = false;
		
		do{
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='safetyPlanList']/tbody");
			for (WebElement trElement : tr_collection) {
				if (trElement.getAttribute("class").contains("no-results ng-hide"))
					continue;
				WebElement cell = trElement.findElement(By.xpath("td[6]"));
				if (cell.getText().contains(AssessmentId)) {
					trElement.findElement(By.xpath("td[7]//span[@tooltip='Discontinue']")).click();
					clicked = true;
					break;
					
				}
				
			}
			
			if(clicked){
				break;
			}
			
		}while (PaginationClickNext());
		
		
	}
	
	
	
	public String GetSafteyDecision(){
		WebElement getPopUpDiv = Browser.driver.findElement(By.xpath("//div[@id='safetyPlanPopup']"));
		return getPopUpDiv.findElement(By.xpath("//div[@class='popup-content']/p[1]/strong")).getText();
				
	}
	
	public List<String> IdentifiedHarmFactorsAvailable(){
		WebElement getPopUpDiv = Browser.driver.findElement(By.xpath("//div[@id='safetyPlanPopup']"));
		List<WebElement> li_collection = getPopUpDiv.findElements(By.xpath("//div[@class='popup-content']//ul/li"));
		//List<WebElement> allElements = Driver.findElements(By.xpath("//ul[@id='invTasks']/li")); 
		List<String> IdentifiedHarmFactors = new ArrayList<String>();  
		for (WebElement li : li_collection) {
			IdentifiedHarmFactors.add(li.getText());
			
		}
		//listA.containsAll(listB) && listB.containsAll(listA)
		return IdentifiedHarmFactors;
		
		
	}
	
	public void ClosePopUp(){
		WebElement getPopUpDiv = Browser.driver.findElement(By.xpath("//div[@id='safetyPlanPopup']"));
		getPopUpDiv.findElement(By.xpath("//div[@class='safety-footer clearfix']//button[@class='btn btn-common pull-right']")).click();
		

	}

}
