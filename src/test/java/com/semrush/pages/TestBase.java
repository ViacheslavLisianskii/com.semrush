package com.semrush.pages;
import com.semrush.logic.ApplicationManager;
import org.testng.annotations.*;

public class TestBase {

	/*
	* Please, read "read me.txt" file
	* */

	public final String correctEmail = "lisianskii.viacheslav@gmail.com";
	public final String correctPassword = "SEMrush2016";
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