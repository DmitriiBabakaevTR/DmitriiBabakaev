package hw4.tests.firstExerciseTestRun;

import hw4.tests.abstractTest.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class FirstExerciseRunTest extends BaseTest {

    @Feature(value = "Проверка домашней страницы")
    @Story(value = "Все шаги для проверки")
    @Test(description = "Тестирование страницы Home page")
    public void verifyHomePage() {

        actionStep.openMainPage();
        assertionStep.verifyHomePageURLAndTitle();
        actionStep.loggInHomePage();
        assertionStep.verifyLoggIn();
        assertionStep.verifyHeaderElementsAreDisplayed();
        assertionStep.verifyHeaderElementsText();
        assertionStep.verifyImagesAreDisplayedOnTheIndexPage();
        assertionStep.verifyImagesOnTheIndexPageText();
        assertionStep.verifyIframeExist();
        actionStep.switchToFrame();
        assertionStep.verifyFrameButtonExist();
        actionStep.switchBackToOriginalWindow();
        assertionStep.verifyFocusOnOriginalWindow();
        assertionStep.verifyLeftElementsAreDisplayed();
        assertionStep.verifyLeftElementsText();
        soft.assertAll();
    }
}