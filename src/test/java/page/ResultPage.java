package page;


import component.CurrencyPopUpResultPageComponent;
import component.FilterFormResultPageComponent;
import component.ResultFormResultPageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'district_link visited_link')]")
    private List<WebElement> foundPropertiesLocationDescription;

    @FindBy(xpath = "//div[contains(@class,'smart_price_style')]//strong[contains(@class,'price')]/b")
    private List<WebElement> foundPropertiesCurrencyDescription;

    @FindBy(xpath = "//div[contains(@class,'bui-review-score__badge')]")
    private List<WebElement> foundPropertiesScoreDescription;

    @FindBy(xpath = "//*[@data-id='currency_selector']/a")
    private WebElement currencyButton;

    private CurrencyPopUpResultPageComponent currencyPopUpResultPageComponent;

    private ResultFormResultPageComponent resultFormResultPageComponent;

    private FilterFormResultPageComponent filterFormResultPageComponent;

    public ResultPage(WebDriver driver) {
        setDriver(driver);
        this.resultFormResultPageComponent = new ResultFormResultPageComponent();
        this.currencyPopUpResultPageComponent = new CurrencyPopUpResultPageComponent();
        this.filterFormResultPageComponent = new FilterFormResultPageComponent();

        this.resultFormResultPageComponent.setDriver(driver);
        this.currencyPopUpResultPageComponent.setDriver(driver);
        this.filterFormResultPageComponent.setDriver(driver);
    }

    public List<WebElement> getFoundPropertiesLocationDescription() {
        return foundPropertiesLocationDescription;
    }

    public List<WebElement> getFoundPropertiesCurrencyDescription() {
        return foundPropertiesCurrencyDescription;
    }

    public List<WebElement> getFoundPropertiesScoreDescription() {
        return foundPropertiesScoreDescription;
    }

    public String getCheckInDate() {
        return resultFormResultPageComponent.getCheckInDate();
    }

    public String getCheckOutDate() {
        return resultFormResultPageComponent.getCheckOutDate();
    }

    public void clickCurrencyButton() {
        currencyButton.click();
    }

    public void setCurrency(String currencyName) {
        currencyPopUpResultPageComponent.selectCurrency(currencyName);
    }

    public void setReviewScore(String reviewScoreName) {
        filterFormResultPageComponent.setReviewScore(reviewScoreName);
    }
}
