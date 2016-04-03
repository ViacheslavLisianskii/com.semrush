package com.semrush.logic;

/**
 * Created by fier on 4/3/2016.
 */
public class ProjectsHelper extends DriverBasedHelper {
    public ProjectsHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    public boolean createNewProject(String domain, String name){
        return pages.projectsPage
                .ensurePageLoaded()
                .createNewProject()
                .setProjectDomain(domain)
                .setProjectName(name)
                .create();
    }

    public void deleteProject(){
        pages.projectsPage
                .deleteProject();
    }

    public void ensurePageLoaded(){
        pages.projectsPage
                .ensurePageLoaded();
    }
}
