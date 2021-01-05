package hw4.tests.secondExerciseTestRun;

import hw4.tests.abstractTest.BaseTest;
import org.testng.annotations.Test;

public class SecondExerciseRunTest extends BaseTest {

    @Test(description = "Тестирование страницы Different element")
    public void verifyDifferentElementsPage() {

        actionStep.openMainPage();
        assertionStep.verifyHomePageURLAndTitle();
        actionStep.loggInHomePage();
        assertionStep.verifyLoggIn();
        actionStep.openDifferentElementsPage();
        assertionStep.verifyDifferentElementsPageURL();
        actionStep.selectProperCheckboxes();
        assertionStep.verifyCheckboxesAreSelected();
        actionStep.selectRadioButton();
        assertionStep.verifyRadioButtonIsSelected();
        actionStep.selectDropDownColor();
        assertionStep.verifyYellowColorIsSelected();
        assertionStep.verifyCheckboxesLogsAndItsStatus();
        assertionStep.verifyRadioButtonLogAndItsStatus();
        assertionStep.verifyDropDownLogAndItsStatus();
        soft.assertAll();
    }
}