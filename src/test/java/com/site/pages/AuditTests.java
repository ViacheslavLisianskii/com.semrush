package com.site.pages;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by fier on 4/3/2016.
 */
public class AuditTests extends TestBase {

    private final String CUSTOM_TYPE = "custom";
    private final String NUMBER_OF_CRAWL_PAGES = "10";

    @BeforeClass
    public void beforeClass() {
        app.getNavigationHelper().openProjectsPage();
        app.getUserHelper().loginAs(correctEmail, correctPassword);
    }

    @BeforeMethod
    public void beforeMethod(){
        app.getNavigationHelper().openProjectsPage();
        app.getProjectsHelper().createNewProject(correctProjectDomain, correctProjectName);
    }

    @AfterMethod
    public void afterMethod(){
        app.getNavigationHelper().openProjectsPage();
        app.getProjectsHelper().deleteProject();
    }

    @Test
    public void reportShouldContainsStatistic() {
        app.getAuditHelper().startAudit(CUSTOM_TYPE, NUMBER_OF_CRAWL_PAGES);
        app.getDashboardHelper().openReport();

        checkReportStatistic(app.getReportHelper().getErrors());
        checkReportStatistic(app.getReportHelper().getWarnings());
        checkReportStatistic(app.getReportHelper().getNotices());
    }

    @Test
    public void setMasksForDisallowAndRemoveParameters_shouldNotBePresentInReport() {
        app.getAuditHelper().startAudit(CUSTOM_TYPE, NUMBER_OF_CRAWL_PAGES, "/join", "lang_id");
        app.getDashboardHelper().openReport();

        Assert.assertFalse(app.getReportHelper().isUrlExists("join"));
        Assert.assertFalse(app.getReportHelper().isUrlExists("lang_id"));
    }

    @Test
    public void setMasksForDisallowUrls_shouldNotBePresentInReport() {
        app.getAuditHelper().startAudit(CUSTOM_TYPE, NUMBER_OF_CRAWL_PAGES, "/join", "");
        app.getDashboardHelper().openReport();

        Assert.assertFalse(app.getReportHelper().isUrlExists("join"));
        Assert.assertTrue(app.getReportHelper().isUrlExists("lang_id"));
    }

    @Test
    public void setRemoveParametersUrls_shouldNotBePresentInReport() {
        app.getAuditHelper().startAudit(CUSTOM_TYPE, NUMBER_OF_CRAWL_PAGES, "", "lang_id");
        app.getDashboardHelper().openReport();

        Assert.assertTrue(app.getReportHelper().isUrlExists("join"));
        Assert.assertFalse(app.getReportHelper().isUrlExists("lang_id"));
    }

    @Test
    public void setCustomPagesCrawled_shouldCrawlCustomNumberOfPages() {
        String crawledPages = "13";
        app.getAuditHelper().startAudit(CUSTOM_TYPE, crawledPages);
        app.getDashboardHelper().openReport();

        Assert.assertEquals(app.getReportHelper().getPageCrawled(), crawledPages + "/" + crawledPages);
    }

    private void checkReportStatistic(String statistic){
        Assert.assertNotEquals(statistic, "N/A");
        Assert.assertNotEquals(statistic, "");
    }
}