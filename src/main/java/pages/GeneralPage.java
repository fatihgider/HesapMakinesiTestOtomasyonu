package pages;

import org.openqa.selenium.*;

public class GeneralPage extends BasePage{
    private final WebDriver driver;

    public GeneralPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void openPage() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals("https://catchyLabs-webClient.testinium.com/") : "Sayfa yüklenmedi!";
    }

    public void waitInSeconds(int seconds) {
        try {
            logger.info(seconds + " saniye bekleniyor...");
            Thread.sleep(seconds * 1000L);  // Milisaniyeye çevirme
        } catch (InterruptedException e) {
            logger.error("Bekleme sırasında bir hata oluştu: " + e.getMessage());
            Thread.currentThread().interrupt();  // Thread'i kesintiye uğratan bayrağı ayarla
        }
    }

    public void clickElementByText(String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//div[text()='" + text + "']"));
            element.click();
            handleUnexpectedAlert();
            logger.info("Elemente tıklandı: " + text);
        } catch (Exception e) {
            logger.error("Element bulunamadı veya tıklanamadı: " + text);
            e.printStackTrace();
        }
    }

    public void handleUnexpectedAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert metni: " + alert.getText());
            alert.accept();
            waitInSeconds(1);
            System.out.println("Alert kapatıldı.");
        } catch (NoAlertPresentException e) {
            System.out.println("Herhangi bir alert açılmadı.");
        } catch (UnhandledAlertException e) {
            System.out.println("Beklenmeyen bir alert yakalandı: " + e.getAlertText());
            driver.switchTo().alert().accept();
            waitInSeconds(1);
        }
    }

}
