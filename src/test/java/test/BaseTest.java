package test;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.SearchModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import page.BasePage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public BasePage basePage;
    private String url = "https://www.booking.com";

    @DataProvider(name = "JSONDataProviderSearch")
    public Iterator<Object[]> jsonDataProviderCollection() throws IOException {
        List<Object[]> dataProvider = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/json/SearchModels.json");

        List<SearchModel> searchModelsFromJson = objectMapper.readValue(
                objectMapper.writeValueAsString(objectMapper.readTree(file)
                        .path("SearchModels")),
                new TypeReference<List<SearchModel>>() {
                });

        searchModelsFromJson.stream().forEach(obj -> dataProvider.add(new Object[]{obj}));
        return dataProvider.iterator();
    }

    @BeforeClass
    public void setUp() {
        //Set here path to your ChromeDriver
        //System.setProperty("webdriver.chrome.setUp", "src/test/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cdadmin\\git\\chromedriver.exe");


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
