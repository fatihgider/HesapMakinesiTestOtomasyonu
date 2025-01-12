package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class CalculatorPage extends BasePage {
    private final WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    private final By resultText = By.cssSelector(".css-1jxf684.r-zz5t5d.r-vw2c0b.r-1ff274t");
    private final By multiplication = By.xpath("//div[text()='9']/../../following-sibling::div//div[text()='*']");
    private final By equals = By.xpath("//div[text()=',']/../../following-sibling::div//div[text()='=']");


    public boolean isTextVisible(String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void typeNumber(String number) {
        for (char digit : number.toCharArray()) {
            String xpath = String.format("//div[text()='%s']", digit);
            driver.findElement(By.xpath(xpath)).click();
        }
    }

    public void clickOperator(String operator) {
        String xpath;
        switch (operator.toLowerCase()) {
            case "toplama":
                xpath = "//div[text()='+']";
                break;
            case "çıkarma":
                xpath = "//div[text()='-']";
                break;
            case "çarpma":
                xpath = "//div[text()='*']";
                break;
            case "bölme":
                xpath = "//div[text()='/']";
                break;
            default:
                throw new IllegalArgumentException("Geçersiz operatör: " + operator);
        }
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText().replace("=", "").trim();
    }

    public void calculateExponentiation(String base, int exponent) {
        GeneralPage generalPage = new GeneralPage(driver);
        typeNumber(base);

        for (int i = 1; i < exponent; i++) {
            driver.findElement(multiplication).click();
            typeNumber(base);
            driver.findElement(equals).click();
            generalPage.handleUnexpectedAlert();
            generalPage.waitInSeconds(2);
        }
    }



}
