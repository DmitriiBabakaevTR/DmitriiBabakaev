package hw5.steps;

import io.cucumber.java.en.When;

public class WhenStep extends AbstractStep{

    @When("I login as {string} with password - {string}")
    public void iLogIn(String user, String pass) {
        homePage.loggIn(user, pass);
    }

    @When("I click on the Service dropdown and then on the 'Different Elements' button")
    public void iChooseDifferentElements(){
        differentElementsPage.openDiffElPage();
    }

    @When("I select 'Earth' and 'Wind' checkboxes")
    public void iSelectTwoCheckboxes(){
        differentElementsPage.selectWaterAndWindCheckboxes();
    }

    @When("I select 'Selen' radiobutton")
    public void iSelectRadioButton(){
        differentElementsPage.selectSelenRadio();
    }

    @When("I select 'Yellow' in dropdown")
    public void iSelectColor(){
        differentElementsPage.selectYellowColor();
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void iGoToUserTablePage(){
    homePage.getHeaderPageElements().getServiceItem().click();
    homePage.getHeaderPageElements().getUserTable().click();
    }

    @When("I select 'vip' checkbox for Sergey Ivan")
    public void makeIvanCheckboxVip(){
        userTablePage.selectIvanCheckbox();
    }
}