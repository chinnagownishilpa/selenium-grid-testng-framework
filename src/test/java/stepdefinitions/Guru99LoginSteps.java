package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ConfigReader;

import static org.testng.Assert.*;

public class Guru99LoginSteps {

	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on Guru99 login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get(ConfigReader.get("app.url"));
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("user enters valid username and password")
    public void user_enters_credentials() {
        loginPage.enterUserId(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
    }

    @And("user clicks on login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("user should be logged in successfully")
    public void user_logged_in_successfully() {

        try {
            // Check if alert is present
            String alertText = DriverFactory.getDriver()
                    .switchTo().alert().getText();

            // Capture alert message
            System.out.println("Login failed alert: " + alertText);

            // Accept alert
            DriverFactory.getDriver().switchTo().alert().accept();

            // Fail test explicitly
            fail("Login failed with alert: " + alertText);

        } catch (org.openqa.selenium.NoAlertPresentException e) {
            // No alert = login successful
            assertTrue(
                DriverFactory.getDriver().getTitle().contains("Guru99"),
                "Login successful, dashboard loaded"
            );
        }
    }

}
