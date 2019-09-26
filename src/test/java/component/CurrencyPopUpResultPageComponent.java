package component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.List;

public class CurrencyPopUpResultPageComponent extends BasePage {

    @FindBy(xpath = "//*[@class='currency_list']/li")
    private List<WebElement> allCurrencies;

    @FindBy(xpath = "//*[@data-id='currency_selector']/input")
    private WebElement currencyValue;

    @FindBy(xpath = "//*[@data-id='currency_selector']/a")
    private WebElement currencyButton;


    public void selectCurrency(String currencyName) {
        String actualCurrency = currencyValue.getAttribute("value");
        if (!actualCurrency.equals(currencyName.toUpperCase())) {
            setCurrency(currencyName);
        }

    }

    private boolean setCurrency(String currencyName) {
        for (WebElement cur : allCurrencies) {
            if (currencyName.equalsIgnoreCase(cur.getAttribute("data-lang"))) {
                cur.click();
                return true;
            }
        }
        return false;
    }
}
