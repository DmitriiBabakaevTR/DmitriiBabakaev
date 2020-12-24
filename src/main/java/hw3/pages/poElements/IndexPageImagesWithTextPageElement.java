package hw3.pages.poElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPageImagesWithTextPageElement{

    @FindBy(css = ".icon-practise")
    private WebElement microscopeImage;

    @FindBy(css = ".icon-custom")
    private WebElement headphonesImage;

    @FindBy(css = ".icon-multi")
    private WebElement monitorImage;

    @FindBy(css = ".icon-base")
    private WebElement rocketImage;

    @FindBy(xpath = "//span[contains(text(),'To include good practices')]")
    private WebElement microscopeText;

    @FindBy(xpath = "//span[contains(text(),'To be flexible and')]")
    private WebElement headphonesText;

    @FindBy(xpath = "//span[contains(text(),'To be multiplatform')]")
    private WebElement monitorText;

    @FindBy(xpath = "//span[contains(text(),'Already have good base')]")
    private WebElement rocketText;

    public WebElement getMicroscopeImage() {
        return microscopeImage;
    }

    public WebElement getHeadphonesImage() {
        return headphonesImage;
    }

    public WebElement getMonitorImage() {
        return monitorImage;
    }

    public WebElement getRocketImage() {
        return rocketImage;
    }

    public WebElement getMicroscopeText() {
        return microscopeText;
    }

    public WebElement getHeadphonesText() {
        return headphonesText;
    }

    public WebElement getMonitorText() {
        return monitorText;
    }

    public WebElement getRocketText() {
        return rocketText;
    }
}