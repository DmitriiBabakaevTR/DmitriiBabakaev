package hw2.ex1;

import hw2.AbstractTest.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstExerciseTestRun extends AbstractBaseTest {

    @Test
    public void verifyMainPage() {

        /* Open test site by URL */
        openMainPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html", "Wrong URL!");

        /* Assert Browser title */
        Assert.assertEquals(getTitle(), "Home Page", "Wrong title!");

        /* Search and click on button for enter login and password */
        WebElement searchbtn = driver.findElement(By.xpath("//a[contains(@href, '#')]"));
        searchbtn.click();

        /* Enter login */
        WebElement searchInput = driver.findElement(By.id("name"));
        searchInput.click();
        searchInput.sendKeys("Roman");

        /* Enter password */
        searchInput = driver.findElement(By.id("password"));
        searchInput.click();
        searchInput.sendKeys("Jdi1234");

        /* Click on "ENTER" button */
        searchInput = driver.findElement(By.id("login-button"));
        searchInput.click();

        /* Assert that Username is logged */
        Assert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV", "Invalid user!");

        /* Assert that items are displayed */
        soft.assertTrue(getImageByKeyword("Home").isDisplayed(), "Element 'Home' is not displayed!");
        soft.assertTrue(getImageByKeyword("Contact form").isDisplayed(), "Element 'Contact form' is not displayed!");
        soft.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Service')]")).isDisplayed(), "Element 'Service' is not displayed!");
        soft.assertTrue(getImageByKeyword("Metals & Colors").isDisplayed(), "Element 'Metals & Colors' is not displayed!");

        /* Assert that items have proper text */
        soft.assertEquals(getImageByKeyword("Home").getText(), "HOME", "Invalid text on button 'Home'!");
        soft.assertEquals(getImageByKeyword("Contact form").getText(), "CONTACT FORM", "Invalid text on button 'Contact form'!");
        soft.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Service')]")).getText(), "SERVICE", "Invalid text on button 'Service'!");
        soft.assertEquals(getImageByKeyword("Metals & Colors").getText(), "METALS & COLORS", "Invalid text on button 'Metals & Colors'!");

        /* Assert that there are 4 images on the Index Page and they are displayed */
        soft.assertTrue(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed(), "Microscope image is not displayed!");
        soft.assertTrue(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed(), "Headphones image is not displayed!");
        soft.assertTrue(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed(), "Monitor image is not displayed!");
        soft.assertTrue(driver.findElement(By.cssSelector(".icon-base")).isDisplayed(), "Rocket image is not displayed!");

        /* Assert that there are 4 proper texts on the Index Page under icons */
        soft.assertEquals(getImageTextByKeyword("To include good practices").getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "Invalid text under microscope image!");
        soft.assertEquals(getImageTextByKeyword("To be flexible and").getText(), "To be flexible and\n" +
                "customizable", "Invalid text under headphones image!");
        soft.assertEquals(getImageTextByKeyword("To be multiplatform").getText(), "To be multiplatform", "Invalid text under monitor image!");
        soft.assertEquals(getImageTextByKeyword("Already have good base").getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…", "Invalid text under rocket image!");

        /* Assert that there is the iframe with “Frame Button” exist */
        soft.assertTrue(driver.findElement(By.id("frame")).isDisplayed(), "Valid iframe is not displayed!");

        /* Switch to the iframe and check that there is “Frame Button” in the iframe */
        driver.switchTo().frame("frame");
        soft.assertTrue(driver.findElement(By.id("frame-button")).isDisplayed(), "Frame Button is not displayed!");

        /* Switch to original window back */
        driver.switchTo().defaultContent();
        soft.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'EPAM')]")).isDisplayed(), "You are not focused on the original window!");

        /* Assert that there are 5 items in the Left Section are displayed */
        soft.assertTrue(getTextByKeyword("Home").isDisplayed(), "Left element 'Home' is not displayed!");
        soft.assertTrue(getTextByKeyword("Contact form").isDisplayed(), "Left element 'Contact form' is not displayed!");
        soft.assertTrue(getTextByKeyword("Service").isDisplayed(), "Left element 'Service' is not displayed!");
        soft.assertTrue(getTextByKeyword("Metals & Colors").isDisplayed(), "Left element 'Metals & Colors' is not displayed!");
        soft.assertTrue(getTextByKeyword("Elements packs").isDisplayed(), "Left element 'Elements packs' is not displayed!");

        /* Assert that there are 5 proper button texts in Left Section */
        soft.assertEquals(getTextByKeyword("Home").getText(), "Home", "Invalid text on left button 'Home'!");
        soft.assertEquals(getTextByKeyword("Contact form").getText(), "Contact form", "Invalid text on left button 'Contact form'!");
        soft.assertEquals(getTextByKeyword("Service").getText(), "Service", "Invalid text on left button 'Service'!");
        soft.assertEquals(getTextByKeyword("Metals & Colors").getText(), "Metals & Colors", "Invalid text on left button 'Metals & Colors'!");
        soft.assertEquals(getTextByKeyword("Elements packs").getText(), "Elements packs", "Invalid text on left button 'Elements packs'!");
        soft.assertAll();
    }

    public WebElement getTextByKeyword(String word) {
        String locator = String.format("//span[text()= '%s']", word);
        return driver.findElement(By.xpath(locator));
    }

    public WebElement getImageTextByKeyword(String word) {
        String itLocator = String.format("//span[contains(text(), '%s')]", word);
        return driver.findElement(By.xpath(itLocator));
    }

    public WebElement getImageByKeyword(String word) {
        String iLocator = String.format("//a[text()= '%s']", word);
        return driver.findElement(By.xpath(iLocator));
    }
}