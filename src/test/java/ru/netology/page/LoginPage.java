package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement loginField = $x("//*[@data-test-id='login']//input");
    private SelenideElement passwordField = $x("//*[@data-test-id='password']//input");
    private SelenideElement loginPageButton = $x("//*[@data-test-id='action-login']");

    public VerificationPage validLogin (DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginPageButton.click();
        return new VerificationPage();
    }
}
