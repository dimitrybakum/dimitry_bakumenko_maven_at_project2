package tests.booking.tests.cucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import page.objects.booking.xpath.BookingHomePageXpath;
import page.objects.booking.xpath.BookingSearchPageXpath;
import utils.Screenshot;
import utils.Waiters;

import java.io.IOException;

import static driver.Driver.getWebDriver;
import static page.objects.booking.xpath.BookingHomePageXpath.*;
import static page.objects.booking.xpath.BookingSearchPageXpath.SEARCH_RESULT_10_XPATH;

public class BookingStepDefinitions {
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final BookingSearchPageXpath bookingSearchResultPage = new BookingSearchPageXpath();
    public final Waiters waiters = new Waiters();
    public final Screenshot screenshot = new Screenshot();
    @Given("navigate to booking home page")
    public void navigate_to_booking_home_page() {
        bookingHomePage.getPage("https://booking.com");
        //throw new io.cucumber.java.PendingException("sssss 1");
    }

    @When("wait for page loaded")
    public void wait_for_page_loaded() {
        waiters.waitForPageLoaded(5);
        waiters.waitForElement(REGISTRATION_ALERT_XPATH);
        //throw new io.cucumber.java.PendingException("hello 1");
    }
    @When("close alert")
    public void close_alert() {
        waiters.waitForElement(REGISTRATION_ALERT_XPATH);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
        //throw new io.cucumber.java.PendingException("hello 2");
    }

    @When("type in search field {string}")
    public void type_in_search_field(String string) {
        getWebDriver().findElement(By.xpath(destinationSearchField)).sendKeys(string);
        //throw new io.cucumber.java.PendingException("hello 3");
    }

    @Then("click [Search] button")
    public void click_search_button() {
        bookingHomePage.locationSelection(londonSearchFirstResultXpath);
        //throw new io.cucumber.java.PendingException("hello 4");
    }
    @Then("click [Submit] button")
    public void click_submit_button() {
        bookingHomePage.locationSelection(SUBMIT_SEARCH_BUTTON_XPATH);
        //throw new io.cucumber.java.PendingException("hello 4");
    }
    @Then("scroll to result 10")
    public void scroll_to_result_10() {
        bookingSearchResultPage.scrollIntoView(SEARCH_RESULT_10_XPATH);
        //throw new io.cucumber.java.PendingException("hello 4");
    }
    @Then("change ElementBgc To Green")
    public void change_elementBgc_to_green() {
        bookingSearchResultPage.changeElementBgcToGreen(SEARCH_RESULT_10_XPATH);
        //throw new io.cucumber.java.PendingException("hello 4");
    }
    @Then("change Element Title Color To Red")
    public void change_element_title_color_to_green() {
        bookingSearchResultPage.changeElementBgcToGreen(SEARCH_RESULT_10_XPATH);
        //throw new io.cucumber.java.PendingException("hello 4");
    }
    @Then("take screenshot")
    public void take_screenshot() throws IOException {
        screenshot.getScreenshot("myGherkinScreenshot");
    }

}