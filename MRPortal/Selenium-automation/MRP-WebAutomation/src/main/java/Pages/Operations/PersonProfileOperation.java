package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import PageControllers.MRPPageManager;
import Pages.Elements.PersonProfileElement;

public class PersonProfileOperation extends BaseOperations<PersonProfileElement> {

	public PersonProfileOperation(PersonProfileElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void NavigateToPersonProfilePage(){
		MRPPageManager.MyComplaintPage().Elements().AddNewReportButton().click();
	}
	
	public void SelectCategory(String Category){
		Element.ReportingPersonCategory().selectByVisibleText(Category);
	}
	
	public void SelectRole(String Role){
		Element.ReportingPersonRole().selectByVisibleText(Role);
	}
	
	public void SelectGender(String Gender){
		Element.Gender().selectByVisibleText(Gender);
	}
	
	public void SelectState(String State){
		Element.State().selectByVisibleText(State);
	}
	
	public void EnterRequired(String Fname,String Lname,String Category,String Role,String Gender,String Phone,String Mobile,String Address1,String Address2,String City,String State,String Zip){
		
		Element.Fname().clear();
		Element.Lname().clear();
		Element.Fname().sendKeys(Fname);
		Element.Lname().sendKeys(Lname);
		SelectCategory(Category);
		SelectRole(Role);
		SelectGender(Gender);
		Element.WorkNumber().sendKeys(Phone);
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
	
	
	
	

}
