package tests.testng.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.booking.BookingHomeXPath;
import tests.BaseTest;
import utils.Clicker;
import utils.Waiters;

import static driver.Driver.getWebDriver;
import static pages.booking.BookingHomeXPath.*;
import static pages.booking.BookingHomeXPath.ratingToCompareXpath;
import static pages.booking.BookingSearchResultsXPath.*;

public class BookingParisSearchTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public final Clicker clicker = new Clicker();
    public final Waiters waiters = new Waiters();
    @Test
    public void BookingParisSearch() {
        waiters.waitForPageLoaded(20);
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
        bookingHomePage.getLocationSearchField("Париж");
        bookingHomePage.locationSelection(parisSearchFirstResultXpath);
        bookingHomePage.datesFromTo(3, 10);
        clicker.click(occurancyXpath);
        clicker.click(addAdultXpath);
        clicker.click(addAdultXpath);
        clicker.click(addRoomXpath);
        clicker.click(submitOcupancyXpath);
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
        waiters.waitForPageLoaded(20);
        waiters.waitForElement(ratingContainerXpath);
        clicker.click(selectRating_6_CheckboxXpath);
        waiters.waitForElement(ratingAppliedFilterAppearsXpath);
        clicker.click(expandSortingFilterXpath);
        clicker.click(selectFilterXpath);
        waiters.waitForPageLoaded(5);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(ratingToCompareXpath)).getText(), "Оценка 6,0", "Rating of the first sorted hotel is differ than expected");
        System.out.println("BookingParisSearch test passed");
    }
}