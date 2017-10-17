package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonProfileElement extends BaseElement{

	public PersonProfileElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
public WebElement UserName(){
		
		return Driver.findElement(By.id("nameEmail"));
	  }
	
	public WebElement Fname(){
		return Driver.findElement(By.id("firstName"));
	}
	
	public WebElement Lname(){
		return Driver.findElement(By.id("lastName"));
	}
	
   public Select Race(){
			Select RaceDropdown = new Select(Driver.findElement(By.id("race")));
			return RaceDropdown;
		}
   
   public Select HeighestEducation(){
			Select HeighestEducationDropdown = new Select(Driver.findElement(By.id("heighestEducation")));
			return HeighestEducationDropdown;
		}
   
   public Select Gender(){
		Select genderDropdown = new Select(Driver.findElement(By.id("Gender")));
		return genderDropdown;
	}
   
   public WebElement DOB(){
		return Driver.findElement(By.id("dob"));
	}
   
   public WebElement WorkNumber(){
		return Driver.findElement(By.id("workNumber"));
	}
   
   public WebElement Mobile(){
		return Driver.findElement(By.id("mobile"));
	}
   
   public WebElement Extension(){
		return Driver.findElement(By.id("extension"));
	}
   public WebElement ContactEmail(){
		return Driver.findElement(By.id("contactEmail"));
	}
   public WebElement Other(){
		return Driver.findElement(By.id("other"));
	}
   public WebElement OrganizationName(){
		return Driver.findElement(By.id("orgName"));
	}
   public WebElement AddressLine1(){
		return Driver.findElement(By.id("addressLine1"));
	}
   public WebElement AddressLine2(){
		return Driver.findElement(By.id("addressLine2"));
	}
   
   public WebElement City(){
		return Driver.findElement(By.id("city"));
	}
   
   public Select State(){
		Select StateDropdown = new Select(Driver.findElement(By.id("state")));
		return StateDropdown;
	}
   public WebElement Zip(){
		return Driver.findElement(By.id("zip"));
	}
  
   
   public WebElement ProfileCancelButton(){
		return Driver.findElement(By.xpath("//button[@id='cancel']"));
	}
   public WebElement ProfileSaveButton(){
		return Driver.findElement(By.xpath("//button[@id='save']"));
	}
   public WebElement EmployerName(){
		return Driver.findElement(By.id("employerName"));
	}
   public WebElement EmployerAddressLine1(){
		return Driver.findElement(By.id("empAddressLine1"));
	}
   public WebElement EmployerAddressLine2(){
		return Driver.findElement(By.id("empAddressLine2"));
	}
   public WebElement EmployerCity(){
		return Driver.findElement(By.id("empCity"));
	}
   public Select EmployerState(){
		Select EmployerStateDropdown = new Select(Driver.findElement(By.id("empState")));
		return EmployerStateDropdown;
	}
   
   public WebElement EmployerZip(){
		return Driver.findElement(By.id("empZip"));
	}
   public WebElement EmployerWorkPhone(){
		return Driver.findElement(By.id("workPhone"));
	}
   public WebElement Occupation(){
		return Driver.findElement(By.id("occupation"));
	}
   
   public Select AnnualIncome(){
		Select AnnualIncomeDropdown = new Select(Driver.findElement(By.id("annualIncome")));
		return AnnualIncomeDropdown;
	}

}
