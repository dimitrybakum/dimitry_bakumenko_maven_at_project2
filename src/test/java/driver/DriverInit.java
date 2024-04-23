package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.Optional;

public class DriverInit {
    public static WebDriver driver;

    public enum Config {
        CHROME, FF, REMOTE
    }

    public static Config config =
            Optional.ofNullable(System.getProperty("CONFIG")).isEmpty() ?
                    Config.CHROME : Config.valueOf(System.getProperty("CONFIG"));

    public static WebDriver getWebDriver() {
        return switch (config) {
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default -> getChromeDriver();
        };
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("--incognito");
        caps.addArguments("start-maximized");
        caps.addArguments("disable-infobars");
        caps.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        return new ChromeDriver(caps);
    }

    private static WebDriver getFFDriver() {
        return null;
    }

    private static WebDriver getRemoteDriver() {
        return null;
    }
}