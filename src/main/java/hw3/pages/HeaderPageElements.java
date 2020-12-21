package hw3.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HeaderPageElements {

    @FindBy(xpath = "//a[contains(@href, '#')]")
    public WebElement searchButton;

    @FindBy(id = "name")
    public WebElement inputName;

    @FindBy(id = "password")
    public WebElement inputPass;

    @FindBy(id = "login-button")
    public WebElement enterButton;

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
}