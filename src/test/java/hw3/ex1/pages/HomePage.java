package hw3.ex1.pages;

import hw3.webDriverManager.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//title[text()='Home Page']")
    WebElement titleText;

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

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement homeItem;

    @FindBy(xpath = "//a[text()='Contact form']")
    public WebElement contactFormItem;

    @FindBy(xpath = "//a[contains(text(),'Service')]")
    public WebElement serviceItem;

    @FindBy(xpath = "//a[text()='Metals & Colors']")
    public WebElement metalsColorsItem;

    @FindBy(css = ".icon-practise")
    public WebElement microscopeImage;

    @FindBy(css = ".icon-custom")
    public WebElement headphonesImage;

    @FindBy(css = ".icon-multi")
    public WebElement monitorImage;

    @FindBy(css = ".icon-base")
    public WebElement rocketImage;

    @FindBy(xpath = "//span[contains(text(),'To include good practices')]")
    public WebElement microscopeText;

    @FindBy(xpath = "//span[contains(text(),'To be flexible and')]")
    public WebElement headphonesText;

    @FindBy(xpath = "//span[contains(text(),'To be multiplatform')]")
    public WebElement monitorText;

    @FindBy(xpath = "//span[contains(text(),'Already have good base')]")
    public WebElement rocketText;

    @FindBy(id = "frame")
    public WebElement iframe;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    @FindBy(xpath = "//h3[contains(text(),'EPAM')]")
    public WebElement textToCheckFocus;

    @FindBy(xpath = "//span[text()='Home']")
    public WebElement homeLeftElement;

    @FindBy(xpath = "//span[text()='Contact form']")
    public WebElement contactFormLeftElement;

    @FindBy(xpath = "//span[text()='Service']")
    public WebElement serviceLeftElement;

    @FindBy(xpath = "//span[text()='Metals & Colors']")
    public WebElement metalsColorsLeftElement;

    @FindBy(xpath = "//span[text()='Elements packs']")
    public WebElement elementsPacksLeftElement;

    public void openPage() {
        driver.get(ConfigProperties.getProperty("URL"));
    }

    public void loggIn(String user, String pass){
        searchButton.click();
        inputName.click();
        inputName.sendKeys(user);
        inputPass.click();
        inputPass.sendKeys(pass);
        enterButton.click();
    }
    public String getTitle(){
        return titleText.getText();
    }
}








