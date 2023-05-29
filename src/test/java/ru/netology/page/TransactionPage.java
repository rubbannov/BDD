package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$x;

public class TransactionPage {
    private SelenideElement amountField = $x("//*[@data-test-id='amount']//input");
    private SelenideElement fromField = $x("//*[@data-test-id='from']//input");
    private SelenideElement toField = $x("//*[@data-test-id='to']//input");
    private SelenideElement acceptButton = $x("//button[@data-test-id='action-transfer']");
    private SelenideElement cancelButton = $x("//button[@data-test-id='action-cancel']");

    public TransactionPage () {
        amountField.shouldBe(Condition.visible);
    }
    public DashBoardPage inputTransaction (DataHelper.CardInfo cardInfo) {
        amountField.setValue(cardInfo.getBalance());
        fromField.setValue(cardInfo.getNumber());
        acceptButton.click();
        return new DashBoardPage();
    }
}
