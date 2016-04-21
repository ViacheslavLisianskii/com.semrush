package com.site.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by fier on 4/2/2016.
 */
public class LoginPage extends Page {

    private final String EMAIL_INPUT_XPATH = "//*[contains(@class, 'auth-form')]/input[@name='email']";
    private final String PASSWORD_INPUT_XPATH = "//*[contains(@class, 'auth-form')]/input[@name='password']";
    private final String LOGIN_BUTTON_XPATH = "//*[contains(@class, 'auth-form')]/button[@type='submit']";
    private final String ERROR_TEXT_XPATH = "//*[contains(@class, 'auth-form')]/div[contains(@class, 'auth-form__alert')]";

    @FindBy(xpath = EMAIL_INPUT_XPATH)
    private WebElement emailInput;
    @FindBy(xpath = PASSWORD_INPUT_XPATH)
    private WebElement passwordInput;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;
    @FindBy(xpath = ERROR_TEXT_XPATH)
    private WebElement errorMessageText;

    public LoginPage(PageManager pages) {
        super(pages);
    }

    public LoginPage setEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);

        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);

        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessageText.getText();
    }
}