package pages.operations;

import general.Browser;
import general.Utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageControllers.ProviderPageManager;
import pages.elements.SupportingDocumentElement;
import pages.operations.BaseOperation;

public class SupportingDocumentOperation extends BaseOperation<SupportingDocumentElement> {
	public SupportingDocumentOperation(SupportingDocumentElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	  private  void setClipboardData(String string) {
			//StringSelection is a class that can be used for copy and paste operations.
			   StringSelection stringSelection = new StringSelection(string);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
	  
	    private  void uploadFile(String fileLocation) {
	        try {
	        	//Setting clipboard with file location
	            setClipboardData(fileLocation);
	         
	            Robot robot = new Robot();
	            Thread.sleep(1000);
	            
	            // Press Enter
	           robot.keyPress(KeyEvent.VK_ENTER);
	           
	          // Release Enter
	           robot.keyRelease(KeyEvent.VK_ENTER);
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            Thread.sleep(1000);
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	        } catch (Exception exp) {
	        	exp.printStackTrace();
	        }
	    }
	
	 public void DocumentDate(String date){
	      List<WebElement> tr_collection=Element.GetAllDate("html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[8]/ng-include/div/div[1]/div[2]/div[2]/div[4]/div[2]/div/span/i","html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[8]/ng-include/div/div[1]/div[2]/div[2]/div[4]/div[2]/div/span/div/ul/li[1]/div/div/div/table/tbody");
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
	 
	 public void EnterRequiredField(String ApplicantName,String DocumentType,String DocumentName,String DocumentDate){
		 Element.ApplicantName().selectByVisibleText(ApplicantName);
		 Element.DocumentType().selectByVisibleText(DocumentType);
		 Element.DocumentName().sendKeys(DocumentName);
		 DocumentDate(DocumentDate);
		 
	 }
	 
	 public void UploadDocumentWithRequiredFieldAndNavigate(String Fname,String Lname) throws InterruptedException, IOException{
		 DateFormat dateFormat = new SimpleDateFormat("dd");
	     Date date = new Date();
	     String todayDate = dateFormat.format(date);
		 for(int i=0;i<=1;i++){
			 String filePath = "../FamilyNow_Provider_Portal_Automation/SupportingDocument/PngTestDocument.png";
			 File file = new File(filePath);
			 String FullPath= file.getCanonicalPath();
			 Element.UploadFile().click();
			 uploadFile(FullPath);
			 Thread.sleep(2000);
			 String DocumentName =Utilities.GetRandomString(10);
		     EnterRequiredField(Fname+" "+Lname, "Document Type 1", DocumentName,todayDate);
			 Thread.sleep(1000);
			
			 if(i==1){
				 Element.SupportingDocumentSaveContinue().click();
				 ApplyWait(Browser.driver);
				 Thread.sleep(3000);
				 Element.SuccessDialogOkButton().click();
			 }
			 else{
			 Element.SupportingDocumentSaveAdd().click();
			 ApplyWait(Browser.driver);;
			 Thread.sleep(3000);
			 Element.SuccessDialogOkButton().click();
			 }
			

			 Thread.sleep(2000);
			 }
	 }
	 
	 public boolean IsDocumentAvailable(String DocumentName){
			boolean columnValue = false;
			List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='documentHistory']/tbody");{
				for(WebElement trElement : tr_collection){
					if(trElement.getAttribute("class").contains("ng-hide"))
		    			continue;
					try{
					 WebElement cell=trElement.findElement(By.xpath("td"+"[3]"));
					
						 if(cell.getText().contains(DocumentName)){ 
							 columnValue = true;
							 break;
						 }
					  
				  }
					
				catch (Exception e){
					
					 columnValue = false;
					 break;
				  }
				}
				
			}
			return columnValue;
		}
	 
	 public void DeleteDocument(String DocumentName){
		 boolean actionPerformed = false;
		 List<WebElement> tr_collection = Element.GetTableBodyRows("//table[@id='documentHistory']/tbody");
		 for(WebElement trElement : tr_collection){
			 if(trElement.getAttribute("class").contains("ng-hide"))
	 			continue;
			 WebElement cell=trElement.findElement(By.xpath("td"+"[3]"));
			
				 if(cell.getText().contains(DocumentName)){
					 WebElement getParentRow =  cell.findElement(By.xpath("./.."));
					  getParentRow.findElement(By.xpath("td[6]//span[@class='fa fa-trash-o clickable ng-scope']")).click();;
					 actionPerformed=true;
					 break;
				 
			 }
			 
	       if(actionPerformed){
				 
				 break;
			 }
			 
		 }
		
		
					 
	}

}
