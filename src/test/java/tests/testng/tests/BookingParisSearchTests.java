package tests.testng.tests;

import org.testng.annotations.Test;
import pages.booking.BookingHomeXPath;
import pages.booking.BookingSearchResultsXPath;
import tests.BaseTest;
import utils.Waiters;

public class BookingParisSearchTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public final BookingSearchResultsXPath bookingSearchResultPage = new BookingSearchResultsXPath();

    public final Waiters waiters = new Waiters();
    @Test
    public void BookingParisSearch() {


        waiters.waitForPageLoaded();
        bookingHomePage.getBookingStartPage();
        bookingHomePage.closeRegistrationAlert();
        bookingHomePage.getLocationSearchField("Париж");
        bookingHomePage.locationSelectionParis();
        bookingHomePage.datesFromTo(3, 10);
        bookingHomePage.getOccupancyPopup();
        bookingHomePage.addAdult();
        bookingHomePage.addAdult();
        bookingHomePage.addRoom();
        bookingHomePage.submitOcupancy();
        bookingHomePage.submitSearch();
        waiters.waitForPageLoaded();
        bookingSearchResultPage.waitForRatingContainer();
        bookingSearchResultPage.selectRating6Checkbox();
        bookingSearchResultPage.verifyRatingApplied();
        bookingSearchResultPage.expandFilter();
        bookingSearchResultPage.selectFilter();
        //ToDo
        bookingSearchResultPage.checkOutFinalRating();
        //bookingSearchResultPage.getRatingToCompare(bookingSearchResultPage.ratingToCompare);

        System.out.println("BookingParisSearch test passed");
    }
}