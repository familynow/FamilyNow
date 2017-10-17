package pages.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.elements.BaseElement;

public class FosterCareElement extends BaseElement {
	public FosterCareElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public Select Adoption(){
		Select adoptionDropdown = new Select(Driver.findElement(By.id("adoption")));
		return adoptionDropdown;
	}
	
	public Select Fostercare(){
		Select fostercareDropdown = new Select(Driver.findElement(By.id("licensed")));
		return fostercareDropdown;
	}
	
	public Select ChildIdentifiedCode(){
		Select childIdentifiedCodeDropdown = new Select(Driver.findElement(By.id("childIdentifiedCode")));
		return childIdentifiedCodeDropdown;
	}
	
	public Select Gender(){
		
		Select childIdentifiedCodeDropdown = new Select(Driver.findElements(By.id("gender")).get(1));
		return childIdentifiedCodeDropdown;
	}
	
	public Select Race(){
		Select childIdentifiedCodeDropdown = new Select(Driver.findElements(By.id("race")).get(1));
		return childIdentifiedCodeDropdown;
	}
	
	public Select Relationship(){
		 List<WebElement> fname = Driver.findElements(By.id("relationship"));
		 int test = fname.size();
		Select relationshipDropdown = new Select(Driver.findElement(By.id("relationship")));
		return relationshipDropdown;
	}
	
	public Select CurrentlyHome(){
		 List<WebElement> fname = Driver.findElements(By.id("currentlyHome"));
		 int test = fname.size();
		Select currentlyHomeDropdown = new Select(Driver.findElement(By.id("currentlyHome")));
		return currentlyHomeDropdown;
	}
	
	//relationship  Relationship with Applicant
	
	 public WebElement Fname(){
		    List<WebElement> fname = Driver.findElements(By.id("fname"));
		    
			return fname.get(1);
		}
	 public WebElement Lname(){
		    List<WebElement> lname = Driver.findElements(By.id("lname"));
			return lname.get(1);
		}
	 public WebElement Mname(){
		 List<WebElement> mname = Driver.findElements(By.id("mname"));
		 int test = mname.size();
			return Driver.findElement(By.id("mname"));
		}
	
   public WebElement FosterSave(){
		 
		 return	  Driver.findElement(By.xpath("//div[@id='fosterCareOrAdoptionHistory']//button[3]"));
		 
	 }
   

   public WebElement FosterSaveContinue(){
		 
		 return	  Driver.findElement(By.xpath("//div[@id='fosterCareOrAdoptionHistory']//button[4]"));
		 
	 }
   
   public WebElement FosterPrevious(){
		 
		 return	  Driver.findElement(By.xpath("//div[@id='fosterCareOrAdoptionHistory']//button[2]"));
		 
	 }

}
