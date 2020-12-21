package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private final RightSideBarElement rightSideBarElement;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        rightSideBarElement = new RightSideBarElement();
        PageFactory.initElements(driver, rightSideBarElement);
    }

    @FindBy(xpath = "//a[contains(text(),'Service')]")
    public WebElement headerService;

    @FindBy(xpath = "//a[contains(@href,'different-elements')]")
    public WebElement diffElements;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkBoxes;

    @FindBy(css = "label.label-radio > input")
    public List<WebElement> radioSelen;

    @FindBy(xpath = "//select")
    public WebElement colorsDropDown;

    @FindBy(xpath = "//option[text()='Yellow']")
    public WebElement yellowColor;

    public RightSideBarElement getRightSideBarElement() {
        return rightSideBarElement;
    }

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