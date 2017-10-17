package Pages.Operations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import General.Browser;
import Pages.Elements.CpsAddParticipanElement;

public class CpsAddParticipanOperation extends BaseOperations<CpsAddParticipanElement> {
	public CpsAddParticipanOperation(CpsAddParticipanElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectRoles(String[] Roles){
		
		
		for(String role:Roles)
		{
			
			Element.Roles().selectByVisibleText(role);
			//selectByVisibleText(MethodName)
	  }
		
		/* Actions actions = new Actions(Browser.driver);
		 Integer iBottom = Element.MoveItemRight(1).getSize().height;
		    Integer iRight = Element.MoveItemRight(1).getSize().width;
		    actions.moveToElement(Element.MoveItemRight(1), iRight/2, iBottom/2).click().perform();*/
		
		((JavascriptExecutor)Browser.driver).executeScript("arguments[0].click();", Element.MoveItemRight(1));
	// Element.MoveItemRight(1).click();	
	}
	
	
    public void SelectGender(String Gender){
		
			Element.Gender().selectByVisibleText(Gender);
	}
	
	
  public void RemoveRoles(String[] Roles){
		
		
		for(String role:Roles)
		{
			
			Element.RemoveRoles().selectByVisibleText(role);
			//selectByVisibleText(MethodName)
	  }
		
		((JavascriptExecutor)Browser.driver).executeScript("arguments[0].click();", Element.MoveItemLeft(1));	
		
	}
	
	public void EnterFirstName(String FirstName){
		 try {
				Thread.sleep(500);
		    Element.FirstName().sendKeys(FirstName);
		 }
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void EnterLastName(String LastName){
		 try {
				Thread.sleep(500);
		 Element.LastName().sendKeys(LastName);
		 }
		 
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void AddParticipant(String fname,String lname,String[] roles)
	{
		EnterFirstName(fname);
		EnterLastName(lname);
		SelectRoles(roles);
	}

}
