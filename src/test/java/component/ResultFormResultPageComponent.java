package component;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class ResultFormResultPageComponent extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'--checkin-field')]//div[contains(@class,'sb-date-field__display')]")
    private WebElement checkInDate;

    @FindBy(xpath = "//div[contains(@class,'--checkout-field')]//div[contains(@class,'sb-date-field__display')]")
    private WebElement checkOutDate;

    public String getCheckInDate() {
        return checkInDate.getText();
    }

    public String getCheckOutDate() {
        return checkOutDate.getText();
    }
}
