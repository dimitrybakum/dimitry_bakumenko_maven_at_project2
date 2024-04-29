package page.objects.numbers.tests;

import numbers.Numbers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class NumbersJUnitTests {
    private static final Logger LOGGER = LogManager.getLogger(NumbersJUnitTests.class);
    @Rule
    public TestName name = new TestName();
    Numbers numbers = new Numbers();

    @Test
    public void testNumberJunit() {
        LOGGER.info("JUnit: "+name.getMethodName()+" test..");
        assertEquals("The age is not correct!", 98, numbers.getNumber(-1, 5));
        assertEquals("The age is not correct!", 48, numbers.getNumber(-1, 10));
        assertEquals("The age is not correct!", 53, numbers.getNumber(2, 2));
        assertEquals("The age is not correct!", 96, numbers.getNumber(-2, 62));
        assertEquals("The age is not correct!", 53, numbers.getNumber(2, -6));
        assertEquals("The age is not correct!", -50, numbers.getNumber(-100, -100));
        LOGGER.info("passed");
    }
}
