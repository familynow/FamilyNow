package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import PageControllers.UsfnPageManager;

public class UserStory23Test {
	WebDriver driver;

	@BeforeMethod
	public void openbrowser() {
		WebDriver driver = Browser.getBrowser(GetConfigValue.GetBrowser());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// @AfterMethod defines this method has to run after every @Test methods
	@AfterMethod
	public void closebrowser() {
		driver = null;
		Browser.driver.close();

	}

	private String AddParticipant(String fname, String lname, String[] roles) {

		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		String getIntakeId = "";

		// Login to USFN
		UsfnPageManager.LoginPage().Operations().Login("sw1234", "sw");
		try {
			UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
			UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
			Thread.sleep(900);

			UsfnPageManager.NonCpsIntakeListPage().Elements().AddNonCpsButton()
					.click();

			UsfnPageManager.CreateNonCpsPage().Operations().ApplyWait(driver);

			// Add Cps Intake
			UsfnPageManager
					.CreateNonCpsPage()
					.Operations()
					.EnterRequiredField("Adoption Dissolution", "E-mail",
							todayDate, "11:15", "Central Intake",
							"Central Intake", "Narrative");
			UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
			Thread.sleep(800);
			getIntakeId = UsfnPageManager.CreateNonCpsPage().Operations()
					.GetIntakeId();
			UsfnPageManager.CreateNonCpsPage().Operations()
					.ClickLeftHandMenu("Participants");
			Thread.sleep(800);
			UsfnPageManager.NonCpsAddParticipantPage().Operations()
					.EnterFirstName(fname);
			UsfnPageManager.NonCpsAddParticipantPage().Operations()
					.EnterLastName(lname);
			UsfnPageManager.NonCpsAddParticipantPage().Operations()
					.SelectRoles(roles);
			UsfnPageManager.NonCpsAddParticipantPage().Elements().SaveButton()
					.click();
			UsfnPageManager.NonCpsListParticipantPage().Operations().ApplyWait(driver);
			Thread.sleep(900);
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getIntakeId;

	}

	
	  @Test 
	  public void VerifyCreateNonCPS(){ 
	  
	  DateFormat dateFormat = new
	  SimpleDateFormat("dd"); Date date = new Date(); String todayDate =
	  dateFormat.format(date); String getIntakeId ="";
	  
	  // Login to USFN
	  UsfnPageManager.LoginPage().Operations().Login("sw1234","sw"); 
	  try {
	  UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
	  UsfnPageManager.IntakeListPage().Operations().ApplyWait(driver);
	  UsfnPageManager.NonCpsIntakeListPage().Elements().AddNonCpsButton().click();
	  UsfnPageManager.CreateNonCpsPage().Operations().ApplyWait(driver);
	  Assert.assertFalse(UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().isEnabled(),"Apply Button is enabled");
	  Assert.assertFalse(UsfnPageManager.CreateNonCpsPage().Elements().SaveButton().isEnabled(),"Save Button is enabled"); 
	  // Add Cps Intake
	  UsfnPageManager .CreateNonCpsPage().Operations().EnterRequiredField("Adoption Dissolution", "E-mail", todayDate,"11:15", "Central Intake", "Central Intake","Narrative");
	  UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
	  Thread.sleep(200);
	  Assert.assertFalse(UsfnPageManager.CreateNonCpsPage().Elements().intakeComplete().isEnabled(), "Intake Complete Checkbox is enabled");
	  getIntakeId =UsfnPageManager.CreateNonCpsPage().Operations().GetIntakeId();
	  UsfnPageManager.CreateNonCpsPage().Elements().SaveButton().click();
	  UsfnPageManager.CreateNonCpsPage().Operations().ApplyWait(driver);
	  Thread.sleep(1000);
	  Assert.assertTrue(UsfnPageManager.NonCpsIntakeListPage().Operations().VerifyInatkeIsAvailable(getIntakeId),"Intake is not created");
	  
	  }
	 
	  catch (InterruptedException e) { 
		  // TODO Auto-generated catch block
	  e.printStackTrace(); 
	  }
	  
	  }
	 

	@Test
	public void LinkPerson() {

		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		String getIntakeId = "";

		// Login to USFN
		UsfnPageManager.LoginPage().Operations().Login("sw1234", "sw");
		try {
			UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
			UsfnPageManager.NonCpsIntakeListPage().Operations().ApplyWait(driver);
			UsfnPageManager.NonCpsIntakeListPage().Elements().AddNonCpsButton().click();
			UsfnPageManager.CreateNonCpsPage().Operations().ApplyWait(driver);
			Assert.assertFalse(UsfnPageManager.CreateNonCpsPage().Elements().OtherTextBox().isEnabled(), "Other TextBox is enabled");
			UsfnPageManager.CreateNonCpsPage().Elements().LinkPersonButton().click();
			UsfnPageManager.PersonSearchPage().Operations().ApplyWait(driver);
			UsfnPageManager.PersonSearchPage().Operations().EnterPersonId("1");
			UsfnPageManager.PersonSearchPage().Elements().GetSearchButton().click();
			String LinkedName = UsfnPageManager.PersonSearchPage().Operations().GetName(1);
			UsfnPageManager.PersonSearchPage().Operations().SelectRecord(1);
			Thread.sleep(200);
			Assert.assertTrue(UsfnPageManager.CreateNonCpsPage().Elements().UnLinkPersonButton().isEnabled(),"UnLink Person Button is not present");
			UsfnPageManager.CreateNonCpsPage().Operations().SelectReportingPersonType("Other");
			Assert.assertTrue(UsfnPageManager.CreateNonCpsPage().Elements().OtherTextBox().isEnabled(), "Other TextBox is enabled");
			UsfnPageManager.CreateNonCpsPage().Elements().OtherTextBox().sendKeys("Test Other");
			UsfnPageManager.CreateNonCpsPage().Operations().EnterRequiredField("Adoption Dissolution", "E-mail",todayDate, "11:15", "Central Intake","Central Intake", "Narrative");
			UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
			Thread.sleep(200);
			Assert.assertFalse(UsfnPageManager.CreateNonCpsPage().Elements().intakeComplete().isEnabled(),"Intake Complete Checkbox is enabled");

			getIntakeId = UsfnPageManager.CreateNonCpsPage().Operations().GetIntakeId();
			UsfnPageManager.CreateNonCpsPage().Elements().SaveButton().click();
			UsfnPageManager.NonCpsIntakeListPage().Operations().ApplyWait(driver);
			Assert.assertTrue(UsfnPageManager.NonCpsIntakeListPage().Operations().VerifyInatkeIsAvailable(getIntakeId),"Intake is not created");
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	  @Test 
	  public void VerifyAddParticipant() {
	 
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);

		String firstName = "ParticipantFName";
		String lastName = "ParticipantLname";
		String name = "ParticipantLname, " + "ParticipantFName";
		String[] Roles = new String[] { "MDHHS Children's Services Employee",
				"Employee of a Licensed/Registered Child Care Organization" };
		String IntakeId = AddParticipant(firstName, lastName, Roles);
	 
	  try { 
			Thread.sleep(1000);
			// Verify Participant name
			Assert.assertTrue(UsfnPageManager.NonCpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, name),
					"Name is not correct");
			Assert.assertTrue(UsfnPageManager.NonCpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, "*"),
					"Intake Name is not set");

			// Verify Participant Roles are selected
			Assert.assertTrue(
					UsfnPageManager
							.NonCpsListParticipantPage()
							.Operations()
							.IsColumnValueAvailable(name,
									"MDHHS Children's Services Employee"),
					"Roles are not selected");
			Assert.assertTrue(
					UsfnPageManager
							.NonCpsListParticipantPage()
							.Operations()
							.IsColumnValueAvailable(name,
									"Employee of a Licensed/Registered Child Care Organization"),
					"Roles are not selected");

			UsfnPageManager.CreateNonCpsPage().Operations()
					.ClickLeftHandMenu("Basic Information");
			Thread.sleep(800);

			Assert.assertTrue(UsfnPageManager.CreateNonCpsPage().Elements()
					.intakeComplete().isEnabled(),
					"Intake Complete is not enabled");

			UsfnPageManager.CreateNonCpsPage().Elements()
					.IntakeCompleteCheckbox().click();

			Assert.assertTrue(UsfnPageManager.CreateNonCpsPage().Elements()
					.CompetedDate().getText().contains(todayDate),
					"Intke completed date is not displaying");

			UsfnPageManager.CreateNonCpsPage().Elements().CancelButton()
					.click();
			UsfnPageManager.NonCpsIntakeListPage().Operations().ApplyWait(driver);
			Thread.sleep(1000);
		
			Assert.assertTrue(UsfnPageManager.NonCpsIntakeListPage()
					.Operations().VerifyIntakeName(IntakeId, name),
					"Intake Name is not set");
	  
	  }
	  
	  catch (InterruptedException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  
	  
	  }
	  
	 @Test 
	 public void VerifyDeleteParticipant(){
	  
	  String firstName = "ParticipantFName"; 
	  String lastName ="ParticipantLname"; 
	  String name ="ParticipantLname, "+"ParticipantFName"; 
	  String[] Roles = new String[]{"MDHHS Children's Services Employee","Employee of a Licensed/Registered Child Care Organization"};
	  AddParticipant(firstName,lastName,Roles); try { Thread.sleep(1000);
	  
	  UsfnPageManager.NonCpsListParticipantPage().Operations().PerformAction(name ,"Delete",true);
	  Assert.assertTrue(UsfnPageManager.NonCpsListParticipantPage().Operations().IsColumnValueAvailable(name,name),"Participant is deleted"); 
	  Assert.assertTrue( UsfnPageManager.NonCpsListParticipantPage().Operations().IsColumnValueAvailable(name,"*"),"Intake Name is not set"); 
	  // Add second participant 
	  firstName = "SecParticipantFName"; 
	  lastName = "SecParticipantLname"; 
	  name = "SecParticipantLname, "+"SecParticipantFName"; 
	  Roles = new String[]{"MDHHS Children's Services Employee"};
	  UsfnPageManager.NonCpsListParticipantPage ().Elements().AddParticipantButton().click();
	  Thread.sleep(600);
	  UsfnPageManager.NonCpsAddParticipantPage ().Operations().EnterFirstName(firstName);
	  UsfnPageManager.NonCpsAddParticipantPage().Operations().EnterLastName(lastName);
	  UsfnPageManager.NonCpsAddParticipantPage().Operations().SelectRoles(Roles);
	  UsfnPageManager.NonCpsAddParticipantPage().Elements().SaveButton().click(); 
	  Thread.sleep(2000);
	  
	  // Make second participant as Intake Namme
	  UsfnPageManager.NonCpsListParticipantPage().Operations().PerformAction(name,"Make Intake Name",false);
	  
	  Thread.sleep(2000); 
	  Assert.assertTrue(UsfnPageManager.NonCpsListParticipantPage().Operations().IsColumnValueAvailable(name,"*"), "Second Participant is not set as Intake Name");
	  Assert.assertFalse(UsfnPageManager.NonCpsListParticipantPage().Operations().IsColumnValueAvailable("ParticipantLname, "+"ParticipantFName","*"), "First Participant is  still a Intake Name");
	  
	  Thread.sleep(1000);
	  // delete first participant
	  UsfnPageManager.NonCpsListParticipantPage ().Operations().PerformAction("ParticipantLname, " +"ParticipantFName","Delete",false);
	  
	  Thread.sleep(1000);
	  
	  Assert.assertFalse(UsfnPageManager.NonCpsListParticipantPage().Operations().IsColumnValueAvailable("ParticipantLname, "+"ParticipantFName","ParticipantLname, "+"ParticipantFName"),"First Participant is not deleted"); 
	  } 
	  catch (InterruptedException e) {
	  // TODO Auto-generated catch block 
		  e.printStackTrace(); 
		  }
	  
	  
	  }
	  
	  
   @Test 
   public void VerifyEditParticipant(){

	  String firstName = "ParticipantFName"; 
	  String lastName ="ParticipantLname";
	  String name = "ParticipantLname, "+"ParticipantFName"; 
	  String[] Roles = new String[]{"MDHHS Children's Services Employee","Employee of a Licensed/Registered Child Care Organization"};
	  AddParticipant(firstName,lastName,Roles); try { Thread.sleep(1000);
	  UsfnPageManager .NonCpsListParticipantPage().Operations().ClickParticipantId(name);
	  
	  Thread.sleep(500);
	  
	  firstName = "SecParticipantFName"; 
	  lastName = "SecParticipantLname"; 
	  name = "SecParticipantLname, "+"SecParticipantFName";
	  UsfnPageManager.CpsAddParticipanPage().Elements().SaveButton().click();
	  Thread.sleep(1000);
	  Assert.assertFalse(UsfnPageManager.NonCpsListParticipantPage().Operations().IsColumnValueAvailable(name,name), "Participant name is not updated");
	  
	  }
	  
	  catch (InterruptedException e) {
	
	      e.printStackTrace(); 
	  }
	 }
	  @Test 
	  public void VerifyLinkParticipant(){
	  
	  String firstName = "ParticipantFName"; 
	  String lastName ="ParticipantLname"; 
	  String name ="ParticipantLname, "+"ParticipantFName";
	  String LinkedName =null;
	  String[] Roles = new String[]{"MDHHS Children's Services Employee","Employee of a Licensed/Registered Child Care Organization"};
	  AddParticipant(firstName,lastName,Roles); 
		  try { 
			  Thread.sleep(1000);//
		      Assert.assertTrue(UsfnPageManager.NonCpsListParticipantPage().Operations().VerifyActionIconIsPresent(name,"Search and Link"),"Search And Link icon is not present");
		  
		      Thread.sleep(1000);
		      UsfnPageManager.NonCpsListParticipantPage().Operations ().PerformAction(name,"Search and Link",false);
		      UsfnPageManager.PersonSearchPage().Operations().EnterPersonId("1");
		      UsfnPageManager.PersonSearchPage().Elements().GetSearchButton().click();
		      LinkedName = UsfnPageManager.PersonSearchPage().Operations().GetName(1);
		      UsfnPageManager.PersonSearchPage().Operations().SelectRecord(1);
		     Thread.sleep(1000);
		    Assert.assertFalse(UsfnPageManager.NonCpsListParticipantPage().Operations().VerifyActionIconIsPresent(LinkedName,"Search And Link"), "Search And Link icon is  present"); 
		 }
		 catch (InterruptedException e) {
		  // TODO Auto-generated catch block 
		 e.printStackTrace(); 
		 }
	  
	  
	  
	  }
	  
	    @Test 
	    public void EditNonCPS(){
	 
	 
	   DateFormat dateFormat = new SimpleDateFormat("dd");
	   Date date = new Date(); 
	   String todayDate = dateFormat.format(date); 
	   String getIntakeId="";
	  
	  // Login to USFN 
	  UsfnPageManager.LoginPage().Operations().Login("sw1234", "sw");
	  try {
	  UsfnPageManager.NonCpsIntakeListPage().NavigateToNonCpsListPage();
	  
	  
	  
	  Thread.sleep(2000);
	  
	  UsfnPageManager.NonCpsIntakeListPage().Elements().AddNonCpsButton().click( );
	  
	  Thread.sleep(500);
	  
	  Assert.assertFalse(UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton ().isEnabled(),"Apply Button is enabled");
	  Assert.assertFalse(UsfnPageManager .CreateNonCpsPage().Elements().SaveButton().isEnabled(),"Save Button is enabled");
	  
	  // Add Cps Intake
	  UsfnPageManager.CreateNonCpsPage().Operations().EnterRequiredField ("Adoption Dissolution", "E-mail", todayDate,"11:15", "Central Intake","Central Intake", "Narrative");
	  UsfnPageManager.CreateNonCpsPage().Elements().ApplyButton().click();
	  
	  Thread.sleep(1000); 
	  getIntakeId = UsfnPageManager.CreateNonCpsPage().Operations().GetIntakeId();
	  UsfnPageManager.CreateNonCpsPage().Elements().SaveButton().click();
	  Thread.sleep(1500);
	
	  UsfnPageManager.NonCpsIntakeListPage().Operations().ClickPendingIntake(getIntakeId);
	  Thread.sleep(500);
	  UsfnPageManager.CreateNonCpsPage().Operations().SelectIntakeType("Adoption Subsidy Assistance");
	  UsfnPageManager.CreateNonCpsPage().Operations().SelectIntakeMethod("In Person");
	  UsfnPageManager.CreateNonCpsPage().Elements().SaveButton().click();
	  Thread.sleep(1500);
	 
	  UsfnPageManager.NonCpsIntakeListPage().Operations().ClickPendingIntake(getIntakeId); 
	  Thread.sleep(500);
	  Assert.assertEquals(UsfnPageManager.CreateNonCpsPage ().Elements().SelectIntakeType ().getFirstSelectedOption().getText(),"Adoption Subsidy Assistance");
	  Assert.assertEquals(UsfnPageManager.CreateNonCpsPage().Elements().SelectIntakeMethod().getFirstSelectedOption().getText(),"In Person"); 
	  }
	  
	  catch (InterruptedException e) { 
		  // TODO Auto-generated catch block
	  e.printStackTrace(); 
	  } 
	  }
	 

}
