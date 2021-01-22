package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import hw6.entities.MetalsColors;
import hw6.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public class JdiRunTest {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initElements(JdiSite.class);
        JdiSite.iOpenHomePage();
        JdiSite.iLoggIn(User.ROMAN);
        Assert.assertEquals(JdiSite.iGetFullUserName(), User.ROMAN.getFullName());
    }

    @Test(dataProviderClass = JdiDataProvider.class,
            dataProvider = "provideDataSetForMetalColorTest")
    public void verifyMetalsAndColorsPageWithJdi(MetalsColors metalsColors) {
        JdiSite.iOpenMetalsAndColorsPage();
        JdiSite.iFillMetalsColorsForm(metalsColors);
        JdiSite.iAssertResultLogs(metalsColors);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
