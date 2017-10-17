package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.CreateCpsElement;
import Pages.Operations.CreateCpsOperation;



public class CreateCpsPage extends BasePage<CreateCpsElement, CreateCpsOperation> {
	
	public WebDriver driver;
	public CreateCpsPage()
	{
         this.driver  = Browser.driver;

	}
	public  CreateCpsElement Elements(){
		   
         return new CreateCpsElement(driver);
       
    }
	  
	public   CreateCpsOperation Operations(){
		
		CreateCpsElement element=  new CreateCpsElement(driver);
       return new CreateCpsOperation(element);  
     }
	
	public void Navigate(String Url){
		driver.get(Url);
		//Elements().GetIntakeList().click();
		
	}


}
