package pages;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends  BasePage{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameField = By.xpath("//input[@placeholder='Username']");
    private final By passwordField = By.xpath("//input[@placeholder='Password']");

    public String[] getCredentialsFromCSV() {
        try (CSVReader csvReader = new CSVReader(new FileReader("data/user.csv"))) {
            String[] csvLine;
            if ((csvLine = csvReader.readNext()) != null) {
                logger.info("Username: " + csvLine[0] + ", Password: " + csvLine[1]);
                return csvLine;
            }
        } catch (IOException e) {
            System.err.println("CSV dosyası okunurken hata oluştu: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.clickElementByText("Login");
    }
}
