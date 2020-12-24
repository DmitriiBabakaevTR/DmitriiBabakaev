package hw3.pages;

import hw3.pages.poElements.RightSideBarElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private final RightSideBarElement rightSideBarElement;

    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement headerService;

    @FindBy(xpath = "//a[contains(@href,'different-elements')]")
    private WebElement diffElements;

    @FindBy(xpath = "//label[contains(. ,'Water')]/input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[contains(. ,'Wind')]/input")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[contains(. ,'Selen')]/input")
    private WebElement radioSelen;

    @FindBy(xpath = "//select")
    private WebElement colorsDropDown;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowColor;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        rightSideBarElement = new RightSideBarElement();
        PageFactory.initElements(driver, rightSideBarElement);
    }

    public WebElement getWaterCheckbox() {
        return waterCheckbox;
    }

    public WebElement getWindCheckbox() {
        return windCheckbox;
    }

    public WebElement getRadioSelen() {
        return radioSelen;
    }

    public WebElement getYellowColor() {
        return yellowColor;
    }

    public RightSideBarElement getRightSideBarElement() {
        return rightSideBarElement;
    }

    public void openDiffElPage() {
        headerService.click();
        diffElements.click();
    }

    public void selectWaterAndWindCheckboxes() {
        waterCheckbox.click();
        windCheckbox.click();
    }

    public void selectSelenRadio() {
        radioSelen.click();
    }

    public void selectYellowColor() {
        colorsDropDown.click();
        yellowColor.click();
    }
}