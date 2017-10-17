package Pages.Operations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.SafteyPlanParticipantElement;

public class SafteyPlanParticipantOperation extends BaseOperations<SafteyPlanParticipantElement> {

	public SafteyPlanParticipantOperation(SafteyPlanParticipantElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void ClickTabularView(){
		WebElement getParentDiv = Browser.driver.findElement(By.xpath("//div[@class='box-wrap clearfix']"));
		getParentDiv.findElement(By.xpath("//span[@tooltip='Tabular View']")).click();
		
	}
	
	public List<String> GetAllParticipant() throws InterruptedException {
		ClickTabularView();
		WebElement getParentDiv = Browser.driver.findElement(By
				.xpath("//div[@class='box-wrap clearfix']"));
		// Click Tabular view
		getParentDiv.findElement(By.xpath(".//span[@tooltip='Tabular View']"))
				.click();
		Thread.sleep(500);
		List<String> Participant = new ArrayList<String>();
		do {
			List<WebElement> tr_collection = Element
					.GetTableBodyRows("//table[@id='participantsViewSafetyPlan']/tbody");
			for (WebElement trElement : tr_collection) {
				if (trElement.getAttribute("class").contains(
						"no-results ng-hide"))
					continue;

				Participant.add(trElement.findElement(By.xpath("td[1]"))
						.getText()
						+ " "
						+ trElement.findElement(By.xpath("td[3]")).getText());
			}
		} while (PaginationClickNext());

		return Participant;

	}
	
	public String GetSafteyDecision(){
		WebElement getPopUpDiv = Browser.driver.findElement(By.xpath("//div[@class='box-wrap']"));
		return getPopUpDiv.findElement(By.xpath("//div[@class='safety-quick-summary col-lg-9']/p[1]/strong")).getText();
				
	}
	
	public List<String> IdentifiedHarmFactorsAvailable(){
		WebElement getPopUpDiv = Browser.driver.findElement(By.xpath("//div[@class='box-wrap']"));
		List<WebElement> li_collection = getPopUpDiv.findElements(By.xpath(".//ul[@class='ticked-list clearfix']/li"));
		//List<WebElement> allElements = Driver.findElements(By.xpath("//ul[@id='invTasks']/li")); 
		List<String> IdentifiedHarmFactors = new ArrayList<String>();  
		for (WebElement li : li_collection) {
			IdentifiedHarmFactors.add(li.getText());
			
		}
		//listA.containsAll(listB) && listB.containsAll(listA)
		return IdentifiedHarmFactors;
		
		
	}

}
