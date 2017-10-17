package pages.operations;

import general.Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.elements.ApplicationSummaryElement;



public class ApplicationSummaryOperation extends BaseOperation<ApplicationSummaryElement>{

	public ApplicationSummaryOperation(ApplicationSummaryElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public boolean IsColumnAvailable(String ColumnValue){
		boolean columnValue = false;
		
		
		
				try{
					String TableValues = Browser.driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[10]/ng-include/div/div[1]/div/div[2]/div/div/div/table/tbody/tr[2]")).getText();
				
					 if(TableValues.contains(ColumnValue)){ 
						
						 columnValue = true;
						 
					 }
				  
			  }
				
			catch (Exception e){
				
				 columnValue = false;
				
			  }
			
			
		
		return columnValue;
	}
	
	public String GetApplicationType(){

	return	Element.GetApplicationTypeDiv().findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(0).getText();
	}
	
	public String GetApplicationDate(){
		
		return	Element.GetApplicationTypeDiv().findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(1).getText();
		}
	
  public String GetAddressDetail(){
	    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")).get(2);
	    WebElement AddressDetailDiv = parent.findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(0);
		return	AddressDetailDiv.getText();
		}
  public String GetRentInfo(){
	    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")).get(2);
	    WebElement RentDiv = parent.findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(1);
		return	RentDiv.getText();
		}
  public String GetWeponInfo(){
	    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")).get(2);
	    WebElement WeponDiv = parent.findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(2);
	    return	WeponDiv.getText();
		}
  public String GetWaterInfo(){
	    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")).get(2);
	    WebElement WaterDiv = parent.findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(3);
	    return	WaterDiv.getText();
		}
  public String GetAppliedForAdoptionInfo(){
	    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")).get(3);
	    WebElement AppliedForAdoptionDiv = parent.findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(0);
	    return	AppliedForAdoptionDiv.getText();
		}
public String GetLicensedForFosterCareInfo(){
	    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")).get(3);
	    WebElement LicensedForFosterCareDiv = parent.findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(1);
	    return	LicensedForFosterCareDiv.getText();
		}
public String GetChildIdentifiedInfo(){
    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 border-btm-gray']")).get(3);
    WebElement ChildIdentifiedDiv = parent.findElements(By.xpath(".//div[@class='col-lg-6 form-field']")).get(2);
    return	ChildIdentifiedDiv.getText();
	}
public String GetAgeInfo(){
    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 mb-20']")).get(0);
    WebElement AgeDiv = parent.findElements(By.xpath(".//div[@class='col-lg-4 form-field']")).get(0);
    return	AgeDiv.getText();
	}
public String GetGenderInfo(){
    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 mb-20']")).get(0);
    WebElement GenderDiv = parent.findElements(By.xpath(".//div[@class='col-lg-4 form-field']")).get(1);
    return	GenderDiv.getText();
	}
public String GetEthinicityInfo(){
    WebElement parent= Element.GetApplicationTypeDiv().findElements(By.xpath("//div[@class='col-lg-12 mb-20']")).get(0);
    WebElement EthinicityDiv = parent.findElements(By.xpath(".//div[@class='col-lg-4 form-field']")).get(2);
    return	EthinicityDiv.getText();
	}

//
	

}
