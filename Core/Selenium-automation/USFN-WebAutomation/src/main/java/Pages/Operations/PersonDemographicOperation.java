package Pages.Operations;

import org.openqa.selenium.support.ui.Select;

import Pages.Elements.PersonDemographicElement;



public class PersonDemographicOperation  extends BaseOperations<PersonDemographicElement>{

	public PersonDemographicOperation(PersonDemographicElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	
  public void SelectLanguage(String[] languages){
		
		for(String language:languages)
		{
			
			Element.AvailableLanguage().selectByVisibleText(language);
			//selectByVisibleText(MethodName)
	   }
		
	   Element.MoveItemRight(1).click();	
	}
  
  public void RemoveLanguage(String[] languages){
		
		
		for(String language:languages)
		{
			
			Element.AvailableLanguage().selectByVisibleText(language);
			//selectByVisibleText(MethodName)
	   }
		
	  Element.MoveItemLeft(1).click();	
	}
  
   public void SelectPrimaryLanguage(String primaryLanguage){
	   Element.PrimaryLanguage().selectByVisibleText(primaryLanguage);
	}
	
	public  void SelectDeathVerificationSource(String deathVerificationSource){
		 Element.DeathVerificationSource().selectByVisibleText(deathVerificationSource);
	}
	
	 public void SelectHairColor(String hairColor){
		   Element.HairColor().selectByVisibleText(hairColor);
		}
	 
	 public void SelectReligion(String religion){
		   Element.Religion().selectByVisibleText(religion);
		}

}
