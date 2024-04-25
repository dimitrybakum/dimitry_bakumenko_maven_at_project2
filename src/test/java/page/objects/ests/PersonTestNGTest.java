package page.objects.ests;

import people.Person;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.testng.AssertJUnit.*;


public class PersonTestNGTest {


    Person person = new Person(25);

    @Test
    public void testPersonAgeTestNG() {
        assertEquals("The age is not correct!", 25, person.getAge());
        System.out.println("Passed");
    }

    @BeforeMethod
    public void name(Method method) {
        System.out.println("TestNG: " + method.getName() + " test..");

    }
}