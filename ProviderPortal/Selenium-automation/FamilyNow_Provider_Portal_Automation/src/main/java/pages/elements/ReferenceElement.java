package pages.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.elements.BaseElement;

public class ReferenceElement extends BaseElement {
	public ReferenceElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    public WebElement App1ReferenceName1 (){
			return Driver.findElements(By.id("refname1")).get(0);
		}
    public WebElement App1ReferenceName2 (){
		return Driver.findElements(By.id("refname2")).get(0);
	}
    
    public WebElement App1ReferenceName3 (){
		return Driver.findElements(By.id("refname3")).get(0);
	}
    
    public WebElement App1Contact1 (){
    	List<WebElement> l =  Driver.findElements(By.id("contact1"));

    	
		return Driver.findElements(By.id("contact1")).get(0);
	}
   public WebElement App1Contact2 (){
	return Driver.findElements(By.id("contact2")).get(0);
   }

  public WebElement App1Contact3 (){
	return Driver.findElements(By.id("contact3")).get(0);
  }
  
  public WebElement App2ReferenceName1 (){
		return Driver.findElements(By.id("refname1")).get(1);
	}
  public WebElement App2ReferenceName2 (){
	return Driver.findElements(By.id("refname2")).get(1);
}

public WebElement App2ReferenceName3 (){
	return Driver.findElements(By.id("refname3")).get(1);
}

public WebElement App2Contact1 (){
	return Driver.findElements(By.id("contact1")).get(1);
}
public WebElement App2Contact2 (){
return Driver.findElements(By.id("contact2")).get(1);
}

public WebElement App2Contact3 (){
return Driver.findElements(By.id("contact3")).get(1);
}
public WebElement ReferenceSaveContinue(){
	 
	 return	  Driver.findElement(By.xpath("//div[@id='references']//button[4]"));
	 
}
public WebElement ReferencePrevious(){
	 
	 return	  Driver.findElement(By.xpath("//div[@id='references']//button[2]"));
	 
}



}
