package hw3.secondExerciseTestRun;

import hw3.abstractTest.BaseTest;
import hw3.config.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondExerciseRunTest extends BaseTest {

    private final static String login = ConfigProperties.getProperty("user");
    private final static String pass = ConfigProperties.getProperty("pass");

    @Test
    public void verifyDifferentElementsPage() {

        /* Open test site and assert valid URL */
        openMainPage();
        Assert.assertEquals(getURL(), "https://jdi-testing.github.io/jdi-light/index.html", "Wrong URL!");

        /* Assert Browser title */
        Assert.assertEquals(getTitle(), "Home Page", "Wrong title!");

        /* Search and click on button for enter login and password */
        homePage.loggIn(login,pass);

        /* Assert that Username is logged */
        Assert.assertEquals(homePage.getHeaderPageElements().userNameText.getText(), "ROMAN IOVLEV", "Invalid user!");

        /* Open through the header menu Service -> Different Elements Page */
        differentElementsPage.openDiffElPage();

        /* Assert that the valid page is opened */
        Assert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html", "Wrong URL!");

        /* Select checkboxes */
        differentElementsPage.selectWaterAndWindCheckboxes();

        /* Assert that valid checkboxes are selected */
        soft.assertTrue(differentElementsPage.checkBoxes.get(0).isSelected(),"Checkbox 'Water' is not selected!");
        soft.assertTrue(differentElementsPage.checkBoxes.get(2).isSelected(),"Checkbox 'Wind' is not selected!");

        /* Select radio */
        differentElementsPage.selectSelenRadio();

        /* Assert that valid radio is selected */
        soft.assertTrue(differentElementsPage.radioSelen.get(3).isSelected(),"Radio 'Selen' is not selected!");

        /* Select Yellow in dropdown */
        differentElementsPage.selectYellowColor();

        /* Assert that valid color is selected */
        soft.assertTrue(differentElementsPage.yellowColor.isDisplayed(),"Yellow color is not selected!");

        /* Assert that checkboxes have individual log row and value is corresponded to the status of checkboxes */
        soft.assertTrue(differentElementsPage.getRightSideBarElement().waterLog.isDisplayed(),"The Water checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().waterLog.getText().contains("true"),"The Water checkbox log has invalid value!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().windLog.isDisplayed(),"The Wind checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().windLog.getText().contains("true"),"The Wind checkbox log has invalid value!");

        /* Assert that radio button has individual log row and value is corresponded to the status of radio button */
        soft.assertTrue(differentElementsPage.getRightSideBarElement().metalRadioLog.isDisplayed(),"The metal radio button log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().metalRadioLog.getText().contains("Selen"),"The metal radio button log has invalid value!");

        /* Assert that dropdown has a log row and value is corresponded to the selected value.  */
        soft.assertTrue(differentElementsPage.getRightSideBarElement().colorsLog.isDisplayed(),"The Colors dropdown log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().colorsLog.getText().contains("Yellow"),"The Colors dropdown log has invalid value!");
        soft.assertAll();
    }
}