package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.Elements.AddAdditionalNameElement;



public class AddAdditionalNameOperation extends BaseOperations<AddAdditionalNameElement> {

	public AddAdditionalNameOperation(AddAdditionalNameElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectNameType(String nameType){
		Element.NameType().selectByVisibleText(nameType);
	}
	
	public void SelectPrefix(String prefix){
		Element.Prefix().selectByVisibleText(prefix);
	}
	
	public void SelectSufix(String sufix){
		Element.Suffix().selectByVisibleText(sufix);
	}
	



}
