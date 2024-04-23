package tests;

import driver.DriverInit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    @BeforeTest
    public void DriverInit() {
        DriverInit.driver = DriverInit.getWebDriver();
        DriverInit.driver.manage().window().maximize();
        DriverInit.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    public void closeDriver() {
        DriverInit.driver.quit();
    }
}