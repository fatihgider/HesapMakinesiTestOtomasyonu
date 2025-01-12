package com.hesapMakinesi.stepdefinitions;

import com.hesapMakinesi.hooks.HookImpl;
import com.thoughtworks.gauge.Step;
import pages.GeneralPage;

public class GeneralSteps extends BaseSteps {
    private final GeneralPage generalPage;

    public GeneralSteps() {
        super();
        this.generalPage = new GeneralPage(HookImpl.getDriver());
    }

    @Step("Sayfa açılır")
    public void openPage() {
        generalPage.openPage();  // Sayfanın açıldığını kontrol eden metot
    }

    @Step("<seconds> saniye beklenir")
    public void waitInSeconds(int seconds) {
        generalPage.waitInSeconds(seconds);  // Bekleme metodu
    }

    @Step("<text> butonuna tıklanır")
    public void clickElementByText(String text) {
        generalPage.clickElementByText(text);  // Element tıklama metodu
    }
}
