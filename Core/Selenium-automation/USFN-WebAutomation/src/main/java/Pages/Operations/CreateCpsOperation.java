package Pages.Operations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Browser;
import PageControllers.UsfnPageManager;
import Pages.Elements.CreateCpsElement;



public class CreateCpsOperation  extends BaseOperations<CreateCpsElement> {
	
	public CreateCpsOperation(CreateCpsElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectIntakeMethod(String MethodName){
		//Element.SelectIntakeMethod().
		Element.SelectIntakeMethod().selectByVisibleText(MethodName);
	}
	
	public void SelectCountyOfResponsibility(String MethodName){
		Element.CountyOfResponsibility().selectByVisibleText(MethodName);
	}
	
	public void SelectPersonCategory(String PersonCategory){
		Element.PersonCategory().selectByVisibleText(PersonCategory);
	}

	public void SelectPersonRole(String PersonRole){
		Element.PersonRole().selectByVisibleText(PersonRole);
	}
	
	public void SelectFeedbackRequested(String PersonRole){
		Element.FeedbackRequested().selectByVisibleText(PersonRole);
	}
	
	public void SelectReportingPersonCheckBox(int index){
		
		List<WebElement> CheckBoxes = Element.GetAllCheckBox();
		CheckBoxes.get(3+index).findElement(By.xpath("./..")).findElement(By.xpath("span")).click();
	}
	
	public void EnterIntakeDate(String date){
      List<WebElement> tr_collection=Element.GetAllDate("//input[@id='receivedDate']","html/body/div[1]/div/div[4]/div/div[2]/div[2]/div/div/form/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/span/ul/li[1]/div/table/tbody");
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
	
	public void EnterTime(String time){
		Element.GetIntakeTime().sendKeys(time);
	}
	
	public void SelectAMPM(String AMPM){
		Element.GetDropDownByXpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/form/div/div[3]/div[2]/div/div[1]/div[3]/div/div[2]/select").selectByVisibleText(AMPM);
	}
	
	public void SelectTimeZone(String timeZone){
		
		Element.GetDropDownByXpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/form/div/div[3]/div[2]/div/div[1]/div[3]/div/div[3]/select").selectByVisibleText(timeZone);
		
	}
	
	public void ClickLinkPersonButton(){
		Element.GetButton("//*[contains(text(),'Link Person')]").click();
		
	}
	
	public void ClickApply(){
		
		Element.GetButton("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/form/div[2]/div[2]/div[3]/div/div/button[1]").click();
		
	}
	
   public void ClickSave(){
	   
		Element.SaveButton().click();
		
	}
   
   public void ClickCancel(){
		
		Element.GetButton("html/body/div[1]/div[3]/div/div[2]/div[2]/div/div/form/div[2]/div[2]/div[3]/div/div/button[3]").click();
		
	}
   
   public void EnterAlligationNotes(String alligation){
	   Element.GetAlligationNotes().click();
	   Element.GetAlligationNotes().sendKeys(alligation);
   }
   
	public void EnterAlltheRequiredFields(String IntakeMethod, String Time,
			String AmPm, String TimeZone, String County, String AlligationNotes) {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
	//	String todayDate = dateFormat.format(date);
		UsfnPageManager.CreateCpsPage().Operations()
				.SelectIntakeMethod(IntakeMethod);
		// UsfnPageManager.CreateCpsPage().Operations().EnterIntakeDate(IntakeDate);
		Element.GetIntakeDate().sendKeys(
				new SimpleDateFormat("MM/dd/yyyy").format(date));
		UsfnPageManager.CreateCpsPage().Operations().EnterTime(Time);
		UsfnPageManager.CreateCpsPage().Operations()
				.SelectCountyOfResponsibility(County);
		UsfnPageManager.CreateCpsPage().Operations()
				.EnterAlligationNotes(AlligationNotes);

	}
   
   
  // GetParticipantMenu
   public void ClickLeftHandMenu(String menuName){
		  
	   try {
		Thread.sleep(1000);
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
   
   public boolean VerifyAllDropDownDisable(){
		boolean disable = false;
		
		List<WebElement> dropDowns = Element.GetAllDropDowns();
		
		for(WebElement dropdow : dropDowns){
			if(dropdow.isEnabled()){
				disable = true;
			}
			
			else {
				disable = false;
				break;
			}
			
		}
		
		return disable;
	}
   
   public boolean VerifyAllCheckboxDisable(){
		boolean disable = false;
		
		List<WebElement> CheckBoxes = Element.GetAllCheckBox();
		int size = CheckBoxes.size();
		int i=0;
		for(WebElement CheckBox : CheckBoxes){
			
			if(i>3){
			if(CheckBox.isEnabled()){
				disable = true;
			}
			
			else {
				disable = false;
				break;
			  }
			}
			i++;
			}
			
		
		return disable;
	}
   
   public String GetIntakeId(){
	   List<WebElement> parentDivs =  Browser.driver.findElements(By.xpath("//div[@class='col-lg-6 col-md-12 col-sm-12 col-xs-12 profile-stats']//div[@class='row']"));
	   String[] parts = parentDivs.get(2).getText().split(":");
	   String part1 = parts[0]; // 004
	   String part2 = parts[1].trim(); // 034556
		return part2;
   }
   
   public String GetIntakeName(){
	   return  Browser.driver.findElement(By.xpath("//div[@class='header-img-subtitle ng-binding']")).getText();
	  
   }
   
   public String GetReportingPerson(){
	   return  Browser.driver.findElement(By.xpath("//div[@id='reporter']//a")).getText();
   }
   
   
   public boolean VerifyReportingWhenAnonymous(){
	   
	   boolean dropdownStatus = false;
	   boolean disableCheckBoxStatus = false; 
	   boolean enableCheckBoxStatus = false; 
	   boolean finalStatus =  false;
	   // Verify dropdown 
	  if(!Browser.driver.findElement(By.xpath("//select[@id='personRole']")).isEnabled() && !Browser.driver.findElement(By.xpath("//select[@id='personCategory']")).isEnabled()&&Browser.driver.findElement(By.xpath("//select[@id='feedbackRequested']")).isEnabled()) {
		  dropdownStatus = true;
		  
	  }
  
	  List<WebElement> CheckBoxes = Element.GetAllCheckBox();
	 int t = CheckBoxes.size();
	  int i=0;
	  for(WebElement CheckBox : CheckBoxes){
		  
		  if(i==4){
			String test=  CheckBox.getText();
			  if(CheckBox.isEnabled()){
				  enableCheckBoxStatus = true;
			  } 
		  }
		  
		  if(i>4){
			  if(!CheckBox.isEnabled()){
				  disableCheckBoxStatus = true;
			  }
			  
		  }
		  
		  i++;
	  }
	   
	  
	  if(dropdownStatus&&disableCheckBoxStatus&&enableCheckBoxStatus){
		  
		  finalStatus =true;
		  
	  }
	  
	  return finalStatus;
   }
   
   

}
