package TestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import General.Browser;
import General.GetConfigValue;
import General.Utilities;
import PageControllers.UsfnPageManager;

public class UserStory20Test {
	
	WebDriver driver;
	 @BeforeMethod
	 public void openbrowser() { 
		 Dimension d = new Dimension(1382, 1300);
			WebDriver driver = Browser.getBrowser(GetConfigValue.GetBrowser());
			driver.manage().window().setSize(d);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }

	 //@AfterMethod defines this method has to run after every @Test methods
	 @AfterMethod
	 public void closebrowser() {
		 driver = null;
		 Browser.driver.close();
		
	 }
	 
	 private String CreateCps(){
		 
		   String getIntakeId ="";
		   try {
				UsfnPageManager.LoginPage().Operations().Login();
				UsfnPageManager.IntakeListPage().Operations().NavigateToCpsPage();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
				Thread.sleep(4000);
				
				UsfnPageManager
						.CreateCpsPage()
						.Operations()
						.EnterAlltheRequiredFields("E-mail", "11:15", "PM", "CT",
								"Alger", "AlligationNotes");
				UsfnPageManager.CreateCpsPage().Elements().ApplyButton().click();
				UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);

				Thread.sleep(2000);
		       getIntakeId =  UsfnPageManager.CreateCpsPage().Operations().GetIntakeId();
		   }
		   
