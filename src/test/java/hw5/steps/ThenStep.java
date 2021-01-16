package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;

public class ThenStep extends AbstractStep {

    @Then("{string} page should be opened")
    public void iAssertOpenedPage(String expectedText) {
        soft.assertEquals(homePage.getTitle(), expectedText);
    }

    @Then("User name should be displayed and equals to {string}")
    public void iAssertUserName(String expectedText) {
        soft.assertEquals(homePage.getHeaderPageElements().getUserNameText().getText(), expectedText.toUpperCase());
    }

    @Then("Each element should be corresponds to itself with positive status")
    public void iAssertAllLogs() {
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWaterLog().isDisplayed(), "The Water checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWaterLog().getText().contains("true"), "The Water checkbox log has invalid value!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWindLog().isDisplayed(), "The Wind checkbox log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getWindLog().getText().contains("true"), "The Wind checkbox log has invalid value!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getMetalRadioLog().isDisplayed(), "The metal radio button log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getMetalRadioLog().getText().contains("Selen"), "The metal radio button log has invalid value!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getColorsLog().isDisplayed(), "The Colors dropdown log is not displayed!");
        soft.assertTrue(differentElementsPage.getRightSideBarElement().getColorsLog().getText().contains("Yellow"), "The Colors dropdown log has invalid value!");
        soft.assertAll();
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void iAssertNumberTypeDropdowns(int amount) {
        soft.assertEquals(userTablePage.getNumberTypeDropdowns().size(), amount);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void iAssertUsernames(int amount) {
        soft.assertEquals(userTablePage.getUserNames().size(), amount);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void iAssertDescriptions(int amount) {
        soft.assertEquals(userTablePage.getUserDescriptions().size(), amount);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void iAssertCheckboxes(int amount) {
        soft.assertEquals(userTablePage.getUserCheckboxes().size(), amount);
    }

    @Then("User table should contain following values:")
    public void tableShouldContainValues(DataTable table) {
        List<List<String>> dataTable = table.cells();
        for (int i = 1; i < dataTable.size(); i++) {
            userTablePage.userTable(dataTable.get(i).get(0),
                    dataTable.get(i).get(1), dataTable.get(i).get(2));
        }
    }

    @Then("Droplist should contain values in column Type for user Roman")
    public void dropdownShouldHaveValue(DataTable table) {
        List<String> list = table.asList();
        for (int i = 1; i < list.size(); i++) {
            userTablePage.elementsInDropdownRoman(list.get(i));
        }
    }

    @Then("1 log row has {string} text in log section")
    public void isDisplayedProperLogRow(String properText){
        userTablePage.logRowHasProperText(properText);
    }
}