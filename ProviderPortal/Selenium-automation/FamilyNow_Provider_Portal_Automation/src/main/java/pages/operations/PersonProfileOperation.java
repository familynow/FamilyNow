package pages.operations;

import general.Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.elements.PersonProfileElement;

public class PersonProfileOperation extends BaseOperation<PersonProfileElement> {

	
	public PersonProfileOperation(PersonProfileElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void SelectRace(String Race){
		Element.Race().selectByVisibleText(Race);
	}
	
	 public void SelectHeighestEducation(String HeighestEducation){
		Element.HeighestEducation().selectByVisibleText(HeighestEducation);
	}
	
	public void SelectGender(String Gender){
		Element.Gender().selectByVisibleText(Gender);
	}
	
	public void SelectState(String State){
		Element.State().selectByVisibleText(State);
	}
	
	public void EnterDOB(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div/div/form/div[1]/div[2]/div/div[4]/div[1]/div/span/i","html/body/div[1]/div/div/form/div[1]/div[2]/div/div[4]/div[1]/div/span/ul/li[1]/div/table/tbody");
	      boolean datefound = false;
	      for(WebElement trElement : tr_collection)
	      {
	    	   List<WebElement> allDates=trElement.findElements(By.xpath("td")); 
			for(WebElement ele:allDates)
			{
				
				if(ele.getText().equals(date))
				{
					ele.findElement(By.xpath("button")).click();
					datefound = true;
					break;
				}
				
			}
			
			if(datefound){
				break;
			}
			
	      }
			
		}
	
	public void EnterRequired(String Gender,String DOB, String Race,String HeighestEducation, String Mobile,String Address1,String Address2,String City,String State,String Zip){
		

		SelectGender(Gender);
		EnterDOB(DOB);
		SelectRace(Race);
		SelectHeighestEducation(HeighestEducation);
		Element.Mobile().click();
		Element.Mobile().sendKeys(Mobile);
		Element.AddressLine1().clear();
		Element.AddressLine2().clear();
		Element.AddressLine1().sendKeys(Address1);
		Element.AddressLine2().sendKeys(Address2);
		Element.City().clear();
		Element.City().sendKeys(City);
		SelectState(State);
		Element.Zip().sendKeys(Zip);
		
		
	}
	 public Boolean IsUnemployedChecked(){
		  
		   return  Browser.driver.findElement(By.id("checkboxUnEmployed")).isSelected();
	   }
	
	public void NavigateToProfilePage(){
		ClickSideMenuBar("My Profile");
	}

}
