package hw4.tests.firstExerciseTestRun;

import hw4.tests.abstractTest.BaseTest;
import org.testng.annotations.Test;

public class FirstExerciseRunTest extends BaseTest {

    @Test
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