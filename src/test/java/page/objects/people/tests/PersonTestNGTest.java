package page.objects.people.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Person;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.testng.AssertJUnit.*;


public class PersonTestNGTest {
    private static final Logger LOGGER = LogManager.getLogger(PersonTestNGTest.class);

    Person person = new Person(25);

    @Test
    public void testPersonAgeTestNG() {
        assertEquals("The age is not correct!", 25, person.getAge());
        LOGGER.info("Passed");
    }

    @BeforeMethod
    public void name(Method method) {
        LOGGER.info("TestNG: " + method.getName() + " test..");

    }
}