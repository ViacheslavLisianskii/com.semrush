package com.semrush.logic;

/**
 * Created by fier on 4/2/2016.
 */
public class UserHelper extends DriverBasedHelper {
    public UserHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    public void loginAs(String email, String password) {
        pages.projectsPage
                .clickLogin();

        pages.loginPage
                .setEmail(email)
                .setPassword(password)
                .clickLogin();
    }

    public String getErrorMessage() {
        return pages.loginPage
                .getErrorMessage();
    }

    public void logout() {
        pages.internalPage.
                logout();
    }
}