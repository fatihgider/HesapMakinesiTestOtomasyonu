package com.hesapMakinesi.hooks;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import helpers.ExtentReportHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class HookImpl {
    private static WebDriver driver;

    @BeforeScenario
    public void setUp() {
        System.out.println("--- TEST STARTING ---");

        // Rapor başlatma
        ExtentReportHelper.startReport();
        ExtentReportHelper.createTest("Senaryo Başladı");

        Properties properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream("config.properties")) {
            properties.load(fileInput);
        } catch (IOException e) {
            ExtentReportHelper.logFail("config.properties yükleme hatası: " + e.getMessage());
            throw new RuntimeException("--- READING ERROR! config.properties ---", e);
        }

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("base.url", "https://catchyLabs-webClient.testinium.com/"));

        ExtentReportHelper.logPass("Web sitesi açıldı: " + driver.getCurrentUrl());
    }

    @AfterScenario
    public void tearDown() {
        if (driver != null) {
            try {
                String screenshotPath = takeScreenshot("final_screenshot");
                ExtentReportHelper.getTest().addScreenCaptureFromPath(screenshotPath);
                ExtentReportHelper.logPass("Test tamamlandı ve ekran görüntüsü alındı.");
            } catch (IOException e) {
                ExtentReportHelper.logFail("Ekran görüntüsü alınamadı: " + e.getMessage());
            }
            driver.quit();
        }
        System.out.println("--- TEST OVER ---");

        // Raporu kaydetme
        ExtentReportHelper.flushReport();
    }

    private static String takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "test-output/screenshots/" + fileName + ".png";
        Files.createDirectories(Paths.get("test-output/screenshots"));
        Files.copy(srcFile.toPath(), Paths.get(screenshotPath));
        return screenshotPath;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
