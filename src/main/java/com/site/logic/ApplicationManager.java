package com.site.logic;

import com.site.util.PropertyLoader;
import com.site.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by fier on 4/2/2016.
 */
public class ApplicationManager {

    private BookingHelper bookingHelper;
    private NavigationHelper navigationHelper;

    private WebDriver driver;
    private String baseUrl;

    public ApplicationManager() {
        baseUrl = PropertyLoader.loadProperty("site.url");

        driver = WebDriverFactory.getInstance(PropertyLoader.loadProperty("browser.name"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        bookingHelper = new BookingHelper(this);
        navigationHelper = new NavigationHelper(this);
    }

    public BookingHelper getBookingHelper() { return bookingHelper; }
    public NavigationHelper getNavigationHelper() { return navigationHelper; }

    protected WebDriver getWebDriver() {
        return driver;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
