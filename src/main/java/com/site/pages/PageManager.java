package com.site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by fier on 4/2/2016.
 */
public class PageManager {

    private WebDriver DRIVER;

    public HomePage homePage;

    public PageManager(WebDriver driver) {
        this.DRIVER = driver;
        homePage = initElements(new HomePage(this));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(DRIVER, page);
        return page;
    }

    public WebDriver getWebDriver() {
        return DRIVER;
    }
}
