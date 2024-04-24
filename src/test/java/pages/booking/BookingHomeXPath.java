package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

import static driver.Driver.*;

public class BookingHomeXPath {
    public String rating9Checkbox = "//*[@data-testid='filters-group']//div[@data-filters-item='review_score:review_score=90']//*[@type='checkbox']";
    public String ratingApplied = "//div[@class='a1d43fa1ac']/div/label/input[@checked]";

    public void hoverLanguageElement() {
        Actions actions = new Actions(getWebDriver());
        WebElement elemLanguage = getWebDriver().findElement(By.xpath("//*[@data-testid='header-language-picker-trigger']"));
        actions.moveToElement(elemLanguage);
        actions.perform();
    }

    public void verifyLanguageElementContainsText(String expectedString) {

        WebElement languageTooltip = getWebDriver().findElement(By.xpath("//div[@class='a0ac0ffd76 eb4b382ac4 f38a56c611']//*[contains(text(),'Выберите язык')]"));


        String languageTooltipActualText = languageTooltip.getText();
        if (Objects.equals(languageTooltipActualText, expectedString)) {
            System.out.println("Language: значение подсказки ожидаемое ->>" + languageTooltip.getText());
        } else {
            System.out.println("Language: значение подсказки не совпадает ->>" + languageTooltip.getText());
        }
    }

    public void hoverCurrencyElement() {
        Actions actions = new Actions(getWebDriver());
        WebElement elemCurrency = getWebDriver().findElement(By.xpath("//*[@data-testid='header-currency-picker-trigger']"));
        actions.moveToElement(elemCurrency);
        actions.perform();
    }
    public void verifyCurrencyElementContainsText(String string) {
        WebElement currencyTooltip = getWebDriver().findElement(By.xpath("//div[@class='a0ac0ffd76 eb4b382ac4 f38a56c611']//*[contains(text(),'Выберите валюту')]"));

        String currencyWordToCheck = string;
        String currencyToolText = currencyTooltip.getText();
        if (Objects.equals(currencyToolText, currencyWordToCheck)) {
            System.out.println("Currency: значение подсказки ожидаемое ->>" + currencyTooltip.getText());
        } else {
            System.out.println("Currency: значение подсказки не совпадает ->>" + currencyTooltip.getText());
        }
    }

    public void getBookingStartPage() {

        getWebDriver().get("https://www.booking.com/");
    }

    public void closeRegistrationAlert() {
        getWebDriver().findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']")).click();
    }
    public void closeDatePicker() {
        getWebDriver().findElement(By.xpath("//span[contains(text(), 'Дата заезда')]")).click();
    }

    public void getLocationSearchField(String location) {
        getWebDriver().findElement(By.xpath("//*[@id=':re:']")).sendKeys(location);
    }

    public void locationSelectionParis() {
        getWebDriver().findElement(By.xpath("//div[text()='Иль-де-Франс, Франция']")).click();
    }
    public void locationSelectionPraha() {
        getWebDriver().findElement(By.xpath("//div[text()='Чехия']")).click();
    }
    public void locationSelectionLondon() {
        getWebDriver().findElement(By.xpath("//div[text()='Большой Лондон, Великобритания']")).click();
    }

//ToDo Refactor datePicker. No selection for next month
    public void datesFromTo(int checkInDate, int checkOutDate) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        int checkInDay = currentDate.plusDays(checkInDate).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        String checkInXpath = String.format(pathToDay, checkInDay);
        WebElement elem1 = getWebDriver().findElement(By.xpath(checkInXpath));
        elem1.click();


        int checkOutDay = currentDate.plusDays(checkOutDate).getDayOfMonth();
        int checkMonth = currentDate.plusDays(checkOutDate).getMonthValue();
        String checkOutXpath = String.format(pathToDay, checkOutDay);
        WebElement elem2 = getWebDriver().findElement(By.xpath(checkOutXpath));
        elem2.click();
//ToDo Refactor datePicker. No selection for next month

    }

    public void getOccupancyPopup() {
        getWebDriver().findElement(By.xpath("//button[@data-testid=\"occupancy-config\"]")).click();

    }

    public void addAdult() {
        getWebDriver().findElement(By.xpath("//*[@data-testid='occupancy-popup']/div/div[1]/div[2]/button[2]")).click();
    }

    public void addRoom() {
        getWebDriver().findElement(By.xpath("//*[@data-testid='occupancy-popup']/div/div[3]/div[2]/button[2]")).click();
    }

    public void submitOcupancy() {
        getWebDriver().findElement(By.xpath("//*[@data-testid='occupancy-popup']/button/*[contains(text(),'Готово')]")).click();

    }

    public void submitSearch() {
        getWebDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    public void selectCheckbox(String string) {
        getWebDriver().findElement(By.xpath(string)).click();
    }
    public void waitForRatingApplied(String string) {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(string)));
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void getTopResult() {
        getWebDriver().findElement(By.xpath("//div[@data-testid='property-card-container']//div[@data-testid='title']")).click();
    }

}
