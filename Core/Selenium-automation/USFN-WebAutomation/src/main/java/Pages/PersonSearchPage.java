package Pages;

import org.openqa.selenium.WebDriver;

import General.Browser;
import Pages.Elements.PersonSearchElement;
import Pages.Operations.PersonSearchOperation;

public class PersonSearchPage extends BasePage<PersonSearchElement, PersonSearchOperation> {
	
	public WebDriver driver;
	public PersonSearchPage()
	{
         this.driver  = Browser.driver;

	}
	public  PersonSearchElement Elements(){
		   
         return new PersonSearchElement(driver);
       
    }
	  
	public   PersonSearchOperation Operations(){
		
		PersonSearchElement element=  new PersonSearchElement(driver);
        return new PersonSearchOperation(element);  
     }
	
	public void Navigate(String Url){
		driver.get(Url);
		//Elements().GetIntakeList().click();
		
	}


}
