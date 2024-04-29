package page.objects.people.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import people.Person;

import static org.junit.Assert.assertEquals;

public class PersonJUnitTest {
    private static final Logger LOGGER = LogManager.getLogger(PersonJUnitTest.class);
    @Rule
    public TestName name = new TestName();

    Person person = new Person(25);
    @Test
    public void testPersonAgeJUnit() {
        LOGGER.info("JUnit: "+name.getMethodName()+" test..");
        System.out.printf("JUnit: %s test..%n");
        assertEquals("The age is not correct!", 25, person.getAge());
        LOGGER.info("Passed");
    }
}