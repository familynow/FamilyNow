package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.elements.BaseElement;

public class ApplicationParticipantElement extends BaseElement {
	public ApplicationParticipantElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public Select ApplicantRole(){
			Select applicantRoleDropdown = new Select(Driver.findElement(By.id("applicantRole")));
			return applicantRoleDropdown;
		}
	 public WebElement Fname(){
			return Driver.findElement(By.id("fname"));
		}
	 public WebElement Lname(){
			return Driver.findElement(By.id("lname"));
		}
	 
	 public Select Gender(){
			Select genderDropdown = new Select(Driver.findElement(By.id("gender")));
			return genderDropdown;
		}
	 
	 public WebElement DOB(){
			return Driver.findElement(By.id("dob"));
		}
	   
	 
	 public Select Race(){
			Select raceDropdown = new Select(Driver.findElement(By.id("race")));
			return raceDropdown;
		}
	 
	 public Select HighestLevelofEducationCompleted (){
			Select highestLevelofEducationCompletedDropdown = new Select(Driver.findElement(By.id("education")));
			return highestLevelofEducationCompletedDropdown;
		}
	 public WebElement HomeMobilePhone(){
			return Driver.findElement(By.id("mobile"));
		}
	 public WebElement EmployerName(){
			return Driver.findElement(By.id("empName"));
		}
	   public WebElement EmployerAddressLine1(){
			return Driver.findElement(By.id("empAddress1"));
		}
	   public WebElement EmployerAddressLine2(){
			return Driver.findElement(By.id("empAddress2"));
		}
	   public WebElement EmployerCity(){
			return Driver.findElement(By.id("city"));
		}
	   public Select EmployerState(){
			Select EmployerStateDropdown = new Select(Driver.findElement(By.id("state")));
			return EmployerStateDropdown;
		}
	   
	   public WebElement EmployerZip(){
			return Driver.findElement(By.id("zip"));
		}
	   public WebElement EmployerWorkPhone(){
			return Driver.findElement(By.id("mobile"));
		}
	   public WebElement Occupation(){
			return Driver.findElement(By.id("occupation"));
		}
	   
	   public Select AnnualIncome(){
			Select AnnualIncomeDropdown = new Select(Driver.findElement(By.id("income")));
			return AnnualIncomeDropdown;
		}
	   
	   public WebElement UnemployedCheckBox(){
		  WebElement chkBox =  Driver.findElement(By.id("checkboxUnEmployed"));
		  WebElement getParentRow =  chkBox.findElement(By.xpath("./.."));
		  return getParentRow.findElement(By.xpath("//span[@class='text checkbox-item']"));
		   
	   }
	   
	   public WebElement CancelButton() {

			return Driver.findElement(By.xpath("//form[@id='providerApplicantsForm']//button[3]"));

		} 
	 
	public WebElement SaveAddButton() {

		return Driver.findElement(By.xpath("//button[4]"));

	}

	public WebElement SaveContinue() {

		return Driver.findElement(By.xpath("//button[5]"));

	}

	public WebElement ClearButton() {
		return Driver
				.findElement(By
						.xpath("//div[@class='action-wrap mt-20 text-right outer']//button[2]"));

	}

}
