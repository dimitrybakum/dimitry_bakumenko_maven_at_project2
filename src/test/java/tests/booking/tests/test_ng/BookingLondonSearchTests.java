package tests.booking.tests.test_ng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.objects.booking.xpath.BookingHomePageXpath;
import page.objects.booking.xpath.BookingSearchPageXpath;
import tests.BaseTest;
import tools.EventListener;
import utils.Clicker;
import utils.Screenshot;
import utils.Waiters;

import java.io.IOException;

import static page.objects.booking.xpath.BookingHomePageXpath.*;
import static page.objects.booking.xpath.BookingSearchPageXpath.SEARCH_RESULT_10_XPATH;
import static page.objects.booking.xpath.BookingSearchPageXpath.SearchResult10TitleXpath;
@Listeners(EventListener.class)
public class BookingLondonSearchTests extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BookingLondonSearchTests.class);
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final BookingSearchPageXpath bookingSearchResultPage = new BookingSearchPageXpath();
    public final Waiters waiters = new Waiters();
    public final Screenshot screenshot = new Screenshot();
    public final Clicker clicker = new Clicker();

    @Test(description = "157941")
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
        LOGGER.info("BookingLondonSearch test passed");

    }
}