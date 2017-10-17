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

public class UserStory17Test {
	
	
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
	 
	
	private String AddParticipant(String fname, String lname, String[] roles) {

		String getIntakeId = "";

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
			getIntakeId = UsfnPageManager.CreateCpsPage().Operations()
					.GetIntakeId();

			// Navigate to Add Participant page
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Participants");
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.ApplyWait(driver);
			// Add Participant
			Thread.sleep(5000);
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.SelectRoles(roles);
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.EnterFirstName(fname);
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.EnterLastName(lname);

			UsfnPageManager.CpsAddParticipanPage().Elements().SaveButton()
					.click();
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getIntakeId;
	}
	 
	@Test
	public void VerifyAddParticipant() {

		String firstName = Utilities.GetRandomFirstName();
		String lastName = Utilities.GetRandomLasttName();
		String name = lastName + ", " + firstName;
		String[] Roles = new String[] { "Alleged Perpetrator (AP)",
				"Alleged Victim (AV)" };
		String getIntakeId = AddParticipant(firstName, lastName, Roles);
		try {

			Thread.sleep(3000);

			String intakeName = UsfnPageManager.CreateCpsPage().Operations()
					.GetIntakeName();

			// Verify Participant name
			Assert.assertTrue(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, name),
					"Name is not correct");
			Assert.assertTrue(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, "*"),
					"Intake Name is not set");
			Assert.assertTrue(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, "!"),
					"Participant  is not set Alleged Perpetrator");

			// Verify Participant Roles are selected
			Assert.assertTrue(
					UsfnPageManager
							.CpsListParticipantPage()
							.Operations()
							.IsColumnValueAvailable(name,
									"Alleged Perpetrator (AP)"),
					"Roles are not selected");
			Assert.assertTrue(
					UsfnPageManager
							.CpsListParticipantPage()
							.Operations()
							.IsColumnValueAvailable(name, "Alleged Victim (AV)"),
					"Roles are not selected");
			UsfnPageManager.CreateCpsPage().Operations()
					.ClickLeftHandMenu("Home");
			UsfnPageManager.CreateCpsPage().Operations().ApplyWait(driver);
			Thread.sleep(5000);
			Assert.assertTrue(UsfnPageManager.IntakeListPage().Operations()
					.VerifyIntakeName(getIntakeId, intakeName),
					"Intake Name is not set");

		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void VerifyDeleteParticipant() {

		String firstName = Utilities.GetRandomFirstName();
		String lastName = Utilities.GetRandomLasttName();
		String name = lastName + ", " + firstName;
		String[] Roles = new String[] { "Alleged Perpetrator (AP)",
				"Alleged Victim (AV)" };
		AddParticipant(firstName, lastName, Roles);
		try {
			Thread.sleep(1000);
			UsfnPageManager.CpsListParticipantPage().Operations()
					.PerformAction(name, "Delete", true);
			Assert.assertTrue(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, name),
					"Participant is deleted");
			Assert.assertTrue(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, "*"),
					"Intake Name is not set");
			// Add second participant
			String secParticipantfirstName = Utilities.GetRandomFirstName()
					+ "s";
			String secParticipantlastName = Utilities.GetRandomLasttName();
			;
			String secParticipantName = secParticipantlastName + ", "
					+ secParticipantfirstName;
			Roles = new String[] { "Alleged Victim (AV)" };
			UsfnPageManager.CpsListParticipantPage().Elements()
					.AddParticipantButton().click();
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.ApplyWait(driver);
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.EnterFirstName(secParticipantfirstName);
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.EnterLastName(secParticipantlastName);
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.SelectRoles(Roles);
			UsfnPageManager.CpsAddParticipanPage().Elements().SaveButton()
					.click();
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(3000);

			// Make second participant as Intake Name
			UsfnPageManager
					.CpsListParticipantPage()
					.Operations()
					.PerformAction(secParticipantName, "Make Intake Name",
							false);

			Thread.sleep(2000);
			Assert.assertTrue(
					UsfnPageManager.CpsListParticipantPage().Operations()
							.IsColumnValueAvailable(secParticipantName, "*"),
					"Second Participant is not set as Intake Name");
			Assert.assertFalse(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, "*"),
					"First Participant is  still a Intake Name");

			Thread.sleep(2000);
			// delete first participant
			UsfnPageManager.CpsListParticipantPage().Operations()
					.PerformAction(name, "Delete", false);

			Thread.sleep(2000);
			Assert.assertFalse(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, name),
					"First Participant is not deleted");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void VerifyEditParticipant() {

		String firstName = Utilities.GetRandomFirstName();
		String lastName = Utilities.GetRandomLasttName();
		String name = lastName + ", " + firstName;
		String[] Roles = new String[] { "Alleged Perpetrator (AP)",
				"Alleged Victim (AV)" };
		AddParticipant(firstName, lastName, Roles);
		try {
			Thread.sleep(2000);
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ClickParticipantId(name);
			String[] RemoveRoles = new String[] { "Alleged Perpetrator (AP)" };
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.CpsAddParticipanPage().Operations()
					.RemoveRoles(RemoveRoles);
			UsfnPageManager.CpsAddParticipanPage().Elements().SaveButton()
					.click();
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertFalse(UsfnPageManager.CpsListParticipantPage()
					.Operations().IsColumnValueAvailable(name, "!"),
					"Alleged Perpetrator is not removed");

		}

		catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void VerifyLinkParticipant() {

		String firstName = Utilities.GetRandomFirstName();
		String lastName = Utilities.GetRandomLasttName();
		String name = lastName + ", " + firstName;
		String LinkedName = null;
		String[] Roles = new String[] { "Alleged Perpetrator (AP)",
				"Alleged Victim (AV)" };
		AddParticipant(firstName, lastName, Roles);
		try {
			Thread.sleep(2000);
			UsfnPageManager.CpsListParticipantPage().Operations()
					.PerformAction(name, "Search and Link", false);
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(3000);
			UsfnPageManager.PersonSearchPage().Elements().AddPersonhButton()
					.click();
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(3000);

			UsfnPageManager.PersonBasicPage().Elements().SaveButton().click();
			UsfnPageManager.CpsListParticipantPage().Operations()
					.ApplyWait(driver);
			Thread.sleep(3000);

			Assert.assertFalse(
					UsfnPageManager.CpsListParticipantPage().Operations()
							.VerifyActionIconIsPresent(name, "Search And Link"),
					"Search And Link icon is  present");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
			   
		


}
