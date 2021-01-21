package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw6.entities.MetalsColors;
import hw6.entities.User;
import hw6.pages.JdiHomePage;
import hw6.pages.JdiMetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static JdiMetalsColorsPage jdiMetalsColorsPage;

    public static void IOpenHomePage() {
        jdiHomePage.open();
    }

    public static void ILoggIn(User user) {
        jdiHomePage.loggIn(user);
    }

    public static String IGetFullUserName() {
        return jdiHomePage.getUserName();
    }

    public static void IOpenMetalsAndColorsPage(){
        jdiHomePage.openMetalsAndColors();
    }

    public static void IFillMetalsColorsForm(MetalsColors metalsColors){
        jdiMetalsColorsPage.fillMetalAndColorForm(metalsColors);
    }

    public static void IAssertResultLogs(MetalsColors metalsColors){
        jdiMetalsColorsPage.verifyResultRows(metalsColors);
    }
}