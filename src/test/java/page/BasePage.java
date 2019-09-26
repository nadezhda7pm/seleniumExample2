package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
