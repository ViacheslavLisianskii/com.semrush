package com.semrush.pages;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase {

	@BeforeMethod
	public void beforeMethod(){
		app.getNavigationHelper().openProjectsPage();
		app.getNavigationHelper().changeLanguage();
	}

	@AfterMethod
	public void afterMethod(){
		app.getUserHelper().logout();
	}

	@Test
	public void incorrectPassword_ErrorMessageIsDisplayed() {
		app.getUserHelper().loginAs(correctEmail, "123");
		Assert.assertEquals(app.getUserHelper().getErrorMessage(), "Error! Wrong login or password.");
	}

	@Test
	public void correctEmailAndPassword_LoginSuccessful() {
		app.getUserHelper().loginAs(correctEmail, correctPassword);
		app.getProjectsHelper().ensurePageLoaded();
	}
}