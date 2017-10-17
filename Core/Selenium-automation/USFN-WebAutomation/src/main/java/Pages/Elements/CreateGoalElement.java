package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import General.Browser;

public class CreateGoalElement extends BaseElements {

	public CreateGoalElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement Goal(){
		return Driver.findElement(By.id("goal"));
	}
	
	public WebElement HarmFactorsButton(){
		return Driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div[1]/form/div[2]/div/div/div[2]/button[1]"));
	}
	
	public WebElement EditHarmFactorsButton(){
		return Driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div/div[2]/div[1]/form/div[2]/div/div/div[2]/button[2]"));
	}
	
	
	
	public WebElement PopUpSave(){
	  return Browser.driver.findElement(By.xpath("//div[@id='harmFactorsPopup']//button[@id='saveHarmFactors']"));
	}
	
	public WebElement PopUpCancel(){
		  return Browser.driver.findElement(By.xpath("//div[@id='harmFactorsPopup']//button[@id='cancelHarmFactors']"));
		}
	public WebElement Apply(){
		 return Browser.driver.findElements(By.xpath("//button[@id='save']")).get(0);
		
	}
	public WebElement Save(){
		 return Browser.driver.findElements(By.xpath("//button[@id='save']")).get(1);
		
	}
	public WebElement Cancel(){
		 return Browser.driver.findElement(By.xpath("//button[@id='cancel']"));
		
	}
	
	public WebElement AddGoalButton(){

		  return Browser.driver.findElement(By.xpath("//button[@id='addActionSteps']"));
	}
	
	public WebElement AddTaskButton(){

		  return Browser.driver.findElement(By.xpath("//button[@id='addSafetyTask']"));
	}
	


}
