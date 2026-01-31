package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import factory.DriverFactory;

public class ScreenshotUtil {

    public static String takeScreenshot(String testName) {
        File src = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String path = "test-output/screenshots/" + testName + ".png";
        File dest = new File(path);

        try {
            org.apache.commons.io.FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
