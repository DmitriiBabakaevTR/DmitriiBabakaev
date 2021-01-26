package hw6.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw6.entities.MetalsColors;
import hw6.forms.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class JdiMetalsColorsPage extends WebPage {

    @Css(".results li")
    public WebList resultRows;

    public MetalsAndColorsForm metalsAndColorsForm;

    public void fillMetalAndColorForm(MetalsColors metalsColors) {
        metalsAndColorsForm.submitForm(metalsColors);
    }

    public void verifyResultRows(MetalsColors metalsColors) {
        List<String> expectedRows = metalsColors.resultLogRows();
        Assert.assertEquals(generateListWithActualRows(), expectedRows);
    }

    public List<String> generateListWithActualRows() {
        List<String> actualRows = new ArrayList<>();
        for (WebElement element : resultRows) {
            actualRows.add(element.getText());
        }
        return actualRows;
    }
}
