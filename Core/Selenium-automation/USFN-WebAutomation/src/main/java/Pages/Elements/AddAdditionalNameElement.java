package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddAdditionalNameElement  extends BaseElements {

	public AddAdditionalNameElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    public WebElement SaveButton(){
		
		return GetButton("//*[contains(text(),'Save')]");
	}
	
	public WebElement ApplyButton(){
		
		return GetButton("//*[contains(text(),'Apply')]");
	}
	
	public Select NameType(){
		return GetDropDown("akaNameType");
	}
	
	public Select Prefix(){
		return GetDropDown("prefix");
	}
	
	public Select Suffix(){
		return GetDropDown("suffix");
	}
	
	public WebElement FirstName()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath("//input[@id='akaFirstName']"));
        return FirstName;
	}
	
	public WebElement MiddleName()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath("//input[@id='akaMiddleName']"));
        return FirstName;
	}
	
	public WebElement LastName()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath("//input[@id='akaLastName']"));
        return FirstName;
	}

}
