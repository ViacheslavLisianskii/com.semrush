package com.site.pages;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by fier on 4/3/2016.
 */
public class CreateProjectTests extends TestBase {

    private final String INCORRECT_PROJECT_DOMAIN = "domain";

    @BeforeClass
    public void beforeClass() {
        app.getNavigationHelper().openProjectsPage();
        app.getUserHelper().loginAs(correctEmail, correctPassword);
    }

    @AfterMethod
    public void afterMethod(){
        app.getNavigationHelper().openProjectsPage();
        app.getProjectsHelper().deleteProject();
    }

    @Test
    public void incorrectProjectDomain_ErrorMessageIsDisplayed() {
        app.getNavigationHelper().openProjectsPage();
        Assert.assertFalse(app.getProjectsHelper().createNewProject(INCORRECT_PROJECT_DOMAIN, correctProjectName));
    }

    @Test
    public void correctProjectName_ProjectHasCreated() {
        Assert.assertTrue(app.getProjectsHelper().createNewProject(correctProjectDomain, correctProjectName));
        Assert.assertEquals(app.getDashboardHelper().getHeaderText(), correctProjectName + " " + correctProjectDomain);
    }
}