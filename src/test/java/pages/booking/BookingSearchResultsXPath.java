
package pages.booking;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiters;

import java.time.Duration;

import static driver.Driver.getWebDriver;

public class BookingSearchResultsXPath {
    public final Waiters waiters = new Waiters();
    public static String ratingForCompareXpath = "//div[@data-testid='review-score-component']/div";
    public static String searchResult_10_xpath = "//div[@data-testid=\"property-card\"][10]";
    public static String getSearchResult_10_title_xpath = "//div[@data-testid=\"property-card\"][10]//div[@data-testid='title']";
    public static String selectRating_6_CheckboxXpath = "//div[@data-testid='filters-group-label-container']/div[contains(text(),'Достаточно хорошо: 6+')]";
    public static String ratingAppliedFilterAppearsXpath = "//div[@class='a1d43fa1ac']/div/label/input[@checked]";
    public static String ratingContainerXpath = "//*[contains(text(),'Оценка по отзывам')]";
    public static String expandSortingFilterXpath = "//button[@data-testid='sorters-dropdown-trigger']";
    public static String selectFilterXpath = "//span[contains(text(), 'Оценка объекта (по возрастанию)')]";
    public void scrollIntoView(String elemXpath) {
        waiters.explicitWait();
        WebElement element = getWebDriver().findElement(By.xpath(elemXpath));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void changeElementTitleColorToRed(String elemXpath) {
        WebElement element = getWebDriver().findElement(By.xpath(elemXpath));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.color = 'red'", element);
    }
    public void changeElementBgcToGreen(String elemXpath) {
        WebElement element = getWebDriver().findElement(By.xpath(elemXpath));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.backgroundColor = 'green'", element);
    }
    public void getRatingToCompare(String string) {
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(webDriver -> getWebDriver().findElement(By.xpath(string)));
        String propertyRating = String.valueOf(getWebDriver().findElement(By.xpath(string)).getText());
        String result = propertyRating.substring(0, 3);
        String numberString = result.replace(",", ".");
        double actualPropertyRating = Double.parseDouble(numberString);
        double expectedRating = 5.0;
        if (actualPropertyRating < expectedRating) {
            System.out.println("Что то пошло не так, рейтинг отеля < 9!");
        } else {
            System.out.println("Все верно, рейтинг отеля >= 9");
        }
    }

}
