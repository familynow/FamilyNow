package Pages.Operations;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import General.Browser;
import Pages.Elements.MyOrganizerElement;

public class MyOrganizerOperations extends BaseOperations<MyOrganizerElement> {
	
	public MyOrganizerOperations(MyOrganizerElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void ClickFirstInvestigation() throws InterruptedException{
		 Thread.sleep(1000);
		Element.ViewAllInvestigation().click();
	   
	
		try{
			 Thread.sleep(1000);
			 List<WebElement> th_collection = Element.GetTableBodyRows("//table[@id='OpenInvestigations']/thead");
			 th_collection.get(0).findElement(By.xpath("//th[2]/a")).click();
			 Thread.sleep(1000);
			 List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='OpenInvestigations']/tbody");
			 int rnd = new Random().nextInt(tr_collection.size());	
			 WebElement row=	Browser.driver.findElements(By.xpath("//table[@id='OpenInvestigations']/tbody/tr")).get(rnd);
			 row.findElement(By.xpath("td[2]/a")).click();
					
		
			 Thread.sleep(1000);
		}
		
		catch (Exception e){
			Assert.fail("No Investigation available");
		}
		
		
	}

}
