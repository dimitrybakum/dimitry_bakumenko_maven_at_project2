
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
import static pages.booking.BookingSearchResultsXPath.ratingContainerXpath;
import static pages.booking.BookingSearchResultsXPath.ratingForCompareXpath;

public class BookingPrahaSearchTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public final Clicker clicker = new Clicker();
    public final Waiters waiters = new Waiters();
    @Test
    public void BookingPrahaSearch() {
        waiters.waitForPageLoaded(20);
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
        bookingHomePage.getLocationSearchField("Прага");
        bookingHomePage.locationSelection(prahaSearchFirstResultXpath);
        clicker.click(closeDatePickerXpath);
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
        waiters.waitForPageLoaded(20);
        waiters.waitForElement(ratingContainerXpath);
        clicker.click(rating9CheckboxXpath);
        bookingHomePage.waitForRatingApplied(ratingAppliedXpath);
        clicker.click(getTopSearchResultXpath);
        waiters.waitForNewTab(5);
        waiters.waitForPageLoaded(20);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(ratingForCompareXpath)).getText(), "9,0\n" +
                "Оценка 9", "Rating of the first sorted hotel differ than expected. 9,0\n" +
                "Оценка 9");

        System.out.println("BookingPrahaSearch test passed");

    }
}