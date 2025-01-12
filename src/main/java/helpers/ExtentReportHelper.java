package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportHelper {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void startReport() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Otomasyon Raporu");
            sparkReporter.config().setReportName("Test Sonuçları");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("İşletim Sistemi", System.getProperty("os.name"));
            extent.setSystemInfo("Java Versiyonu", System.getProperty("java.version"));
            extent.setSystemInfo("Tarayıcı", "Chrome");
        }
    }

    public static void createTest(String testName) {
        if (extent != null) {
            test = extent.createTest(testName);
        }
    }

    public static void logInfo(String message) {
        if (test != null) {
            test.info(message);
        }
    }

    public static void logPass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }

    public static void logFail(String message) {
        if (test != null) {
            test.fail(message);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static ExtentTest getTest() {
        return test;
    }
}
