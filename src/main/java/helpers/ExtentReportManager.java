package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportFilePath = "reports/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Otomasyon Test Raporu");
            sparkReporter.config().setReportName("Test Senaryoları Raporu");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("İşletim Sistemi", System.getProperty("os.name"));
            extent.setSystemInfo("Tarayıcı", "Chrome/Firefox/Edge");
            extent.setSystemInfo("Test Framework", "Gauge");
        }
        return extent;
    }
}
