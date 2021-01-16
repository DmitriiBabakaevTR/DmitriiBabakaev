package hw5.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep{

    @Given("I open JDI GitHub site")
    public void iOpenHomePage() {
        homePage.openPage();
    }
}