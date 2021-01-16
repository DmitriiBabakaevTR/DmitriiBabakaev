package hw5.pages.poElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightSideBarElement {

    @FindBy(xpath = "//li[contains(text(), 'Water')]")
    private WebElement waterLog;

    @FindBy(xpath = "//li[contains(text(), 'Wind')]")
    private WebElement windLog;

    @FindBy(xpath = "//li[contains(text(), 'metal')]")
    private WebElement metalRadioLog;

    @FindBy(xpath = "//li[contains(text(), 'Colors')]")
    private WebElement colorsLog;

    public WebElement getWaterLog() {
        return waterLog;
    }

    public WebElement getWindLog() {
        return windLog;
    }

    public WebElement getMetalRadioLog() {
        return metalRadioLog;
    }

    public WebElement getColorsLog() {
        return colorsLog;
    }
}