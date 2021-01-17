package hw5.pages;

import hw5.config.ConfigProperties;
import hw5.pages.poElements.HeaderPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    private final HeaderPageElements headerPageElements;

    public HomePage(WebDriver driver) {
        super(driver);
        headerPageElements = new HeaderPageElements();
        PageFactory.initElements(driver, headerPageElements);
    }

    public HeaderPageElements getHeaderPageElements() {
        return headerPageElements;
    }

    public void openPage() {
        driver.get(ConfigProperties.getProperty("URL"));
    }

    public void loggIn(String user, String pass) {
        getHeaderPageElements().getSearchButton().click();
        getHeaderPageElements().getInputName().sendKeys(user);
        getHeaderPageElements().getInputPass().sendKeys(pass);
        getHeaderPageElements().getEnterButton().click();
    }
}