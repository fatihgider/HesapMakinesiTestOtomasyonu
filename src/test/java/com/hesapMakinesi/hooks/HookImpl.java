package com.hesapMakinesi.hooks;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

public class HookImpl {
    private static WebDriver driver;

    @BeforeScenario
    public void setUp() {
        System.out.println("--- TEST STARTING ---");

        Properties properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream("config.properties")) {
            properties.load(fileInput);
        } catch (IOException e) {
            throw new RuntimeException("--- READING ERROR! config.properties ---", e);
        }

        String browser = properties.getProperty("browser", "chrome");

        System.out.println("--- opening "+ browser +"---");

        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-web-security");
                firefoxOptions.addArguments("--ignore-certificate-errors");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-web-security");
                edgeOptions.addArguments("--ignore-certificate-errors");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--no-proxy-server");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("base.url", "https://catchyLabs-webClient.testinium.com/"));  // URL config.properties'ten çekilir
    }

    @AfterScenario
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("--- TEST OVER ---");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
