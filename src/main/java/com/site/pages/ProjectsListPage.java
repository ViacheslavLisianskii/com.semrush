package com.site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by fier on 4/2/2016.
 */
public class ProjectsListPage extends Page {

    private final String LOGIN_BUTTON_CLASSNAME = "js-authentication-login";
    private final String CREATE_PROJECT_BUTTON_XPATH = "//*[contains(@class, 's-projects-search-bar-create')]";
    private final String DOMAIN_INPUT_XPATH = "//*[contains(@class, 'js-pr-watch-domain')]";
    private final String NAME_INPUT_XPATH = "//*[contains(@class, 'js-pr-watch-name')]";
    private final String SAVE_BUTTON_XPATH = "//button[contains(@class, 'js-pr-create')]";
    private final String DELETE_PROJECT_BUTTON_XPATH = "//*[contains(@class, 'a-icn-trash')]";
    private final String CONFIRM_DELETE_BUTTON_CLASSNAME = "pr-save";

    @FindBy(xpath = DELETE_PROJECT_BUTTON_XPATH)
    private WebElement deleteProjectButton;
    @FindBy(className = LOGIN_BUTTON_CLASSNAME)
    private WebElement loginButton;
    @FindBy(xpath = CREATE_PROJECT_BUTTON_XPATH)
    private WebElement createNewProject;
    @FindBy(xpath = DOMAIN_INPUT_XPATH)
    private WebElement projectDomainInput;
    @FindBy(xpath = NAME_INPUT_XPATH)
    private WebElement projectNameInput;
    @FindBy(xpath = SAVE_BUTTON_XPATH)
    private WebElement saveButton;
    @FindBy(className = CONFIRM_DELETE_BUTTON_CLASSNAME)
    private WebElement confirmDeletingButton;

    public ProjectsListPage(PageManager pages) {
        super(pages);
    }

    public ProjectsListPage createNewProject() {
        createNewProject.click();

        return this;
    }

    public ProjectsListPage setProjectDomain(String domain) {
        projectDomainInput.clear();
        projectDomainInput.sendKeys(domain);

        return this;
    }

    public ProjectsListPage setProjectName(String name) {
        projectNameInput.clear();
        projectNameInput.sendKeys(name);

        return this;
    }

    public ProjectsListPage deleteProject() {
        try {
            deleteProjectButton.click();
            confirmDeletingButton.click();
        } catch (NoSuchElementException e) {
            // project doesn't exist
        }

        return this;
    }

    public boolean create() {
        try {
            saveButton.click();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public void clickLogin() {
        loginButton.click();
    }

    public ProjectsListPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(elementToBeClickable(By.xpath(CREATE_PROJECT_BUTTON_XPATH)));
        return this;
    }
}