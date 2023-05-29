package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPage {
    private SelenideElement header = $x("//*[@data-test-id='dashboard']");
    private SelenideElement firstButtonBalance = $x("//ul/li[1]//button");
    private SelenideElement secondButtonBalance = $x("//ul/li[2]//button");
    private SelenideElement refreshButton = $x("//*[@data-test-id='action-reload']");
    private ElementsCollection cards = $$x("//ul//div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashBoardPage () {
        refreshButton.click();
        firstButtonBalance.shouldBe(visible, Duration.ofSeconds(10));
    }
    public int getCardBalance(int id) {
        val text = cards.get(id).text();
        return extractBalance(text);
    }
    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransactionPage fromFirstToSecondCard () {
        firstButtonBalance.click();
        return new TransactionPage();
    }
    private TransactionPage fromSecondToFirstCard () {
        secondButtonBalance.click();
        return new TransactionPage();
    }
}
