package page.objects.numbers.tests;

import numbers.Numbers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.testng.AssertJUnit.*;

public class NumbersTestNGTests {
    private static final Logger LOGGER = LogManager.getLogger(NumbersTestNGTests.class);
    Numbers numbers = new Numbers();

    @Test
    public void testNumberTestNG() {
        assertEquals("The age is not correct!", 98, numbers.getNumber(-1, 5));
        assertEquals("The age is not correct!", 48, numbers.getNumber(-1, 10));
        assertEquals("The age is not correct!", 53, numbers.getNumber(2, 2));
        assertEquals("The age is not correct!", 96, numbers.getNumber(-2, 62));
        assertEquals("The age is not correct!", 53, numbers.getNumber(2, -6));
        assertEquals("The age is not correct!", -50, numbers.getNumber(-100, -100));
        LOGGER.info("Passed");
    }

    @BeforeMethod
    public void name(Method method) {
        LOGGER.info("TestNG: " + method.getName() + " test..");

    }
}