package pages;

import general.Browser;

import org.openqa.selenium.WebDriver;

import pages.elements.UserListElement;
import pages.operations.UserListOperation;

public class UserListPage extends BasePage<UserListElement,UserListOperation>{
	
	public WebDriver driver;
	public UserListPage(){
		this.driver = Browser.driver;
	}

	@Override
	public UserListElement Elements() {
		// TODO Auto-generated method stub
		return new UserListElement(driver);
	}

	@Override
	public UserListOperation Operation() {
		UserListElement element = new UserListElement(driver);
		return new UserListOperation(element);
	}

}
