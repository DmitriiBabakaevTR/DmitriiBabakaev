package hw3.ex2.pages;

import hw3.webDriverManager.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, '#')]")
    WebElement searchButton;

    @FindBy(id = "name")
    WebElement inputName;

    @FindBy(id = "password")
    WebElement inputPass;

    @FindBy(id = "login-button")
    WebElement enterButton;

    @FindBy(id = "user-name")
    public WebElement userNameText;



    public HomePage openPage() {
        driver.get(ConfigProperties.getProperty("URL"));
        return this;
    }

    public void loggIn() {
        searchButton.click();
        inputName.click();
        inputName.sendKeys(ConfigProperties.getProperty("user"));
        inputPass.click();
        inputPass.sendKeys(ConfigProperties.getProperty("pass"));
        enterButton.click();
    }
    }
