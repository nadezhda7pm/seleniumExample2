package component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.List;

public class FilterFormResultPageComponent extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'filterbox')]//div[contains(@class,'filteroptions')]" +
            "//a[contains(@class,'filterelement bui-checkbox ')]" +
            "//div[contains(@class,'filter_item')]//span[@class]")
    private List<WebElement> allReviewScore;

    public boolean setReviewScore(String reviewScoreName) {
        for (WebElement score : allReviewScore) {
            if (reviewScoreName.equalsIgnoreCase(score.getText())) {
                score.click();
                return true;
            }
        }
        return false;
    }
}
