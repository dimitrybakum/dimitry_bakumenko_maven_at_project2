package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.Optional;
public class Driver {
    private static WebDriver driver;

    protected static Config.Configs config =
            Optional.ofNullable(System.getProperty("CONFIG")).isEmpty() ?
                    Config.Configs.CHROME : Config.Configs.valueOf(System.getProperty("CONFIG"));

    public static WebDriver getWebDriver() {
        return switch (config) {
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default ->  getChromeDriver();
        };
    }

    private static WebDriver getChromeDriver() {
        if (null == driver) {
            ChromeOptions caps = new ChromeOptions();
            caps.addArguments("--incognito");
            caps.addArguments("start-maximized");
            caps.addArguments("disable-infobars");
            caps.setExperimentalOption("excludeSwitches",
                    Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(caps);
        }
        return driver;
    }

    public static void driverDestroy() {
        driver.quit();
        driver = null;
    }

    private static WebDriver getFFDriver() {
        return null;
    }

    private static WebDriver getRemoteDriver() {
        return null;
    }
}