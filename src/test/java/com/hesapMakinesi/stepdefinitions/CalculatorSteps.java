package com.hesapMakinesi.stepdefinitions;

import com.thoughtworks.gauge.Step;
import pages.CalculatorPage;
import com.hesapMakinesi.hooks.HookImpl;

public class CalculatorSteps {
    CalculatorPage calculatorPage = new CalculatorPage(HookImpl.getDriver());

    @Step("Sayfa açılır")
    public void openPageStep() {
        calculatorPage.openPage();
    }
}
