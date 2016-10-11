package com.site.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by fier on 4/2/2016.
 */
public class HomePage extends Page {

    private final String DESTINATION_INPUT_XPATH = "//*[@id='ss']";
    private final String CHECKIN_DATETIME_XPATH = "//*[contains(@data-mode, 'check-in')]";
    private final String CHECKOUT_DATETIME_XPATH = "//*[contains(@data-mode, 'check-out')]";
    private final String LETSGO_BUTTON_XPATH = "//*[@id='frm']//*[contains(@type, 'submit')]";

    @FindBy(xpath = DESTINATION_INPUT_XPATH)
    private WebElement destinationInput;
    @FindBy(xpath = CHECKIN_DATETIME_XPATH)
    private WebElement checkinDatetime;
    @FindBy(xpath = CHECKOUT_DATETIME_XPATH)
    private WebElement checkoutDatetime;
    @FindBy(xpath = LETSGO_BUTTON_XPATH)
    private WebElement letsgoButton;

    public HomePage(PageManager pages) {
        super(pages);
    }

    public HomePage setDestination(String destination) {
        destinationInput.clear();
        destinationInput.sendKeys(destination);

        return this;
    }

    public HomePage setCheckin(String checkin) {
        checkinDatetime.sendKeys(checkin);

        return this;
    }

    public HomePage setCheckout(String checkout) {
        checkoutDatetime.sendKeys(checkout);

        return this;
    }

    public HomePage clickLetsgo() {
        letsgoButton.click();

        return this;
    }
}