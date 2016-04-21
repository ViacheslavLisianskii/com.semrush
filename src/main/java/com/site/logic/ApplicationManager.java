package com.site.logic;

import com.site.util.PropertyLoader;
import com.site.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by fier on 4/2/2016.
 */
public class ApplicationManager {

    private UserHelper userHelper;
    private ProjectsHelper projectsHelper;
    private NavigationHelper navHelper;
    private DashboardHelper dashboardHelper;
    private AuditHelper auditHelper;
    private ReportHelper reportHelper;

    private WebDriver driver;
    private String baseUrl;

    public ApplicationManager() {
        baseUrl = PropertyLoader.loadProperty("site.url");

        driver = WebDriverFactory.getInstance(PropertyLoader.loadProperty("browser.name"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        userHelper = new UserHelper(this);
        projectsHelper = new ProjectsHelper(this);
        navHelper = new NavigationHelper(this);
        dashboardHelper = new DashboardHelper(this);
        auditHelper = new AuditHelper(this);
        reportHelper = new ReportHelper(this);
    }

    public NavigationHelper getNavigationHelper() {
        return navHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ProjectsHelper getProjectsHelper() { return projectsHelper; }

    public DashboardHelper getDashboardHelper() { return dashboardHelper; }

    public AuditHelper getAuditHelper() { return auditHelper; }

    public ReportHelper getReportHelper() { return reportHelper; }

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
