package tests.booking.tests.test_ng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.booking.BookingHomePageXpath;
import tests.BaseTest;
import utils.Clicker;
import utils.Waiters;

import static driver.Driver.getWebDriver;
import static page.objects.booking.BookingHomePageXpath.*;
import static page.objects.booking.BookingSearchPageXpath.*;

public class BookingParisSearchTests extends BaseTest {
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final Clicker clicker = new Clicker();
    public final Waiters waiters = new Waiters();
    @Test
    public void BookingParisSearch() {
        waiters.waitForPageLoaded(5);
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
        bookingHomePage.destinationSearch("Париж");
        bookingHomePage.locationSelection(parisSearchFirstResultXpath);
        bookingHomePage.datesFromTo(3, 10);
        bookingHomePage.bookPersonsRooms(5,5);
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
        waiters.waitForPageLoaded(5);
        waiters.waitForElement(RATING_CONTAINER_XPATH);
        bookingHomePage.selectRating(6);
        waiters.waitForElement(RATING_APPLIED_XPATH);
        clicker.click(expandSortingFilterXpath);
        clicker.click(selectFilterXpath);
        waiters.waitForPageLoaded(5);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(RATING_TO_COMPARE_XPATH)).getText(), "Оценка 6,0", "Rating of the first sorted hotel is differ than expected");
        System.out.println("BookingParisSearch test passed");
    }
}