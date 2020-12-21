package hw2.AbstractTest;

import hw2.baseOptions.ChromeManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected SoftAssert soft;

    @BeforeClass(alwaysRun = true)
    protected void SetUp() {
        driver = new ChromeManager().WebDriverSetUp();
        soft = new SoftAssert();
    }
    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        driver.close();
    }

    protected void openMainPage(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }
    protected String getTitle(){
        return driver.getTitle();
    }
}
