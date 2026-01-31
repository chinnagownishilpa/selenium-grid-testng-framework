package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("test-output/ExtentReports/extent.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
