package hw3.ex1.TestRun;

import hw3.ex1.pages.HomePage;
import hw3.webDriverManager.ChromeManager;
import hw3.webDriverManager.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstExerciseRunTest {

    public static HomePage homePage;
    SoftAssert soft = new SoftAssert();
    WebDriver driver;
    private final static String login = ConfigProperties.getProperty("user");
    private final static String pass = ConfigProperties.getProperty("pass");

    @BeforeClass(alwaysRun = true)
    public void SetUp() {
        driver = new ChromeManager().WebDriverSetUp();
        homePage = new HomePage(driver);
    }

    @Test
    public void FirstExerciseTest(){
        /* Open test site and assert valid URL */
        homePage.openPage();
        soft.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html","Wrong URL!");
        /* Assert Browser title */
        soft.assertEquals(homePage.getTitle(), "Home Page","Wrong title!");
        /* Search and click on button for enter login and password */
        homePage.loggIn(login,pass);
        /* Assert that Username is logged */
        soft.assertEquals(homePage.userNameText.getText(),"ROMAN IOVLEV", "Invalid user!");
        /* Assert that items are displayed */
        soft.assertTrue(homePage.homeItem.isDisplayed(),"Element 'Home' is not displayed!");
        soft.assertTrue(homePage.contactFormItem.isDisplayed(),"Element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.serviceItem.isDisplayed(),"Element 'Service' is not displayed!");
        soft.assertTrue(homePage.metalsColorsItem.isDisplayed(),"Element 'Metals & Colors' is not displayed!");
        /* Assert that items have proper text */
        soft.assertEquals(homePage.homeItem.getText(),"HOME", "Invalid text on button 'Home'!");
        soft.assertEquals(homePage.contactFormItem.getText(),"CONTACT FORM", "Invalid text on button 'Contact form'!");
        soft.assertEquals(homePage.serviceItem.getText(),"SERVICE", "Invalid text on button 'Service'!");
        soft.assertEquals(homePage.metalsColorsItem.getText(),"METALS & COLORS", "Invalid text on button 'Metals & Colors'!");
        /* Assert that there are 4 images on the Index Page and they are displayed */
        soft.assertTrue(homePage.microscopeImage.isDisplayed(),"Microscope image is not displayed!");
        soft.assertTrue(homePage.headphonesImage.isDisplayed(),"Headphones image is not displayed!");
        soft.assertTrue(homePage.monitorImage.isDisplayed(),"Monitor image is not displayed!");
        soft.assertTrue(homePage.rocketImage.isDisplayed(),"Rocket image is not displayed!");
        /* Assert that there are 4 proper texts on the Index Page under icons */
        soft.assertEquals(homePage.microscopeText.getText(),"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "Invalid text under microscope image!");
        soft.assertEquals(homePage.headphonesText.getText(),"To be flexible and\n" +
                "customizable", "Invalid text under headphones image!");
        soft.assertEquals(homePage.monitorText.getText(),"To be multiplatform", "Invalid text under monitor image!");
        soft.assertEquals(homePage.rocketText.getText(),"Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…", "Invalid text under rocket image!");
        /* Assert that there is the iframe with “Frame Button” exist */
        soft.assertTrue(homePage.iframe.isDisplayed(),"Valid iframe is not displayed!");
        /* Switch to the iframe and check that there is “Frame Button” in the iframe */
        driver.switchTo().frame("frame");
        soft.assertTrue(homePage.frameButton.isDisplayed(),"Frame Button is not displayed!");
        /* Switch to original window back */
        driver.switchTo().defaultContent();
        soft.assertTrue(homePage.textToCheckFocus.isDisplayed(),"You are not focused on the original window!");
        /* Assert that there are 5 items in the Left Section are displayed */
        soft.assertTrue(homePage.homeLeftElement.isDisplayed(),"Left element 'Home' is not displayed!");
        soft.assertTrue(homePage.contactFormLeftElement.isDisplayed(),"Left element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.serviceLeftElement.isDisplayed(),"Left element 'Service' is not displayed!");
        soft.assertTrue(homePage.metalsColorsLeftElement.isDisplayed(),"Left element 'Metals & Colors' is not displayed!");
        soft.assertTrue(homePage.elementsPacksLeftElement.isDisplayed(),"Left element 'Elements packs' is not displayed!");
        /* Assert that there are 5 proper button texts in Left Section */
        soft.assertEquals(homePage.homeLeftElement.getText(),"Home", "Invalid text on left button 'Home'!");
        soft.assertEquals(homePage.contactFormLeftElement.getText(),"Contact form", "Invalid text on left button 'Contact form'!");
        soft.assertEquals(homePage.serviceLeftElement.getText(),"Service", "Invalid text on left button 'Service'!");
        soft.assertEquals(homePage.metalsColorsLeftElement.getText(),"Metals & Colors", "Invalid text on left button 'Metals & Colors'!");
        soft.assertEquals(homePage.elementsPacksLeftElement.getText(),"Elements packs", "Invalid text on left button 'Elements packs'!");
        soft.assertAll();
    }
    @AfterClass(alwaysRun = true)
    private void tearDown() {
        driver.close();
    }
}