		   catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  return getIntakeId;
		 
	 }
	 
	 private String AddParticipant(String fname,String lname,String[] roles,boolean CrteateCps){
		 
		  String getIntakeId ="";
		 
		 if(CrteateCps){
			 
			 getIntakeId =CreateCps();
			// Navigate to Add Participant page
				UsfnPageManager.CreateCpsPage().Operations()
						.ClickLeftHandMenu("Participants");
				UsfnPageManager.CpsAddParticipanPage().Operations()
						.ApplyWait(driver);
			
			 
		 }
		 
		 
		  try {
			 
				Thread.sleep(5000);
				 if(!CrteateCps){
					 UsfnPageManager.CpsListParticipantPage().Elements().AddParticipantButton().click();
					 UsfnPageManager.CpsAddParticipanPage().Operations().ApplyWait(driver);
				 }
		 
		  UsfnPageManager.CpsAddParticipanPage().Operations().EnterFirstName(fname);
		  UsfnPageManager.CpsAddParticipanPage().Operations().EnterLastName(lname);
		  UsfnPageManager.CpsAddParticipanPage().Operations().SelectRoles(roles);
		  UsfnPageManager.CpsAddParticipanPage().Elements().SaveButton().click();
		  UsfnPageManager.CpsListParticipantPage().Operations().ApplyWait(driver);
		  }
		  
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return getIntakeId;
		
	 }
	 
	@Test
	public void VerifyPiriorityWhenRecommendationNo() {
		try {

			String firstName1 = Utilities.GetRandomFirstName() + "AP1";
			String lastName1 = Utilities.GetRandomLasttName();
			String perpetrator = lastName1 + ", " + firstName1;
			String[] Roles = new String[] { "Alleged Perpetrator (AP)" };
			AddParticipant(firstName1, lastName1, Roles, true);

			String firstName2 = Utilities.GetRandomFirstName() + "AV1";
			String lastName2 = Utilities.GetRandomLasttName();
			String victim = lastName2 + ", " + firstName2;
			Roles = new String[] { "Alleged Victim (AV)" };
			AddParticipant(firstName2, lastName2, Roles, false);
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Maltreatments");
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectVictim(victim);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectPerpetator(perpetrator);

			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectAllegationType("Abandonment");
			Dimension d = new Dimension(1382, 744);

			Browser.driver.manage().window().setSize(d);
			Thread.sleep(8000);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ClickAlligation();
			UsfnPageManager.CpsMaltreatmentPage().Elements()
					.InformationDialoogOKButton().click();
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(5000);
			d = new Dimension(1382, 1300);
			Browser.driver.manage().window().setSize(d);
			Thread.sleep(8000);
			Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage()
					.Operations().IsVictimAvailable(victim),
					"Victim is not added to alligation");
			Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage()
					.Operations().IsPerpetatorAvailable(perpetrator),
					"Perpetrator is not added to alligation");
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Response Priority");
			UsfnPageManager.ResponsePriorityPage().Operations()
					.ApplyWait(driver);
			UsfnPageManager.ResponsePriorityPage().Operations()
					.ClickPiriorityTool("NEGLECT");
			Thread.sleep(4000);
			UsfnPageManager.PriorityQuestionPage().Operations()
					.SelectAnswers("Yes");
			UsfnPageManager.PriorityQuestionPage().Elements().ApplyButton()
					.click();
			Thread.sleep(2000);
			String piriority = UsfnPageManager.PriorityQuestionPage()
					.Elements().GetPiriority().getText();
			UsfnPageManager.PriorityQuestionPage().Elements().SaveButton()
					.click();
			Thread.sleep(4000);
			Assert.assertEquals(piriority, UsfnPageManager
					.ResponsePriorityPage().Elements()
					.GetRecommentdedResponse().getText());
			Assert.assertTrue(UsfnPageManager.ResponsePriorityPage()
					.Operations().VerifyPiriority("NEGLECT", piriority),
					"Piriority is not ");

			UsfnPageManager.ResponsePriorityPage().Elements().NoRadioButon()
					.click();
			UsfnPageManager.ResponsePriorityPage().Elements().ApplyButton()
					.click();
			UsfnPageManager.ResponsePriorityPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertEquals("Please select recommended priority",
					UsfnPageManager.ResponsePriorityPage().Elements()
							.ProvideRecommendedPriorityRequireWarningMessage()
							.getText());
			UsfnPageManager.ResponsePriorityPage().Operations()
					.SelectProvideRecommendedPriority("24/24");
			UsfnPageManager.ResponsePriorityPage().Elements().Comment()
					.sendKeys("Comment Text");
			UsfnPageManager.ResponsePriorityPage().Elements().ApplyButton()
					.click();
			UsfnPageManager.ResponsePriorityPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertEquals("24/24", UsfnPageManager.ResponsePriorityPage()
					.Operations().GetPiriority());
			Assert.assertEquals("24/24", UsfnPageManager.ResponsePriorityPage()
					.Elements().ProvideRecommendedPriority()
					.getFirstSelectedOption().getText());

		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void VerifyPiriorityTool() {

		try {

			String firstName1 = Utilities.GetRandomFirstName() + "AP1";
			String lastName1 = Utilities.GetRandomLasttName();
			String perpetrator = lastName1 + ", " + firstName1;
			String[] Roles = new String[] { "Alleged Perpetrator (AP)" };
			String IntakeId = AddParticipant(firstName1, lastName1, Roles, true);

			String firstName2 = Utilities.GetRandomFirstName() + "AV1";
			String lastName2 = Utilities.GetRandomLasttName();
			String victim = lastName2 + ", " + firstName2;
			Roles = new String[] { "Alleged Victim (AV)" };
			AddParticipant(firstName2, lastName2, Roles, false);
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Maltreatments");
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectVictim(victim);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectPerpetator(perpetrator);

			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectAllegationType("Abandonment");
			Dimension d = new Dimension(1382, 744);

			Browser.driver.manage().window().setSize(d);
			Thread.sleep(8000);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ClickAlligation();
			UsfnPageManager.CpsMaltreatmentPage().Elements()
					.InformationDialoogOKButton().click();
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(5000);
			d = new Dimension(1382, 1300);
			Browser.driver.manage().window().setSize(d);
			Thread.sleep(8000);
			Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage()
					.Operations().IsVictimAvailable(victim),
					"Victim is not added to alligation");
			Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage()
					.Operations().IsPerpetatorAvailable(perpetrator),
					"Perpetrator is not added to alligation");
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Response Priority");
			UsfnPageManager.ResponsePriorityPage().Operations()
					.ApplyWait(driver);
			UsfnPageManager.ResponsePriorityPage().Operations()
					.ClickPiriorityTool("NEGLECT");
			Thread.sleep(4000);
			UsfnPageManager.PriorityQuestionPage().Operations()
					.SelectAnswers("Yes");
			UsfnPageManager.PriorityQuestionPage().Elements().ApplyButton()
					.click();
			Thread.sleep(2000);
			String piriority = UsfnPageManager.PriorityQuestionPage()
					.Elements().GetPiriority().getText();
			UsfnPageManager.PriorityQuestionPage().Elements().SaveButton()
					.click();
			Thread.sleep(4000);
			Assert.assertEquals(piriority, UsfnPageManager
					.ResponsePriorityPage().Elements()
					.GetRecommentdedResponse().getText());
			Assert.assertTrue(UsfnPageManager.ResponsePriorityPage()
					.Operations().VerifyPiriority("NEGLECT", piriority),
					"Piriority is not ");

			UsfnPageManager.ResponsePriorityPage().Elements().YesRadioButon()
					.click();
			UsfnPageManager.ResponsePriorityPage().Elements().ApplyButton()
					.click();
			UsfnPageManager.ResponsePriorityPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);

			Assert.assertEquals("I/24", UsfnPageManager.ResponsePriorityPage()
					.Operations().GetPiriority());

		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
