
package tests.testNGtests;

import org.testng.annotations.Test;
import pages.booking.BookingHomeXPath;
import pages.booking.BookingSearchResultsXPath;
import tests.BaseTest;
import utils.Screenshot;
import utils.Waiters;

import java.io.IOException;

public class BookingLondonSearchTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public final BookingSearchResultsXPath bookingSearchResultPage = new BookingSearchResultsXPath();
    public final Waiters waiters = new Waiters();
    public final Screenshot screenshot = new Screenshot();

    @Test
    public void BookingLondonSearch() throws IOException {


        waiters.waitForPageLoaded();
        bookingHomePage.getBookingStartPage();
        bookingHomePage.closeRegistrationAlert();
        bookingHomePage.getLocationSearchField("Лондон");
        bookingHomePage.locationSelectionLondon();
        bookingHomePage.submitSearch();
        waiters.waitForPageLoaded();
        bookingSearchResultPage.scrollToResult10();
        bookingSearchResultPage.changeResult10Bgc();
        bookingSearchResultPage.changeResult10TitleColor();
        screenshot.getScreenshot();
        System.out.println("BookingLondonSearch test passed");
    }
}