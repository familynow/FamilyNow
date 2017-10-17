package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonContactDetailElement extends BaseElements{

	public PersonContactDetailElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public Select ContactType(){
		return GetDropDown("contactTypeCode");
	}
	
	public WebElement Contact(){
		return  Driver.findElement(By.xpath(".//*[@id='contact']"));
	}
	
	public WebElement Primary(){
	
		return  Driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/form/div/div[1]/div[3]/label/span"));
	        

	}
	
	public WebElement Description(){
		return  Driver.findElement(By.xpath(".//*[@id='description']"));
	}
	
	
    public WebElement SaveButton(){
		
		return GetButton("//*[contains(text(),'Save')]");
	}
 
    public WebElement CotactRequiredFieldMessage(){
    	return  Driver.findElement(By.xpath("//*[contains(text(),'Contact is required.')]"));
    	
    }
    
    public WebElement DescriptionMaxLengthMessage(){
    	
    	return  Driver.findElement(By.xpath("//*[contains(text(),'More than 100 characters are not allowed.')]"));
    }

}
