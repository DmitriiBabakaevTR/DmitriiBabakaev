package hw3.pages.poElements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HeaderPageElements {

    @FindBy(xpath = "//a[contains(@href, '#')]")
    private WebElement searchButton;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement homeItem;

    @FindBy(xpath = "//a[text()='Contact form']")
    private WebElement contactFormItem;

    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceItem;

    @FindBy(xpath = "//a[text()='Metals & Colors']")
    private WebElement metalsColorsItem;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getInputName() {
        return inputName;
    }

    public WebElement getInputPass() {
        return inputPass;
    }

    public WebElement getEnterButton() {
        return enterButton;
    }

    public WebElement getUserNameText() {
        return userNameText;
    }

    public WebElement getHomeItem() {
        return homeItem;
    }

    public WebElement getContactFormItem() {
        return contactFormItem;
    }

    public WebElement getServiceItem() {
        return serviceItem;
    }

    public WebElement getMetalsColorsItem() {
        return metalsColorsItem;
    }
}