package tests;

import driver.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    //ToDo mby remove at all @BeforeTest
    //ToDo packageNamings to lowercase noCamalCase
    //ToDO test data should be tettled in tests -> method(testData) 1:42:35 19_day video
    @BeforeTest
    public void DriverInit() {
        //Driver.getWebDriver();
        //Driver.driver.manage().window().maximize();
        //Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    public void closeDriver() {
        Driver.getWebDriver().quit();
        Driver.driverDestroy();
    }
}