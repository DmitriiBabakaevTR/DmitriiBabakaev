package hw3.abstractTest;

import hw3.config.ConfigProperties;
import hw3.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected SoftAssert soft;
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    private final static String login = ConfigProperties.getProperty("user");
    private final static String pass = ConfigProperties.getProperty("pass");

    private void openMainPageAndVerifyURLAndTitle(){
        driver.get(ConfigProperties.getProperty("URL"));
        Assert.assertEquals(getURL(), "https://jdi-testing.github.io/jdi-light/index.html", "Wrong URL!");
        Assert.assertEquals(getTitle(), "Home Page", "Wrong title!");
    }

    private void loggInAndVerify(){
        homePage.loggIn(login, pass);
        Assert.assertEquals(homePage.getHeaderPageElements().getUserNameText().getText(), "ROMAN IOVLEV", "Invalid user!");
    }

    protected String getTitle(){
        return driver.getTitle();
    }
    protected String getURL(){
        return driver.getCurrentUrl();
    }

    @BeforeClass(alwaysRun = true)
    protected void SetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soft = new SoftAssert();
        homePage = new HomePage(driver);
        openMainPageAndVerifyURLAndTitle();
        loggInAndVerify();
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        driver.close();
    }
}