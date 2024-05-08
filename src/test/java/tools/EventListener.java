package tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(tests.booking.tests.test_ng.BookingParisSearchTests.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info(result.getMethod().getDescription());
        LOGGER.info("Test started " + result.getStatus());
        TestRailReporter.reportResult("2357",result.getMethod().getDescription(), new Result(1));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info(result.getMethod().getDescription());
        LOGGER.info("Test passed " + result.getStatus());
        TestRailReporter.reportResult("2357",result.getMethod().getDescription(), new Result(1));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info(result.getMethod().getDescription());
        LOGGER.info("Test failed " + result.getStatus());
        TestRailReporter.reportResult("2357",result.getMethod().getDescription(), new Result(5));

    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("Test stopped ");
    }
}
