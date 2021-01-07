package hw4.steps;

import hw4.config.ConfigProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class ActionStep extends AbstractStep {
    public ActionStep(WebDriver driver, SoftAssert soft) {
        super(driver, soft);
    }

    private final static String login = ConfigProperties.getProperty("user");
    private final static String pass = ConfigProperties.getProperty("pass");

    @Step("Залогиниться")
        public void loggInHomePage() {
        homePage.loggIn(login, pass);
    }

    @Step("Переключиться на фрэйм")
        public void switchToFrame(){
        homePage.switchToFrame();
    }

    @Step("Переключиться обратно в главное окно")
        public void switchBackToOriginalWindow(){
        homePage.switchToOriginalWindow();
    }

    @Step("Открыть Different Elements Page")
    public void openDifferentElementsPage() {
        differentElementsPage.openDiffElPage();
    }

    @Step("Выбрать чекбоксы: 'Water' и 'Wind'")
    public void selectProperCheckboxes(){
        differentElementsPage.selectWaterAndWindCheckboxes();
    }

    @Step("Выбрать радио-кнопку: 'Selen'")
    public void selectRadioButton(){
        differentElementsPage.selectSelenRadio();
    }

    @Step("Выбрать из выпадающего списка цвет: 'Yellow'")
    public void selectDropDownColor(){
        differentElementsPage.selectYellowColor();
    }
}