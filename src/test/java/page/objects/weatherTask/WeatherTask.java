package page.objects.weatherTask;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("погода минск weather");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='погода минск weather']")));
        driver.findElement(By.xpath("//span[text()='погода минск weather']")).click();

        String tomorrow = LocalDate.now(ZoneId.systemDefault()).plusDays(1)
                .getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("be"));

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#wob_gsvg > text:nth-child(41)")));

        WebElement el = driver.findElement(
                By.cssSelector(String.format("#wob_gsvg > text:nth-child(41)", tomorrow)));
        System.out.println(el.getAttribute("aria-label"));
        driver.close();
    }
}
