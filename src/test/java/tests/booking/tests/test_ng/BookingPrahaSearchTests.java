package tests.booking.tests.test_ng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.booking.xpath.BookingHomePageXpath;
import tests.BaseTest;
import utils.Clicker;
import utils.Waiters;

import static driver.Driver.getWebDriver;
import static page.objects.booking.xpath.BookingHomePageXpath.*;
import static page.objects.booking.xpath.BookingSearchPageXpath.*;

public class BookingPrahaSearchTests extends BaseTest {
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final Clicker clicker = new Clicker();
    public final Waiters waiters = new Waiters();
    @Test
    public void BookingPrahaSearch() throws InterruptedException {
        waiters.waitForPageLoaded(5);
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
        bookingHomePage.destinationSearch("Прага");
        bookingHomePage.locationSelection(prahaSearchFirstResultXpath);
        clicker.click(closeDatePickerXpath);
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
        waiters.waitForPageLoaded(20);
        waiters.waitForElement(RATING_CONTAINER_XPATH);
        bookingHomePage.selectRating(9);
        waiters.waitForElement(RATING_APPLIED_XPATH);
        clicker.click(getTopSearchResultXpath);
        waiters.waitForNewTab(5);
        waiters.waitForPageLoaded(5);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(ratingForCompareXpath)).getText(), "9,0\n" +
                "Оценка 9", "Rating of the first sorted hotel differ than expected. 9,0\n" +
                "Оценка 9");

        System.out.println("BookingPrahaSearch test passed");

    }
}