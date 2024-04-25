package tests;

import driver.Driver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    //ToDO test data should be tettled in tests -> method(testData) 1:42:35 19_day video


    @AfterTest
    public void closeDriver() {
        Driver.getWebDriver().quit();
        Driver.driverDestroy();
    }
}