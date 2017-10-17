package Pages.Operations;

import Pages.Elements.PersonContactDetailElement;

public class PersonContactDetailOperation extends BaseOperations<PersonContactDetailElement> {

	public PersonContactDetailOperation(PersonContactDetailElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectContactType(String contactType){
		Element.ContactType().selectByVisibleText(contactType);
	}

}
