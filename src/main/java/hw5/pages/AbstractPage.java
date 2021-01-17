package hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String getTitle(){
        return driver.getTitle();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void assertThatAllElementsAreDisplayed(List<WebElement> elements) {
        boolean result = elements.stream().anyMatch(element -> !element.isDisplayed());
        Assert.assertFalse(result);
    }

    public void assertThatElementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }
}