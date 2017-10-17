package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.MyOrganizerElement;
import Pages.Operations.MyOrganizerOperations;

public class MyOrganizerPage extends BasePage<MyOrganizerElement, MyOrganizerOperations> {
	
	public WebDriver driver;
	public MyOrganizerPage()
	{
		
         this.driver  = Browser.driver;
		
	}
	public  MyOrganizerElement Elements(){
		
		return new MyOrganizerElement(driver);
       
    }
	  
	public   MyOrganizerOperations Operations(){
		  
		MyOrganizerElement element=  new MyOrganizerElement(driver);
          return new MyOrganizerOperations(element);  
     }
	
	public void Navigate(String Url){
		driver.get(Url);
		
		
	}

}
