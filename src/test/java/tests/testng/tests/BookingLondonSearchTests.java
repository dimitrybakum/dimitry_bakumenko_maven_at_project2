
package tests.testng.tests;

import org.testng.annotations.Test;
import pages.booking.BookingHomeXPath;
import pages.booking.BookingSearchResultsXPath;
import tests.BaseTest;
import utils.Clicker;
import utils.Screenshot;
import utils.Waiters;

import java.io.IOException;

import static pages.booking.BookingHomeXPath.*;
import static pages.booking.BookingSearchResultsXPath.getSearchResult_10_title_xpath;
import static pages.booking.BookingSearchResultsXPath.searchResult_10_xpath;

public class BookingLondonSearchTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public final BookingSearchResultsXPath bookingSearchResultPage = new BookingSearchResultsXPath();
    public final Waiters waiters = new Waiters();
    public final Screenshot screenshot = new Screenshot();
    public final Clicker clicker = new Clicker();

    @Test
    public void BookingLondonSearch() throws IOException {
        waiters.waitForPageLoaded(20);
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
        bookingHomePage.getLocationSearchField("Лондон");
        bookingHomePage.locationSelection(londonSearchFirstResultXpath);
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
        waiters.waitForPageLoaded(20);
        bookingSearchResultPage.scrollIntoView(searchResult_10_xpath);
        bookingSearchResultPage.changeElementBgcToGreen(searchResult_10_xpath);
        bookingSearchResultPage.changeElementTitleColorToRed(getSearchResult_10_title_xpath);
        screenshot.getScreenshot("myScreenshotName");
        System.out.println("BookingLondonSearch test passed");
    }
}