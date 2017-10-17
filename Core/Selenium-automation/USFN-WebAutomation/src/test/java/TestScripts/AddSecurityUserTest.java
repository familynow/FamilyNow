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

public class AddSecurityUserTest {
	WebDriver driver;

	@BeforeMethod
	public void openbrowser() {
		Dimension d = new Dimension(1382, 1382);
		WebDriver driver = Browser.getBrowser(GetConfigValue.GetBrowser());
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// @AfterMethod defines this method has to run after every @Test methods
	@AfterMethod
	public void closebrowser() {
		driver = null;
		Browser.driver.close();

	}

	private void verifySearchResult(String userId, String organiztion,
			String name) {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		Assert.assertTrue(UsfnPageManager.UserMaintenancePage().Operations()
				.IsColumnValueAvailable(userId, organiztion));
		Assert.assertTrue(UsfnPageManager.UserMaintenancePage().Operations()
				.IsColumnValueAvailable(userId, name));
		Assert.assertEquals(new SimpleDateFormat("MM/dd/yyyy").format(date),
				UsfnPageManager.UserMaintenancePage().Operations()
						.GetColumnValue(userId, 5));
		Assert.assertEquals(new SimpleDateFormat("MM/dd/yyyy").format(date),
				UsfnPageManager.UserMaintenancePage().Operations()
						.GetColumnValue(userId, 6));

	}

	@Test
	public void SearchSecurityUser() {
		try {
			// Login to USFN
			UsfnPageManager.LoginPage().Operations().Login();
			UsfnPageManager.UserMaintenancePage().Operations()
					.NavigateToUserMaintenancePage();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.UserMaintenancePage().Elements().AddUserButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.AddSecurityUserPage().Elements()
					.LinkEmployeeButton().click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.EmployeeSearchPage().Elements().EmployeeId()
					.sendKeys("17800877");
			UsfnPageManager.EmployeeSearchPage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			String name = UsfnPageManager.EmployeeSearchPage().Operations()
					.GetSearchedValue("17800877", 3);
			String[] splitName = name.split(",");
			String fname = splitName[1];
			String lname = splitName[0];
			String organiztion = UsfnPageManager.EmployeeSearchPage()
					.Operations().GetSearchedValue("17800877", 6);
			UsfnPageManager.EmployeeSearchPage().Operations()
					.SelectEmployee("17800877");
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertEquals(name + " " + "(17800877)", UsfnPageManager
					.AddSecurityUserPage().Elements().Name().getText());
			Assert.assertEquals(organiztion, UsfnPageManager
					.AddSecurityUserPage().Elements().Organization().getText());
			String userId = Utilities.GetRandomFirstName()
					+ Utilities.GetRandomString(2);
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			// new SimpleDateFormat("MM/dd/yyyy").format(date)
			UsfnPageManager.AddSecurityUserPage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.AddSecurityUserPage().Elements().AccessStartDate()
					.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(date));
			UsfnPageManager.AddSecurityUserPage().Elements().AccessEndDate()
					.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(date));
			UsfnPageManager.AddSecurityUserPage().Elements().SaveButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.UserMaintenancePage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			verifySearchResult(userId, organiztion, name);

			UsfnPageManager.UserMaintenancePage().Elements().ClearButton()
					.click();
			Thread.sleep(1000);
			UsfnPageManager.UserMaintenancePage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.UserMaintenancePage().Elements().FirstName()
					.sendKeys(fname);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			verifySearchResult(userId, organiztion, name);
			UsfnPageManager.UserMaintenancePage().Elements().ClearButton()
					.click();
			Thread.sleep(1000);
			UsfnPageManager.UserMaintenancePage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.UserMaintenancePage().Elements().LastName()
					.sendKeys(lname);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			verifySearchResult(userId, organiztion, name);

		}

		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void VerifyUniqueUserId() {
		try {
			// Login to USFN
			UsfnPageManager.LoginPage().Operations().Login();
			UsfnPageManager.UserMaintenancePage().Operations()
					.NavigateToUserMaintenancePage();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.UserMaintenancePage().Elements().AddUserButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.AddSecurityUserPage().Elements()
					.LinkEmployeeButton().click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.EmployeeSearchPage().Elements().EmployeeId()
					.sendKeys("17800877");
			UsfnPageManager.EmployeeSearchPage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.EmployeeSearchPage().Operations()
					.SelectEmployee("17800877");
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			String userId = Utilities.GetRandomFirstName()
					+ Utilities.GetRandomString(2);
			UsfnPageManager.AddSecurityUserPage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.AddSecurityUserPage().Elements().SaveButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.UserMaintenancePage().Elements().AddUserButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.AddSecurityUserPage().Elements()
					.LinkEmployeeButton().click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.EmployeeSearchPage().Elements().EmployeeId()
					.sendKeys("17800877");
			UsfnPageManager.EmployeeSearchPage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.EmployeeSearchPage().Operations()
					.SelectEmployee("17800877");
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.AddSecurityUserPage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.AddSecurityUserPage().Elements().ApplyButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertEquals(
					"User ID already exists. Please choose a different ID.",
					UsfnPageManager.AddSecurityUserPage().Elements()
							.GetErrorMessage().getText());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void VerifyUnlinkEmployee() {
		try {

			// Login to USFN
			UsfnPageManager.LoginPage().Operations().Login();
			UsfnPageManager.UserMaintenancePage().Operations()
					.NavigateToUserMaintenancePage();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.UserMaintenancePage().Elements().AddUserButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.AddSecurityUserPage().Elements()
					.LinkEmployeeButton().click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			UsfnPageManager.EmployeeSearchPage().Elements().EmployeeId()
					.sendKeys("17800877");
			UsfnPageManager.EmployeeSearchPage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			String name = UsfnPageManager.EmployeeSearchPage().Operations()
					.GetSearchedValue("17800877", 3);
			String[] splitName = name.split(",");
			String fname = splitName[1];
			String lname = splitName[0];
			String organiztion = UsfnPageManager.EmployeeSearchPage()
					.Operations().GetSearchedValue("17800877", 6);
			UsfnPageManager.EmployeeSearchPage().Operations()
					.SelectEmployee("17800877");
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertEquals(name + " " + "(17800877)", UsfnPageManager
					.AddSecurityUserPage().Elements().Name().getText());
			Assert.assertEquals(organiztion, UsfnPageManager
					.AddSecurityUserPage().Elements().Organization().getText());
			String userId = Utilities.GetRandomFirstName()
					+ Utilities.GetRandomString(2);
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date date = new Date();
			// new SimpleDateFormat("MM/dd/yyyy").format(date)
			UsfnPageManager.AddSecurityUserPage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.AddSecurityUserPage().Elements().AccessStartDate()
					.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(date));
			UsfnPageManager.AddSecurityUserPage().Elements().AccessEndDate()
					.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(date));
			UsfnPageManager.AddSecurityUserPage().Elements().SaveButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.UserMaintenancePage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			verifySearchResult(userId, organiztion, name);
			UsfnPageManager.UserMaintenancePage().Operations()
					.ClickEdit(userId);
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.AddSecurityUserPage().Elements().UnLinkEmployee()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.AddSecurityUserPage().Elements()
					.LinkEmployeeButton().click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);

			UsfnPageManager.EmployeeSearchPage().Elements().EmployeeId()
					.sendKeys("17800841");
			UsfnPageManager.EmployeeSearchPage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(4000);
			name = UsfnPageManager.EmployeeSearchPage().Operations()
					.GetSearchedValue("17800841", 3);
			splitName = name.split(",");
			fname = splitName[1];
			lname = splitName[0];
			organiztion = UsfnPageManager.EmployeeSearchPage().Operations()
					.GetSearchedValue("17800841", 6);
			UsfnPageManager.EmployeeSearchPage().Operations()
					.SelectEmployee("17800841");
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			Assert.assertEquals(name + " " + "(17800841)", UsfnPageManager
					.AddSecurityUserPage().Elements().Name().getText());
			Assert.assertEquals(organiztion, UsfnPageManager
					.AddSecurityUserPage().Elements().Organization().getText());
			UsfnPageManager.AddSecurityUserPage().Elements().SaveButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			UsfnPageManager.UserMaintenancePage().Elements().UserId()
					.sendKeys(userId);
			UsfnPageManager.UserMaintenancePage().Elements().FirstName()
					.sendKeys(fname);
			UsfnPageManager.UserMaintenancePage().Elements().SearchButton()
					.click();
			UsfnPageManager.UserMaintenancePage().Operations()
					.ApplyWait(driver);
			Thread.sleep(2000);
			verifySearchResult(userId, organiztion, name);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
