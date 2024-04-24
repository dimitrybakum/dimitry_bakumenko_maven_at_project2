package tests.testng.tests;

import org.testng.annotations.Test;
import pages.booking.BookingHomeXPath;
import tests.BaseTest;
import utils.Waiters;

public class BookingTooltipTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();

    public final Waiters waiters = new Waiters();
    @Test
    public void BookingTooltips() {
        bookingHomePage.getBookingStartPage();
        waiters.waitForPageLoaded();
        bookingHomePage.closeRegistrationAlert();
        bookingHomePage.hoverCurrencyElement();
        bookingHomePage.verifyCurrencyElementContainsText("Выберите валюту");
        bookingHomePage.hoverLanguageElement();
        bookingHomePage.verifyLanguageElementContainsText("Выберите язык");
        System.out.println("BookingTooltips test passed");
    }
}