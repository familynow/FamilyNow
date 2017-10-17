package Pages.Operations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.NonCpsListParticipantElement;

public class NonCpsListParticipantOperation extends BaseOperations<NonCpsListParticipantElement> {

	public NonCpsListParticipantOperation(NonCpsListParticipantElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public boolean IsColumnValueAvailable(String participantName,
			String columnValueToBeSearched) {

		boolean columnValue = false;
		List<WebElement> tr_collection = Element
				.GetTableBodyRows("//table[@id='participantSummary']/tbody");
		for (WebElement trElement : tr_collection) {
			if(trElement.getAttribute("class").contains("no-results ng-hide"))
    			continue;
			WebElement cell = trElement.findElement(By.xpath("td[2]"));

			if (cell.getText().contains(participantName)) {
				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				if (getParentRow.getText().contains(columnValueToBeSearched)) {
					columnValue = true;
					break;

				}

			}

		}

		return columnValue;
	}

public boolean ClickParticipantId(String participantName){
	
	boolean columnValue = false;
	List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='participantSummary']/tbody");
	for(WebElement trElement : tr_collection)
{
  List<WebElement> td_collection=trElement.findElements(By.xpath("td"+"[2]"));
  
  for(WebElement tdElement : td_collection)
  {

  	          	
  	if(tdElement.getText().contains(participantName)){
  		
  		WebElement getParentRow =  tdElement.findElement(By.xpath("./.."));
  	 	getParentRow.findElement(By.xpath(".//td[1]/a")).click();
  		
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

	public void PerformAction(String participantName, String ActionName, boolean closeInformation) {

		List<WebElement> tr_collection = Element
				.GetTableBodyRows("//table[@id='participantSummary']/tbody");
		for (WebElement trElement : tr_collection) {

			if (trElement.getAttribute("class").contains("no-results ng-hide"))
				continue;
			WebElement cell = trElement.findElement(By.xpath("td[2]"));

			if (cell.getText().contains(participantName)) {
				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				String test12 = getParentRow.getText();
				WebElement getActionColumn = getParentRow.findElement(By
						.xpath(".//td[5]"));
				if (ActionName.contains("Make Intake Name")) {
					String test23 = getParentRow.findElement(
							By.xpath(".//td[2]")).getText();
					getActionColumn.findElement(
							By.xpath(".//span[@tooltip='" + ActionName + "']"))
							.click();
					Alert alert = Browser.driver.switchTo().alert();
					alert.accept();

					break;

				}
				if (ActionName.contains("Search and Link")) {

					getActionColumn.findElement(
							By.xpath("//span[@tooltip='" + ActionName + "']"))
							.click();

					break;

				}

				else {
					getActionColumn.findElement(
							By.xpath("//a[@tooltip='" + ActionName + "']"))
							.click();
					 if(closeInformation){
						   
					     Element.InformationDialoogOKButton().click();
					   }
					 else{

					Alert alert = Browser.driver.switchTo().alert();
					alert.accept();
					 }

					break;
				}

			}

		}

	}
  
  
	public boolean VerifyActionIconIsPresent(String participantName,
			String ActionName) {

		boolean isActionAvailable = false;

		List<WebElement> tr_collection = Element
				.GetTableBodyRows("//table[@id='participantSummary']/tbody");
		for (WebElement trElement : tr_collection) {
			if (trElement.getAttribute("class").contains("no-results ng-hide"))
				continue;
			WebElement cell = trElement.findElement(By.xpath("td[2]"));

			if (cell.getText().contains(participantName)) {
				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				WebElement getActionColumn = getParentRow.findElement(By
						.xpath(".//td[5]"));
				try {

					if (ActionName.contains("Make Intake Name")) {
						getActionColumn
								.findElement(By.xpath("//span[@tooltip='"
										+ ActionName + "']"));
						isActionAvailable = true;

						break;
					}

					if (ActionName.contains("Search and Link")) {
						getActionColumn
								.findElement(By.xpath("//span[@tooltip='"
										+ ActionName + "']"));
						isActionAvailable = true;

						break;
					} else {
						getActionColumn.findElement(By.xpath("//a[@tooltip='"
								+ ActionName + "']"));
						isActionAvailable = true;

						break;
					}

				} catch (Exception e) {
					isActionAvailable = false;

					break;
				}
			}

		}

		return isActionAvailable;
	}

}
