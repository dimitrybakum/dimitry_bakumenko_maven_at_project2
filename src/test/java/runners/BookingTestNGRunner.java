package runners;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.internal.Parser;

import java.io.IOException;
import java.util.List;

public class BookingTestNGRunner {
    public static void main(String[] args) throws IOException {
        final TestNG testNG = new TestNG(true);
        final Parser parser = new Parser("testng.xml");
        final List<XmlSuite> suites = parser.parseToList();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
