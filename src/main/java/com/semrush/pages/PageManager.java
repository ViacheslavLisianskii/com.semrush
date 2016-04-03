package com.semrush.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by fier on 4/2/2016.
 */
public class PageManager {

    private WebDriver DRIVER;

    public LoginPage loginPage;
    public ProjectsListPage projectsPage;
    public InternalPage internalPage;
    public DashboardPage dashboardPage;
    public SiteAuditSettingsPage siteAuditSettingsPage;
    public ReportPage reportPage;

    public PageManager(WebDriver driver) {
        this.DRIVER = driver;
        loginPage = initElements(new LoginPage(this));
        projectsPage = initElements(new ProjectsListPage(this));
        internalPage = initElements(new InternalPage(this));
        dashboardPage = initElements(new DashboardPage(this));
        siteAuditSettingsPage = initElements(new SiteAuditSettingsPage(this));
        reportPage = initElements(new ReportPage(this));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(DRIVER, page);
        return page;
    }

    public WebDriver getWebDriver() {
        return DRIVER;
    }
}
