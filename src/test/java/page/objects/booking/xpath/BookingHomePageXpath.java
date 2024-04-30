package page.objects.booking.xpath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

import static driver.Driver.getWebDriver;

public class BookingHomePageXpath {

    private static final Logger LOGGER = LogManager.getLogger(BookingHomePageXpath.class);
    public final static String BOOKING_HOME_PAGE = "https://www.booking.com/";
    public final static String REGISTRATION_ALERT_XPATH = "//button[@aria-label='Скрыть меню входа в аккаунт.']";
    public final static String SUBMIT_SEARCH_BUTTON_XPATH = "//button[@type='submit']";
    public final static String RATING_TO_COMPARE_XPATH = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div";
    public static String londonSearchFirstResultXpath = "//div[text()='Большой Лондон, Великобритания']";
    public static String parisSearchFirstResultXpath = "//div[text()='Иль-де-Франс, Франция']";
    public static String prahaSearchFirstResultXpath = "//div[text()='Чехия']";
    public static String occurancyXpath = "//button[@data-testid=\"occupancy-config\"]";
    public static String addAdultXpath = "//*[@data-testid='occupancy-popup']/div/div[1]/div[2]/button[2]";
    public static String addRoomXpath = "//*[@data-testid='occupancy-popup']/div/div[3]/div[2]/button[2]";
    public static String submitOcupancyXpath = "//*[@data-testid='occupancy-popup']/button/*[contains(text(),'Готово')]";
    public static String getTopSearchResultXpath = "//div[@data-testid='property-card-container']//div[@data-testid='title']";
    public static String closeDatePickerXpath = "//span[contains(text(), 'Дата заезда')]";
    public static String currencyElementXpath = "//*[@data-testid='header-currency-picker-trigger']";
    public static String currencyElementTooltipXpath = "//div[@class='a0ac0ffd76 eb4b382ac4 f38a56c611']//*[contains(text(),'Выберите валюту')]";
    public static String languageElementXpath = "//*[@data-testid='header-language-picker-trigger']";
    public static String languageElementTooltipXpath = "//div[@class='a0ac0ffd76 eb4b382ac4 f38a56c611']//*[contains(text(),'Выберите язык')]";
    public static String destinationSearchField = "//*[@id=':re:']";
    public void getPage(String url) {

        getWebDriver().get(url);
        LOGGER.info("booking home page loaded");
    }

    public void bookPersonsRooms(int peoples, int rooms) {
        getWebDriver().findElement(By.xpath(occurancyXpath)).click();
        for (int defaultAdultsQty = 2; defaultAdultsQty < peoples; defaultAdultsQty++) {
            getWebDriver().findElement(By.xpath(addAdultXpath)).click();
        }
        for (int defaultRoomsQty = 1; defaultRoomsQty < rooms; defaultRoomsQty++) {
            getWebDriver().findElement(By.xpath(addRoomXpath)).click();
        }
        getWebDriver().findElement(By.xpath(submitOcupancyXpath)).click();
        LOGGER.info("booked "+rooms+" rooms for " + peoples + " peoples");
    }

    public void closeRegistrationAlert(String string) {
        getWebDriver().findElement(By.xpath(string)).click();
        LOGGER.info("registration alert is closed");

    }

    public void destinationSearch(String string) {
        getWebDriver().findElement(By.xpath(destinationSearchField)).sendKeys(string);
        LOGGER.info("Destination entered");
    }

    public void locationSelection(String string) {
        getWebDriver().findElement(By.xpath(string)).click();
        LOGGER.info("searsh field with value " + string);
    }

    public void selectRating(int rating) {
        getWebDriver().findElement(By.xpath(String.format("//*[@data-testid='filters-group']//div[@data-filters-item='review_score:review_score=%s0']//*[@type='checkbox']", rating))).click();
        LOGGER.info("checkbox with rating " + rating + " checked");
    }

    //ToDo Refactor datePicker. No selection for next month
    public void datesFromTo(int checkInDate, int checkOutDate) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        int checkInDay = currentDate.plusDays(checkInDate).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        String checkInXpath = String.format(pathToDay, checkInDay);
        WebElement elem1 = getWebDriver().findElement(By.xpath(checkInXpath));
        elem1.click();


        int checkOutDay = currentDate.plusDays(checkOutDate).getDayOfMonth();
        int checkMonth = currentDate.plusDays(checkOutDate).getMonthValue();
        String checkOutXpath = String.format(pathToDay, checkOutDay);
        WebElement elem2 = getWebDriver().findElement(By.xpath(checkOutXpath));
        elem2.click();
        //ToDo Refactor datePicker. No selection for next month
    }


}
