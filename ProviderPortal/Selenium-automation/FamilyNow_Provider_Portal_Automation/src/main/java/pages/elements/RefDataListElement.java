package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RefDataListElement extends BaseElement {

	public RefDataListElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public WebElement DomainCode(){
			return Driver.findElement(By.id("dcode"));
		}
	 public WebElement ReferenceCode(){
			return Driver.findElement(By.id("refcode"));
		}
	 
	 public WebElement DisplayValue(){
			return Driver.findElement(By.id("displayValue"));
		}
	 
	 public Select Status(){
			Select status = new Select(Driver.findElement(By.id("status")));
			return status;
		}
	 
	 public WebElement Search(){
			return Driver.findElement(By.id("search"));
		}
	 public WebElement AddNewRecord(){
			return Driver.findElement(By.id("addNewRecord"));
		}

}
