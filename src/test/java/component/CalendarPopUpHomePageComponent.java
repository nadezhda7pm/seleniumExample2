package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.time.LocalDate;
import java.util.List;

import static util.Util.FORMATTER;

public class CalendarPopUpHomePageComponent extends BasePage {
    private static final String DAYS_PATH = "//td[@class='bui-calendar__date']";
    private static final String DATE_ATTRIBUTE = "data-date";

    @FindBy(xpath = "//td[@class='bui-calendar__date']")
    private WebElement currentMonthDate;

    @FindBy(xpath = "//div[@class='bui-calendar__control bui-calendar__control--next']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//div[@class='bui-calendar__control bui-calendar__control--prev']")
    private WebElement prevMonthButton;

    public CalendarPopUpHomePageComponent(WebDriver driver) {
        setDriver(driver);
    }

    public void setDates(String checkInDate, String checkOutDate) {
        selectDate(LocalDate.parse(checkInDate, FORMATTER));
        selectDate(LocalDate.parse(checkOutDate, FORMATTER));
    }

    private void selectDate(LocalDate checkInDate) {
        selectValue(checkInDate.getMonthValue());
        selectDay(checkInDate);
    }

    private void selectValue(int expectedValue) {
        int currentValue = updateCurrentMonthValue();
        if (currentValue < expectedValue) {
            nextMonthButton.click();
            selectValue(expectedValue);
        }
    }

    private void selectDay(LocalDate checkInDate) {
        List<WebElement> dates = driver.findElements(By.xpath(DAYS_PATH));
        for (WebElement date : dates) {
            String dateString = date.getAttribute(DATE_ATTRIBUTE);
            if (dateString.equals(checkInDate.toString())) {
                date.click();
                return;
            }
        }
    }

    private int updateCurrentMonthValue() {
        return LocalDate.parse(driver.findElement(By.xpath("//td[@class='bui-calendar__date']"))
                .getAttribute(DATE_ATTRIBUTE), FORMATTER).getMonthValue();
    }
}
