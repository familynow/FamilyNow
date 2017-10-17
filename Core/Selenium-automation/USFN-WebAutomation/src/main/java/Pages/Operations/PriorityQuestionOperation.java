package Pages.Operations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import General.Browser;
import Pages.Elements.PriorityQuestionElement;



public class PriorityQuestionOperation extends BaseOperations<PriorityQuestionElement> {

	public PriorityQuestionOperation(PriorityQuestionElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectAnswers(String AnswerType){
		do{
			if(AnswerType.contains("Yes")){
				Element.YesRadioButton().click();
			 
			}
			
			else{
				Element.NoRadioButton().click();
			}
			
			
		}while(NextButtonClick());
		
	}
	
	public boolean NextButtonClick()
	  {

		  boolean success = true;
	       if( Element.NextButton().isEnabled()){
	    	  Element.NextButton().click();
	       }
	         
	       else{
	     
	          success = false; // Next button is disabled
	       }
	    
	    
	     
	      return success;
	  }
	
/*	public void SelectAnswers(String AnswerType, boolean edit){
		
		if(AnswerType.contains("Yes")){
			Element.YesRadioButton().click();
			if(edit){
				Alert alert = Browser.driver.switchTo().alert();
				alert.accept();
			}
		}
		if(AnswerType.contains("No")){
			Element.NoRadioButton().click();
			Element.NextButton().click();
			Element.NoRadioButton().click();
		}
		
		
		
	}*/

}
