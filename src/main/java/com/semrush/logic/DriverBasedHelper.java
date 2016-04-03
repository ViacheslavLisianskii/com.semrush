package com.semrush.logic;

import com.semrush.pages.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by fier on 4/2/2016.
 */
public class DriverBasedHelper {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;

    public DriverBasedHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        pages = new PageManager(driver);
    }

}