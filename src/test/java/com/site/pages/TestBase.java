package com.site.pages;
import com.site.logic.ApplicationManager;
import org.testng.annotations.*;

public class TestBase {

	/*
	* Please, read "read me.txt" file
	* */

	public final String correctEmail = "";
	public final String correctPassword = "";
	public final String correctProjectDomain = "vk.com";
	public final String correctProjectName = "vk";

	protected ApplicationManager app;

	@BeforeTest
	public void beforeTest() {
		app = new ApplicationManager();
	}

	@AfterTest
	public void afterTest() {
		app.stop();
	}
}