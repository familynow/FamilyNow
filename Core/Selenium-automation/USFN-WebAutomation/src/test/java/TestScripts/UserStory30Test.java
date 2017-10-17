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

public class UserStory30Test {
	
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
	 
	 @Test
	 public void AddContactInfo(){
		 
		  String Fname = GetRandomString(10);
		  String Lname = GetRandomString(10);
		  String ssn = GetRandomInt();
		  String contact = GetRandomInt();
		  String description = GetRandomString(101);
		 AddPersonBasicInformation(Fname,Lname,ssn);
		 UsfnPageManager.PersonBasicPage().Operations().ClickLeftHandMenu("Address");
		 UsfnPageManager.PersonAddressListPage().Elements().AddContact().click();
		 UsfnPageManager.PersonContactDetailPage().Operations().SelectContactType("Relative");
		 UsfnPageManager.PersonContactDetailPage().Elements().SaveButton().click();
		 Assert.assertTrue( UsfnPageManager.PersonContactDetailPage().Elements().CotactRequiredFieldMessage().isDisplayed(), "Contact is not a required field");
		 UsfnPageManager.PersonContactDetailPage().Elements().Contact().sendKeys(contact);
		 UsfnPageManager.PersonContactDetailPage().Elements().Description().sendKeys(description);
		 UsfnPageManager.PersonContactDetailPage().Elements().SaveButton().click();
         Assert.assertTrue( UsfnPageManager.PersonContactDetailPage().Elements().DescriptionMaxLengthMessage().isDisplayed(), "Descritption field is allowing more than 100 character");
		 
		 description = GetRandomString(100);
		 UsfnPageManager.PersonContactDetailPage().Elements().Description().sendKeys(description);
		 UsfnPageManager.PersonContactDetailPage().Elements().SaveButton().click();
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,contact), "Contact information is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact ,"Relative"), "Type is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact ,"No"), "Primary contact type is");
		 
	 }
	 
	 @Test
	 public void VerifyPrimaryContactInfo(){
		 
		 String Fname = GetRandomString(10);
		 String Lname = GetRandomString(10);
		 String ssn = GetRandomInt();
		 String contact = GetRandomInt();
		 String description = GetRandomString(100);
		 AddPersonBasicInformation(Fname,Lname,ssn);
		 UsfnPageManager.PersonBasicPage().Operations().ClickLeftHandMenu("Address");
		  try{
			  Thread.sleep(300);
		
		 UsfnPageManager.PersonAddressListPage().Elements().AddContact().click();
		 UsfnPageManager.PersonContactDetailPage().Elements().Primary().click();
		 UsfnPageManager.PersonContactDetailPage().Operations().SelectContactType("Relative");
		 UsfnPageManager.PersonContactDetailPage().Elements().Contact().sendKeys(contact);
		 UsfnPageManager.PersonContactDetailPage().Elements().Description().sendKeys(description);
		 UsfnPageManager.PersonContactDetailPage().Elements().SaveButton().click();
		 Thread.sleep(300);
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,contact), "Contact information is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,"Relative"), "Type is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,"Yes"), "Primary contact type is");
		 UsfnPageManager.PersonAddressListPage().Elements().AddContact().click();
		 String contact2 = GetRandomInt();
		 description = GetRandomString(10);
		 Thread.sleep(300);
		 UsfnPageManager.PersonContactDetailPage().Operations().SelectContactType("Neighbor");
		 UsfnPageManager.PersonContactDetailPage().Elements().Contact().sendKeys(contact2);
		 UsfnPageManager.PersonContactDetailPage().Elements().Description().sendKeys(description);
		 UsfnPageManager.PersonContactDetailPage().Elements().Primary().click();
		 UsfnPageManager.PersonContactDetailPage().Elements().SaveButton().click();
		 Thread.sleep(300);
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact2,contact2), "Contact information is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact2,"Neighbor"), "Type is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact2,"Yes"), "Primary contact type is");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,contact), "Contact information is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,"Relative"), "Type is not saved");
		 Assert.assertTrue( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,"No"), "Primary contact type is");
		  }
		 catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		 
		 
		 
	 }
	 @Test
	 public void VerifyDeleteContactInfo(){
		 String Fname = GetRandomString(10);
		 String Lname = GetRandomString(10);
		 String ssn = GetRandomInt();
		 String contact = GetRandomInt();
		 String description = GetRandomString(100);
		 AddPersonBasicInformation(Fname,Lname,ssn);
		 UsfnPageManager.PersonBasicPage().Operations().ClickLeftHandMenu("Address");
		  try{
			  Thread.sleep(300);
		
		 UsfnPageManager.PersonAddressListPage().Elements().AddContact().click();
		 Thread.sleep(300);
		 UsfnPageManager.PersonContactDetailPage().Elements().Primary().click();
		 UsfnPageManager.PersonContactDetailPage().Operations().SelectContactType("Relative");
		 UsfnPageManager.PersonContactDetailPage().Elements().Contact().sendKeys(contact);
		 UsfnPageManager.PersonContactDetailPage().Elements().Description().sendKeys(description);
		 UsfnPageManager.PersonContactDetailPage().Elements().SaveButton().click();
		 Thread.sleep(300);
		 UsfnPageManager.PersonAddressListPage().Operations().DeleteContact(contact);
		 Assert.assertFalse( UsfnPageManager.PersonAddressListPage().Operations().IsColumnValueAvailable(contact,contact), "Contact information is not deleted");
		 
	   }
		  
		  catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	 }

}
