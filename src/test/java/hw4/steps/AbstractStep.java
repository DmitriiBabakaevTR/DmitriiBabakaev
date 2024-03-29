package hw4.steps;

import hw4.pages.DifferentElementsPage;
import hw4.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected SoftAssert soft;

    protected AbstractStep(WebDriver driver,SoftAssert soft) {

        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        this.soft = soft;
    }

    @Step("Открыть HomePage")
    public void openMainPage(){
        homePage.openPage();
    }
}