package com.hesapMakinesi.stepdefinitions;

import com.hesapMakinesi.hooks.HookImpl;
import com.thoughtworks.gauge.Step;
import pages.LoginPage;

public class LoginSteps extends BaseSteps{
    private final LoginPage loginPage;

    public LoginSteps() {
        super();
        this.loginPage = new LoginPage(HookImpl.getDriver());
    }

    @Step("CSV dosyasından kullanıcı adı ve şifre ile giriş yap")
    public void loginWithCSV() {
        String[] credentials = loginPage.getCredentialsFromCSV();
        if (credentials != null) {
            loginPage.login(credentials[0], credentials[1]);  // username ve password
        } else {
            System.err.println("CSV dosyasından kullanıcı bilgileri okunamadı!");
        }
    }
}
