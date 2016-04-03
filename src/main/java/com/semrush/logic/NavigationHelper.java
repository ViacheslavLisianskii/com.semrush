package com.semrush.logic;

import com.semrush.util.PropertyLoader;

/**
 * Created by fier on 4/2/2016.
 */
public class NavigationHelper extends DriverBasedHelper {
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
        this.baseUrl = manager.getBaseUrl();
    }

    public void openProjectsPage() {
        driver.get(baseUrl);
    }

    public void openRelativeUrl(String url) {
        driver.get(baseUrl + url);
    }

    public void changeLanguage(){
        pages.internalPage
                .changeLanguage(PropertyLoader.loadProperty("site.locale"));
    }
}
