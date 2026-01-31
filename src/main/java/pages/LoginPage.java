package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userIdField = By.name("uid");
    By passwordField = By.name("password");
    By loginBtn = By.name("btnLogin");

    
    public void enterUserId(String userId) {
        driver.findElement(userIdField).clear();
        driver.findElement(userIdField).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }


}
