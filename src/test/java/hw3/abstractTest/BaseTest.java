package hw3.abstractTest;

import hw3.config.ConfigProperties;
import hw3.pages.*;
import hw3.webDriverManager.ChromeManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public abstract class BaseTest {

    protected SoftAssert soft;
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    protected void openMainPage(){
        driver.get(ConfigProperties.getProperty("URL"));
    }
    protected String getTitle(){
        return driver.getTitle();
    }
    protected String getURL(){
        return driver.getCurrentUrl();
    }

    @BeforeClass(alwaysRun = true)
    protected void SetUp() {
        soft = new SoftAssert();
        driver = new ChromeManager().WebDriverSetUp();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        driver.close();
    }
}