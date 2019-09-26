package page;

import component.CalendarPopUpHomePageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "ss")
    private WebElement location;

    @FindBy(xpath = "//div[@class='xp__dates xp__group']")
    private WebElement calendarPopupButton;

    @FindBy(id = "xp__guests__toggle")
    private WebElement guestsPopupButton;

    @FindBy(xpath = "//div[@class='xp__button']//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ul/li[@role='option']")
    private WebElement locationFirsFoundOption;

    private CalendarPopUpHomePageComponent calendarPopup;

    public HomePage(WebDriver driver) {
        setDriver(driver);
        this.calendarPopup = new CalendarPopUpHomePageComponent(driver);
    }

    public void selectLocation(String locationName) {
        location.clear();
        location.sendKeys(locationName);
        locationFirsFoundOption.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void selectDates(String checkInDate, String checkOutDate) {
        calendarPopup.setDates(checkInDate, checkOutDate);
    }

}

