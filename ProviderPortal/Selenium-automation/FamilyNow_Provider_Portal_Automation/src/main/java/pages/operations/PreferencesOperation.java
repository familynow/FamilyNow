package pages.operations;

import general.Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageControllers.ProviderPageManager;
import pages.elements.PreferencesElement;

public class PreferencesOperation extends BaseOperation<PreferencesElement>{

	public PreferencesOperation(PreferencesElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
public void SelectRace(String[] Races){
		
		
		for(String race:Races)
		{
			
			Element.AvailableRace().selectByVisibleText(race);
			
	  }
		
	 Element.MoveItemRight(0).click();	
	}

public void NavigateAndFillRequiredField() throws InterruptedException{
	 ClickNavigationWizard("Preferences");
	 ApplyWait(Browser.driver);
	 Thread.sleep(4000);
	 String[] Race = new String[]{"Asian"};
	 EnterRequiredField("10", "15", Race);
}

public void EnterRequiredField(String MinAge,String MaxAge,String[] Race){
	 ProviderPageManager.PreferencesPage().Elements().MinAge().clear();
	 ProviderPageManager.PreferencesPage().Elements().MinAge().sendKeys(MinAge);
	 ProviderPageManager.PreferencesPage().Elements().MaxAge().clear();
	 ProviderPageManager.PreferencesPage().Elements().MaxAge().sendKeys(MaxAge);
	 SelectRace(Race);
	
}

public boolean VerifyWarningMessage(String WarningMessage){
	
	List<WebElement> allRequiredFieldDiv=	Browser.driver.findElements(By.xpath("//div[@class='has-error ng-binding']"));
	
	boolean warningMessageDisplayed=false;
	
	 for(WebElement div : allRequiredFieldDiv){
		 String test = div.getText();
		 if(div.getText().contains(WarningMessage))
			{
			 warningMessageDisplayed = true;
				break;
			}
	 }
	
	return warningMessageDisplayed;
}

}
