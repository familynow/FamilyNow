package Pages.Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import Pages.Elements.CreateNonCpsElement;

public class CreateNonCpsOperation  extends BaseOperations<CreateNonCpsElement> {

	public CreateNonCpsOperation(CreateNonCpsElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	
	public void EnterIntakeDate(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("NonCps","html/body/div[1]/div[4]/div/div[2]/div[2]/div/div/form/div/div[3]/div[2]/div/div[2]/div/div/div[1]/span/ul/li[1]/div/table/tbody");
	      boolean datefound = false;
	      for(WebElement trElement : tr_collection)
	      {
	    	   List<WebElement> allDates=trElement.findElements(By.xpath("td")); 
			for(WebElement ele:allDates)
			{
				
				if(ele.getText().equals(date))
				{
					ele.findElement(By.xpath("button")).click();
					datefound = true;
					break;
				}
				
			}
			
			if(datefound){
				break;
			}
			
	      }
			
		}
	
	
	
	public void SelectIntakeType(String IntakeType){
		
		Element.SelectIntakeType().selectByVisibleText(IntakeType);
	}
	
	public void SelectIntakeMethod(String IntakeMethod){
		
		Element.SelectIntakeMethod().selectByVisibleText(IntakeMethod);
	}
	
   public void SelectOrganizationCategory(String OrganizationCategory){
		
		Element.OrganizationCategory().selectByVisibleText(OrganizationCategory);
	}
   
   public void SelectOrganization(String Organization){
		
		Element.Organization().selectByVisibleText(Organization);
	}
   
   public void SelectReportingPersonType(String Organization){
		
		Element.SelectReportingPerson().selectByVisibleText(Organization);
	}
   
   
	
	public void EnterRequiredField(String IntakeType,String IntakeMethod,String Date,String Time, String OrganizationCategory,String  Organization,String Narrative){
		
		
		SelectIntakeType(IntakeType);
		SelectIntakeMethod(IntakeMethod);
		Element.IntakeDate().click();
		EnterIntakeDate(Date);
		Element.IntakeTime().click();
		Element.IntakeTime().sendKeys(Time);
		SelectOrganizationCategory(OrganizationCategory);
		SelectOrganization(Organization);
		Element.IntakeNarrative().sendKeys(Narrative);
		
	}
	
	 public String GetIntakeId(){
		  List<WebElement> parentDivs =  Browser.driver.findElements(By.xpath("//div[@class='col-lg-6 col-md-12 col-sm-12 col-xs-12 profile-stats padding-lr-5']//div[@class='row']"));
		   String[] parts = parentDivs.get(2).getText().split(":");
		   String part1 = parts[0]; // 004
		   String part2 = parts[1].trim(); // 034556
			return part2;
	   }
	 
	// GetParticipantMenu
	   public void ClickLeftHandMenu(String menuName){
			  
		   try {
			Thread.sleep(5000);
			List<WebElement> allElements =  Element.GetLeftMenuList(); 

			for (WebElement element: allElements) {
				
				if(element.getText().contains(menuName)){
			     
				  element.findElement(By.linkText(menuName)).click();
				  break;
				}
			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  }
	 
	

}
