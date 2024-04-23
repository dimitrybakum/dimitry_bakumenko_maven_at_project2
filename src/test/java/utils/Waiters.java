package utils;

import driver.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.booking.BookingHomeXPath;

import java.time.Duration;
import java.util.ArrayList;

public class Waiters {
    public final BookingHomeXPath bookingHomePage = new BookingHomeXPath();
    public void implicitWait() {
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void explicitWait() {
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(DriverInit.driver, Duration.ofSeconds(25));
    }
    public void waitForPageLoaded() {
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(DriverInit.driver, Duration.ofSeconds(20));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void waitForElement(String string) {
        new WebDriverWait(DriverInit.driver, Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(webDriver -> DriverInit.driver.findElement(By.xpath(string)));
    }
    public void waitForNewTab() {
        new WebDriverWait(DriverInit.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(DriverInit.driver.getWindowHandles());
        DriverInit.driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
