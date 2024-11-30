package org.example.StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login_Locators;

public class Login_Action {
    Login_Locators login = new Login_Locators();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        login.Account().click();
        login.Go_to_Login_page().click();
    }

    @When("user Enter Email_Address {string}")
    public void userEnterEmailAddress(String email) {
        login.Email_address().sendKeys(email);
    }

    @And("user Enter Password {string}")
    public void userEnterPassword(String password) {
        login.Password().sendKeys(password);
    }

    @Then("user clicks the login button")
    public void userClockLoginButton() {
        login.Login().click();
    }
}
