package com.hesapMakinesi.stepdefinitions;

import com.hesapMakinesi.hooks.HookImpl;
import com.thoughtworks.gauge.Step;
import pages.CalculatorPage;

public class CalculatorSteps extends BaseSteps{
    private final CalculatorPage calculatorPage;

    public CalculatorSteps() {
        super();
        this.calculatorPage = new CalculatorPage(HookImpl.getDriver());
    }

    @Step("<text> metni sayfada görüntülenebilir olmalıdır")
    public void checkTextVisibility(String text) {
        boolean isVisible = calculatorPage.isTextVisible(text);
        if (!isVisible) {
            throw new AssertionError("Metin sayfada görüntülenemedi: " + text);
        }
        logger.info("Metin başarıyla bulundu ve görüntülendi: " + text);
    }

    @Step("<number> sayısı yazılır")
    public void enterNumber(String number) {
        logger.info("'{}' sayısı butonlara tıklanarak yazılıyor...", number);
        calculatorPage.typeNumber(number);
    }

    @Step("<operator> işlemine tıklanır")
    public void clickOperatorStep(String operator) {
        calculatorPage.clickOperator(operator);
        logger.info("'{}' işlemi başarıyla tıklandı.", operator);
    }

    @Step("Sonuç <expectedResult> olmalıdır")
    public void verifyResult(String expectedResult) {
        String actualResult = calculatorPage.getResultText();
        logger.info("Beklenen sonuç: {}, Gerçek sonuç: {}", expectedResult, actualResult);

        if (!actualResult.equals(expectedResult)) {
            throw new AssertionError("Sonuç farklı! Beklenen sonuç: " + expectedResult + ", Gerçekleşen sonuç: " + actualResult);
        }
        logger.info("Sonuç doğru!");
    }


    @Step("<base> üzeri <exponent> işlemi yapılır")
    public void calculateExponentiationStep(String base, int exponent) {
        calculatorPage.calculateExponentiation(base, exponent);
        logger.error(base+" üzeri "+exponent+" işlemi yapılır - PASS");
    }

}
