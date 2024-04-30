package utils;

import org.openqa.selenium.By;

import static driver.Driver.getWebDriver;

public class Clicker {
    public void click(String string) {
        getWebDriver().findElement(By.xpath(string)).click();
    }
    public void press(String string) {
        getWebDriver().findElement(By.xpath(string)).click();
    }
}
