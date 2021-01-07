package hw4.tests.abstractTest;

import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;
    protected SoftAssert soft;

    @BeforeClass(alwaysRun = true)
    protected void SetUp(ITestContext testContext) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soft = new SoftAssert();
        actionStep = new ActionStep(driver, soft);
        assertionStep = new AssertionStep(driver, soft);
        testContext.setAttribute("driver", driver);
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        driver.close();
    }
}