package hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.entities.MetalsColors;

public class MetalsAndColorsForm extends Form<MetalsColors> {

    @FindBy(name = "custom_radio_odd")
    public RadioButtons oddRadio;

    @FindBy(name = "custom_radio_even")
    public RadioButtons evenRadio;

    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    public Checklist elements;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown color;

    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    public static Dropdown metals;

    @FindBy(id = "salad-dropdown")
    private Button btnOpenVegetablesDropdown;

    @FindBy(css = "#salad-dropdown  input")
    private Checklist vegetables;

    @FindBy(id = "submit-button")
    private Button submitBtn;

    public void fillForm(MetalsColors metalsColors){
        oddRadio.select(metalsColors.getSummary().get(0));
        evenRadio.select(metalsColors.getSummary().get(1));
        for (int i = 0; i < metalsColors.getElements().size(); i++) {
            elements.select(metalsColors.getElements().get(i));
        }
        color.select(metalsColors.getColor());
        metals.select(metalsColors.getMetals());
        btnOpenVegetablesDropdown.click();
        vegetables.select("Vegetables");
        for (int i = 0; i < metalsColors.getVegetables().size(); i++) {
            vegetables.select(metalsColors.getVegetables().get(i));
        }
        submitBtn.click();
    }
}