package com.semrush.logic;

/**
 * Created by fier on 4/3/2016.
 */
public class ReportHelper extends DriverBasedHelper {
    public ReportHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    public String getErrors(){
        return pages.reportPage
                .ensurePageLoaded()
                .getErrorsCount();
    }

    public String getWarnings(){
        return pages.reportPage
                .ensurePageLoaded()
                .getWarningsCount();
    }

    public String getNotices(){
        return pages.reportPage
                .ensurePageLoaded()
                .getNoticesCount();
    }

    public boolean isUrlExists(String url){
        return pages.reportPage
                .openPageReport()
                .isUrlExists(url);
    }

    public String  getPageCrawled(){
        return pages.reportPage
                .ensurePageLoaded()
                .getPagesCrawled();
    }
}
