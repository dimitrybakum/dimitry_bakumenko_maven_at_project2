
package page.objects.booking.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Waiters;

import static driver.Driver.getWebDriver;

public class BookingSearchPageXpath {
    public final Waiters waiters = new Waiters();

    public final static String SEARCH_RESULT_10_XPATH = "//div[@data-testid=\"property-card\"][10]";
    public final static String RATING_APPLIED_XPATH = "//div[@class='a1d43fa1ac']/div/label/input[@checked]";
    public final static String RATING_CONTAINER_XPATH = "//*[contains(text(),'Оценка по отзывам')]";
    public static String expandSortingFilterXpath = "//button[@data-testid='sorters-dropdown-trigger']/span[2]";
    public static String selectFilterXpath = "//span[contains(text(), 'Оценка объекта (по возрастанию)')]";
    public static String ratingForCompareXpath = "//div[@data-testid='review-score-component']/div";
    public static String SearchResult10TitleXpath = "//div[@data-testid='property-card'][10]//div[@data-testid='title']";

    public void scrollIntoView(String string) {
        waiters.explicitWait();
        WebElement element = getWebDriver().findElement(By.xpath(string));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void changeElementTitleColorToRed(String string) {
        WebElement element = getWebDriver().findElement(By.xpath(string));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.color = 'red'", element);
    }

    public void changeElementBgcToGreen(String string) {
        WebElement element = getWebDriver().findElement(By.xpath(string));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.backgroundColor = 'green'", element);
    }

}
