package test;

import model.SearchModel;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.HomePage;
import page.ResultPage;

import static junit.framework.TestCase.assertTrue;
import static util.Util.waitUntilLoad;

public class FilterTest extends BaseTest {

    private static final String SCORE = "Very Good: 8+";
    private static final Float SCORE_TO_CHECK = 8F;

    @Test(dataProvider = "JSONDataProviderSearch")
    public void findByParams(SearchModel searchModel) {
        HomePage homePage = new HomePage(driver);

        homePage.selectLocation(searchModel.getLocation());
        homePage.selectDates(searchModel.getCheckInDate(), searchModel.getCheckOutDate());
        homePage.clickSearchButton();
    }

    @Test(dependsOnMethods = "findByParams")
    public void chooseReviewScore() throws InterruptedException {
        ResultPage resultPage = new ResultPage(driver);
        resultPage.setReviewScore(SCORE);
        waitUntilLoad();
    }

    @Test(dependsOnMethods = "chooseReviewScore")
    public void checkResultListScore() {
        ResultPage resultPage = new ResultPage(driver);
        for (WebElement score : resultPage.getFoundPropertiesScoreDescription()) {
            assertTrue(Float.valueOf(score.getText()) >= SCORE_TO_CHECK);
        }
    }
}
