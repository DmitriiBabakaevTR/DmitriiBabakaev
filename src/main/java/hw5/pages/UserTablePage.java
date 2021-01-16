package hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends AbstractPage {

    @FindBy(css = "td > select")
    List<WebElement> numberTypeDropdowns;

    @FindBy(css = "td > a")
    List<WebElement> userNames;

    @FindBy(css = ".user-descr")
    List<WebElement> userDescriptions;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    List<WebElement> userCheckboxes;

    @FindBy(id = "ivan")
    private WebElement ivanCheckbox;

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> getUserDescriptions() {
        return userDescriptions;
    }

    public List<WebElement> getUserCheckboxes() {
        return userCheckboxes;
    }

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public void userTable(String number, String user, String description) {

        String numberExpression = "//td[contains(text()," + number + ")]";
        String userExpression = "//a[contains(text(),'" + user + "')]";
        String descriptionExpression = "//span[contains(. ,'" + description.substring(0,3) + "')]";
        List<WebElement> table = new ArrayList<>();
        table.add(driver.findElement(By.xpath(numberExpression)));
        table.add(driver.findElement(By.xpath(userExpression)));
        table.add(driver.findElement(By.xpath(descriptionExpression)));
        assertThatAllElementsAreDisplayed(table);
    }

    public void elementsInDropdownRoman(String element) {
        String xpathExpr = "//select/option[contains(. ,'" + element + "')]";
        numberTypeDropdowns.get(0).click();
        assertThatElementIsDisplayed(driver.findElement(By.xpath(xpathExpr)));
    }

    public void selectIvanCheckbox() {
        ivanCheckbox.click();
    }

    public void logRowHasProperText(String expectedText) {
        String xpathExpr = "//li[contains(. ,'" + expectedText.substring(0,3) + "')]";
        assertThatElementIsDisplayed(driver.findElement(By.xpath(xpathExpr)));
    }
}