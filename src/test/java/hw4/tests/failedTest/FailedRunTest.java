package hw4.tests.failedTest;

import hw4.tests.abstractTest.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class FailedRunTest extends BaseTest {

    @Feature(value = "Selenium")
    @Story(value = "Домашняя работа №4")
    @Test(description = "Тестирование страницы Home page")
    public void verifyHomePage() {

        actionStep.openMainPage();
        assertionStep.verifyHomePageURLAndTitle();
        actionStep.loggInHomePage();
        assertionStep.verifyLoggIn();
        assertionStep.verifyHeaderElementsAreDisplayed();
        assertionStep.verifyHeaderElementsTextForFailedTest();
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