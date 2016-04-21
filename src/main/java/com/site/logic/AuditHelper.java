package com.site.logic;

/**
 * Created by fier on 4/3/2016.
 */
public class AuditHelper extends DriverBasedHelper {
    public AuditHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    public void startAudit(String selectType, String pageLimit, String disallowUrls, String removedUrls){
        pages.dashboardPage
                .setUpAudit();

        pages.siteAuditSettingsPage
                .selectLimitType(selectType)
                .setPageLimit(pageLimit)
                .clickCheckbox()
                .chooseMasksWizard()
                .setDisallow(disallowUrls)
                .chooseParametersWizard()
                .setRemoveParameters(removedUrls)
                .startSiteAudit();
    }

    public void startAudit(String selectType, String pageLimit){
        startAudit(selectType, pageLimit, "", "");
    }
}
