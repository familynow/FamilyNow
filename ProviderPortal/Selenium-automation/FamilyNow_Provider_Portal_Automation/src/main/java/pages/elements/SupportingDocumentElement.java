package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.elements.BaseElement;

public class SupportingDocumentElement extends BaseElement{
	public SupportingDocumentElement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public Select ApplicantName (){
			Select applicantNameDropdown = new Select(Driver.findElement(By.id("applicantName")));
			return applicantNameDropdown;
		}
	 
	 public Select DocumentType (){
			Select documentTypeDropdown = new Select(Driver.findElement(By.id("documentType")));
			return documentTypeDropdown;
		}
	 
	 public WebElement DocumentName (){
		 return Driver.findElement(By.id("documentName"));
		}
	 
	 public WebElement UploadFile (){
		 return Driver.findElement(By.id("upload-btn"));
		}
	 
	 public WebElement SupportingDocumentSaveAdd(){
		 return Driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[8]/ng-include/div/div[2]/span[1]/button[3]"));
		 //
	 }
	 
	 public WebElement SupportingDocumentSaveContinue(){
		 return Driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div/div/div/div[2]/div/div/div[8]/ng-include/div/div[2]/span[1]/button[4]"));

	 }
	 
}
