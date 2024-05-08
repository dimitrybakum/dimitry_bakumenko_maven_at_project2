package tests.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tools.EventListener;

@Listeners(EventListener.class)
public class ReportingTests {
    private static final Logger LOGGER = LogManager.getLogger(tests.booking.tests.test_ng.BookingParisSearchTests.class);

    @Test(description = "157876")
    public void Case_1() throws InterruptedException {
        Assert.assertTrue(true);
        LOGGER.info("passed");
    }

    @Test(description = "157880")
    public void Case_2() throws InterruptedException {
        Assert.assertTrue(true);
        LOGGER.info("passed");
    }

    @Test(description = "157881")
    public void Case_3() throws InterruptedException {
        Assert.assertTrue(false);
        LOGGER.info("failed");
    }

    @Test(description = "157882")
    public void Case_4() throws InterruptedException {
        Assert.assertTrue(true);
        LOGGER.info("passed");
    }
}