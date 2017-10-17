package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ComplaintParticipantElement extends BaseElements {

	public ComplaintParticipantElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
	
	 public Select SuffixDropdown(){
			Select suffixDropdown = new Select(Driver.findElement(By.id("suffix")));
			return suffixDropdown;
		}
	 
	 public Select GenderDropdown(){
			Select suffixDropdown = new Select(Driver.findElement(By.id("gender")));
			return suffixDropdown;
		}
	 public Select AvailableRace(){
			Select availableRace = new Select(Driver.findElement(By.id("availableRace")));
			return availableRace;
		}
	 
	 public Select SelectedRace(){
			Select selectedRace = new Select(Driver.findElement(By.id("selectedRace")));
			return selectedRace;
		}
	 
	 public Select AvailableRole(){
			Select availableRole = new Select(Driver.findElement(By.id("availableRoles")));
			return availableRole;
		}
	 
	 public Select SelectedRole(){
			Select selectedRole = new Select(Driver.findElement(By.id("selectedRoles")));
			return selectedRole;
		}
	 
	 public WebElement MoveItemRight(int index){
			
			List<WebElement> moveRightButton = Driver.findElements(By.xpath(".//*[@id='move-item-right']"));
			  return moveRightButton.get(index);
	    }
			
	 public WebElement MoveItemLeft(int index){
				
		    List<WebElement> moveLeftButton = Driver.findElements(By.xpath(".//*[@id='move-item-left']"));
		    return moveLeftButton.get(index);
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
	   
	   public WebElement AddressUnknown(){
			
			return Driver.findElement(By.xpath("//*[contains(text(),'Address Unknown')]"));
		}
	   
	   
	   
	   public Select SameDropdown(){
			Select sameDropdown = new Select(Driver.findElement(By.id("same")));
			return sameDropdown;
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
			Select stateDropdown = new Select(Driver.findElement(By.id("state")));
			return stateDropdown;
		}
	   public WebElement Zip(){
			return Driver.findElement(By.id("zip"));
		}
	   
	   public Select Location(){
			Select locationDropdown = new Select(Driver.findElement(By.id("location")));
			return locationDropdown;
		}
	   
	   public WebElement ComplaintNameDiv(){
		   return Driver.findElement(By.xpath("//div[@class='col-lg-2 col-xs-12 hero-img-wrap']"));
		
		}
	   
	   public Select AccessToVictimDropdown(){
			Select accessToVictimDropdown = new Select(Driver.findElement(By.id("accessToVictim")));
			return accessToVictimDropdown;
		}
	   
	   public WebElement SaveAdd(){
			 return Driver.findElement(By.id("saveAdd"));
			}

}
