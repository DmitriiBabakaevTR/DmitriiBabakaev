package hw3.secondExerciseTestRun;

import hw3.abstractTest.BaseTest;
import hw3.pages.DifferentElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondExerciseRunTest extends BaseTest {

    @Test
    public void verifyDifferentElementsPage() {

        /* Open through the header menu Service -> Different Elements Page */
        differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.openDiffElPage();

        /* Assert that the valid page is opened */
        Assert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html", "Wrong URL!");

        /* Select checkboxes */
        differentElementsPage.selectWaterAndWindCheckboxes();

        /* Assert that valid checkboxes are selected */
        soft.assertTrue(differentElementsPage.getWaterCheckboxe().isSelected(),"Checkbox 'Water' is not selected!");
        soft.assertTrue(differentElementsPage.getWindCheckboxe().isSelected(),"Checkbox 'Wind' is not selected!");

        /* Select radio */
        differentElementsPage.selectSelenRadio();

        /* Assert that valid radio is selected */
        soft.assertTrue(differentElementsPage.getRadioSelen().get(3).isSelected(),"Radio 'Selen' is not selected!");

        /* Select Yellow in dropdown */
        differentElementsPage.selectYellowColor();

        /* Assert that valid color is selected */
        soft.assertTrue(differentElementsPage.getYellowColor().isDisplayed(),"Yellow color is not selected!");

        /* Assert that checkboxes have individual log row and value is corresponded to the status of checkboxes */
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWaterLog().isDisplayed(),"The Water checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWaterLog().getText().contains("true"),"The Water checkbox log has invalid value!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWindLog().isDisplayed(),"The Wind checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWindLog().getText().contains("true"),"The Wind checkbox log has invalid value!");

        /* Assert that radio button has individual log row and value is corresponded to the status of radio button */
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getMetalRadioLog().isDisplayed(),"The metal radio button log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getMetalRadioLog().getText().contains("Selen"),"The metal radio button log has invalid value!");

        /* Assert that dropdown has a log row and value is corresponded to the selected value.  */
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getColorsLog().isDisplayed(),"The Colors dropdown log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getColorsLog().getText().contains("Yellow"),"The Colors dropdown log has invalid value!");
        soft.assertAll();
    }
}