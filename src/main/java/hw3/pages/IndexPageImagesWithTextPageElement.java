package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPageImagesWithTextPageElement{



    @FindBy(css = ".icon-practise")
    public WebElement microscopeImage;

    @FindBy(css = ".icon-custom")
    public WebElement headphonesImage;

    @FindBy(css = ".icon-multi")
    public WebElement monitorImage;

    @FindBy(css = ".icon-base")
    public WebElement rocketImage;

    @FindBy(xpath = "//span[contains(text(),'To include good practices')]")
    public WebElement microscopeText;

    @FindBy(xpath = "//span[contains(text(),'To be flexible and')]")
    public WebElement headphonesText;

    @FindBy(xpath = "//span[contains(text(),'To be multiplatform')]")
    public WebElement monitorText;

    @FindBy(xpath = "//span[contains(text(),'Already have good base')]")
    public WebElement rocketText;
}