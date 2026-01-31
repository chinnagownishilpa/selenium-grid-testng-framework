package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerHomePage {

	WebDriver driver;
    WebDriverWait wait;

    By managerIdText = By.xpath("//td[contains(text(),'Manger Id')]");
    By logoutLink = By.linkText("Log out");

    public ManagerHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isManagerIdDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(managerIdText))
                   .isDisplayed();
    }

    public void logout() {
        WebElement logout = wait.until(
                ExpectedConditions.elementToBeClickable(logoutLink)
        );

        // Scroll into view to avoid overlay issues
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", logout);

        // Fallback click using JS (real-world safe approach)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", logout);

        driver.switchTo().alert().accept();
    }
}
