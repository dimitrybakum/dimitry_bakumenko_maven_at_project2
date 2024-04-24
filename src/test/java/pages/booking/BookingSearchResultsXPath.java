
package pages.booking;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Waiters;

import java.time.Duration;

import static driver.Driver.getWebDriver;

public class BookingSearchResultsXPath {
    public final Waiters waiters = new Waiters();
    public String ratingToCompare = "//div[@data-testid='review-score-component']/div";
    public void scrollToResult10() {
        waiters.explicitWait();
        WebElement element = getWebDriver().findElement(By.xpath("//div[@class='d4924c9e74']/div[22]"));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void changeResult10TitleColor() {
        WebElement element = getWebDriver().findElement(By.xpath("//div[@data-testid=\"property-card\"][10]//div[@data-testid='title']"));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.color = 'red'", element);
    }
    public void changeResult10Bgc() {
        WebElement element = getWebDriver().findElement(By.xpath("//div[@data-testid=\"property-card\"][10]"));
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].style.backgroundColor = 'green'", element);
    }
    public void waitForRatingContainer() {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Оценка по отзывам')]")));
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void selectRating6Checkbox () {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement checkbox = getWebDriver().findElement(By.xpath("//div[@data-testid='filters-group-label-container']/div[contains(text(),'Достаточно хорошо: 6+')]"));
        checkbox.click();
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, checkbox.isSelected()));
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void verifyRatingApplied() {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='a1d43fa1ac']/div/label/input[@checked]")));
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void expandFilter() {
        WebElement popularity = getWebDriver().findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']"));
        getWebDriver().findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();

    }
    public void selectFilter() {
        getWebDriver().findElement(By.xpath("//span[contains(text(), 'Оценка объекта (по возрастанию)')]")).click();
    }

    public void checkOutFinalRating() {
        Assert.assertEquals("Rating of the first sorted hotel is differ than expected", "Оценка 6,3", getWebDriver().findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div")).getText());
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
        double expectedRating = 9.0;
        if (actualPropertyRating < expectedRating) {
            System.out.println("Что то пошло не так, рейтинг отеля < 9!");
        } else {
            System.out.println("Все верно, рейтинг отеля >= 9");
        }
    }

}
