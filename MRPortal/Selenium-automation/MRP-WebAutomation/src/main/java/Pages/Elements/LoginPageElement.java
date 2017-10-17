package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElement extends BaseElements {

	public LoginPageElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement Email(){
		
		 return Driver.findElement(By.id("email"));
		
	  }
	
	public WebElement Password(){
		
		return Driver.findElement(By.id("password"));
	  }
	
	public WebElement LoginButton(){
		
		return Driver.findElement(By.id("signup"));
		
	  }
	
	public WebElement SignUp(){
		
		 return Driver.findElement(By.xpath("html/body/div[1]/div/div/div/p/a"));
	  }
	public WebElement Fname(){
		 return Driver.findElement(By.id("fname"));
	  }
	
	public WebElement Lname(){
		 return Driver.findElement(By.id("lname"));
	  }
	
	public WebElement UserName(){
		 return Driver.findElement(By.id("email"));
	  }
	
   public WebElement RePassword(){
		
		return Driver.findElement(By.id("repassword"));
	  }
   public WebElement SignUpButton(){
		
		return Driver.findElement(By.id("signup"));
	  }

}
