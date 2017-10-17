package Pages.Operations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import General.Browser;
import PageControllers.MRPPageManager;

public abstract class BaseOperations<TElement> {
	public TElement Element;
	public BaseOperations(TElement element) {
		Element = element;
    }

  public boolean VerifyRequiredFieldWarningMessage(String WarningMessage){
		
		List<WebElement> allRequiredFieldDiv=	Browser.driver.findElements(By.xpath("//div[@class='has-error']"));
		boolean warningMessageDisplayed=false;
		 for(WebElement div : allRequiredFieldDiv){
			 if(div.getText().contains(WarningMessage))
				{
				 warningMessageDisplayed = true;
					break;
				}
			 
		 }
		
		return warningMessageDisplayed;
	}
  
  public String GetModalDialogMessage(){
	return  Browser.driver.findElement(By.xpath("//div[@id='msgModal']//div[@class='msg-body ng-binding']")).getText();
	  
  }
  
  public String GetComplaintId(){
	
		return    Browser.driver.findElements(By.xpath("//div[@class='col-lg-7 col-md-6 hero-value ng-binding']")).get(0).getText();
		
	}
  
  public WebElement PaginationNextArrow(){
	  WebElement arrow ;
	   WebElement getParentDiv =  Browser.driver.findElement(By.xpath("//div[@class='pagination-wrap']"));
       arrow = getParentDiv.findElement(By.linkText("›"));
       WebElement parent = arrow.findElement(By.xpath("./.."));
       @SuppressWarnings("unused")
	String test = parent.getAttribute("class");
       return parent.getAttribute("class").contains("ng-scope disabled") ? null : arrow; // If the parent is 'disabled' then don't return it
     
	  
  }
  
  public void NavigateToFirstPage(){
	  WebElement arrow ;
	  try {
	      WebElement getParentDiv =  Browser.driver.findElement(By.xpath("//div[@class='pagination-wrap']"));
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
	        // insert code most suitable for you
	    }



  

  }
}
