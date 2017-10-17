package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElement extends BaseElements {

	public LoginElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement GetUserId()
	{
		
 		WebElement UserId= Driver.findElement(By.id("userName"));
        return UserId;
	}
	
	
	public WebElement GetPassword()
	{
		
 		WebElement Password= Driver.findElement(By.id("password"));
        return Password;
	}
	
	public WebElement GetLoginButton()
	{
		
 		WebElement LoginButton= Driver.findElement(By.xpath(".//button[@id='signup']"));
        return LoginButton;
	}
	
	public static void CloseBrowser(){
		Driver = null;
	}
}
