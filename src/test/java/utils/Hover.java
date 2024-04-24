package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static driver.Driver.getWebDriver;

public class Hover {
    public void hoverOverElement(String string) {
        Actions actions = new Actions(getWebDriver());
        WebElement elemCurrency = getWebDriver().findElement(By.xpath(string));
        actions.moveToElement(elemCurrency);
        actions.perform();
    }
}
