package tests.booking.tests.test_ng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.objects.booking.xpath.BookingHomePageXpath;
import tests.BaseTest;
import tools.EventListener;
import utils.Clicker;
import utils.Hover;
import utils.Waiters;

import static driver.Driver.getWebDriver;
import static page.objects.booking.xpath.BookingHomePageXpath.*;
@Listeners(EventListener.class)
public class BookingTooltipTests extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BookingTooltipTests.class);
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final Clicker clicker = new Clicker();
    public final Waiters waiters = new Waiters();
    public final Hover hover = new Hover();
    @Test(description = "157944")
    public void BookingTooltips() {
        bookingHomePage.getPage(BOOKING_HOME_PAGE);
        waiters.waitForPageLoaded(20);
        clicker.click(REGISTRATION_ALERT_XPATH);
        hover.hoverOverElement(currencyElementXpath);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(currencyElementTooltipXpath)).getText(), "Выберите валюту", "Caution! different text for currency tooltip");
        hover.hoverOverElement(languageElementXpath);
        Assert.assertEquals(getWebDriver().findElement(By.xpath(languageElementTooltipXpath)).getText(), "Выберите язык", "Caution! different text for language tooltip");
        LOGGER.info("BookingTooltips test passed");
    }
}