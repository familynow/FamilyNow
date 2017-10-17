package pages.operations;

import general.Browser;
import general.GetConfigValue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageControllers.ProviderPageManager;
import pages.elements.LoginPageElement;

public class LoginPageOperation extends BaseOperation<LoginPageElement> {
	public LoginPageOperation(LoginPageElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void Login(){
		String getUrl = GetConfigValue.GetUrl();
		ProviderPageManager.LoginPage().Navigate(getUrl);
		try{
			Thread.sleep(1000);
			Element.Email().sendKeys("Test@gmail.com");
			Element.Password().sendKeys("Welcome1");
			Element.LoginButton().click();
			Thread.sleep(1000);
		}
		
		catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 	}
		
	}
	
	
	
	public void Login(String Email, String Password){
		
		try{
			Thread.sleep(1000);
			Element.Email().sendKeys(Email);
			Element.Password().sendKeys(Password);
			Element.LoginButton().click();
			Thread.sleep(1000);
		}
		
		catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 	}
		
	}

  public void EnterRequiredField(String Fname, String Lname,String Email,String Password,String RePassword){
	  
	  Element.Fname().sendKeys(Fname);
	  Element.Lname().sendKeys(Lname);
	  Element.Email().sendKeys(Email);
	  Element.Password().sendKeys(Password);
	  Element.RePassword().sendKeys(RePassword);
		
	}
  
  public boolean VerifyRequiredFieldMessage(String WarningMessage){
		
	  List<WebElement> allRequiredFieldDiv=	Browser.driver.findElements(By.xpath("//form[@id='signupForm']//div[@class='form-group single-field-set']"));
		boolean warningMessageDisplayed=false;
		
		 for(WebElement div : allRequiredFieldDiv){
			
			 if(div.getText().contains(WarningMessage))
				{
				 warningMessageDisplayed = true;
					break;
				}
			 
		 }
		
		return warningMessageDisplayed;
  }

}
