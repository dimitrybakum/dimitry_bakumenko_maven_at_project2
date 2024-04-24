package utils;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public void getScreenshot() throws IOException {
        File asfile = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(asfile, new File("pic5.png"));
    }
}
