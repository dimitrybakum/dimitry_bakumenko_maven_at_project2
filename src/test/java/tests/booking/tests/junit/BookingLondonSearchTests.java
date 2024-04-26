package tests.booking.tests.junit;
import org.junit.Test;

import page.objects.booking.BookingHomePageXpath;
import page.objects.booking.BookingSearchPageXpath;
import tests.BaseTest;
import utils.Clicker;
import utils.Screenshot;
import utils.Waiters;

import java.io.IOException;

import static page.objects.booking.BookingHomePageXpath.*;
import static page.objects.booking.BookingSearchPageXpath.*;

public class BookingLondonSearchTests extends BaseTest {
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final BookingSearchPageXpath bookingSearchResultPage = new BookingSearchPageXpath();
    public final Waiters waiters = new Waiters();
    public final Screenshot screenshot = new Screenshot();
    public final Clicker clicker = new Clicker();

    @Test
    public void BookingLondonSearch() throws IOException {
        waiters.waitForPageLoaded(5);
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
        bookingHomePage.destinationSearch("Лондон");
        bookingHomePage.locationSelection(londonSearchFirstResultXpath);
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
        waiters.waitForPageLoaded(5);
        bookingSearchResultPage.scrollIntoView(SEARCH_RESULT_10_XPATH);
        bookingSearchResultPage.changeElementBgcToGreen(SEARCH_RESULT_10_XPATH);
        bookingSearchResultPage.changeElementTitleColorToRed(SearchResult10TitleXpath);
        screenshot.getScreenshot("myScreenshot");
        System.out.println("BookingLondonSearch test passed");

    }
}