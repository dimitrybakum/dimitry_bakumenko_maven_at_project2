
package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.booking.tests.junit.*;
@RunWith(Suite.class)
@Suite.SuiteClasses({BookingLondonSearchTests.class, BookingParisSearchTests.class, BookingPrahaSearchTests.class, BookingTooltipTests.class})

public class BookingJUnitRunner {
}