package com.site.logic;

/**
 * Created by fier on 4/3/2016.
 */
public class DashboardHelper extends DriverBasedHelper {

    public DashboardHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    public String getHeaderText() {
        return pages.dashboardPage
                .ensurePageLoaded()
                .getHeaderText();
    }

    public void openReport(){
        pages.dashboardPage
                .ensurePageLoaded()
                .openReport();
    }
}
