package factory;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver() {
	
		try {

			boolean isGrid = Boolean.parseBoolean(ConfigReader.get("grid.enabled"));
			String browser = ConfigReader.get("browser");

			if (browser == null || browser.trim().isEmpty()) {
			    throw new RuntimeException("Browser value is NULL or EMPTY. Please set browser in config.properties or via Maven profile.");
			}

			browser = browser.toLowerCase();		

			if (isGrid) {
				driver.set(createRemoteDriver(browser));
			} else {
				System.out.println("Running on LOCAL browser");
				driver.set(createLocalDriver(browser));
			}

			getDriver().manage().window().maximize();

		} catch (Exception e) {
			throw new RuntimeException("Driver initialization failed", e);
		}
	}

	private static WebDriver createLocalDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		default:
			throw new RuntimeException("Unsupported browser: " + browser);
		}
	}

	private static WebDriver createRemoteDriver(String browser) throws Exception {

	    String gridUrlValue = ConfigReader.get("grid.url");

	    if (gridUrlValue == null || gridUrlValue.trim().isEmpty()) {
	        throw new RuntimeException("grid.url is NULL or EMPTY. Please set it in config.properties or via Maven -Dgrid.url");
	    }

	    URL gridUrl = new URL(gridUrlValue);

	    switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("WINDOWS");
			return new RemoteWebDriver(gridUrl, chromeOptions);

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPlatformName("WINDOWS");
			return new RemoteWebDriver(gridUrl, firefoxOptions);

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setPlatformName("WINDOWS");
			return new RemoteWebDriver(gridUrl, edgeOptions);

		default:
			throw new RuntimeException("Unsupported browser for Grid: " + browser);
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
