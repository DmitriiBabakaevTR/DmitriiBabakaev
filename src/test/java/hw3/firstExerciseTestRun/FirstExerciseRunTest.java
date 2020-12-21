package hw3.firstExerciseTestRun;

import hw3.abstractTest.BaseTest;
import hw3.config.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstExerciseRunTest extends BaseTest {

    private final static String login = ConfigProperties.getProperty("user");
    private final static String pass = ConfigProperties.getProperty("pass");

    @Test
    public void verifyHomePage() {

        /* Open test site and assert valid URL */
        openMainPage();
        Assert.assertEquals(getURL(), "https://jdi-testing.github.io/jdi-light/index.html", "Wrong URL!");

        /* Assert Browser title */
        Assert.assertEquals(getTitle(), "Home Page", "Wrong title!");

        /* Search and click on button for enter login and password */
        homePage.loggIn(login, pass);

        /* Assert that Username is logged */
        Assert.assertEquals(homePage.getHeaderPageElements().userNameText.getText(), "ROMAN IOVLEV", "Invalid user!");

        /* Assert that items are displayed */
        soft.assertTrue(homePage.getHeaderPageElements().homeItem.isDisplayed(), "Element 'Home' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().contactFormItem.isDisplayed(), "Element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().serviceItem.isDisplayed(), "Element 'Service' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().metalsColorsItem.isDisplayed(), "Element 'Metals & Colors' is not displayed!");

        /* Assert that items have proper text */
        soft.assertEquals(homePage.getHeaderPageElements().homeItem.getText(),"HOME", "Invalid text on button 'Home'!");
        soft.assertEquals(homePage.getHeaderPageElements().contactFormItem.getText(),"CONTACT FORM", "Invalid text on button 'Contact form'!");
        soft.assertEquals(homePage.getHeaderPageElements().serviceItem.getText(),"SERVICE", "Invalid text on button 'Service'!");
        soft.assertEquals(homePage.getHeaderPageElements().metalsColorsItem.getText(),"METALS & COLORS", "Invalid text on button 'Metals & Colors'!");

        /* Assert that there are 4 images on the Index Page and they are displayed */
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().microscopeImage.isDisplayed(), "Microscope image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().headphonesImage.isDisplayed(), "Headphones image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().monitorImage.isDisplayed(), "Monitor image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().rocketImage.isDisplayed(), "Rocket image is not displayed!");

        /* Assert that there are 4 proper texts on the Index Page under icons */
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().microscopeText.getText(),"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "Invalid text under microscope image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().headphonesText.getText(),"To be flexible and\n" +
                "customizable", "Invalid text under headphones image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().monitorText.getText(), "To be multiplatform", "Invalid text under monitor image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().rocketText.getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…", "Invalid text under rocket image!");

        /* Assert that there is the iframe with “Frame Button” exist */
        soft.assertTrue(homePage.iframe.isDisplayed(), "Valid iframe is not displayed!");

        /* Switch to the iframe and check that there is “Frame Button” in the iframe */
        homePage.switchToFrame();
        soft.assertTrue(homePage.frameButton.isDisplayed(), "Frame Button is not displayed!");

        /* Switch to original window back */
        homePage.switchToOriginalWindow();
        soft.assertTrue(homePage.textToCheckFocus.isDisplayed(), "You are not focused on the original window!");

        /* Assert that there are 5 items in the Left Section are displayed */
        soft.assertTrue(homePage.getLeftSideMenuElement().homeLeftElement.isDisplayed(), "Left element 'Home' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().contactFormLeftElement.isDisplayed(), "Left element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().serviceLeftElement.isDisplayed(), "Left element 'Service' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().metalsColorsLeftElement.isDisplayed(), "Left element 'Metals & Colors' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().elementsPacksLeftElement.isDisplayed(), "Left element 'Elements packs' is not displayed!");

        /* Assert that there are 5 proper button texts in Left Section */
        soft.assertEquals(homePage.getLeftSideMenuElement().homeLeftElement.getText(), "Home", "Invalid text on left button 'Home'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().contactFormLeftElement.getText(), "Contact form", "Invalid text on left button 'Contact form'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().serviceLeftElement.getText(), "Service", "Invalid text on left button 'Service'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().metalsColorsLeftElement.getText(), "Metals & Colors", "Invalid text on left button 'Metals & Colors'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().elementsPacksLeftElement.getText(), "Elements packs", "Invalid text on left button 'Elements packs'!");
        soft.assertAll();
    }
}