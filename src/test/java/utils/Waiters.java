package utils;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Waiters {
    public void implicitWait() {
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void explicitWait() {
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        waitForPageLoaded(10);
    }
    public void waitForPageLoaded(int seconds) {
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void waitForElement(String string) throws InterruptedException {
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(webDriver -> Driver.getWebDriver().findElement(By.xpath(string)));
    }
    public void waitForNewTab(int seconds) {
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(Driver.getWebDriver().getWindowHandles());
        Driver.getWebDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }
    public void waitForSeconds(int seconds) {
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
