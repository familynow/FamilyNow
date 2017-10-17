package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.IntakeListElement;
import Pages.Operations.IntakeListOperation;



public class IntakeListPage extends BasePage<IntakeListElement, IntakeListOperation> {
	
	public WebDriver driver;
	public IntakeListPage()
	{
         this.driver  = Browser.driver;

	}
	public  IntakeListElement Elements(){
		   
         return new IntakeListElement(driver);
       
    }
	  
	public   IntakeListOperation Operations(){
		
	   IntakeListElement element=  new IntakeListElement(driver);
       return new IntakeListOperation(element);  
     }
	
	public void Navigate(String Url){
		driver.get(Url);
		Elements().GetIntakeList().click();
		
	}
	  

}
