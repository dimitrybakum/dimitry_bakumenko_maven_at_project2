package pages.booking;

import driver.DriverInit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

import static org.testng.AssertJUnit.assertEquals;

public class BookingParisCSSTests {

    WebDriver driver = DriverInit.getWebDriver();

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testParis() throws InterruptedException {
        LocalDate currentDate = LocalDate.now();
        LocalDate fromDate = currentDate.plusDays(3);
        LocalDate toDate = fromDate.plusDays(6);
        String closeAlertButton = "[aria-label='Скрыть меню входа в аккаунт.']";
        String placeToVisit = "[id=':re:']";
        String searchValue = "#autocomplete-result-0 > div > div > div > :first-of-type";
        String datePickerFrom = "[data-testid='searchbox-datepicker-calendar'] [aria-label*='" + fromDate.getDayOfMonth() + "']";
        String datePickerTo = "[data-testid='searchbox-datepicker-calendar'] [aria-label*='" + toDate.getDayOfMonth() + "']";
        String occupancy = "[data-testid='occupancy-config']";
        String adultsSelection = "[data-testid='occupancy-popup'] :nth-child(1) :nth-child(3)";
        String roomsSelection = "[data-testid='occupancy-popup'] >div > div:nth-child(3)> div:nth-child(3) > button:last-of-type";
        String occupancySubmit = "[data-testid='occupancy-popup'] button";
        String searchButton = "[data-testid='searchbox-layout-wide'] div:nth-of-type(4)";
        String rating6Checkbox = "[data-testid='filters-group-label-container'] :contains('Достаточно хорошо: 6+')";
        String reviewRatingContainer = "[id='filter_group_review_score_:r1j:'][id^='filter_group_review_score'] h3";
        String popularityDD = "[data-testid='sorters-dropdown-trigger']";
        String sorting = "[data-testid='sorters-dropdown-trigger']";
        String sortFromLowToHigh = ":contains('Оценка объекта (по возрастанию)')";
        String ratingToCompare = "[data-testid='property-card'] :first-child [data-testid='review-score'] :first-child";

        driver.get("https://www.booking.com/");

        driver.findElement(By.cssSelector(closeAlertButton)).click();
        driver.findElement(By.cssSelector(placeToVisit)).sendKeys("Париж");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector(searchValue)).click();
        driver.findElement(By.cssSelector(datePickerFrom)).click();
        driver.findElement(By.cssSelector(datePickerTo)).click();
        driver.findElement(By.cssSelector(occupancy)).click();
        driver.findElement(By.cssSelector(adultsSelection)).click();
        driver.findElement(By.cssSelector(adultsSelection)).click();
        driver.findElement(By.cssSelector(roomsSelection)).click();
        driver.findElement(By.cssSelector(occupancySubmit)).click();
        driver.findElement(By.cssSelector(searchButton)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(reviewRatingContainer)));
        WebElement checkbox = driver.findElement(By.cssSelector(rating6Checkbox));
        checkbox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, checkbox.isSelected()));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(popularityDD)));
        WebElement popularity = driver.findElement(By.cssSelector(popularityDD));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popularity);
        driver.findElement(By.cssSelector(sorting)).click();
        driver.findElement(By.cssSelector(sortFromLowToHigh)).click();
        assertEquals("Rating of the first sorted hotel is differ than expected", "Оценка 6,3", driver.findElement(By.cssSelector(ratingToCompare)).getText());
    }

    @After
    public void closeWindow() {
        driver.close();
    }
}
