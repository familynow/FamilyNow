package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.DiscontinueElement;

public class DiscontinueOperation extends BaseOperations<DiscontinueElement> {

	public DiscontinueOperation(DiscontinueElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	
	public void EnterDiscontinuedDate(String date) {
		List<WebElement> tr_collection = Element
				.GetAllDate(
						"html/body/div[1]/div[4]/div/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/span/i",
						"html/body/div[1]/div[4]/div/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/span/ul/li[1]/div/table/tbody");
		boolean datefound = false;
		for (WebElement trElement : tr_collection) {
			List<WebElement> allDates = trElement.findElements(By.xpath("td"));
			for (WebElement ele : allDates) {

				if (ele.getText().equals(date)) {
					ele.findElement(By.xpath("button")).click();
					datefound = true;
					break;
				}

			}

			if (datefound) {
				break;
			}

		}

	}

	public void EnterNotificationDate(String date) {
		List<WebElement> tr_collection = Element
				.GetAllDate(
						"html/body/div[1]/div[4]/div/div/div/div/div/div[2]/form/div[1]/div[5]/div/div/span/i",
						"html/body/div[1]/div[4]/div/div/div/div/div/div[2]/form/div[1]/div[5]/div/div/span/ul/li[1]/div/table/tbody");
		boolean datefound = false;
		for (WebElement trElement : tr_collection) {
			List<WebElement> allDates = trElement.findElements(By.xpath("td"));
			for (WebElement ele : allDates) {

				if (ele.getText().equals(date)) {
					ele.findElement(By.xpath("button")).click();
					datefound = true;
					break;
				}

			}

			if (datefound) {
				break;
			}

		}

	}

	public boolean VerifyCheckboxIsChecked() {
		boolean checked = false;

		WebElement CheckBox = Browser.driver.findElement(By
				.xpath("//input[@id='approproatePartiesNotified']"));

		if (CheckBox.isEnabled()) {
			checked = true;
		}

		return checked;
	}
	
public boolean VerifyRequiredFieldWarningMessage(String WarningMessage){
		
		List<WebElement> allRequiredFieldDiv=	Browser.driver.findElements(By.xpath("//div[@class='has-error']"));
		int size = allRequiredFieldDiv.size();
		boolean warningMessageDisplayed=false;
		
		 for(WebElement div : allRequiredFieldDiv){
			 String test = div.getText();
			 if(div.getText().contains(WarningMessage))
				{
				 warningMessageDisplayed = true;
					break;
				}
		 }
		
		return warningMessageDisplayed;
	}

}
