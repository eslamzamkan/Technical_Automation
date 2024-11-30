package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.example.pages.Register_Locators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Register_Action {
    private List<Map<String, String>> testData;
    private Map<String, String> currentRowData;
    Register_Locators reg = new Register_Locators();

    @Given("I read test data from excel sheet {int}")
    public void readTestData(Integer rowNumber) {
        testData = ExcelReader.readAllData();
        if (testData.isEmpty()) {
            throw new RuntimeException("No data found in Excel file");
        }
        currentRowData = testData.get(rowNumber);
    }

    @When("user Enter valid First_Name")
    public void enterValidFirstName() throws InterruptedException {
        reg.Account().click();
        Thread.sleep(2000);
        reg.Go_to_Register_page().click();
        Thread.sleep(2000);
        String firstName = currentRowData.get("First_Name");
        reg.First_Name().sendKeys(firstName);
    }

    @And("user Enter Middle_Name")
    public void enterMiddleName() {
        String middleName = currentRowData.get("Middle_Name");
        reg.Middle_Name().sendKeys(middleName);
    }

    @And("user Enter Last_Name")
    public void enterLastName() {
        String lastName = currentRowData.get("Last_Name");
        reg.Last_Name().sendKeys(lastName);
    }

    @And("user Enter Email_Address")
    public void enterEmailAddress() {
        String emailAddress = currentRowData.get("Email_Address");
        reg.Email_Address().sendKeys(emailAddress);
    }

    @And("user Enter Password")
    public void enterPassword() {
        String password = currentRowData.get("Password");
        reg.Password().sendKeys(password);
    }

    @And("user Enter ConfirmPassword")
    public void enterConfirmPassword() {
        String confirmPassword = currentRowData.get("ConfirmPassword");
        reg.ConfirmPassword().sendKeys(confirmPassword);
    }

    @Then("click Register button")
    public void clickRegisterButton() throws IOException {
        System.out.println("Attempting to click Register button...");
        try {
            // Wait until the button is clickable
            WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(reg.Register_button()));

            // Scroll the button into view
            JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
            js.executeScript("arguments[0].scrollIntoView(true);", reg.Register_button());

            // Click the button
            reg.Register_button().click();
            System.out.println("Register button clicked successfully.");
        } catch (Exception e) {
            System.out.println("Encountered an issue: " + e.getMessage());
            // Capture screenshot for debugging
            File screenshot = ((TakesScreenshot) Hooks.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("RegisterButtonError.png"));
            System.out.println("Screenshot saved: RegisterButtonError.png");
            throw e;
        }
    }
}
