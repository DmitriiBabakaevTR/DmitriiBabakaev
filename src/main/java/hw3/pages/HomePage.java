package hw3.pages;

import hw3.pages.poElements.HeaderPageElements;
import hw3.pages.poElements.IndexPageImagesWithTextPageElement;
import hw3.pages.poElements.LeftSideMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    private final HeaderPageElements headerPageElements;
    private final IndexPageImagesWithTextPageElement indexPageImagesWithTextPageElement;
    private final LeftSideMenuElement leftSideMenuElement;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(xpath = "//h3[contains(text(),'EPAM')]")
    private WebElement textToCheckFocus;

    public HomePage(WebDriver driver) {
        super(driver);
        headerPageElements = new HeaderPageElements();
        indexPageImagesWithTextPageElement = new IndexPageImagesWithTextPageElement();
        leftSideMenuElement = new LeftSideMenuElement();
        PageFactory.initElements(driver, headerPageElements);
        PageFactory.initElements(driver, indexPageImagesWithTextPageElement);
        PageFactory.initElements(driver, leftSideMenuElement);
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public WebElement getTextToCheckFocus() {
        return textToCheckFocus;
    }

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
        getHeaderPageElements().getSearchButton().click();
        getHeaderPageElements().getInputName().sendKeys(user);
        getHeaderPageElements().getInputPass().sendKeys(pass);
        getHeaderPageElements().getEnterButton().click();
    }

    public void switchToFrame() {
        driver.switchTo().frame("frame");
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }
}