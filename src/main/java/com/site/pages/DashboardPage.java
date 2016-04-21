package com.site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by fier on 4/3/2016.
 */
public class DashboardPage extends Page {

    private final String HEADER_TEXT_XPATH = "//div[contains(@class,'pr-dashHeader-title')]";
    private final String SETUP_AUDIT_BUTTON_XPATH = "//button[contains(@class, 'js-trigger-audit-wizard')]";
    private final String STATISTIC_BUTTON_XPATH = "//div[@class='sa-tool-name']/a";

    @FindBy(xpath = SETUP_AUDIT_BUTTON_XPATH)
    private WebElement setUpAuditButton;
    @FindBy(xpath = HEADER_TEXT_XPATH)
    private WebElement headerText;
    @FindBy(xpath = STATISTIC_BUTTON_XPATH)
    private WebElement statisticButton;

    public DashboardPage(PageManager pages) {
        super(pages);
    }

    public String getHeaderText(){
        return headerText.getText();
    }

    public void setUpAudit(){
        setUpAuditButton.click();
    }

    public void openReport(){
        wait.until(elementToBeClickable(statisticButton));
        statisticButton.click();
    }

    public DashboardPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(HEADER_TEXT_XPATH)));
        return this;
    }
}
