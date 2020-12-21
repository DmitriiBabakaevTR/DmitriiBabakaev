package hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenuElement{

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
}