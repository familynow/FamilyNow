package TestScripts;

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

public class UserStory18Test {
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
	public void CreateAlligation() {
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
			 UsfnPageManager.CpsMaltreatmentPage().Elements().InformationDialoogOKButton().click();
			 UsfnPageManager.CpsMaltreatmentPage().Operations().ApplyWait(driver);	 
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
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
	 
	 @Test 
	 public void VerifyDuplicateAllegationGroup(){
		 try{
		    String firstName1 = Utilities.GetRandomFirstName() + "AP1";
			String lastName1 = Utilities.GetRandomLasttName();
			String perpetrator = lastName1 + ", " + firstName1;
			String[] Roles = new String[] { "Alleged Perpetrator (AP)" };
			String IntakeId = AddParticipant(firstName1, lastName1, Roles, true);
		  
		  String firstName2 =  Utilities.GetRandomFirstName()+"AP2";
		  String lastName2 =  Utilities.GetRandomLasttName();
		  String perpetrator2 =  lastName2 + ", " + firstName2;
		  Roles = new String[]{"Alleged Perpetrator (AP)"};
		  AddParticipant(firstName2,lastName2,Roles,false);
		  
		  String firstName3 =Utilities.GetRandomFirstName()+ "AV1";
		  String lastName3 = Utilities.GetRandomLasttName();
		  String victim =  lastName3 + ", " + firstName3;
		  Roles = new String[]{"Alleged Victim (AV)"};
		  AddParticipant(firstName3,lastName3,Roles,false);
		
		 UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Maltreatments");
		 UsfnPageManager.CpsMaltreatmentPage().Operations().ApplyWait(driver);
	     Thread.sleep(4000);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().ApplyWait(driver);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectVictim(victim);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectPerpetator(perpetrator);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectAllegationType("Abandonment");
		 Dimension d = new Dimension(1382, 744);
		 Browser.driver.manage().window().setSize(d);
		 Thread.sleep(8000);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().ClickAlligation();
		 UsfnPageManager.CpsMaltreatmentPage().Elements().InformationDialoogOKButton().click();
		 UsfnPageManager.CpsMaltreatmentPage().Operations().ApplyWait(driver);	 
		  Thread.sleep(5000);
		
			 d = new Dimension(1382, 1300);
				
				Browser.driver.manage().window().setSize(d);
				Thread.sleep(8000);
		  Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().IsVictimAvailable(victim), "Victim is not added to allegation");
		  Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().IsPerpetatorAvailable(perpetrator), "Perpetrator is not added to allegation");
		  Thread.sleep(5000);
		  UsfnPageManager.CpsMaltreatmentPage().Operations().SelectVictim(victim);
		  Thread.sleep(1000);
		  UsfnPageManager.CpsMaltreatmentPage().Operations().SelectPerpetator(perpetrator);
		  Thread.sleep(1000);
		  UsfnPageManager.CpsMaltreatmentPage().Operations().SelectPerpetator(perpetrator2);
		  Thread.sleep(1000);
		  UsfnPageManager.CpsMaltreatmentPage().Operations().SelectAllegationType("Abandonment");
		   d = new Dimension(1382, 744);
			 Browser.driver.manage().window().setSize(d);
			 Thread.sleep(8000);
		  UsfnPageManager.CpsMaltreatmentPage().Elements().AddAlligationButton().click();
		  UsfnPageManager.CpsMaltreatmentPage().Operations().ApplyWait(driver);
		  Thread.sleep(2000);
		  d = new Dimension(1382, 1300);
			
			Browser.driver.manage().window().setSize(d);
			Thread.sleep(8000);
		  Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().GetWarningMessage().contains("Duplicate entry of Maltreatment for same pair of Perpetrator and Victim cannot be created"), "Warning message for duplicate entry is not displayed");
		  Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage().Operations().IsPerpetatorAvailable(perpetrator2), "Duplicate entry of Maltreatment is created");
		  }
		  
		  catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		 
		
		
	 }
	 
	@Test
	public void DeleteAllegation() {
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
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.DeleteAllegation(perpetrator);
			UsfnPageManager.CpsMaltreatmentPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(3000);
			Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage()
					.Operations().IsPerpetatorAvailable(perpetrator),
					"Perpetrator is not deleted");
			Assert.assertFalse(UsfnPageManager.CpsMaltreatmentPage()
					.Operations().IsVictimAvailable(victim),
					"Victim is not deleted");
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
	  /*	  @Test
	 public void EditAllegation(){
		 
		 String firstName1 = "AP1";
		 String lastName1 = "AP1";
		 String perpetrator = "AP1, "+"AP1";
		 String[] Roles = new String[]{"Alleged Perpetrator (AP)"};
		 String IntakeId= AddParticipant(firstName1,lastName1,Roles,true);
		 String firstName2 = "AP2";
		 String lastName2 = "AP2";
		 String perpetrator1 = "AP2, "+"AP2";
		 Roles = new String[]{"Alleged Perpetrator (AP)"};
		 AddParticipant(firstName2,lastName2,Roles,false);
		 String firstName3 = "AV1";
		 String lastName3 = "AV1";
		 String victim = "AV1, "+"AV1";
		 Roles = new String[]{"Alleged Victim (AV)"};
		 AddParticipant(firstName3,lastName3,Roles,false);
		 UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Maltreatments");
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectVictim(victim);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectPerpetator(perpetrator);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectAllegationType("Abandonment");
		 UsfnPageManager.CpsMaltreatmentPage().Operations().ClickAlligation();
		 try {
			 
				Thread.sleep(5000);
				 UsfnPageManager.CpsMaltreatmentPage().Operations().ClickEditIcon(perpetrator);
				 Thread.sleep(400);
				 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectPerpetator(perpetrator1);
				 UsfnPageManager.CpsMaltreatmentPage().Operations().ClickSaveAlligation();
				 Thread.sleep(5000);
				 Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().IsVictimAvailable(victim), "Victim is not added to alligation");
				 Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().IsPerpetatorAvailable(perpetrator), "Perpetrator is not added to alligation");
				 Assert.assertTrue(UsfnPageManager.CpsMaltreatmentPage().Operations().IsPerpetatorAvailable(perpetrator1), "Perpetrator is not added to alligation");
		
		 }
		 
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		 
	 }
	 
	 @Test
	 public void VerifyAddRiskFactor(){
		 
		 String firstName1 = "AP1";
		 String lastName1 = "AP1";
		 String perpetrator = "AP1, "+"AP1";
		 String[] Roles = new String[]{"Alleged Perpetrator (AP)"};
         AddParticipant(firstName1,lastName1,Roles,true);
		 String firstName3 = "AV1";
		 String lastName3 = "AV1";
		 String victim = "AV1, "+"AV1";
		 Roles = new String[]{"Alleged Victim (AV)"};
		 AddParticipant(firstName3,lastName3,Roles,false);
		 String[] Risks = new String[]{"Child Trafficking"};
		 UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Maltreatments");
		 try {
			 Thread.sleep(200);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectRiskFactor(Risks);
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectLivingArrangementAtTheTimeOfIntake("01=Married two parent household, with two biological/adoptive parents");
		 UsfnPageManager.CpsMaltreatmentPage().Operations().SelectLivingArrangementAtTheTimeOfOccurrence("02=Married two parent household with one biological/adoptive and one step parent");
		 UsfnPageManager.CpsMaltreatmentPage().Elements().ApplyButton().click();
		 UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Participants");
		 Thread.sleep(200);
		 UsfnPageManager.CreateCpsPage().Operations().ClickLeftHandMenu("Maltreatments");
		 Thread.sleep(200);
		 Assert.assertEquals( UsfnPageManager.CpsMaltreatmentPage().Elements().LivingArrangementAtTheTimeOfIntake().getFirstSelectedOption().getText(),"01=Married two parent household, with two biological/adoptive parents");
		 Assert.assertEquals(UsfnPageManager.CpsMaltreatmentPage().Elements().LivingArrangementAtTheTimeOfOccurrence().getFirstSelectedOption().getText(),"02=Married two parent household with one biological/adoptive and one step parent");
			
	      }
	      
	      catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
	 }*/

}
