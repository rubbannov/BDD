package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    private SelenideElement codeField = $x("//*[@data-test-id='code']//input");
    private SelenideElement verifyButton = $x("//*[@data-test-id='action-verify']");
    public VerificationPage () {
        codeField.shouldBe(Condition.visible);
    }
    public DashBoardPage validVerify (DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return new DashBoardPage();
    }
}

