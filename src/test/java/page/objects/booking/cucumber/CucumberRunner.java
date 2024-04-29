package page.objects.booking.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "summary" },
        glue = {"helpers", "tests/booking/tests/cucumber"},
        features = {"src/test/resources/features/BookingLondonSearchTests.feature",
                "src/test/resources/features/BookingParisSearchTests.feature",
                "src/test/resources/features/BookingPrahaSearchTests.feature"}
)
public class CucumberRunner {
}