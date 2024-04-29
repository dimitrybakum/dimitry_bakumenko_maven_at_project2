package tests.booking.tests.cucumber;

import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import page.objects.booking.xpath.BookingHomePageXpath;
import page.objects.booking.xpath.BookingSearchPageXpath;
import utils.Clicker;
import utils.Screenshot;
import utils.Waiters;

import java.io.IOException;

import static driver.Driver.getWebDriver;
import static page.objects.booking.xpath.BookingHomePageXpath.*;
import static page.objects.booking.xpath.BookingSearchPageXpath.*;

public class BookingStepDefinitions {
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final BookingSearchPageXpath bookingSearchResultPage = new BookingSearchPageXpath();
    public final Waiters waiters = new Waiters();
    public final Screenshot screenshot = new Screenshot();
    public final Clicker clicker = new Clicker();
    @Given("navigate to booking home page")
    public void navigate_to_booking_home_page() {
        bookingHomePage.getPage("https://booking.com");
    }
    @Given("select london from search results")
    public void select_london_from_search_results() {
        waiters.waitForPageLoaded(5);
        waiters.waitForElement(londonSearchFirstResultXpath);
        bookingHomePage.locationSelection(londonSearchFirstResultXpath);
    }
    @Given("select paris from search results")
    public void select_paris_from_search_results() {
        waiters.waitForPageLoaded(5);
        waiters.waitForElement(parisSearchFirstResultXpath);
        bookingHomePage.locationSelection(parisSearchFirstResultXpath);
    }

    @When("wait for page loaded")
    public void wait_for_page_loaded() {
        waiters.waitForPageLoaded(5);
    }
    @When("wait for registration alert")
    public void wait_for_registration_alert() {
        waiters.waitForElement(REGISTRATION_ALERT_XPATH);
    }
    @When("close alert")
    public void close_alert() {
        waiters.waitForElement(REGISTRATION_ALERT_XPATH);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
    }

    @When("type in search field {string}")
    public void type_in_search_field(String string) {
        getWebDriver().findElement(By.xpath(destinationSearchField)).sendKeys(string);
    }

    @Then("click [Search] button")
    public void click_search_button() {
        bookingHomePage.locationSelection(londonSearchFirstResultXpath);
    }
    @Then("click [Submit] button")
    public void click_submit_button() {
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
    }
    @Then("scroll to result 10")
    public void scroll_to_result_10() {
        bookingSearchResultPage.scrollIntoView(SEARCH_RESULT_10_XPATH);
    }
    @Then("change ElementBgc To Green")
    public void change_elementBgc_to_green() {
        bookingSearchResultPage.changeElementBgcToGreen(SEARCH_RESULT_10_XPATH);
    }
    @Then("change Element Title Color To Red")
    public void change_element_title_color_to_green() {
        bookingSearchResultPage.changeElementBgcToGreen(SEARCH_RESULT_10_XPATH);
    }
    @Then("take screenshot")
    public void take_screenshot() throws IOException {
        waiters.waitForPageLoaded(5);
        screenshot.getScreenshot("myGherkinScreenshot");
    }

    @Then("select dates in {int} out {int}")
    public void selectDatesInOut(int arg0, int arg1) {
        bookingHomePage.datesFromTo(arg0, arg1);
    }

    @Then("select {int} persons and {int} rooms")
    public void selectPersonsAndRooms(int arg0, int arg1) {
        bookingHomePage.bookPersonsRooms(arg0,arg1);
    }

    @Then("destroy driver")
    public void destroy_driver() {
        Driver.destroy();
    }

    @Then("wait for element {string}")
    public void waitForElement(String arg0) {
        waiters.waitForElement(arg0);
    }

    @Then("select rating {int} checkbox")
    public void selectRatingCheckbox(int arg0) {
        bookingHomePage.selectRating(arg0);
    }

    @Then("close date picker")
    public void closeDatepicker() {
        getWebDriver().findElement(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[2]/div/div[1]/div/form/div[1]/div[2]/div/div[1]")).click();
    }

    @When("scroll to rating container")
    public void scrollToRetingContainer() {
        bookingSearchResultPage.scrollIntoView(RATING_CONTAINER_XPATH);
    }

    @Then("click on {string} button")
    public void clickOnButton(String string) {
        bookingSearchResultPage.scrollIntoView(string);
        clicker.click(string);
    }

    @Then("expand filters")
    public void expandFilters() {
        bookingSearchResultPage.scrollIntoView(expandSortingFilterXpath);
        clicker.click(expandSortingFilterXpath);
    }

    @Then("select filter from min to max")
    public void selectFilterFromMinToMax() {
        clicker.click(selectFilterXpath);
    }

    @Then("check out rating should be {string}")
    public void checkOutRatingShouldBe(String string) {
        Assert.assertEquals(getWebDriver().findElement(By.xpath(RATING_TO_COMPARE_XPATH)).getText(), string, "Rating of the first sorted hotel is differ than expected");
    }
}