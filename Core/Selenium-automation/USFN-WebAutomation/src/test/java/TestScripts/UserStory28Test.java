package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class UserStory28Test {
	WebDriver driver;
	 @BeforeMethod
	 public void openbrowser() { 
		  WebDriver driver = Browser.getBrowser(GetConfigValue.GetBrowser());
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }

	 //@AfterMethod defines this method has to run after every @Test methods
	 @AfterMethod
	 public void closebrowser() {
		 driver = null;
		 Browser.driver.close();
		
	 }
	 
	 private String GetRandomString(int lenght){
		 char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 for (int i = 0; i < lenght; i++) {
		     char c = chars[random.nextInt(chars.length)];
		     sb.append(c);
		 }
		 
		 return sb.toString();
	 }
	 
	 private String GetRandomInt(){
		 char[] chars = "0123456789".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 for (int i = 0; i < 9; i++) {
		     char c = chars[random.nextInt(chars.length)];
		     sb.append(c);
		 }
		 
		 return sb.toString();
	 }
	 
	 private String AddPersonBasicInformation(String fName,String lName,String ssn){
		 
		   DateFormat dateFormat = new SimpleDateFormat("dd");
		   Date date = new Date();
		   String todayDate = dateFormat.format(date);
		   String personId ="";
		   try{
		   UsfnPageManager.LoginPage().Operations().Login("sw", "sw");
		   UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
		   UsfnPageManager.CreateCpsPage().Elements().LinkPersonButton().click();
		   UsfnPageManager.PersonSearchPage().Elements().GetPersonId().sendKeys("12");
		   UsfnPageManager.PersonSearchPage().Elements().GetSearchButton().click();
		   UsfnPageManager.PersonSearchPage().Elements().AddPersonhButton().click();
		   UsfnPageManager.PersonBasicPage().Operations().EnterDOB(todayDate);
		   UsfnPageManager.PersonBasicPage().Elements().MaleCheckBox().click();
		   UsfnPageManager.PersonBasicPage().Operations().SelectPrefix("Dr.");
		   UsfnPageManager.PersonBasicPage().Elements().FirstName().sendKeys(fName);
		   UsfnPageManager.PersonBasicPage().Elements().Lastname().sendKeys(lName);
		   UsfnPageManager.PersonBasicPage().Elements().SSN().sendKeys(ssn);
		   UsfnPageManager.PersonBasicPage().Operations().SelectSuffix("II");
		   UsfnPageManager.PersonBasicPage().Elements().ApplyButton().click();
		 
			  Thread.sleep(500);
			   personId = 	 UsfnPageManager.PersonBasicPage().Operations().GetPersonId(); 
		   }
		   catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   
		   return personId;
	 }
	 
	/* @Test
	 public void AddAdditionalName(){
		 
		  String Fname = GetRandomString(10);
		  String Lname = GetRandomString(10);
		  String ssn = GetRandomInt();
		  String contact = GetRandomInt();
		  String description = GetRandomString(101);
		  AddPersonBasicInformation(Fname,Lname,ssn);
		  UsfnPageManager.PersonBasicPage().Elements().AdditionalNameButton().click();
		  String additionalFname = GetRandomString(10);
		  String additionalLname = GetRandomString(10);
		  String additionaMLname = GetRandomString(10);
		 try{
			  Thread.sleep(500);
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectNameType("Alias");
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectPrefix("Dr.");
			  UsfnPageManager.AddAdditionalNamePage().Elements().FirstName().sendKeys(additionalFname);
			  UsfnPageManager.AddAdditionalNamePage().Elements().LastName().sendKeys(additionalLname);
			  UsfnPageManager.AddAdditionalNamePage().Elements().MiddleName().sendKeys(additionaMLname);
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectSufix("III");
			  UsfnPageManager.AddAdditionalNamePage().Elements().SaveButton().click();
			  Thread.sleep(500);
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,additionalFname), "First name is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,additionalLname), "Last name is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,additionaMLname), "Last name is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"Alias"), "Name Type is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"Dr."), "Prefix is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"III"), "Sufix is not correct");
			   
		   }
		   catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	 }*/
	 
	 @Test
	 public void EditAdditionalName(){
		 
		  String Fname = GetRandomString(10);
		  String Lname = GetRandomString(10);
		  String ssn = GetRandomInt();
		  String contact = GetRandomInt();
		  String description = GetRandomString(101);
		  AddPersonBasicInformation(Fname,Lname,ssn);
		  UsfnPageManager.PersonBasicPage().Elements().AdditionalNameButton().click();
		  String additionalFname = GetRandomString(10);
		  String additionalLname = GetRandomString(10);
		  String additionaMLname = GetRandomString(10);
		 try{
			  Thread.sleep(500);
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectNameType("Alias");
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectPrefix("Dr.");
			  UsfnPageManager.AddAdditionalNamePage().Elements().FirstName().sendKeys(additionalFname);
			  UsfnPageManager.AddAdditionalNamePage().Elements().LastName().sendKeys(additionalLname);
			  UsfnPageManager.AddAdditionalNamePage().Elements().MiddleName().sendKeys(additionaMLname);
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectSufix("III");
			  UsfnPageManager.AddAdditionalNamePage().Elements().SaveButton().click();
			  Thread.sleep(500);
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,additionalFname), "First name is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,additionalLname), "Last name is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,additionaMLname), "Last name is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"Alias"), "Name Type is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"Dr."), "Prefix is not correct");
			  Assert.assertTrue(  UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"III"), "Sufix is not correct");
			  UsfnPageManager.PersonBasicPage().Operations().ClickAdditional(1);
			  Thread.sleep(500);
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectNameType("Maiden");
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectPrefix("Miss");
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectSufix("II");
			  UsfnPageManager.AddAdditionalNamePage().Elements().SaveButton().click();
			  Thread.sleep(500);
			  Assert.assertTrue(UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"Maiden"), "Name Type is not edited");
			  Assert.assertTrue(UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"Miss"), "Prefix is not edited");
			  Assert.assertTrue(UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,"II"), "Sufix is not edited");
			   
		   }
		   catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	 }
	 
	 @Test
	 public void DeleteAdditionalName(){
		 
		  String Fname = GetRandomString(10);
		  String Lname = GetRandomString(10);
		  String ssn = GetRandomInt();
		  String contact = GetRandomInt();
		  String description = GetRandomString(101);
		  AddPersonBasicInformation(Fname,Lname,ssn);
		  UsfnPageManager.PersonBasicPage().Elements().AdditionalNameButton().click();
		  String additionalFname = GetRandomString(10);
		  String additionalLname = GetRandomString(10);
		  String additionaMLname = GetRandomString(10);
		 try{
			  Thread.sleep(500);
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectNameType("Alias");
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectPrefix("Dr.");
			  UsfnPageManager.AddAdditionalNamePage().Elements().FirstName().sendKeys(additionalFname);
			  UsfnPageManager.AddAdditionalNamePage().Elements().LastName().sendKeys(additionalLname);
			  UsfnPageManager.AddAdditionalNamePage().Elements().MiddleName().sendKeys(additionaMLname);
			  UsfnPageManager.AddAdditionalNamePage().Operations().SelectSufix("III");
			  UsfnPageManager.AddAdditionalNamePage().Elements().SaveButton().click();
			  Thread.sleep(500);
			  UsfnPageManager.PersonBasicPage().Operations().DeleteAdditionalName(Fname);
			  Assert.assertFalse( UsfnPageManager.PersonBasicPage().Operations().IsColumnValueAvailable(additionalFname,additionalFname), "Additional name information is not deleted");
		 }
		 
		 catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	 }
	 
	 /* @Test
	 public void PrimaryAdditionalName(){
		 // TO DO 
		 // Currently there is a bug so due to that not able to automate
	 }*/
	 
	 
}
