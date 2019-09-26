package test;

import model.SearchModel;
import org.testng.annotations.Test;
import page.HomePage;
import page.ResultPage;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;
import static util.Util.FORMATTER;
import static util.Util.convertLocalDateToString;


public class FindTest extends BaseTest {

    @Test(dataProvider = "JSONDataProviderSearch")
    public void findByParams(SearchModel searchModel) {
        HomePage homePage = new HomePage(driver);

        homePage.selectLocation(searchModel.getLocation());
        homePage.selectDates(searchModel.getCheckInDate(), searchModel.getCheckOutDate());
        homePage.clickSearchButton();
    }

    @Test(dependsOnMethods = "findByParams", dataProvider = "JSONDataProviderSearch")
    public void checkResultListLocation(SearchModel searchModel) {
        ResultPage resultPage = new ResultPage(driver);

        assertTrue(resultPage.getFoundPropertiesLocationDescription()
                .stream()
                .allMatch(location -> location.getText().contains(searchModel.getLocation())));
    }

    @Test(dependsOnMethods = "findByParams", dataProvider = "JSONDataProviderSearch")
    public void checkSelectedDate(SearchModel searchModel) {
        ResultPage resultPage = new ResultPage(driver);

        String checkInDate = convertLocalDateToString(LocalDate.parse(searchModel.getCheckInDate(), FORMATTER));
        String checkOutDate = convertLocalDateToString(LocalDate.parse(searchModel.getCheckOutDate(), FORMATTER));

        assertTrue(resultPage.getCheckInDate().equalsIgnoreCase(checkInDate));
        assertTrue(resultPage.getCheckOutDate().equalsIgnoreCase(checkOutDate));
    }

}
