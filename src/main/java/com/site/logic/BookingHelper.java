package com.site.logic;

/**
 * Created by fier on 4/3/2016.
 */
public class BookingHelper extends DriverBasedHelper {

    public BookingHelper(ApplicationManager manager) {
        super(manager.getWebDriver());
    }

    public void findBestDeals(String destination, String checkin, String checkout) {
        pages.homePage
                .setDestination(destination)
                .setCheckin(checkin)
                .setCheckout(checkout)
                .clickLetsgo();
    }
}
