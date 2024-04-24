package tests.testng.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.booking.BookingHomeXPath;
import tests.BaseTest;
import utils.Clicker;
import utils.Hover;
import utils.Waiters;

import static driver.Driver.getWebDriver;
import static pages.booking.BookingHomeXPath.*;

public class BookingTooltipTests extends BaseTest {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public final Clicker clicker = new Clicker();
    public final Waiters waiters = new Waiters();
    public final Hover hover = new Hover();
    @Test
    public void BookingTooltips() {
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        waiters.waitForPageLoaded(20);
        clicker.click(REGISTRATION_ALERT_XPATH);
        hover.hoverOverElement(currencyElementXpath);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(currencyElementTooltipXpath)).getText(), "Выберите валюту", "Caution! different text for currency tooltip");
        hover.hoverOverElement(languageElementXpath);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(languageElementTooltipXpath)).getText(), "Выберите язык", "Caution! different text for language tooltip");
        System.out.println("BookingTooltips test passed");
    }
}