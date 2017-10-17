package Pages.Operations;

import org.openqa.selenium.WebElement;

import Pages.Elements.CpsDecisionElement;

public class CpsDecisionOperation extends BaseOperations<CpsDecisionElement> {

	public CpsDecisionOperation(CpsDecisionElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectAgreewithRecommendedPriorityAsSubmitted(String option){
		Element.AgreewithRecommendedPriorityAsSubmitted().selectByVisibleText(option);
	}
	
	public void SelectOverridePriority(String priority){
		Element.OverridePriority().selectByVisibleText(priority);
	}
	
	public void SelectIntakeAction(String intakeAction){
		Element.IntakeAction().selectByVisibleText(intakeAction);
	}
	
	  

}
