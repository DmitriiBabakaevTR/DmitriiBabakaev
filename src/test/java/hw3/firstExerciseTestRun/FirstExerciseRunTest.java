package hw3.firstExerciseTestRun;

import hw3.abstractTest.BaseTest;
import org.testng.annotations.Test;

public class FirstExerciseRunTest extends BaseTest {

    @Test
    public void verifyHomePage() {

        /* Assert that items are displayed */
        soft.assertTrue(homePage.getHeaderPageElements().getHomeItem().isDisplayed(), "Element 'Home' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().getContactFormItem().isDisplayed(), "Element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().getServiceItem().isDisplayed(), "Element 'Service' is not displayed!");
        soft.assertTrue(homePage.getHeaderPageElements().getMetalsColorsItem().isDisplayed(), "Element 'Metals & Colors' is not displayed!");

        /* Assert that items have proper text */
        soft.assertEquals(homePage.getHeaderPageElements().getHomeItem().getText(),"HOME", "Invalid text on button 'Home'!");
        soft.assertEquals(homePage.getHeaderPageElements().getContactFormItem().getText(),"CONTACT FORM", "Invalid text on button 'Contact form'!");
        soft.assertEquals(homePage.getHeaderPageElements().getServiceItem().getText(),"SERVICE", "Invalid text on button 'Service'!");
        soft.assertEquals(homePage.getHeaderPageElements().getMetalsColorsItem().getText(),"METALS & COLORS", "Invalid text on button 'Metals & Colors'!");

        /* Assert that there are 4 images on the Index Page and they are displayed */
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getMicroscopeImage().isDisplayed(), "Microscope image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getHeadphonesImage().isDisplayed(), "Headphones image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getMonitorImage().isDisplayed(), "Monitor image is not displayed!");
        soft.assertTrue(homePage.getIndexPageImagesWithTextPageElement().getRocketImage().isDisplayed(), "Rocket image is not displayed!");

        /* Assert that there are 4 proper texts on the Index Page under icons */
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getMicroscopeText().getText(),"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "Invalid text under microscope image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getHeadphonesText().getText(),"To be flexible and\n" +
                "customizable", "Invalid text under headphones image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getMonitorText().getText(), "To be multiplatform", "Invalid text under monitor image!");
        soft.assertEquals(homePage.getIndexPageImagesWithTextPageElement().getRocketText().getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…", "Invalid text under rocket image!");

        /* Assert that there is the iframe with “Frame Button” exist */
        soft.assertTrue(homePage.getIframe().isDisplayed(), "Valid iframe is not displayed!");

        /* Switch to the iframe and check that there is “Frame Button” in the iframe */
        homePage.switchToFrame();
        soft.assertTrue(homePage.getFrameButton().isDisplayed(), "Frame Button is not displayed!");

        /* Switch to original window back */
        homePage.switchToOriginalWindow();
        soft.assertTrue(homePage.getTextToCheckFocus().isDisplayed(), "You are not focused on the original window!");

        /* Assert that there are 5 items in the Left Section are displayed */
        soft.assertTrue(homePage.getLeftSideMenuElement().getHomeLeftElement().isDisplayed(), "Left element 'Home' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getContactFormLeftElement().isDisplayed(), "Left element 'Contact form' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getServiceLeftElement().isDisplayed(), "Left element 'Service' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getMetalsColorsLeftElement().isDisplayed(), "Left element 'Metals & Colors' is not displayed!");
        soft.assertTrue(homePage.getLeftSideMenuElement().getElementsPacksLeftElement().isDisplayed(), "Left element 'Elements packs' is not displayed!");

        /* Assert that there are 5 proper button texts in Left Section */
        soft.assertEquals(homePage.getLeftSideMenuElement().getHomeLeftElement().getText(), "Home", "Invalid text on left button 'Home'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getContactFormLeftElement().getText(), "Contact form", "Invalid text on left button 'Contact form'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getServiceLeftElement().getText(), "Service", "Invalid text on left button 'Service'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getMetalsColorsLeftElement().getText(), "Metals & Colors", "Invalid text on left button 'Metals & Colors'!");
        soft.assertEquals(homePage.getLeftSideMenuElement().getElementsPacksLeftElement().getText(), "Elements packs", "Invalid text on left button 'Elements packs'!");
        soft.assertAll();
    }
}