/*	  TODO : Currently "Next" button is not recognized by automation need to check 
	  @Test
	 public void EditPiriorityTool(){
		 String firstName1 = "AP1";
		  String lastName1 = "AP1";
		  String perpetrator = "AP1, "+"AP1";
		  String[] Roles = new String[]{"Alleged Perpetrator (AP)"};
		  String IntakeId= AddParticipant(firstName1,lastName1,Roles,true);
		  String firstName2 = "AV1";
		  String lastName2 = "AV1";
		  String victim = "AV1, "+"AV1";
		  Roles = new String[]{"Alleged Victim (AV)"};
		  AddParticipant(firstName2,lastName2,Roles,false);
		
		 UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Maltreatments");
		 
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectVictim(victim);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectPerpetator(perpetrator);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectAllegationType("Abandonment");
		 UsfnPageManager.CpsMaltreatmentPage().Operations().ClickAlligation();
		
		
		  try {
				 
			  Thread.sleep(5000);
		
		  Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().IsVictimAvailable(victim), "Victim is not added to alligation");
		  Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().IsPerpetatorAvailable(perpetrator), "Perpetrator is not added to alligation");
		  UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Response Priority");
		 
		  
		  UsfnPageManager.ResponsePriorityPage().Operations().ClickPiriorityTool("NEGLECT");
		  Thread.sleep(500);
		
		  UsfnPageManager.PriorityQuestionPage().Operations().SelectAnswers("No",false);
		  
		  UsfnPageManager.PriorityQuestionPage().Elements().ApplyButton().click();
		  Thread.sleep(500);
		  String piriority=  UsfnPageManager.PriorityQuestionPage().Elements().GetPiriority().getText();
		  
		  UsfnPageManager.PriorityQuestionPage().Elements().SaveButton().click();
		  
		  Thread.sleep(500);
		  Assert.assertEquals(piriority, UsfnPageManager.ResponsePriorityPage().Elements().GetRecommentdedResponse().getText());
		  Assert.assertTrue(UsfnPageManager.ResponsePriorityPage().Operations().VerifyPiriority("NEGLECT", piriority),"Piriority is not ");
		  
		  UsfnPageManager.ResponsePriorityPage().Operations().EditPiriorityTool("NEGLECT");
		  Thread.sleep(500);
		  UsfnPageManager.PriorityQuestionPage().Operations().SelectAnswers("Yes",true);
		  UsfnPageManager.PriorityQuestionPage().Elements().ApplyButton().click();
		   Thread.sleep(500);
		   piriority=  UsfnPageManager.PriorityQuestionPage().Elements().GetPiriority().getText();
		  
		  UsfnPageManager.PriorityQuestionPage().Elements().SaveButton().click();
		  
		  Thread.sleep(500);
		  Assert.assertEquals(piriority, UsfnPageManager.ResponsePriorityPage().Elements().GetRecommentdedResponse().getText());
		  Assert.assertTrue(UsfnPageManager.ResponsePriorityPage().Operations().VerifyPiriority("NEGLECT", piriority),"Piriority is not ");
		
		 
		 
		  
		  }
		  
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	 }*/
	  
	  @Test
	  public void VerifyPiriorityIsNotDisplayedForBirthMatchThreatenedHarm(){
		  try {
		  String firstName1 = Utilities.GetRandomFirstName() + "AP1";
			String lastName1 = Utilities.GetRandomLasttName();
			String perpetrator = lastName1 + ", " + firstName1;
			String[] Roles = new String[] { "Alleged Perpetrator (AP)" };
			String IntakeId = AddParticipant(firstName1, lastName1, Roles, true);

			String firstName2 = Utilities.GetRandomFirstName() + "AV1";
			String lastName2 = Utilities.GetRandomLasttName();
			String victim = lastName2 + ", " + firstName2;
			Roles = new String[] { "Alleged Victim (AV)" };
			AddParticipant(firstName2, lastName2, Roles, false);
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Maltreatments");
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectVictim(victim);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.SelectPerpetator(perpetrator);

			UsfnPageManager.CpsMaltreatmentPage().Operations();
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectAllegationType("Birth Match");
			Dimension d = new Dimension(1382, 744);

			Browser.driver.manage().window().setSize(d);
			Thread.sleep(8000);
	
		 UsfnPageManager.CpsMaltreatmentPage().Operations()
			.ClickAlligation();
	UsfnPageManager.CpsMaltreatmentPage().Elements()
			.InformationDialoogOKButton().click();
	UsfnPageManager.CpsMaltreatmentPage().Operations()
			.ApplyWait(driver);
	Thread.sleep(5000);
	d = new Dimension(1382, 1300);
	Browser.driver.manage().window().setSize(d);
	Thread.sleep(8000);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectVictim(victim);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectPerpetator(perpetrator);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectAllegationType("Threatened Harm");
	
		  d = new Dimension(1382, 744);

			Browser.driver.manage().window().setSize(d);
			Thread.sleep(8000);
	
		 UsfnPageManager.CpsMaltreatmentPage().Operations()
			.ClickAlligation();
	UsfnPageManager.CpsMaltreatmentPage().Elements()
			.InformationDialoogOKButton().click();
	UsfnPageManager.CpsMaltreatmentPage().Operations()
			.ApplyWait(driver);
	Thread.sleep(5000);
	d = new Dimension(1382, 1300);
	Browser.driver.manage().window().setSize(d);
	Thread.sleep(8000);
		
		  UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Response Priority");
			UsfnPageManager.CpsMaltreatmentPage().Operations()
			.ApplyWait(driver);
			Thread.sleep(2000);
		  Assert.assertTrue(UsfnPageManager.ResponsePriorityPage().Operations().IsPiriorityToolAvailable(),"Piriority tool is displaying");
		  }
		  
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
	  }



}
