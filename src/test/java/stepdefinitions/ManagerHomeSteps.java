package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ManagerHomePage;
import utils.AlertUtil;
import utils.ConfigReader;

import static org.testng.Assert.*;

import org.openqa.selenium.Alert;
import org.testng.Assert;

public class ManagerHomeSteps {
	
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    ManagerHomePage homePage = new ManagerHomePage(DriverFactory.getDriver());
    
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.enterUserId(
                ConfigReader.get("invalid.username"));
        loginPage.enterPassword(
                ConfigReader.get("invalid.password"));
    }

    @Then("manager home page should be displayed")
    public void manager_home_page_should_be_displayed() {
        assertTrue(
            homePage.isManagerIdDisplayed(),
            "Manager home page is not displayed"
        );
        homePage.logout();
    }
    
    
    @Then("error alert should be displayed")
    public void error_alert_should_be_displayed() {

        Alert alert = AlertUtil.waitForAlert(DriverFactory.getDriver(), 5);
        String alertText = alert.getText();

        System.out.println("Login failed alert: " + alertText);

        Assert.assertTrue(
            alertText.contains("User or Password is not valid"),
            "Unexpected alert message"
        );

        alert.accept(); // CRITICAL
    
    }
}
