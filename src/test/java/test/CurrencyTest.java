package test;

import model.SearchModel;
import org.testng.annotations.Test;
import page.HomePage;
import page.ResultPage;

import static junit.framework.TestCase.assertTrue;

public class CurrencyTest extends BaseTest {

    private static final String CURRENCY = "EUR";
    private static final String CURRENCY_FOR_CHECK = "€";

    @Test(dataProvider = "JSONDataProviderSearch")
    public void findByParams(SearchModel searchModel) {
        HomePage homePage = new HomePage(driver);

        homePage.selectLocation(searchModel.getLocation());
        homePage.selectDates(searchModel.getCheckInDate(), searchModel.getCheckOutDate());
        homePage.clickSearchButton();

    }

    @Test(dependsOnMethods = "findByParams")
    public void chooseCurrency() {
        ResultPage resultPage = new ResultPage(driver);
        resultPage.clickCurrencyButton();
        resultPage.setCurrency(CURRENCY);
    }

    @Test(dependsOnMethods = "chooseCurrency")
    public void checkResultListCurrency() {
        ResultPage resultPage = new ResultPage(driver);

        assertTrue(resultPage.getFoundPropertiesCurrencyDescription()
                .stream()
                .allMatch(currency -> currency.getText().contains(CURRENCY_FOR_CHECK)));
    }
}
