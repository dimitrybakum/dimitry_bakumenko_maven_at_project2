import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebDriverClass {
    private static final Logger LOGGER = LogManager.getLogger(TestWebDriverClass.class);

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        LOGGER.info(driver.getTitle());
        driver.close();
    }
}
