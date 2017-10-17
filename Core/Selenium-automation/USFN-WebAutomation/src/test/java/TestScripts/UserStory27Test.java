package TestScripts;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class UserStory27Test {
	
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
	 
	 private String GetRandomString(){
		 char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 for (int i = 0; i < 10; i++) {
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
	 
	 private String AddPersonBasicInformation(String fName,String lName,String ssn){
		 
		   DateFormat dateFormat = new SimpleDateFormat("dd");
		   Date date = new Date();
		   String todayDate = dateFormat.format(date);
		   String personId ="";
		   try{
		   UsfnPageManager.LoginPage().Operations().Login("familynow@unisys.com", "Welcome1");
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
	public void VerifyAddPersonBasicInformation() {
		String Fname = GetRandomString();
		String Lname = GetRandomString();
		try {
			UsfnPageManager.LoginPage().Operations().Login();
			UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
			Thread.sleep(4000);
			UsfnPageManager.CreateCpsPage().Elements().LinkPersonButton()
					.click();
			Thread.sleep(4000);
			// UsfnPageManager.PersonSearchPage().Elements().GetPersonId().sendKeys("12");
			// UsfnPageManager.PersonSearchPage().Elements().GetSearchButton().click();
			UsfnPageManager.PersonSearchPage().Elements().AddPersonhButton()
					.click();
			Thread.sleep(5000);
			/*
			 * UsfnPageManager.PersonBasicPage().Elements().UploadPicture().click
			 * (); String filePath =
			 * "../USFN-WebAutomation/profilePicture/ProfilePicture.jpg"; File
			 * file = new File(filePath); String FullPath =
			 * file.getCanonicalPath();
			 * 
			 * UsfnPageManager.PersonBasicPage().Elements().browseButton().click(
			 * ); uploadFile(FullPath); Boolean ImagePresent = (Boolean)
			 * ((JavascriptExecutor)Browser.driver).executeScript(
			 * "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0"
			 * , UsfnPageManager.PersonSearchPage().Elements().ImageFile());
			 * String test =
			 * UsfnPageManager.PersonBasicPage().Elements().ImageFile
			 * ().getAttribute("src"); Boolean Test2 =
			 * test.contains("Women.png");
			 * 
			 * 
			 * 
			 * if (!ImagePresent) { System.out.println("Image not displayed.");
			 * } else { System.out.println("Image displayed."); }
			 */
		/*	UsfnPageManager.PersonBasicPage().Operations().EnterDOB(todayDate);
			Assert.assertFalse(UsfnPageManager.PersonBasicPage().Elements()
					.Year().isEnabled(), "Year Field is enabled");
			Assert.assertFalse(UsfnPageManager.PersonBasicPage().Elements()
					.Month().isEnabled(), "Year Field is enabled");
			Assert.assertFalse(UsfnPageManager.PersonBasicPage().Elements()
					.Day().isEnabled(), "Day Fied is enabled");
			UsfnPageManager.PersonBasicPage().Elements().MaleCheckBox().click();
			UsfnPageManager.PersonBasicPage().Operations().SelectPrefix("Dr.");*/
			UsfnPageManager.PersonBasicPage().Elements().FirstName()
					.sendKeys(Fname);
			UsfnPageManager.PersonBasicPage().Elements().Lastname()
					.sendKeys(Lname);
		//	UsfnPageManager.PersonBasicPage().Operations().SelectSuffix("II");
			UsfnPageManager.PersonBasicPage().Elements().ApplyButton().click();

			Thread.sleep(500);
			// String personId =
			// UsfnPageManager.PersonBasicPage().Operations().GetPersonId();

			// UsfnPageManager.PersonBasicPage().Elements().CancelButton().click();
			// Thread.sleep(100);
			// UsfnPageManager.PersonSearchPage().Elements().SSN().sendKeys(ssn);
			// UsfnPageManager.PersonSearchPage().Elements().GetSearchButton().click();
			Thread.sleep(200);

			// Assert.assertTrue(
			// UsfnPageManager.PersonSearchPage().Operations().VerifyPersonIsAvailable(personId),
			// "Person is not Created");
		}

		   catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   
		   
	 }
	 
	/* @Test
	 public void EditPersonsBasicInformation(){
		 // TO DO 
		 // Currently in Person Search result grid name is not a hyper link 
		 //due to that not able to navigate to edit person basic info page
	 }*/
	 
	/* @Test
	 public void AddDemographicInfo(){
		 
		  String Fname = GetRandomString();
		  String Lname = GetRandomString();
		  String ssn = GetRandomInt();
		 String PersonId = AddPersonBasicInformation(Fname,Lname,ssn);
		  try{
			 
		 UsfnPageManager.PersonBasicPage().Operations().ClickLeftHandMenu("Demographic");
		 Thread.sleep(500);
		 String[] language = new String[]{"African"};
		 UsfnPageManager.PersonDemographicPage().Operations().SelectLanguage(language);
		 
	  // Assert.assertEquals(UsfnPageManager.PersonDemographicPage().Elements().PrimaryLanguage().getFirstSelectedOption().getText(),"African");
	   
	   language = new String[]{"Arabic"};
	   UsfnPageManager.PersonDemographicPage().Operations().SelectLanguage(language);
	   List<String> actualLanguageList = new ArrayList<String>();
	   actualLanguageList.add("African");
	   actualLanguageList.add("Arabic");
	   
	   List<WebElement> languageOption = UsfnPageManager.PersonDemographicPage().Elements().PrimaryLanguage().getOptions();
       List<String> expectedLanguageList = new ArrayList<String>(); 
       for (WebElement we : languageOption) {
    	   
    	 
    	   if(we.getText().trim().length()>0)
    		 
    	   expectedLanguageList.add(we.getText()); 
       } 
	
	 
       Assert.assertTrue(actualLanguageList.containsAll(expectedLanguageList),"Langaue is not displaying under Primary Language drop down");
       
       UsfnPageManager.PersonDemographicPage().Operations().SelectPrimaryLanguage("Arabic");
       UsfnPageManager.PersonDemographicPage().Operations().SelectHairColor("Blonde");
       UsfnPageManager.PersonDemographicPage().Operations().SelectDeathVerificationSource("Death Certificate");
       UsfnPageManager.PersonDemographicPage().Operations().SelectReligion("Catholic");
	   UsfnPageManager.PersonDemographicPage().Elements().ApplyButton().click();
	   Thread.sleep(500);
	   UsfnPageManager.PersonBasicPage().Operations().ClickLeftHandMenu("Basic");
	   UsfnPageManager.PersonBasicPage().Operations().ClickLeftHandMenu("Demographic");
	   Thread.sleep(500);

	   Assert.assertEquals(UsfnPageManager.PersonDemographicPage().Elements().PrimaryLanguage().getFirstSelectedOption().getText(),"Arabic");
	   Assert.assertEquals(UsfnPageManager.PersonDemographicPage().Elements().HairColor().getFirstSelectedOption().getText(),"Blonde");
	   Assert.assertEquals(UsfnPageManager.PersonDemographicPage().Elements().DeathVerificationSource().getFirstSelectedOption().getText(),"Death Certificate");
	   Assert.assertEquals(UsfnPageManager.PersonDemographicPage().Elements().Religion().getFirstSelectedOption().getText(),"Catholic");
	
	   
		  }
	   catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	   
		 
		 
	 }*/
	 
	 /* @Test
	 public void EditPersonsDemographicInformation(){
		 // TO DO 
		 // Currently in Person Search result grid name is not a hyper link 
		 //due to that not able to navigate to edit person basic info page
	 }*/

}
