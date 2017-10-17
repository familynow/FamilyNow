package Pages.Elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriorityQuestionElement extends BaseElements {

	public PriorityQuestionElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public WebElement SaveButton(){
			
			return GetButton("//*[contains(text(),'Save')]");
		}
	 
	
		
		public WebElement ApplyButton(){
			
			return GetButton("//*[contains(text(),'Apply')]");
		}
		
		public WebElement GetPiriority(){
			
		return	Driver.findElement(By.xpath("//h3[@class='panel-title']/strong"));
			
		}
		
       public WebElement NextButton(){
    	
    	  return Driver.findElement(By.xpath("//button[2]"));
			
		}
       
       public WebElement PreviousButton(){
			
			return GetButton("//button[1]");
		}
       
       public WebElement YesRadioButton(){
    	   
    	   WebElement radioButton = null;
			
    	List<WebElement> allRadioButton=  Driver.findElements(By.xpath("//div[@class='radio form-field']//span[text()='Yes']"));
    	
    	int counter=0;
    	 for(WebElement RadioButton : allRadioButton)
         {
    		 String test12= RadioButton.getText();
    		if(RadioButton.getText().contains("Yes")){
    			radioButton = allRadioButton.get(counter);
    			break;
    			 
    		 }
    		
    		else {
    			counter++;
    		}
    		 
         }
    
    	return radioButton;
		}
       
       public WebElement NoRadioButton(){
    	   
    	   WebElement radioButton = null;
			
       	List<WebElement> allRadioButton=  Driver.findElements(By.xpath("//div[@class='radio form-field']//span[text()='No']"));
       	int counter=0;
       	 for(WebElement RadioButton : allRadioButton)
            {
       		
       		if(RadioButton.getText().contains("No")){
       			
       			radioButton = allRadioButton.get(counter);
       			
       			break;
       			 
       		 }
       		
       		else {
       			counter++;
       		}
       		 
            }
       
       	return radioButton;
		}
		
		//Next

}
