package hw5.pages.poElements;

import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceItem;

    @FindBy(xpath = "//a[text()='User Table ']")
    private WebElement userTable;

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

    public WebElement getServiceItem() {
        return serviceItem;
    }

    public WebElement getUserTable() {
        return userTable;
    }
}