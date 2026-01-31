package hooks;

import com.aventstack.extentreports.ExtentTest;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class Hooks {
	private ExtentTest test;
	
	@Before
	public void setUp(Scenario scenario) {
		DriverFactory.initDriver();
		test=ExtentReportManager.getReport().createTest(scenario.getName());
	}
	
	@After
	public void tearDown(Scenario scenario) {
		 try {
		        DriverFactory.getDriver().switchTo().alert().accept();
		    } catch (Exception ignored) {
		    }
		
		if(scenario.isFailed()) {
			String path=ScreenshotUtil.takeScreenshot(scenario.getName());
			test.fail("Test failed").addScreenCaptureFromPath(path);
		}
		else {
			test.pass("Test passed");
		}
		
		DriverFactory.quitDriver();
		ExtentReportManager.getReport().flush();
		
	
	}

}
