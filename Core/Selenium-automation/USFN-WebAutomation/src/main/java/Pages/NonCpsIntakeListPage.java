package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import General.Browser;
import PageControllers.UsfnPageManager;
import Pages.Elements.NonCpsIntakeListElement;
import Pages.Operations.NonCpsIntakeListOperation;



public class NonCpsIntakeListPage  extends BasePage<NonCpsIntakeListElement, NonCpsIntakeListOperation> {
	
	public WebDriver driver;
	public NonCpsIntakeListPage()
	{
         this.driver  = Browser.driver;

	}
	@Override
	public NonCpsIntakeListElement Elements() {
		  return new NonCpsIntakeListElement(driver);
	}
	@Override
	public NonCpsIntakeListOperation Operations() {
		NonCpsIntakeListElement element=  new NonCpsIntakeListElement(driver);
	       return new NonCpsIntakeListOperation(element);  
	}

	
	public void NavigateToNonCpsListPage() {
		try{
			 UsfnPageManager.IntakeListPage().Operations().NavigateToIntakeListPage();
			    Thread.sleep(1000);
				Operations().ClickHeaderMenu("Non CPS Workload");
				 Thread.sleep(1000);
			
		}
	   
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
}
