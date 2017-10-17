package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Elements.EmployeeSearchElement;

public class EmployeeSearchOperation extends BaseOperations<EmployeeSearchElement> {

	public EmployeeSearchOperation(EmployeeSearchElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectEmployee(String EmployeeId) {

		List<WebElement> tr_collection = Element
				.GetTableBodyRows("//table[@id='EmpSearchResultTable']/tbody");
		for (WebElement trElement : tr_collection) {
			if (trElement.getAttribute("class").contains("no-results ng-hide"))
				continue;
			WebElement cell = trElement.findElement(By.xpath("td[2]"));

			if (cell.getText().contains(EmployeeId)) {

				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				getParentRow.findElement(By.xpath(".//td[1]/a")).click();

				break;

			}

		}

	}
	
	public String GetSearchedValue(String EmployeeId, int ColumnIndex) {
        String searchedValue ="";
		List<WebElement> tr_collection = Element
				.GetTableBodyRows("//table[@id='EmpSearchResultTable']/tbody");
		for (WebElement trElement : tr_collection) {
			if (trElement.getAttribute("class").contains("no-results ng-hide"))
				continue;
			WebElement cell = trElement.findElement(By.xpath("td[2]"));

			if (cell.getText().contains(EmployeeId)) {

				WebElement getParentRow = cell.findElement(By.xpath("./.."));
				searchedValue =	getParentRow.findElement(By.xpath(".//td["+String.valueOf(ColumnIndex)+"]")).getText();

				break;

			}

		}
		
		return searchedValue;

	}


}
