package hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw6.entities.User;
import hw6.forms.LoggInForm;

public class JdiHomePage extends WebPage {

    @Css("#user-icon")
    private Icon userIcon;

    @Css("#user-name")
    private Label userName;

    @FindBy(xpath = "//a[text()='Metals & Colors']")
    public Button metalsAndColors;

    public LoggInForm loggInForm;

    public void loggIn(User user) {
        userIcon.click();
        loggInForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void openMetalsAndColors() {
        metalsAndColors.click();
    }
}
