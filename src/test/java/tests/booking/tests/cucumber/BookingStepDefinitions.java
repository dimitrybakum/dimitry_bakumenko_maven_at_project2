package tests.booking.tests.cucumber;

import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import page.objects.booking.xpath.BookingHomePageXpath;
import page.objects.booking.xpath.BookingSearchPageXpath;
import page.objects.booking.xpath.BookingSignInPageXpath;
import utils.Clicker;
import utils.Screenshot;
import utils.Waiters;

import java.io.IOException;

import static driver.Driver.getWebDriver;
import static page.objects.booking.xpath.BookingHomePageXpath.*;
import static page.objects.booking.xpath.BookingSearchPageXpath.*;
import static page.objects.booking.xpath.TrashMailPageXpath.final_temp_email_address;

public class BookingStepDefinitions {

    private static final Logger LOGGER = LogManager.getLogger(BookingStepDefinitions.class);
    public final BookingHomePageXpath bookingHomePage = new BookingHomePageXpath();
    public final BookingSearchPageXpath bookingSearchResultPage = new BookingSearchPageXpath();
    public final BookingSignInPageXpath bookingSignInPageXpath = new BookingSignInPageXpath();

    public final Waiters waiters = new Waiters();
    public final Screenshot screenshot = new Screenshot();
    public final Clicker clicker = new Clicker();
    public final String RATING_CONTAINER_XPATH = "//*[contains(text(),'Оценка по отзывам')]";
    public final String EMAIL = "dimitrybakum@gmail.com";
    public final String PWD = "1234567!Q1q";

    @Given("navigate to booking home page")
    public void navigate_to_booking_home_page() {
        bookingHomePage.getPage("https://booking.com");

    }

    @Given("switch to iframe")
    public void switch_to_iframe() {
            getWebDriver().switchTo().frame(0);
            LOGGER.info("switched");
    }

    @Given("select london from search results")
    public void select_london_from_search_results() throws InterruptedException {
        waiters.waitForPageLoaded(5);
        waiters.waitForElement(londonSearchFirstResultXpath);
        bookingHomePage.locationSelection(londonSearchFirstResultXpath);

    }

    @Given("select paris from search results")
    public void select_paris_from_search_results() throws InterruptedException {
        waiters.waitForPageLoaded(5);
        waiters.waitForElement(parisSearchFirstResultXpath);
        bookingHomePage.locationSelection(parisSearchFirstResultXpath);

    }

    @Given("select praha from search results")
    public void select_praha_from_search_results() throws InterruptedException {
        waiters.waitForPageLoaded(5);
        waiters.waitForElement(prahaSearchFirstResultXpath);
        bookingHomePage.locationSelection(prahaSearchFirstResultXpath);

    }

    @When("wait for {int} seconds")
    public void wait_for_page_loaded(int seconds) {
        waiters.waitForSeconds(seconds);
        LOGGER.info("waiting for " + seconds + " seconds");
    }

    @When("wait for page loaded")
    public void wait_for_page_loaded() {
        waiters.waitForPageLoaded(10);
        LOGGER.info("page loaded");
    }

    @When("wait for registration alert")
    public void wait_for_registration_alert() throws InterruptedException {
        waiters.waitForElement(REGISTRATION_ALERT_XPATH);
        LOGGER.info("registration alert is displayed");
    }


    @When("close alert")
    public void close_alert() throws InterruptedException {
        waiters.waitForElement(REGISTRATION_ALERT_XPATH);
        bookingHomePage.closeRegistrationAlert(REGISTRATION_ALERT_XPATH);
    }

    @When("type in search field {string}")
    public void type_in_search_field(String string) {
        getWebDriver().findElement(By.xpath(destinationSearchField)).sendKeys(string);
    }

    @When("type in email {string}")
    public void type_in_email(String string) {
        getWebDriver().findElement(By.xpath(BookingSignInPageXpath.signInEmailField)).sendKeys(string);
        LOGGER.info("email entered");
    }

    @When("type in pwd {string}")
    public void type_in_pwd(String string) {
        getWebDriver().findElement(By.id("password")).sendKeys(string);
        LOGGER.info("pwd entered");
    }

