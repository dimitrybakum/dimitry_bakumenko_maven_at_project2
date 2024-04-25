package tests;

import driver.Driver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    @AfterTest
    public void closeDriver() {
        Driver.getWebDriver().quit();
        Driver.driverDestroy();
    }
}