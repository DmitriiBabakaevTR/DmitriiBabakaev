package hw4.pages.poElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenuElement{

    @FindBy(xpath = "//span[text()='Home']")
    private WebElement homeLeftElement;

    @FindBy(xpath = "//span[text()='Contact form']")
    private WebElement contactFormLeftElement;

    @FindBy(xpath = "//span[text()='Service']")
    private WebElement serviceLeftElement;

    @FindBy(xpath = "//span[text()='Metals & Colors']")
    private WebElement metalsColorsLeftElement;

    @FindBy(xpath = "//span[text()='Elements packs']")
    private WebElement elementsPacksLeftElement;

    public WebElement getHomeLeftElement() {
        return homeLeftElement;
    }

    public WebElement getContactFormLeftElement() {
        return contactFormLeftElement;
    }

    public WebElement getServiceLeftElement() {
        return serviceLeftElement;
    }

    public WebElement getMetalsColorsLeftElement() {
        return metalsColorsLeftElement;
    }

    public WebElement getElementsPacksLeftElement() {
        return elementsPacksLeftElement;
    }
}