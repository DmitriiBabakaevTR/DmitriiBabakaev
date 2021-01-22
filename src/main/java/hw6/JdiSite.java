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

    public static void iOpenHomePage() {
        jdiHomePage.open();
    }

    public static void iLoggIn(User user) {
        jdiHomePage.loggIn(user);
    }

    public static String iGetFullUserName() {
        return jdiHomePage.getUserName();
    }

    public static void iOpenMetalsAndColorsPage(){
        jdiHomePage.openMetalsAndColors();
    }

    public static void iFillMetalsColorsForm(MetalsColors metalsColors){
        jdiMetalsColorsPage.fillMetalAndColorForm(metalsColors);
    }

    public static void iAssertResultLogs(MetalsColors metalsColors){
        jdiMetalsColorsPage.verifyResultRows(metalsColors);
    }
}