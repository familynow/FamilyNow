package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.elements.BaseElement;

public class AddressInformationElement extends BaseElement {
	public AddressInformationElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	 public WebElement City(){
		
			return Driver.findElements(By.id("city")).get(1);
		}
	 public Select State(){
		   
			Select stateDropdown = new Select(Driver.findElements(By.id("state")).get(1));
			return stateDropdown;
		}
	 
	 public WebElement Zip(){
		
			return Driver.findElements(By.id("zip")).get(1);
		}
	 
	 public Select DoYouOwnRentOrLease(){
			Select doYouOwnRentOrLeaseDropdown = new Select(Driver.findElement(By.id("rentStatus")));
			return doYouOwnRentOrLeaseDropdown;
		}
	 public Select AreThereWeaponsInHome(){
			Select  areThereWeaponsInHomeDropdown = new Select(Driver.findElement(By.id("weapons")));
			return areThereWeaponsInHomeDropdown;
		}
	 
	 public Select AreThereBodiesOfWaterNearYourHome(){
			Select areThereBodiesOfWaterNearYourHomeDropdown = new Select(Driver.findElement(By.id("waterBodies")));
			return areThereBodiesOfWaterNearYourHomeDropdown;
		}
	 
	 public WebElement AddressSaveButton(){
			
			return	  Driver.findElement(By.xpath("//div[@id='addressInformation']//button[3]"));
					
				}
	 
	 public WebElement AddressSaveContinue(){
		 
		 //Save & Continue
		 return	  Driver.findElement(By.xpath("//*[contains(text(),'Save & Continue')]"));
		 
	 }
	 public WebElement PreviousButton(){
			
			return	  Driver.findElement(By.xpath("//div[@id='addressInformation']//button[2]"));
					
				}
	 public WebElement Addressline1(){
		 return Driver.findElement(By.id("address_line_1"));
		 
	 }
	 
	 public WebElement Addressline2(){
		 return Driver.findElement(By.id("address_line_2"));
		 
	 }
	 
	

}
