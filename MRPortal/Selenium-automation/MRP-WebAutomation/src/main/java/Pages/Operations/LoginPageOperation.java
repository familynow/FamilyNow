package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import General.GetConfigValue;
import PageControllers.MRPPageManager;
import Pages.Elements.LoginPageElement;



public class LoginPageOperation extends BaseOperations<LoginPageElement> {

	public LoginPageOperation(LoginPageElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void Login(){
		String getUrl = GetConfigValue.GetUrl();
		MRPPageManager.LoginPage().Navigate(getUrl);
		try{
			Thread.sleep(1000);
			Element.Email().sendKeys("automationuser@selenium.com");
			Element.Password().sendKeys("12345678");
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
