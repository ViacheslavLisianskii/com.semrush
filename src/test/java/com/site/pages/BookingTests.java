package com.site.pages;

import org.testng.Assert;
import org.testng.annotations.*;

public class BookingTests extends TestBase {

	@BeforeMethod
	public void beforeMethod(){
		app.getNavigationHelper().openBaseSite();
	}

	@Test
	public void test() {
		app.getBookingHelper().findBestDeals("New York City", "July 1, 2016", "July 5, 2016");

		Assert.assertTrue(false);
	}
}