
package pages.booking;

import driver.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Waiters;

import java.time.Duration;

public class BookingSearchResultsXPath {
    public final Waiters waiters = new Waiters();
    public String ratingToCompare = "//div[@data-testid='review-score-component']/div";
    //WebDriver driver = Driver.getWebDriver();

//    @Before
//    public void setUp() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }

//    @Test
//    public void testParis() {
//
//        String rating6Checkbox = "//div[@data-testid='filters-group-label-container']/div[contains(text(),'Достаточно хорошо: 6+')]";
//        String reviewRatingContainer = "//*[contains(text(),'Оценка по отзывам')]";
//        String popularityDD = "//button[@data-testid='sorters-dropdown-trigger']";
//        String ratingApplied = "//div[@class='a1d43fa1ac']/div/label/input[@checked]";
//        String sorting = "//button[@data-testid='sorters-dropdown-trigger']";
//        String sortFromLowToHigh = "//span[contains(text(), 'Оценка объекта (по возрастанию)')]";
//        String ratingToCompare = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div";

//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(reviewRatingContainer)));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(reviewRatingContainer)));
//        WebElement checkbox = driver.findElement(By.xpath(rating6Checkbox));
//        checkbox.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, checkbox.isSelected()));
//
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ratingApplied)));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        WebElement popularity = driver.findElement(By.xpath(popularityDD));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popularity);
//        driver.findElement(By.xpath(sorting)).click();
//        driver.findElement(By.xpath(sortFromLowToHigh)).click();
//        assertEquals("Rating of the first sorted hotel is differ than expected", "Оценка 6,3", driver.findElement(By.xpath(ratingToCompare)).getText());
//        driver.close();
//    }
    public void scrollToResult10() {
        waiters.explicitWait();
        WebElement element = DriverInit.driver.findElement(By.xpath("//div[@class='d4924c9e74']/div[22]"));
        ((JavascriptExecutor) DriverInit.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void changeResult10TitleColor() {
        WebElement element = DriverInit.driver.findElement(By.xpath("//div[@data-testid=\"property-card\"][10]//div[@data-testid='title']"));
        ((JavascriptExecutor) DriverInit.driver).executeScript("arguments[0].style.color = 'red'", element);
    }
    public void changeResult10Bgc() {
        WebElement element = DriverInit.driver.findElement(By.xpath("//div[@data-testid=\"property-card\"][10]"));
        ((JavascriptExecutor) DriverInit.driver).executeScript("arguments[0].style.backgroundColor = 'green'", element);
    }
    public void waitForRatingContainer() {
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(DriverInit.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Оценка по отзывам')]")));
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void selectRating6Checkbox () {
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement checkbox = DriverInit.driver.findElement(By.xpath("//div[@data-testid='filters-group-label-container']/div[contains(text(),'Достаточно хорошо: 6+')]"));
        checkbox.click();
        WebDriverWait wait = new WebDriverWait(DriverInit.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, checkbox.isSelected()));
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void verifyRatingApplied() {
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(DriverInit.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='a1d43fa1ac']/div/label/input[@checked]")));
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void expandFilter() {
        WebElement popularity = DriverInit.driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']"));
        DriverInit.driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();

    }
    public void selectFilter() {
        DriverInit.driver.findElement(By.xpath("//span[contains(text(), 'Оценка объекта (по возрастанию)')]")).click();
    }

    public void checkOutFinalRating() {
        Assert.assertEquals("Rating of the first sorted hotel is differ than expected", "Оценка 6,3", DriverInit.driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div")).getText());
    }
    public void getRatingToCompare(String string) {
        new WebDriverWait(DriverInit.driver, Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(webDriver -> DriverInit.driver.findElement(By.xpath(string)));
        String propertyRating = String.valueOf(DriverInit.driver.findElement(By.xpath(string)).getText());
        String result = propertyRating.substring(0, 3);
        String numberString = result.replace(",", ".");
        double actualPropertyRating = Double.parseDouble(numberString);
        double expectedRating = 9.0;
        if (actualPropertyRating < expectedRating) {
            System.out.println("Что то пошло не так, рейтинг отеля < 9!");
        } else {
            System.out.println("Все верно, рейтинг отеля >= 9");
        }
    }

}
