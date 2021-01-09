package hw4.tests.secondExerciseTestRun;

import hw4.tests.abstractTest.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Домашняя работа №4, Allure and jenkins")
@Story("Упражнение №1")
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