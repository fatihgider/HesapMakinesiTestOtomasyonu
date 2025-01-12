package pages;

import org.openqa.selenium.WebDriver;

public class CalculatorPage {
    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals("https://catchyLabs-webClient.testinium.com/") : "Sayfa yüklenmedi!";
    }
}
