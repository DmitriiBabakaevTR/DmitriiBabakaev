package hw5.steps;

import hw5.pages.DifferentElementsPage;
import hw5.pages.HomePage;
import hw5.driver.WebDriverSingleton;
import hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected SoftAssert soft;
    protected WebDriver driver;

    protected AbstractStep() {
        driver = WebDriverSingleton.getDriver();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
        soft = new SoftAssert();
    }
}