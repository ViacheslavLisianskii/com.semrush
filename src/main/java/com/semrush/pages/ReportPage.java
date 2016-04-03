package com.semrush.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by fier on 4/3/2016.
 */
public class ReportPage extends Page {

    private final String ERRORS_TEXT_XPATH = "//div[@class='sa-countIssues']/a[@href='#issues/errors']";
    private final String WARNINGS_TEXT_XPATH = "//div[@class='sa-countIssues']/a[@href='#issues/warnings']";
    private final String NOTICES_TEXT_XPATH = "//div[@class='sa-countIssues']/a[@href='#issues/notices']";
    private final String PAGE_REPORT_XPATH = "//li[@data-name='pagereport']";
    private final String PAGES_LIST_XPATH = "//td[contains(@class, 'pages-report-pageURL')]/div/a[contains(text(),";
    private final String PAGES_CRAWLED_TEXT_XPATH = "//li[@data-attr='pagesCrawled']/span";

    @FindBy(xpath = ERRORS_TEXT_XPATH)
    private WebElement errorsText;
    @FindBy(xpath = WARNINGS_TEXT_XPATH)
    private WebElement warningsText;
    @FindBy(xpath = NOTICES_TEXT_XPATH)
    private WebElement noticesText;
    @FindBy(xpath = PAGE_REPORT_XPATH)
    private WebElement pageReport;
    @FindBy(xpath = PAGES_CRAWLED_TEXT_XPATH)
    private WebElement pagesCrawled;

    public ReportPage(PageManager pages) {
        super(pages);
    }

    public String getErrorsCount(){
        return errorsText.getText();
    }

    public String getWarningsCount(){
        return warningsText.getText();
    }

    public String getNoticesCount(){
        return noticesText.getText();
    }

    public ReportPage openPageReport(){
        pageReport.click();

        return this;
    }

    public String getPagesCrawled(){
        return pagesCrawled.getText();
    }

    public Boolean isUrlExists(String url){
        try{
            wait.until(presenceOfElementLocated(By.xpath(PAGES_LIST_XPATH + "\'" + url + "\')]")));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public ReportPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(elementToBeClickable(By.xpath(ERRORS_TEXT_XPATH)));
        return this;
    }
}