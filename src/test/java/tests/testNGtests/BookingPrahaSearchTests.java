
package tests.testNGtests;

import org.testng.annotations.Test;
import pages.booking.BookingHomeXPath;
import pages.booking.BookingSearchResultsXPath;
import tests.BaseTest;
import utils.Waiters;

public class BookingPrahaSearchTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public final BookingSearchResultsXPath bookingSearchResultPage = new BookingSearchResultsXPath();

    public final Waiters waiters = new Waiters();
    @Test
    public void BookingPrahaSearch() {


        waiters.waitForPageLoaded();
        bookingHomePage.getBookingStartPage();
        bookingHomePage.closeRegistrationAlert();
        bookingHomePage.getLocationSearchField("Прага");
        bookingHomePage.locationSelectionPraha();
        bookingHomePage.closeDatePicker();
        bookingHomePage.submitSearch();
        waiters.waitForPageLoaded();
        waiters.waitForElement(bookingHomePage.rating9Checkbox);
        bookingHomePage.selectCheckbox(bookingHomePage.rating9Checkbox);
        bookingHomePage.waitForRatingApplied(bookingHomePage.ratingApplied);
        bookingHomePage.getTopResult();
        waiters.waitForNewTab();
        waiters.waitForPageLoaded();
        bookingSearchResultPage.getRatingToCompare(bookingSearchResultPage.ratingToCompare);
        System.out.println("BookingPrahaSearch test passed");

    }
}