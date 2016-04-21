package com.site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by fier on 4/2/2016.
 */
public class InternalPage extends Page {
    private final String LOGOUT_BUTTON_XPATH = "//*[contains(@href, 'users/logout')]";
    private final String LANGUAGE_BUTTON_XPATH = "//*[contains(@class, 'header__user-menu')]/div[1]";
    private final String USER_BUTTON_XPATH = "//*[contains(@class, 'header__user-menu')]/div[2]";

    @FindBy(xpath = LOGOUT_BUTTON_XPATH)
    private WebElement logoutButton;
    @FindBy(xpath = LANGUAGE_BUTTON_XPATH)
    private WebElement languageButton;
    @FindBy(xpath = USER_BUTTON_XPATH)
    private WebElement userButton;

    public InternalPage(PageManager pages) {
        super(pages);
    }

    public InternalPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("bs-example-navbar-collapse-1")));
        return this;
    }

    public void changeLanguage(String locale) {
        languageButton.click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[contains(@href, '/projects/?l=" + locale + "')]"))).click();
    }

    public void logout() {
        try {
            userButton.click();
            logoutButton.click();
        } catch (Exception e) {
            // user doesn't logged in
        }
    }
}