    @Then("click [Submit] button")
    public void click_submit_button() {
        clicker.click(SUBMIT_SEARCH_BUTTON_XPATH);
        LOGGER.info("submitted");
    }

    @Then("press button")
    public void press_button() {
        WebElement clickAndHoldButton = getWebDriver().findElement(By.xpath("//div[@aria-label='Нажать и удерживать']//p"));
        Actions actions = new Actions(getWebDriver());
        actions.clickAndHold(clickAndHoldButton);
        LOGGER.info("button pressed");
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
        LOGGER.info("screenshot...");
    }

    @Then("select dates in {int} out {int}")
    public void selectDatesInOut(int arg0, int arg1) {
        bookingHomePage.datesFromTo(arg0, arg1);
        LOGGER.info("booked from " + arg0 + " to " + arg1);
    }

    @Then("select {int} persons and {int} rooms")
    public void selectPersonsAndRooms(int arg0, int arg1) {
        bookingHomePage.bookPersonsRooms(arg0, arg1);
    }

    @Then("destroy driver")
    public void destroy_driver() {
        LOGGER.info("driver destroyer in progress..");
        Driver.destroy();
    }

    @Then("wait for element {string}")
    public void waitForElement(String string) throws InterruptedException {
        waiters.waitForElement(string);
        LOGGER.info("waiting for element " + string);
    }

    @Then("select rating {int} checkbox")
    public void selectRatingCheckbox(int rating) {
        bookingHomePage.selectRating(rating);
    }

    @Then("close date picker")
    public void closeDatepicker() {
        getWebDriver().findElement(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[2]/div/div[2]/div[3]/div[1]/div[3]/div[1]/h2")).click();
        LOGGER.info("date picker closed");
    }

    @Then("wait for new tab")
    public void waitNewTab() {
        waiters.waitForNewTab(5);
        LOGGER.info("switching to new tab..");
    }

    @When("scroll to rating container")
    public void scrollToRetingContainer() {
        bookingSearchResultPage.scrollIntoView(RATING_CONTAINER_XPATH);
    }

    @Then("click on {string} button")
    public void clickOnButton(String string) {
        //bookingSearchResultPage.scrollIntoView(string);
        clicker.click(string);
        LOGGER.info("button " + string + " clicked");
    }
//    @Given("click on {string} button")
//    public void clickOnButton(String string) {
//        clicker.click(string);
//    }

    @Then("expand filters")
    public void expandFilters() {
        bookingSearchResultPage.scrollIntoView(expandSortingFilterXpath);
        clicker.click(expandSortingFilterXpath);
        LOGGER.info("filter is expanded");
    }

    @Then("select filter from min to max")
    public void selectFilterFromMinToMax() {
        clicker.click(selectFilterXpath);
        LOGGER.info("fromMinToMax filter selected");
    }

    @Then("check out rating for Paris should be {string}")
    public void checkOutParisRating(String string) {
        Assert.assertEquals(getWebDriver().findElement(By.xpath(RATING_TO_COMPARE_XPATH)).getText(), string, "Rating of the first sorted hotel is differ than expected");
        LOGGER.info("comparing ratings for Paris");
    }

    @Then("check out rating for Praha should be 9")
    public void checkOutPrahaRating() {
        Assert.assertEquals(getWebDriver().findElement(By.xpath(ratingForCompareXpath)).getText(), "9,0\n" +
                "Оценка 9", "Rating of the first sorted hotel differ than expected. 9,0\n" +
                "Оценка 9");
        LOGGER.info("comparing ratings for Praha");
    }

    @Then("click on signUp button")
    public void SignUp() {
        clicker.click("//*[@id=\"b2indexPage\"]/div[2]/div/div/header/nav[1]/div[2]/a[2]");
        LOGGER.info("registration page loaded");
    }
    @When("fill out temp email")
    public void real_email() {
        getWebDriver().findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(final_temp_email_address);
        LOGGER.info("email entered");
    }
    @When("click on create account button")
    public void create_account_btn() {
        getWebDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/form/div/button")).click();
        LOGGER.info("email entered");
    }
}