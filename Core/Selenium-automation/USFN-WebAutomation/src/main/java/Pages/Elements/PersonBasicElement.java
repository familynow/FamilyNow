package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonBasicElement extends BaseElements{

	public PersonBasicElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
   public WebElement SaveButton(){
		
		return GetButton("//button[contains(text(),'Save')]");
	}
	
	public WebElement ApplyButton(){
		
		return GetButton("//button[contains(text(),'Apply')]");
	}
	
   public WebElement CancelButton(){
		
		return GetButton("//*[contains(text(),'Cancel')]");
	}
   
   public WebElement AdditionalNameButton()
	{
		
		WebElement FirstName= Driver.findElement(By.xpath("//button[@id='addAdditionalName']"));
       return FirstName;
	}
	
	public WebElement FirstName()
	{
		
 		WebElement FirstName= Driver.findElement(By.xpath("//input[@id='firstName']"));
        return FirstName;
	}
	
	public WebElement MiddleName()
	{
		
 		WebElement MiddleName= Driver.findElement(By.xpath("//input[@id='middlename']"));
        return MiddleName;
	}
	
	public WebElement Lastname()
	{
		
 		WebElement Lastname= Driver.findElement(By.xpath("//input[@id='lastname']"));
        return Lastname;
	}
	
	public Select Suffix(){
		return GetDropDown("suffixType");
	}
	public Select Prefix(){
		return GetDropDown("prefixType");
	}
	
	public WebElement MaleCheckBox()
	{
		
 		WebElement MiddleName= Driver.findElement(By.xpath("//*[contains(text(),'Male')]"));
        return MiddleName;
	}
	
	public WebElement FemaleCheckBox()
	{
		
 		WebElement MiddleName= Driver.findElement(By.xpath("//*[contains(text(),'Female')]"));
        return MiddleName;
	}
	
	public WebElement SSN()
	{
		
 		WebElement SSN= Driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[2]/div[2]/div/div[3]/form/div[1]/div[2]/div/div[3]/div[3]/div/input"));
        return SSN;
	}
	
	public WebElement Age()
	{
		
 		WebElement Age= Driver.findElement(By.xpath("//input[@id='idAge']"));
        return Age;
	}
	
	public WebElement Year()
	{
		
 		WebElement Year= Driver.findElement(By.xpath("//input[@id='year']"));
        return Year;
	}
	
	public WebElement UploadPicture()
	{
		
 		WebElement Year= Driver.findElement(By.linkText("Upload Picture"));
        return Year;
	}
	public WebElement ImageFile()
	{
		
		return Driver.findElement(By.xpath("//img[@class='header-avatar']"));
	}
	
	public WebElement browseButton(){
		return Driver.findElement(By.xpath("//button[@id='browseBtn']"));
	}
	
	public WebElement Month()
	{
		
 		WebElement Month= Driver.findElement(By.xpath("//input[@id='months']"));
        return Month;
	}
	
	public WebElement Day()
	{
		
 		WebElement days= Driver.findElement(By.xpath("//input[@id='days']"));
        return days;
	}
	
     public List<WebElement> GetLeftMenuList(){
		
		
		List<WebElement> allElements = Driver.findElements(By.xpath("html/body/div[1]/div/div[3]/div/div[1]/ul/li[2]/ul/li")); 
		return allElements;
	}
     
     public WebElement GetAdditionalNamegRow(int RowIndex){
    		
    	 WebElement allTableBody=Driver.findElement(By.xpath("//table[@id='additionalNames']/tbody"));
       return allTableBody.findElement(By.xpath(".//tr["+String.valueOf(RowIndex)+"]"));
    	
    }
	

}
