package page.objects.demoQA;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class DemoQATests {
    private static final Logger LOGGER = LogManager.getLogger(DemoQATests.class);

    WebDriver driver = Driver.getWebDriver();

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void dropDownsTest() {
        driver.get("https://demoqa.com/select-menu");

        WebElement element3 = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select3 = new Select(element3);
        select3.selectByValue("4");
        select3.getOptions();
        LOGGER.info("Passed");

        WebElement element5 = driver.findElement(By.xpath("//select[@id='cars']"));
        Select select5 = new Select(element5);
        select5.selectByValue("opel");
        select5.getOptions();
        LOGGER.info("Passed");
    }

    @After
    public void closeWindow() {
        driver.close();
    }

}
