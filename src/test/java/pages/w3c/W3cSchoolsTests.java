package pages.w3c;

import dev.failsafe.internal.util.Assert;
import driver.DriverInit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class W3cSchoolsTests {
    WebDriver driver = DriverInit.getWebDriver();

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void w3cSchoolTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.w3schools.com/java/");

        Actions make = new Actions(driver);
        WebElement nameField = driver.findElement(By.xpath("//div[@id='main']/h1/span[contains(text(), 'Tutorial')]"));
        make.doubleClick(nameField).keyDown(Keys.LEFT_CONTROL).sendKeys("c").clickAndHold().keyUp(Keys.LEFT_CONTROL).build().perform();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@id='APjFqb']")).click();
        make.keyDown(Keys.LEFT_CONTROL).sendKeys("v").clickAndHold().keyUp(Keys.LEFT_CONTROL).build().perform();
        driver.findElement(By.xpath("//*[@id='APjFqb']")).click();
        make.sendKeys(Keys.ENTER).build().perform();

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='rso']//*"));
        String wordToCheck = "tutorial";

        boolean allCantain = true;
        for (WebElement result : searchResults) {
            String resultText = result.getText().toLowerCase();
            if (!resultText.contains(wordToCheck)) {
                allCantain = false;
                break;
            }
            System.out.println(allCantain);
        }
        System.out.println(allCantain);

        Assert.isTrue(allCantain, "Some of result does not contains key word " + "'" + wordToCheck + "'");
    }

    @After
    public void closeWindow() {
        driver.close();
    }
}
