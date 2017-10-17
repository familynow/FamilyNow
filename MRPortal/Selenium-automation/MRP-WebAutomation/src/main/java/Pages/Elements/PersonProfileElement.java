package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonProfileElement extends BaseElements {

	public PersonProfileElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement UserName(){
		
		return Driver.findElement(By.id("nameEmail"));
	  }
	
	public WebElement Fname(){
		return Driver.findElement(By.id("fname"));
	}
	
	public WebElement Mname(){
		return Driver.findElement(By.id("mname"));
	}
	
	public WebElement Lname(){
		return Driver.findElement(By.id("lname"));
	}
	
   public Select ReportingPersonCategory(){
			Select ReportingPersonCategoryDropdown = new Select(Driver.findElement(By.id("personCategory")));
			return ReportingPersonCategoryDropdown;
		}
   
   public Select ReportingPersonRole(){
			Select ReportingPersonRoleDropdown = new Select(Driver.findElement(By.id("personRole")));
			return ReportingPersonRoleDropdown;
		}
   
   public Select Gender(){
		Select genderDropdown = new Select(Driver.findElement(By.id("gender")));
		return genderDropdown;
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
   public WebElement Email(){
		return Driver.findElement(By.id("email"));
	}
   public WebElement Other(){
		return Driver.findElement(By.id("other"));
	}
   public WebElement OrganizationName(){
		return Driver.findElement(By.id("orgName"));
	}
   public WebElement AddressLine1(){
		return Driver.findElement(By.id("address1"));
	}
   public WebElement AddressLine2(){
		return Driver.findElement(By.id("address2"));
	}
   
   public WebElement City(){
		return Driver.findElement(By.id("city"));
	}
   
   public Select State(){
		Select ReportingPersonRoleDropdown = new Select(Driver.findElement(By.id("state")));
		return ReportingPersonRoleDropdown;
	}
   public WebElement Zip(){
		return Driver.findElement(By.id("zip"));
	}
 
}
