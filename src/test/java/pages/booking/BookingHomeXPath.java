package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

import static driver.Driver.getWebDriver;

public class BookingHomeXPath {
    public final static String BOOKING_HOME_PAGE = "https://www.booking.com/";
    public final static String REGISTRATION_ALERT_XPATH = "//button[@aria-label='Скрыть меню входа в аккаунт.']";
    public final static String SUBMIT_SEARCH_BUTTON_XPATH = "//button[@type=\"submit\"]";
    public static String rating9CheckboxXpath = "//*[@data-testid='filters-group']//div[@data-filters-item='review_score:review_score=90']//*[@type='checkbox']";
    public static String ratingAppliedXpath = "//div[@class='a1d43fa1ac']/div/label/input[@checked]";
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

    public static String ratingToCompareXpath = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div";
    public void getPage(String url) {

        getWebDriver().get(url);
    }

    public void closeRegistrationAlert(String string) {
        getWebDriver().findElement(By.xpath(string)).click();
    }

    public void getLocationSearchField(String location) {
        getWebDriver().findElement(By.xpath("//*[@id=':re:']")).sendKeys(location);
    }

    public void locationSelection(String string) {
        getWebDriver().findElement(By.xpath(string)).click();
    }

    public void waitForRatingApplied(String string) {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(string)));
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
