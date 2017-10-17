package Pages.Operations;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import General.Browser;
import Pages.Elements.NonCpsDecisionElement;

public class NonCpsDecisionOperation   extends BaseOperations<NonCpsDecisionElement> {

	public NonCpsDecisionOperation(NonCpsDecisionElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectDecision(String descision){
		
		Element.Decision().selectByVisibleText(descision);
	}
	
    public void SelectRejectWithdrawReason(String reason){
		
		Element.RejectWithdrawReason().selectByVisibleText(reason);
	}
    
    public void EnterComments(String comment){
    	Element.Comments().sendKeys(comment);
    	
    }

    public boolean VerifyDecisionIsNotEnabled(){
    	boolean IsEnabled = true;
    	
    	  Alert alert = Browser.driver.switchTo().alert();
    	 if( alert.getText().contains("Non CPS Decision information cannot be entered when Intake status is 'PENDING' or 'LINKED'")){
    		 IsEnabled=false;
    		 alert.accept();
    		 
    	 }
		  
		 return IsEnabled;
    }
    
    public boolean IsRejectWithdrowReasonEnabled(){
    	boolean IsEnabled = true;
    	if(Browser.driver.findElement(By.xpath("//select[@id='rejectWithdrawReason']")).isEnabled()){
    		IsEnabled = true;
    	}
    	
    	else {
    		IsEnabled = false;
    	}
    	
    	return IsEnabled;
    }
    
    public boolean IsDecisionEnabled(){
    	boolean IsEnabled = true;
    	if(Browser.driver.findElement(By.xpath("//select[@id='decision']")).isEnabled()){
    		IsEnabled = true;
    	}
    	
    	else {
    		IsEnabled = false;
    	}
    	
    	return IsEnabled;
    }
}
