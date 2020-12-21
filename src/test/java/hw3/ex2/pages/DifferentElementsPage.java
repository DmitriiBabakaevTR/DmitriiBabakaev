package hw3.ex2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {
    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Service')]")
    WebElement headerService;

    @FindBy(xpath = "//a[contains(@href,'different-elements')]")
    WebElement diffElements;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkBoxes;

    @FindBy(css = "label.label-radio > input")
    public List<WebElement> radioSelen;

    @FindBy(xpath = "//select")
    WebElement colorsDropDown;

    @FindBy(xpath = "//option[text()='Yellow']")
    public WebElement yellowColor;

    @FindBy(xpath = "//li[contains(text(), 'Water')]")
    public WebElement waterLog;

    @FindBy(xpath = "//li[contains(text(), 'Wind')]")
    public WebElement windLog;

    @FindBy(xpath = "//li[contains(text(), 'metal')]")
    public WebElement metalRadioLog;

    @FindBy(xpath = "//li[contains(text(), 'Colors')]")
    public WebElement colorsLog;


    public void openDiffElPage() {
        headerService.click();
        diffElements.click();
    }

    public void selectWaterAndWindCheckboxes() {
        checkBoxes.get(0).click();
        checkBoxes.get(2).click();
    }

    public void selectSelenRadio() {
        radioSelen.get(3).click();
    }

    public void selectYellowColor() {
        colorsDropDown.click();
        yellowColor.click();
    }
}
