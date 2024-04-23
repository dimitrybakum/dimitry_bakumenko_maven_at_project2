package pages.PeopleTest;
import org.junit.Rule;
import org.junit.Test;
import People.Person;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class PersonJUnitTest {
    @Rule
    public TestName name = new TestName();

    Person person = new Person(25);
    @Test
    public void testPersonAgeJUnit() {

        System.out.printf("JUnit: %s test..%n", name.getMethodName());
        assertEquals("The age is not correct!", 25, person.getAge());
        System.out.println("Passed");
    }
}