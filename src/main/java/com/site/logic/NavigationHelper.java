package com.site.logic;

/**
 * Created by fier on 5/24/2016.
 */
public class NavigationHelper extends DriverBasedHelper {
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
        this.baseUrl = manager.getBaseUrl();
    }

    public void openBaseSite() {
        driver.get(baseUrl);
    }
}
