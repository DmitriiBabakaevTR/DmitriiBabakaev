package hw3.ex2.testRun;

import hw3.ex2.pages.DifferentElementsPage;
import hw3.ex2.pages.HomePage;
import hw3.webDriverManager.ChromeManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondExerciseRunTest {

    public static HomePage homePage;
    public static DifferentElementsPage differentElementsPage;
    SoftAssert soft = new SoftAssert();
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void SetUp() {
        driver = new ChromeManager().WebDriverSetUp();
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);

    }

    @Test
    public void FirstExerciseTest() {
        /* Open test site and assert valid URL */
        homePage.openPage();
        soft.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html", "Wrong URL!");
        /* Assert Browser title */
        soft.assertEquals(driver.getTitle(), "Home Page", "Wrong title!");
        /* Search and click on button for enter login and password */
        homePage.loggIn();
        /* Assert that Username is logged */
        soft.assertEquals(homePage.userNameText.getText(), "ROMAN IOVLEV", "Invalid user!");
        /* Open through the header menu Service -> Different Elements Page */
        differentElementsPage.openDiffElPage();
        /* Assert that the valid page is opened */
        soft.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html", "Wrong URL!");
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
        soft.assertTrue(differentElementsPage.waterLog.isDisplayed(),"The Water checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.waterLog.getText().contains("true"),"The Water checkbox log has invalid value!");
        soft.assertTrue(differentElementsPage.windLog.isDisplayed(),"The Wind checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.windLog.getText().contains("true"),"The Wind checkbox log has invalid value!");
        /* Assert that radio button has individual log row and value is corresponded to the status of radio button */
        soft.assertTrue(differentElementsPage.metalRadioLog.isDisplayed(),"The metal radio button log is not displayed!");
        soft.assertTrue(differentElementsPage.metalRadioLog.getText().contains("Selen"),"The metal radio button log has invalid value!");
        /* Assert that dropdown has a log row and value is corresponded to the selected value.  */
        soft.assertTrue(differentElementsPage.colorsLog.isDisplayed(),"The Colors dropdown log is not displayed!");
        soft.assertTrue(differentElementsPage.colorsLog.getText().contains("Yellow"),"The Colors dropdown log has invalid value!");
        soft.assertAll();
    }
    @AfterClass(alwaysRun = true)
    private void tearDown() {
        driver.close();
    }

}
