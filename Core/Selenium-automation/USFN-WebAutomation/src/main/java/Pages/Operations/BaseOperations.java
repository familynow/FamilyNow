package Pages.Operations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import General.Browser;

public abstract class BaseOperations<TElement> {
	public TElement Element;
	public BaseOperations(TElement element)
	
    {
		this.Element = element;
    }

	 public void ApplyWait(WebDriver driver){
		
		  
		  try {
		        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
		            public Boolean apply(final WebDriver webDriver) {
		                WebElement element = webDriver.findElement(By.xpath("//div[@class='page-loader-overlay ng-scope ng-animate ng-hide-animate ng-hide-add']"));
		                return !element.isDisplayed();
		            }
		        };
		        Wait w = new WebDriverWait(driver, 2000);
		        w.until(condition);
		    } catch (Exception ex) {
		        // if it gets here it is because the element is still displayed after timeoutInSeconds
		        // insert code most suitable for you
		    }

	  }
	 
	 public void WaitForPageLoad(WebDriver driver){
			
		  
		  try {
		        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
		            public Boolean apply(final WebDriver webDriver) {
		                WebElement element = webDriver.findElement(By.xpath("//div[@class='page-loader-overlay ng-scope']"));
		                return !element.isDisplayed();
		            }
		        };
		        Wait w = new WebDriverWait(driver, 2000);
		        w.until(condition);
		    } catch (Exception ex) {
		        // if it gets here it is because the element is still displayed after timeoutInSeconds
		        // insert code most suitable for you
		    }

	  }
	 
	 
	 
	 public WebElement PaginationNextArrow(){
		  WebElement arrow ;
		   WebElement getParentDiv =  Browser.driver.findElement(By.xpath("//ul[@class='pagination ng-scope']"));
		 
		   try{
	       arrow = getParentDiv.findElement(By.linkText("›"));
		   }
		   
		   catch (NoSuchElementException e) {
			   getParentDiv =  Browser.driver.findElement(By.xpath("//div[@class='action-wrap outer ng-scope']//ul[@class='pagination ng-scope']"));
			   arrow = getParentDiv.findElement(By.linkText("›"));
			}
	       WebElement parent = arrow.findElement(By.xpath("./.."));
	       @SuppressWarnings("unused")
		String test = parent.getAttribute("class");
	       return parent.getAttribute("class").contains("ng-scope disabled") ? null : arrow; // If the parent is 'disabled' then don't return it
	     
		  
	  }
	  
	  public void NavigateToFirstPage(){
		  WebElement arrow ;
		  try {
		      WebElement getParentDiv =  Browser.driver.findElement(By.xpath("//ul[@class='pagination ng-scope']"));
		      try{
	          arrow = getParentDiv.findElement(By.linkText("«"));
		      }
		      catch (NoSuchElementException e) {
				   getParentDiv =  Browser.driver.findElement(By.xpath("//div[@class='action-wrap outer ng-scope']//ul[@class='pagination ng-scope']"));
				   arrow = getParentDiv.findElement(By.linkText("«"));
				}
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
	  
	  
  public List<String> GetApprovalWarningMessages(){
	  WebElement parentDiv = Browser.driver.findElement(By.xpath("//div[@role='alert']"));
	  List<WebElement> div_collection = parentDiv.findElements(By.xpath(".//div[@class='ng-binding ng-scope']"));
	  List<String> approvalWarningMessages = new ArrayList<String>();  
		for (WebElement div : div_collection) {
			approvalWarningMessages.add(div.getText());
			
		}
		
		return approvalWarningMessages;
  }
	
}
