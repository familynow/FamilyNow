package Pages.Operations;

import Pages.Elements.NonCpsAddParticipantElement;

public class NonCpsAddParticipantOperation extends BaseOperations<NonCpsAddParticipantElement> {

	public NonCpsAddParticipantOperation(NonCpsAddParticipantElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	
public void SelectRoles(String[] Roles){
		
		
		for(String role:Roles)
		{
			
			Element.AvailableRoles().selectByVisibleText(role);
			//selectByVisibleText(MethodName)
	  }
		
	 Element.MoveItemRight(1).click();	
	}
	
	
    public void SelectGender(String Gender){
		
			Element.Gender().selectByVisibleText(Gender);
	}
	
	
  public void RemoveRoles(String[] Roles){
		
		
		for(String role:Roles)
		{
			
			Element.SelectedRoles().selectByVisibleText(role);
			//selectByVisibleText(MethodName)
	  }
		
	 Element.MoveItemLeft(1).click();	
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

}
