package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InquirySearchElement extends BaseElement {

	public InquirySearchElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public Select Organization(){
			Select OrganizationDropdown = new Select(Driver.findElement(By.id("allegationTypeProvider")));
			return OrganizationDropdown;
		}
	 public WebElement FirstName(){
			return Driver.findElement(By.xpath("//div[@id='firstNameProvider']/input[@name='FirstName']"));
	
		}
	 public WebElement LastName(){
		 return Driver.findElement(By.xpath("//div[@id='lastNameProvider']/input[@name='LastName']"));
	
		}
	 public WebElement SearchButton(){
			return Driver.findElement(By.id("saerchProvider"));
	
		}
		public WebElement Email(){
			
			 return Driver.findElement(By.id("userName"));
			
		  }
		
		public WebElement Password(){
			
			return Driver.findElement(By.id("password"));
		  }
		
		public WebElement LoginButton(){
			
			return Driver.findElement(By.id("signup"));
			
		  }

}
