package hw2.ex2;

import hw2.baseOptions.ChromeManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Exercise2 {

    SoftAssert soft = new SoftAssert();
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void SetUp() {
        driver = new ChromeManager().WebDriverSetUp();
    }

    @Test
    public void secondExerciseSoftAssertTest() {

        /* Open test site by URL */
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        soft.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html", "Wrong URL!");

        /* Assert Browser title */
        soft.assertEquals(driver.getTitle(), "Home Page","Wrong title!");

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

        /* Assert that Username is loggined */
        soft.assertEquals(driver.findElement(By.id("user-name")).getText(),"ROMAN IOVLEV", "Invalid user!");

        /* Open through the header menu Service -> Different Elements Page */
        searchbtn = driver.findElement(By.xpath("//a[contains(text(),'Service')]"));
        searchbtn.click();
        searchbtn = driver.findElement(By.xpath("//a[contains(@href,'different-elements')]"));
        searchbtn.click();

        /* Assert that the valid page is opened */
        soft.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html", "Wrong URL!");

        /* Select checkboxes */
        List<WebElement> searchbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        searchbox.get(0).click();
        searchbox.get(2).click();

        /* Assert that valid checkboxes are selected */
        soft.assertTrue(searchbox.get(0).isSelected(),"Checkbox 'Water' is not selected!");
        soft.assertTrue(searchbox.get(2).isSelected(),"Checkbox 'Wind' is not selected!");

        /* Select radio */
        List<WebElement> searcradio = driver.findElements(By.cssSelector("label.label-radio > input"));
        searcradio.get(3).click();

        /* Assert that valid radio is selected */
        soft.assertTrue(searcradio.get(3).isSelected(),"Radio 'Selen' is not selected!");

        /* Select Yellow in dropdown */
        WebElement searchDropDown = driver.findElement(By.xpath("//select"));
        searchDropDown.click();
        WebElement searchColor = driver.findElement(By.xpath("//option[text()='Yellow']"));
        searchColor.click();

        /* Assert that valid radio is selected */
        soft.assertTrue(driver.findElement(By.xpath("//option[text()='Yellow']")).isDisplayed(),"Yellow color is not selected!");

        /* Assert that checkboxes have individual log row and value is corresponded to the status of checkboxes */
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'Water')]")).isDisplayed(),"The Water checkbox log is not displayed!");
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'Water')]")).getText().contains("true"),"The Water checkbox log has invalid value!");
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'Wind')]")).isDisplayed(),"The Wind checkbox log is not displayed!");
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'Wind')]")).getText().contains("true"),"The Wind checkbox log has invalid value!");

        /* Assert that radio button has individual log row and value is corresponded to the status of radio button */
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'metal')]")).isDisplayed(),"The metal radio button log is not displayed!");
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'metal')]")).getText().contains("Selen"),"The metal radio button log has invalid value!");

        /* Assert that dropdown has a log row and value is corresponded to the selected value.  */
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'Colors')]")).isDisplayed(),"The Colors dropdown log is not displayed!");
        soft.assertTrue(driver.findElement(By.xpath("//li[contains(text(), 'Colors')]")).getText().contains("Yellow"),"The Colors dropdown log has invalid value!");
        soft.assertAll();
    }

    @AfterClass(alwaysRun = true)
    private void tearDown() {
        driver.close();
    }
}
