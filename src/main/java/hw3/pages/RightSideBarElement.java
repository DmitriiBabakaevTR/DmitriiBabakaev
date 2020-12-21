package hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightSideBarElement {

    @FindBy(xpath = "//li[contains(text(), 'Water')]")
    public WebElement waterLog;

    @FindBy(xpath = "//li[contains(text(), 'Wind')]")
    public WebElement windLog;

    @FindBy(xpath = "//li[contains(text(), 'metal')]")
    public WebElement metalRadioLog;

    @FindBy(xpath = "//li[contains(text(), 'Colors')]")
    public WebElement colorsLog;
}