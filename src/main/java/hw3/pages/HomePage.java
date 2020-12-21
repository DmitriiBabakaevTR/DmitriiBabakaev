package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    private final HeaderPageElements headerPageElements;
    private final IndexPageImagesWithTextPageElement indexPageImagesWithTextPageElement;
    private final LeftSideMenuElement leftSideMenuElement;

    public HomePage(WebDriver driver) {
        super(driver);
        headerPageElements = new HeaderPageElements();
        indexPageImagesWithTextPageElement = new IndexPageImagesWithTextPageElement();
        leftSideMenuElement = new LeftSideMenuElement();
        PageFactory.initElements(driver, headerPageElements);
        PageFactory.initElements(driver, indexPageImagesWithTextPageElement);
        PageFactory.initElements(driver, leftSideMenuElement);
    }

    @FindBy(id = "frame")
    public WebElement iframe;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    @FindBy(xpath = "//h3[contains(text(),'EPAM')]")
    public WebElement textToCheckFocus;

    public HeaderPageElements getHeaderPageElements() {
        return headerPageElements;
    }

    public IndexPageImagesWithTextPageElement getIndexPageImagesWithTextPageElement() {
        return indexPageImagesWithTextPageElement;
    }

    public LeftSideMenuElement getLeftSideMenuElement() {
        return leftSideMenuElement;
    }

    public void loggIn(String user, String pass) {
        getHeaderPageElements().searchButton.click();
        getHeaderPageElements().inputName.click();
        getHeaderPageElements().inputName.sendKeys(user);
        getHeaderPageElements().inputPass.click();
        getHeaderPageElements().inputPass.sendKeys(pass);
        getHeaderPageElements().enterButton.click();
    }

    public void switchToFrame() {
        driver.switchTo().frame("frame");
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}