package page.objects.booking.xpath;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Randomizer;
import utils.Waiters;

import static driver.Driver.getWebDriver;

public class TrashMailPageXpath {
    public final Waiters waiters = new Waiters();

    //public static final Randomizer randomizer = new Randomizer();
    private static final Logger LOGGER = LogManager.getLogger(BookingHomePageXpath.class);
    public static String confirmationPassword = Randomizer.generatePassword();
    public static String newUserTabXpath = "//a[@href=\"#tab-register\"]";

    public static String newUserInputFieldXpath = "//*[@id=\"tab-register\"]/form/div[1]/input";
    public static String email = "dimitrybakum@gmail.com";
    public static String emailInputFieldXpath = "//*[@id=\"fe-forward\"]";
    public static String numberOfForwardsDropDownXpath = "//*[@id=\"tab-quick\"]/form/div[3]/div/button";
    public static String expandedDropDownXpath ="//*[@class=\"select dropdown-menu ng-scope am-fade bottom-left\"]";
    public static String getNumberOfForwardsValueXpath = "//*[@class=\"select dropdown-menu ng-scope am-fade bottom-left\"]/li/a";
    public static String createTempEmailButtonID = "id=\"fe-submit\"";
    public static String final_temp_email_address;
    @Given("navigate to {string} page")
    public void navigate_to_booking_home_page(String string) {
        getPage(string);
        LOGGER.info("trashmail loaded");

    }
    @Given("select number of forwards value 1 day")
    public void expand_numberOfForwards() throws InterruptedException {
        getWebDriver().findElement(By.xpath(numberOfForwardsDropDownXpath)).click();
        waiters.waitForElement(expandedDropDownXpath);
        getWebDriver().findElement(By.xpath(getNumberOfForwardsValueXpath)).click();
        LOGGER.info("numberOfForwards expanded and value selected");

    }
    public void getPage(String url) {
        getWebDriver().get(url);
    }

    @When("add name")
    public void addName() {
        String name = Randomizer.generateName();
        getWebDriver().findElement(By.xpath("//*[@id=\"tab-register\"]/form/div[1]/input")).sendKeys(name);
        LOGGER.info("name entered");
    }
    @When("add password")
    public void addPassword() {
        getWebDriver().findElement(By.xpath("//*[@id=\"new_password\"]")).sendKeys(confirmationPassword);
        LOGGER.info("pwd entered");
    }
    @When("confirm password")
    public void confirmPassword() {
        getWebDriver().findElement(By.xpath("//*[@id=\"confirmed_password\"]")).sendKeys(confirmationPassword);
        LOGGER.info("pwd confirmed");
    }


    @When("click on [Get mail] button")
    public void getMail() {
        getWebDriver().findElement(By.xpath("//*[@id=\"fe-submit\"]")).click();
        LOGGER.info("[Get mail] button clicked");
    }


    @When("open newUser form")
    public void newUser() {
        getWebDriver().findElement(By.xpath(String.valueOf(newUserTabXpath))).click();
        LOGGER.info("newUser element clicked");
        waiters.waitForSeconds(1);
    }@When("click on newUser input field")
    public void newUserInput() throws InterruptedException {
        getWebDriver().findElement(By.xpath(String.valueOf(newUserInputFieldXpath))).click();
        LOGGER.info("newUser element clicked");
        Thread.sleep(5000);
    }

    @When("fill out real email")
    public void real_email() {
        getWebDriver().findElement(By.xpath(emailInputFieldXpath)).sendKeys(email);
        LOGGER.info("email entered");
    }

    @When("store temp email address")
    public void store_temp_email_address() {
        WebElement temp_email_address = getWebDriver().findElement(By.xpath("//*[@id=\"fe-dea\"]"));
        final_temp_email_address = temp_email_address.getAttribute("value");
        LOGGER.info("email " + final_temp_email_address + " stored" );
    }

}
