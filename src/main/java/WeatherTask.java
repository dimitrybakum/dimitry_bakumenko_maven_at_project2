import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WeatherTask {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");

        WebElement searchField = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchField.sendKeys("погода минск weather");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.xpath("//*[@id='Alh6id']/div[1]/div/ul/li[1]/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id='wob_sd']/div[7]/span")).click();
        driver.findElement(By.xpath("//*[@id='wob_sd']/div[7]/span")).click();
        System.out.println("Temperature for tomorrow at 12:00 will be about " + driver.findElement(By.xpath("//*[@id='wob_tm']")).getText() + "°C");
    }
}
