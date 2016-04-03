package com.semrush.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WebDriverFactory {

	private static String PROPERTY_NAME = "webdriver.chrome.driver";
	private static String PROPERTY_VALUE = ".\\src\\main\\resources\\drivers\\chrome\\chromedriver.exe";
	private static final String CHROME = "chrome";

	private WebDriverFactory() {
	}

	public static WebDriver getInstance(String browserName) {
		if (CHROME.equals(browserName)) {
			System.setProperty(PROPERTY_NAME, PROPERTY_VALUE);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-javascript");
			return new ChromeDriver(options);
		} else {
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			return new FirefoxDriver(firefoxProfile);
		}
	}
}