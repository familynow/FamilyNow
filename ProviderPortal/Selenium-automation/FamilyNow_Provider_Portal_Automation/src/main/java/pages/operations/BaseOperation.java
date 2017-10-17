package pages.operations;

import java.awt.Robot;
import java.util.List;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import general.Browser;

public abstract class BaseOperation<TElement> {
	public TElement Element;
	public BaseOperation(TElement element) {
		Element = element;
    }
	
	 public boolean VerifyRequiredFieldWarningMessage(String WarningMessage){
			
			List<WebElement> allRequiredFieldDiv=	Browser.driver.findElements(By.xpath("//div[@class='has-error']"));
			int size = allRequiredFieldDiv.size();
			boolean warningMessageDisplayed=false;
			
			 for(WebElement div : allRequiredFieldDiv){
				 String test = div.getText();
				 if(div.getText().contains(WarningMessage))
					{
					 warningMessageDisplayed = true;
						break;
					}
			 }
			
			return warningMessageDisplayed;
		}
	 
	  public void ApplyWait(WebDriver driver){
		  
		  try {
		        ExpectedCondition condition = new ExpectedCondition<Boolean>() {
		            public Boolean apply(final WebDriver webDriver) {
		                WebElement element = webDriver.findElement(By.id("loaderOverlay"));
		                return !element.isDisplayed();
		            }
		        };
		        Wait w = new WebDriverWait(driver, 200);
		        w.until(condition);
		    } catch (Exception ex) {
		        // if it gets here it is because the element is still displayed after timeoutInSeconds
		    }

	  }
	  
	  
	  public void ClickNavigationWizard(String navigationWizard){
		  
		   try {
			Thread.sleep(1000);
			List<WebElement> allElements =  Browser.driver.findElements(By.xpath(".//*[@id='applicationNavigationWizard']//div[@class='centered-content ng-scope']/ul/li")); ; 

			for (WebElement element: allElements) {
				 String test = element.getText();
				
				if(element.getText().contains(navigationWizard)){
				  element.click();
				  break;
				}
			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  }
	  
	  public String GetModalDialogMessage(){
			return  Browser.driver.findElement(By.xpath("//div[@id='msgModal']//div[@class='msg-body ng-binding']")).getText();
			  
		  }
	  
	  public WebElement ConfirmationDialoogOKButton(){
		   return Browser.driver.findElement(By.xpath("//div[@id='confirm-popup']//div[@class='msg-footer']/button[text()='Yes']"));
	   }
	  
	
	 public void ClickSideMenuBar(String MenuName){
		 List<WebElement> allElements =  Browser.driver.findElements(By.xpath(".//*[@id='sidebar']//ul[@class='nav sidebar-menu']//li"));
		 for (WebElement element: allElements) {

				if(element.getText().contains(MenuName)){
				  element.click();
				  break;
		 }
	   }			
		 
	 }
	 
	  public WebElement PaginationNextArrow(){
		  WebElement arrow ;
		   WebElement getParentDiv =  Browser.driver.findElement(By.xpath("//div[@class='pagination-wrap ng-scope']"));
	       arrow = getParentDiv.findElement(By.linkText("›"));
	       WebElement parent = arrow.findElement(By.xpath("./.."));
	       @SuppressWarnings("unused")
		String test = parent.getAttribute("class");
	       return parent.getAttribute("class").contains("ng-scope disabled") ? null : arrow; // If the parent is 'disabled' then don't return it
	     
		  
	  }
	  
	  public void NavigateToFirstPage(){
		  WebElement arrow ;
		  try {
		      WebElement getParentDiv =  Browser.driver.findElement(By.xpath("//div[@class='pagination-wrap ng-scope']"));
	          arrow = getParentDiv.findElement(By.linkText("«"));
	          arrow.click();
		  }
		  catch (Exception e)
	      {
	          
	      }
	      
		  
	  }
	  public boolean PaginationClickNext()
	  {
		  boolean success = true;
	      try
	      {
	    	  PaginationNextArrow().click();
	         
	      }
	      catch (Exception e)
	      {
	          success = false; // We couldn't click the -> arrow
	      }
	    
	     
	      return success;
	  }
	  

}
